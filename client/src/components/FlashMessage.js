import React from 'react';
import { Consumer } from './AppProvider';

const FlashMessage = () => <Consumer>
    {({ state, ...context }) => state.message && <small className="flash-message">
        {state.message}
        <button type="button" onClick={() => context.clearMessage()}>OK</button>
    </small>}
</Consumer>;

export default FlashMessage;