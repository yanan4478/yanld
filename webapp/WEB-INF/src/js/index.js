/**
 * Created by xgz on 15/11/5.
 */
import 'babel-core/polyfill'
import React from 'react'
import { render } from 'react-dom'
import { Provider } from 'react-redux'
import Root from './containers/Root'
import configureStore from './store/configureStore'

const store = configureStore()

console.log("_store",store)

render(
    <Root store={store} />,
    document.getElementById('root')
)
