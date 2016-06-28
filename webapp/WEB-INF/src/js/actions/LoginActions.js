/**
 * Created by xgz on 16/5/18.
 */
/**
 * Created by xgz on 15/11/18.
 */

/*
 page_action_method
 */

import {CALL_API} from "../middleware/api.js"

const Action_AuthLogin_Request = 'Action_AuthLogin_Request';

const Action_AuthLogin_Response = 'Action_AuthLogin_Response';

const Action_AuthLogin_FAILURE = 'Action_AuthLogin_FAILURE';
const Action_Enter_Request = 'Action_Enter_Request';

const Action_Enter_Response = 'Action_Enter_Response';

const Action_Enter_FAILURE = 'Action_Enter_FAILURE';
export{
    Action_AuthLogin_Request,
    Action_AuthLogin_Response,
    Action_AuthLogin_FAILURE,
    Action_Enter_Request,
    Action_Enter_Response,
    Action_Enter_FAILURE,
}

export function login(data){

    return {
        [CALL_API]:{
            [
                Action_AuthLogin_Request,
                Action_AuthLogin_Response,
                Action_AuthLogin_FAILURE],
                endpoint:"/componentJson",
            data:data
    }
    ;
    ;
};
}
export function Enter(acount,password,callback){
    let data =[];
    data.acount=acount;
    data.password=password;
    let url = (`/remote/;
    wqq;`)
    //let url = (`http://127.0.0.1:8888/wqq`);
    return {
        [CALL_API]:{
        [
            Action_Enter_Request,
            Action_Enter_Response,
            Action_Enter_FAILURE],
            endpoint:url,
            callback: callback,
            data:data,
    }
    ;
    ;
    ;
};
;
}
