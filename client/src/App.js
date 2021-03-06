import React, { Component } from 'react'
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom';

import { withAlert } from 'react-alert'

import ReactGA from 'react-ga';

import './App.css'

import AppProvider from './components/AppProvider';

import Login from './components/Login';
import Signup from './components/Signup';
import Navbar from './components/Navbar';
import FlashMessage from './components/FlashMessage';

import Sights from './components/Sights';

ReactGA.initialize('UA-129720588-1');
ReactGA.pageview('/');

class App extends Component {
    render() {
        return (
            <AppProvider>
                <Router>
                    <div className="container">
                        <h1>TravellingON</h1>
                        <Navbar />
                        <FlashMessage />

                        <Route exact path="/" component={() => <Sights />} />
                        <Route exact path="/login" component={() => <Login />} />
                        <Route exact path="/signup" component={() => <Signup />} />
                        <Route exact path="/accountCreated" component={() => <p className="content">Account created. Would you like to <Link to="/login">log in</Link>?</p>} />
                    </div>
                </Router>
            </AppProvider>
        );
    }
}

export default withAlert(App)