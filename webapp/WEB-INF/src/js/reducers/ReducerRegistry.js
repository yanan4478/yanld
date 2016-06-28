/**
 * Created by xgz on 15/11/26.
 */
// Based on https://github.com/rackt/redux/issues/37#issue-85098222
export default class ReducerRegistry {

    constructor(initialReducers = {}) {
        this.__reducers = {...initialReducers}
        this._emitChange = null
    }

    register = (newReducers)=>{
        this.__reducers = {...this.__reducers, ...newReducers}
        if (this._emitChange != null) {
            this._emitChange(this.getReducers())
        }
    }

    getReducers = () => {
        return {...this.__reducers}
    }

    setChangeListener = (listener)=>{
        if (this._emitChange != null) {
            throw new Error('Can only set the listener for a ReducerRegistry once.')
        }
        this._emitChange = listener
    }
}
