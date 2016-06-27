/**
 * Created by XK on 2016/6/7.
 */
import {CALL_API } from '../middleware/api.js';
//import { Order,OrderDetail,total } from '../schemas/OrderSchema.js';
import { arrayOf } from 'normalizr';
const Action_GetOrderList_Request = 'Action_GetOrderList_Request';
const Action_GetOrderList_Response= 'Action_GetOrderList_Response';
const Action_GetOrderList_Failure = 'Action_GetOrderList_Failure';
const Action_GetOrderListByOrderNo_Request = 'Action_GetOrderListByOrderNo_Request';
const Action_GetOrderListByOrderNo_Response= 'Action_GetOrderListByOrderNo_Response';
const Action_GetOrderListByOrderNo_Failure = 'Action_GetOrderListByOrderNo_Failure';
const Action_UpdateOrderStatus_Request = 'Action_UpdateOrderStatus_Request';
const Action_UpdateOrderStatus_Response = 'Action_UpdateOrderStatus_Response';
const Action_UpdateOrderStatus_Failure = 'Action_UpdateOrderStatus_Failure';
const Action_UpdateTaskStatus_Request = 'Action_UpdateTaskStatus_Request';
const Action_UpdateTaskStatus_Response = 'Action_UpdateTaskStatus_Response';
const Action_UpdateTaskStatus_Failure = 'Action_UpdateTaskStatus_Failure';
const Action_DeleteByOrderNo_Request = 'Action_DeleteByOrderNo_Request';
const Action_DeleteByOrderNo_Response = 'Action_DeleteByOrderNo_Response';
const Action_DeleteByOrderNo_Failure = 'Action_DeleteByOrderNo_Failure';
//var debug = process.env.NODE_ENV !== 'production' ? true : false;
//let dev = debug ? '' : '';
export{
    Action_GetOrderList_Request,
    Action_GetOrderList_Response,
    Action_GetOrderList_Failure,
    Action_GetOrderListByOrderNo_Request,
    Action_GetOrderListByOrderNo_Response,
    Action_GetOrderListByOrderNo_Failure,
    Action_UpdateOrderStatus_Request,
    Action_UpdateOrderStatus_Response,
    Action_UpdateOrderStatus_Failure,
    Action_UpdateTaskStatus_Request,
    Action_UpdateTaskStatus_Response,
    Action_UpdateTaskStatus_Failure,
    Action_DeleteByOrderNo_Request,
    Action_DeleteByOrderNo_Response,
    Action_DeleteByOrderNo_Failure,
}
export function getOrderList(page,pageSize,callback) {
   let data = [];
    data.page = page;
    data.pageSize = pageSize;

    let url = (`/remote/myApp/index.php/test/test`);//http://localhost/myApp/index.php?r=ucOrders/admin
    return {
        [CALL_API]: {
            types: [
                Action_GetOrderList_Request,
                Action_GetOrderList_Response,
                Action_GetOrderList_Failure
            ],
            endpoint: url,
            callback: callback,
            data:data,
        },
    };
}
export function UpdateOrderStatus(selectedRowOrder,callback) {
    let data = [];
    data.orderList= selectedRowOrder.join("*");
    let url = (`/remote/myApp/index.php/test/UpdateOrderStatusByOrderNo`);
    return {
        [CALL_API]: {
            types: [
                Action_UpdateOrderStatus_Request,
                Action_UpdateOrderStatus_Response,
                Action_UpdateOrderStatus_Failure
            ],
            endpoint: url,
            callback: callback,
            data:data,
        },
    };
}
export function UpdateTaskStatus(selectedRowOrder,callback) {
    let data = [];
    data.orderList= selectedRowOrder.join("*");
    let url = (`/remote/myApp/index.php/test/UpdateTaskStatusByOrderNo`);
    return {
        [CALL_API]: {
            types: [
                Action_UpdateTaskStatus_Request,
                Action_UpdateTaskStatus_Response,
                Action_UpdateTaskStatus_Failure
            ],
            endpoint: url,
            callback: callback,
            data:data,
        },
    };
}
export function DeleteByOrder_no(selectedRowOrder,callback) {
    let data = [];
    data.orderList= selectedRowOrder.join("*");
    let url = (`/remote/myApp/index.php/test/DeleteByOrderNo`);
    return {
        [CALL_API]: {
            types: [
                Action_DeleteByOrderNo_Request,
                Action_DeleteByOrderNo_Response,
                Action_DeleteByOrderNo_Failure
            ],
            endpoint: url,
            callback: callback,
            data:data,
        },
    };
}

export function getOrderListByOrderNo(receiver_name,order_no,status,page,pageSize,order_type,fromDate,toDate,callback) {
    let data = [];
    data.order_no = order_no;
    data.receiver_name=receiver_name;
    data.status = status;
    data.page = page;
    data.pageSize = pageSize;
    data.order_type = order_type;
    data.fromDate = fromDate;
    data.toDate = toDate;

    let url = (`/remote/myApp/index.php/test/testByOrderNo`);//http://localhost/myApp/index.php?r=ucOrders/admin
    return {
        [CALL_API]: {
            types: [
                Action_GetOrderListByOrderNo_Request,
                Action_GetOrderListByOrderNo_Response,
                Action_GetOrderListByOrderNo_Failure
            ],
            endpoint: url,
            callback: callback,
            data:data,
        },
    };
}