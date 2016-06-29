/**
 * Created by XK on 2016/6/28.
 */
require("../../less/component/list.less");
import React from 'react';

import {connect} from 'react-redux';
import {pushState} from 'redux-router';
export default class List extends React.Component{
    static defaultProps = {

    };
    static propTypes: {

        };
    render=()=>{
        return (
            <div>
                <ul className="list">{this.props.children}</ul>
            </div>
        )

    }
}