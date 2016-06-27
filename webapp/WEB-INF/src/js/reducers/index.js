/**
 * Created by xgz on 15/11/2.
 */

import { combineReducers } from 'redux';

import { routerStateReducer } from 'redux-router';
import auth from "./authReducers"
import OrderReducers from "./OrderReducers"

// Reducers which should be included in the app's entry bundle
module.exports = {
    auth:auth,
    router: routerStateReducer,
    OrderReducers: OrderReducers
}