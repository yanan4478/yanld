import React from 'react'
import { Router, Route,IndexRoute } from 'react-router'
import App from './containers/App.js'
import Layout from  "./containers/Layout.js"
import PageComp from  "./containers/PageComp.js"
import Userlist from  "./containers/user/Userlist.js"
import Circle from  "./containers/circle/Circle"
import Docs from  "./containers/Docs.js"
import {requireAuthentication} from './components/AuthenticatedComponent';

var dynamicLoad = (bundle,reducerRegistry,obj)=>{
    //var docs = "docs";
    return (location, cb) => {
        // Webpack code splitting incantation - anything required in the callback
        // will be placed in a new chunk.

        //require.ensure([], require => {
        bundle(component=>{
            // Register the reducer depended upon by the screen component
            reducerRegistry.register(obj)
            // Configure hot module replacement for the reducer
            if (process.env.NODE_ENV !== 'production') {
                if (module.hot) {
                    module.hot.accept('./reducers', () => {
                        reducerRegistry.register(obj)
                    })
                }
            }
            cb(null, component)
        })
    }
}

const loadContainerAsync = bundle => (location, cb) => {
    bundle(component => {
        cb(null, component);
    });
};

module.exports = function configureRoutes(reducerRegistry) {

    return(

        <Route path="/client" component={App}>
            <IndexRoute component={Layout} />

            <Route path="login" component={Docs}/>

            <Route path="page" component={requireAuthentication(Layout)}>
                <Route path="content" getComponent={loadContainerAsync(require('bundle?lazy!./containers/content/ContentLayout.js'))}></Route>
                <Route path="topic" getComponent={loadContainerAsync(require('bundle?lazy!./containers/topic/Topic.js'))}></Route>

            </Route>
        </Route>
    )
}