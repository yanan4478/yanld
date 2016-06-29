/**
 * Created by XK on 2016/6/28.
 */
require("../../less/component/tab.less");
import React from 'react';

import {connect} from 'react-redux';
import {pushState} from 'redux-router';
export default class Tab extends React.Component{
    static defaultProps = {
       text:"",
    };
    static propTypes: {
        onSelect:React.PropTypes.func,
        text:React.PropTypes.string
        };
    render=()=>{
        return (
            <div>
                <a onClick={this.props.onSelect} className="tab">{this.props.text}</a>
            </div>
        )

    }
}