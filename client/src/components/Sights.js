import React, { Component } from 'react'
import axios from 'axios'

import { withAlert } from 'react-alert'

import { Consumer } from './AppProvider'

const noSightsFoundMessage = 'No sights found. '
const sightsFoundMessage = 'Amount of sights found: '
const newSightAddedMessage = 'New sight added. '
const sightRemovedMessage = 'Sight removed. '
const sightUpdatedMessage = 'Sight updated. '

const errorMessage = 'Error occured. '

class Sights extends Component {
    constructor(props) {
        super(props)

        this.state = {
            sights: [],
            updatingSight: null,
            message: ''
        }
    }

    componentDidMount() {
        return axios.get('https://us-central1-travellingon-922b0.cloudfunctions.net/selectAllSights')
            .then((response) => {
                const sightsCount = response.data.length

                this.setState({
                    sights: response.data,
                    message: sightsCount === 0 ? noSightsFoundMessage : sightsFoundMessage.concat(sightsCount)
                })
            })
            .catch((error) => {
                this.setState({
                    message: errorMessage.concat(error.response.data.message)
                })
            })
    }

    addSight(event) {
        event.preventDefault()

        const newSightName = this.newSightName.value
        const newSightLocation = this.newSightLocation.value
        const newSightDescription = this.newSightDescription.value

        axios.post('https://us-central1-travellingon-922b0.cloudfunctions.net/insertSight',
            { name: newSightName, location: newSightLocation, description: newSightDescription })
            .then((response) => {
                this.setState({
                    sights: response.data,
                    message: newSightAddedMessage.concat(sightsFoundMessage.concat(response.data.length))
                })
                this.addForm.reset()
            })
            .catch((error) => {
                this.setState({
                    message: errorMessage.concat(error.response.data.message)
                })
            })
    }

    removeSight(sightId) {
        axios.delete(`https://us-central1-travellingon-922b0.cloudfunctions.net/deleteSight?id=${sightId}`)
            .then((response) => {
                const sightsCount = response.data.length

                this.setState({
                    sights: response.data,
                    message: sightRemovedMessage.concat(sightsCount === 0 ? noSightsFoundMessage : sightsFoundMessage.concat(sightsCount))
                })
            })
            .catch((error) => {
                this.setState({
                    message: errorMessage.concat(error.response.data.message)
                })
            })
    }

    removeAll() {
        this.removeSight = this.removeSight.bind(this)

        const sights = this.state.sights
        sights.forEach(this.removeSight)
    }

    updateSightInProgress(sight) {
        this.setState({
            updatingSight: sight
        })
    }

    updateSight(event) {
        event.preventDefault()

        const sightId = this.state.updatingSight.id

        const sightNewName = this.sightNewName.value
        const sightNewLocation = this.sightNewLocation.value
        const sightNewDescription = this.sightNewDescription.value

        axios.post(`https://us-central1-travellingon-922b0.cloudfunctions.net/updateSight?id=${sightId}`,
            { name: sightNewName, location: sightNewLocation, description: sightNewDescription })
            .then((response) => {
                this.setState({
                    sights: response.data,
                    updatingSight: null,
                    message: sightUpdatedMessage.concat(sightsFoundMessage.concat(response.data.length))
                })
            })
            .catch((error) => {
                this.setState({
                    message: errorMessage.concat(error.response.data.message)
                })
            })
    }

