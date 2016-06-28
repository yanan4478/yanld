/**
 * Created by xgz on 15/11/18.
 */

/*
    page_action_method
 */

import {CALL_API} from "../middleware/api.js"

const Docs_Action_GetCompList_Request = 'Docs_Action_GetCompList_Request';

const Docs_Action_GetCompList_Response = 'Docs_Action_GetCompList_Response';

const Docs_Action_GetCompList_FAILURE = 'Docs_Action_GetCompList_FAILURE'

export{
    Docs_Action_GetCompList_FAILURE,
    Docs_Action_GetCompList_Request,
    Docs_Action_GetCompList_Response
}

export function getCompList(data){

    return {
        [CALL_API]:{
            types:[Docs_Action_GetCompList_Request,Docs_Action_GetCompList_Response,Docs_Action_GetCompList_FAILURE],
            endpoint:"/componentJson",
            data:data
        }
    }
}
