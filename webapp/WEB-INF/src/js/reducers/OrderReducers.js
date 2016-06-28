/**
 * Created by XK on 2016/6/7.
 */
import {
    Action_GetOrderList_Request,
    Action_GetOrderList_Response,
    Action_GetOrderList_Failure,
    Action_GetOrderListByOrderNo_Request,
    Action_GetOrderListByOrderNo_Response,
    Action_GetOrderListByOrderNo_Failure,
    Action_UpdateOrderStatus_Request,
    Action_UpdateOrderStatus_Response,
    Action_UpdateOrderStatus_Failure,
    Action_DeleteByOrderNo_Request,
    Action_DeleteByOrderNo_Response,
    Action_DeleteByOrderNo_Failure,
    Action_UpdateTaskStatus_Request,
    Action_UpdateTaskStatus_Response,
    Action_UpdateTaskStatus_Failure,
}from '../actions/OrderActions.js'
import Immutable from 'immutable';
function posts(state = {
}, action = {}) {

    switch (action.type) {
        case  Action_GetOrderList_Request:
        case Action_GetOrderListByOrderNo_Request:
            return Object.assign({}, state, {
            });
        case Action_GetOrderList_Response:
            console.log(action.response.code);
            let data =Immutable.fromJS({});

            if (action.response.code == 0) {
                data = Immutable.fromJS(action.response);
            }
            return Object.assign({}, state, {
                Action_GetOrderList_Response:data,
            });
            break;
        case Action_GetOrderListByOrderNo_Response:
            let orderNo = Immutable.fromJS({});
            if (action.response.code == 0) {
                orderNo = Immutable.fromJS(action.response);
        }
            return Object.assign({}, state, {
                Action_GetOrderList_Response:orderNo,
            });
            break;
        /*case Action_UpdateOrderStatus_Response:
            let order = Immutable.fromJS({});
            if (action.response.code == 0) {
                order = Immutable.fromJS(action.response);
            }
            return Object.assign({}, state, {
                Action_GetOrderList_Response:order,
            });
            break;*/
        default:
            return state;
    }
}
export default function OrderReducers(state = {}, action = null) {

    let ret = posts(state, action);

    return ret;
}
