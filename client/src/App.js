import React, { Component } from 'react'
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom';

import { withAlert } from 'react-alert'

import './App.css'

import AppProvider, { Consumer } from './components/AppProvider';

import Login from './components/Login';
import Signup from './components/Signup';
import Navbar from './components/Navbar';
import FlashMessage from './components/FlashMessage';

import Sights from './components/Sights';

class App extends Component {
    render() {
        return (
            <AppProvider>
                <Router>
                    <div className="container">
                        <Navbar />
                        <FlashMessage />

                        <Route exact path="/" component={() =>
                            <div>
                                <Consumer>
                                    {
                                        ({ state }) => state.currentUser ? <p>You are logged in as {state.currentUser.email}.</p> : <p>You are not logged in.</p>
                                    }
                                </Consumer>
                                <Sights />
                            </div>} />
                        <Route exact path="/login" component={() => <Login />} />
                        <Route exact path="/signup" component={() => <Signup />} />
                        <Route exact path="/loggedOut" component={() => <p className="content">You've logged out.</p>} />
                        <Route exact path="/accountCreated" component={() => <p className="content">Account created. Would you like to <Link to="/login">log in</Link>?</p>} />
                    </div>
                </Router>
            </AppProvider>
        );
    }
}

export default withAlert(App)