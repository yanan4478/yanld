import { createStore, applyMiddleware, compose,combineReducers } from 'redux'
import { reduxReactRouter,routerStateReducer} from 'redux-router'
import createBrowserHistory from 'history/lib/createBrowserHistory'
import createHashHistory from 'history/lib/createHashHistory'
import configureRoutes from '../routes'
import thunk from 'redux-thunk'
//import api from '../middleware/api'
import createLogger from 'redux-logger'
import rootReducer from '../reducers'
import ReducerRegistry from '../reducers/ReducerRegistry.js'

import api from '../middleware/api'

var reducerRegistry = new ReducerRegistry(rootReducer)
var routes = configureRoutes(reducerRegistry);

// Use hash location for Github Pages
// but switch to HTML5 history locally.
const createHistory = process.env.NODE_ENV === 'production' ?
    createBrowserHistory : createBrowserHistory;

//console.log(createHistory)

const  configureReducers = (reducers) => {
  return combineReducers({
    ...reducers,
    // Combine core third-party reducers here, e.g.:
    // form: formReducer
      //router:routerStateReducer
  })
}

const finalCreateStore = compose(
    applyMiddleware(thunk,api),
    reduxReactRouter({
      routes,
      createHistory ,
      //routerStateSelector: state => state.get('router')
    }),
    applyMiddleware(createLogger()),
    window.devToolsExtension ? window.devToolsExtension() : f => f
)(createStore)

export default function configureStore(initialState) {
    //console.log(reducerRegistry.getReducers())
  var rootReducer = configureReducers(reducerRegistry.getReducers())

  const store = finalCreateStore(rootReducer, initialState)

  // Reconfigure the store's reducer when the reducer registry is changed - we
  // depend on this for loading reducers via code splitting and for hot
  // reloading reducer modules.
  reducerRegistry.setChangeListener((reducers) => {
    store.replaceReducer(configureReducers(reducers))
  })

  if (module.hot) {
    // Enable Webpack hot module replacement for reducers
    module.hot.accept('../reducers', () => {
      const nextRootReducer = require('../reducers')
      store.replaceReducer(nextRootReducer)
    })
  }

  return store
}


