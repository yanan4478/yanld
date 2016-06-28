/**
 * Created by xgz on 15/12/2.
 */
import {
    Action_AuthLogin_Request,
    Action_AuthLogin_Response,
    Action_AuthLogin_FAILURE,
    Action_Enter_Request,
    Action_Enter_Response,
    Action_Enter_FAILURE,
} from '../actions/LoginActions';

function posts(state = {
    isFetching: false,
    didInvalidate: false,
    items: []
}, action = {}) {
    //console.log(action)
    switch (action.type) {
        case Action_AuthLogin_Request:
            return Object.assign({}, state, {
                isFetching: true,
                didInvalidate: false
            });
        case Action_AuthLogin_Response:
            return Object.assign({}, state, {
                isFetching: false,
                didInvalidate: false,
                isAuthenticated:true,
                Action_AuthLogin_Response: action.response,
                lastUpdated: action.receivedAt
            });
        default:
            return state
    }
}

export default function proxyPageReducers(state = {}, action = null) {

    let ret = posts(state,action);

    return ret;
}