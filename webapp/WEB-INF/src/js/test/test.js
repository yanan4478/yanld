/**
 * Created by xgz on 15/11/2.
 */

import { combineReducers, createStore,bindActionCreators, applyMiddleware, compose } from 'redux';

import thunk from 'redux-thunk'
//import api from '../middleware/api'
import createLogger from 'redux-logger'
import rootReducer from '../reducers'

import api from '../middleware/api'
import * as calPageCreators from "../actions/calPageActionCreators.js"

const finalCreateStore = compose(
    applyMiddleware(thunk,api)
)(createStore)

const store = finalCreateStore(rootReducer)

let actionCre = bindActionCreators(calPageCreators,store.dispatch);

// 打印初始状态
//console.log(store.getState());

// 监听 state 更新时，打印日志
let unsubscribe = store.subscribe(() =>
        console.log(store.getState())
);

actionCre.getCalList("od-5Ut75Nw6AJmiAIS8UnT-A6jDg");

// 发起一系列 action
/*store.dispatch(addTodo('Learn about actions'));
store.dispatch(addTodo('Learn about reducers'));
store.dispatch(addTodo('Learn about store'));
store.dispatch(completeTodo(0));
store.dispatch(completeTodo(1));
store.dispatch(setVisibilityFilter(VisibilityFilters.SHOW_COMPLETED));*/

//actionCre.addTodo('Learn about actions');

//console.log(actionCre);

console.info("start...");

// 停止监听 state 更新
unsubscribe();