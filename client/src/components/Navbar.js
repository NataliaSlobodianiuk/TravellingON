import React from 'react';
import {
    Link,
    withRouter
} from 'react-router-dom';
import { auth } from '../firebase';
import { Consumer } from './AppProvider';

const Navbar = props => {
    const handleLogout = context => {
        auth.logout();
        context.destroySession();
        props.history.push('/loggedOut');
    };

    return <Consumer>
        {({ state, ...context }) => (
            state.currentUser ?
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><a onClick={() => handleLogout(context)}>Logout</a></li>
                    <li style={{ float: 'right' }}><p>You are logged in as {state.currentUser.email}</p></li>
                </ul>
                :
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/login">Login</Link></li>
                    <li><Link to="/signup">Create Account</Link></li>
                    <li style={{ float: 'right' }}><p>You are not logged in</p></li>
                </ul>
        )}
    </Consumer>
};

export default withRouter(Navbar);