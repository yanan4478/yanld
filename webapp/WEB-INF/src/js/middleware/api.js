/**
 * Created by xgz on 15/11/27.
 */
import 'isomorphic-fetch'
import { pushState,replaceState } from 'redux-router';
import { normalize, Schema, arrayOf } from 'normalizr';
import cookie from "react-cookie"


var AppConfig = require("util/appConfig")

console.log("api:" + process.env.NODE_ENV)
let API_ROOT = AppConfig.hostName;
/*console.log(process.env.NODE_ENV)
if (process.env.NODE_ENV !== 'production') {
    API_ROOT = 'http://localhost:3000'
}*/

//console.log(API_ROOT)

var serialize = function (data) {
    data = data || {};
    return Object.keys(data).map(function (keyName) {
        return encodeURIComponent(keyName) + '=' + encodeURIComponent(data[keyName])
    }).join('&');
};

var getCookieParam = (name)=>{
    let value = cookie.load(name);

    return value == undefined? -1:value;
}

var commonParams = (data)=>{

    let agentid = getCookieParam("agentid");
    let dataid = getCookieParam("dataid");

    if(data.wxopenid == undefined){
        let wxopenid = getCookieParam("wxopenid");
        data.wxopenid = wxopenid;
    }

    if(data.dataid == undefined){
        data.dataid = dataid;
    }

    if(data.agentid == undefined){
        data.agentid = agentid;
    }

    return data;
}

// Fetches an API response and normalizes the result JSON according to schema.
// This makes every API response have the same shape, regardless of how nested it was.
function callApi(endpoint,json,schema) {
    const fullUrl = (endpoint.indexOf("http") === -1) ? API_ROOT + endpoint : endpoint

    json = commonParams(json)

    return fetch(fullUrl,{
        method: 'post',
        headers: {
            "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
        },
        body: serialize(json)
    })
        .then(response =>
            response.json().then(json => ({ json, response }))
    ).then(({ json, response }) => {

            if (!response.ok) {
                return Promise.reject(json)
            }

            if(!!schema && json.code == 0){
                var jsonObj = json.object || json.list || json.body || {}

                return Object.assign({},
                    normalize(jsonObj, schema)
                )
            }else{
                return json
            }

        })
}

// Action key that carries API call info interpreted by this Redux middleware.
export const CALL_API = ('ZS_Call_API')

export default store => next => action => {

    const callAPI = action[CALL_API]
    if (typeof callAPI === 'undefined') {
        return next(action)
    }

    let {endpoint,data,callback,schema} = callAPI
    const { types } = callAPI

    data = data || {};

    //callback = callback || function(){}

    if (!Array.isArray(types) || types.length !== 3) {
        throw new Error('Expected an array of three action types.')
    }

    if (!types.every(type => typeof type === 'string')) {
        throw new Error('Expected action types to be strings.')
    }

    function actionWith(data) {
        const finalAction = Object.assign({}, action, data)
        delete finalAction[CALL_API]
        return finalAction
    }

    /**
     * let newQuery = {};
     //Filter out empty and null values
     for (let queryKey in newQueryParts) {
                if (!String(newQueryParts[queryKey]).length) continue;
                newQuery[queryKey] = newQueryParts[queryKey];
            }
     next(replaceState(null, url, newQuery));
     */

    const [ requestType, successType, failureType ] = types

    next(actionWith({ type: requestType,data: data}))

    return callApi(endpoint,data,schema).then(
            response => {

                console.log(response)

                if(!!data.redirect && response.code == 0){
                    console.log(data.redirect)
                    next(pushState(null, data.redirect))
                }else{

                    if(!!callback){
                        callback(null,response)
                    }

                    return next(actionWith({
                        response:response,
                        requestData:data,
                        type: successType,
                        receivedAt: Date.now()
                    }))
                }
            } ,
            error =>{
                if(!!callback){
                    callback(error)
                }

                next(actionWith({
                    type: failureType,
                    data:data,
                    error: error.message || 'Something bad happened'
                }))
            }
        );
}