    renderSights() {
        let num = 1
        const sights = this.state.sights

        return (
            sights.length > 0 &&
            <table className="table">
                <caption>Sights</caption>
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Location</th>
                        <th scope="col">Description</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        sights.map(sight => {
                            return (
                                <tr key={sight.num}>
                                    <th scope="row">{num++}</th>
                                    <td style={{ width: '15%' }} >{sight.name}</td>
                                    <td style={{ width: '20%' }} >{sight.location}</td>
                                    <td style={{ width: '40%' }} >{sight.description}</td>

                                    <td>
                                        <Consumer>
                                            {
                                                ({ state }) => state.currentUser
                                                    ?
                                                    <button onClick={(e) => this.props.alert.show('Not implemented yet!') } type="button" className="btn btn-default btn-sm">
                                                        View Trips
                                                    </button>
                                                    :
                                                    null
                                            }
                                        </Consumer>
                                        <Consumer>
                                            {
                                                ({ state }) => state.currentUser
                                                    ?
                                                    <button onClick={(e) => this.updateSightInProgress(sight)} type="button" className="btn btn-default btn-sm">
                                                        Update
                                                    </button>
                                                    :
                                                    null
                                            }
                                        </Consumer>
                                        <Consumer>
                                            {
                                                ({ state }) => state.currentUser && state.currentUser.email === 'admin@admin.com'
                                                    ?
                                                    <button onClick={(e) => this.removeSight(sight.id)} type="button" className="btn btn-default btn-sm">
                                                        Remove
                                                    </button>
                                                    :
                                                    null
                                            }
                                        </Consumer>
                                    </td>
                                </tr>
                            )
                        })
                    }
                </tbody>
                <tfoot>
                    <tr>
                        <td colSpan="4">&nbsp;</td>
                        <Consumer>
                            {
                                ({ state }) => state.currentUser && state.currentUser.email === 'admin@admin.com'
                                    ?
                                    <td>
                                        <button onClick={(e) => this.removeAll()}
                                            className="btn btn-default btn-sm">Remove All</button>
                                    </td>
                                    :
                                    null
                            }
                        </Consumer>
                    </tr>
                </tfoot>
            </table>
        )
    }

    render() {
        const message = this.state.message
        const updatingSight = this.state.updatingSight

        return (
            <div className="container">
                <p className="message text-danger">{message}</p>
                <div className="content">

                    <Consumer>
                        {
                            ({ state }) => state.currentUser
                                ?
                                <form ref={input => { this.addForm = input }} onSubmit={this.addSight.bind(this)}>
                                    <div className="form-group">
                                        <label for="newSightName">Name</label>
                                        <input name="newSightName" placeholder="Type sight name"
                                            ref={input => { this.newSightName = input }}
                                            type="text" className="form-control" />
                                    </div>
                                    <div className="form-group">
                                        <label for="newSightLocation">Location</label>
                                        <input name="newSightLocation" placeholder="Type sight location"
                                            ref={input => { this.newSightLocation = input }}
                                            type="text" className="form-control" />
                                    </div>
                                    <div className="form-group">
                                        <label for="newSightDescription">Description</label>
                                        <textarea name="newSightDescription" placeholder="Type some sight description (optional)"
                                            ref={input => { this.newSightDescription = input }}
                                            className="form-control" rows="5" />
                                    </div>
                                    <button className="btn btn-primary">Add</button>
                                </form>
                                :
                                null
                        }
                    </Consumer>
                    
                    {this.renderSights()}

                    {
                        updatingSight !== null
                            ?
                            <form ref={input => { this.updateForm = input }} onSubmit={this.updateSight.bind(this)}>
                                <div className="form-group">
                                    <label for="newSightName">Name</label>
                                    <input name="newSightName" defaultValue={updatingSight.name}
                                        ref={input => { this.sightNewName = input }}
                                        type="text" className="form-control" />
                                </div>
                                <div className="form-group">
                                    <label for="newSightLocation">Location</label>
                                    <input name="newSightLocation" defaultValue={updatingSight.location}
                                        ref={input => { this.sightNewLocation = input }}
                                        type="text" className="form-control" />
                                </div>
                                <div className="form-group">
                                    <label for="newSightDescription">Description</label>
                                    <textarea name="newSightDescription" defaultValue={updatingSight.description}
                                        ref={input => { this.sightNewDescription = input }}
                                        className="form-control" rows="5" />
                                </div>
                                <button className="btn btn-primary">Submit</button>
                            </form>
                            :
                            null
                    }
                </div>
            </div>
        );
    }
}

export default withAlert(Sights)
