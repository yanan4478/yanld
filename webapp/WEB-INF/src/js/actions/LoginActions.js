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

const Action_AuthLogin_Request = 'Action_AuthLogin_Request'

const Action_AuthLogin_Response = 'Action_AuthLogin_Response'

const Action_AuthLogin_FAILURE = 'Action_AuthLogin_FAILURE'

export{
    Action_AuthLogin_Request,
    Action_AuthLogin_Response,
    Action_AuthLogin_FAILURE
}

export function login(data){

    return {
        [CALL_API]:{
            types:[
                Action_AuthLogin_Request,
                Action_AuthLogin_Response,
                Action_AuthLogin_FAILURE],
            endpoint:"/componentJson",
            data:data
        }
    }
}
