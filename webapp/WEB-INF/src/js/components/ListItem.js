/**
 * Created by XK on 2016/6/28.
 */
require("../../less/component/listItem.less")
import React from 'react';

import {connect} from 'react-redux';
import {pushState} from 'redux-router';
import { Row,Col, } from 'antd';
export default class ListItem extends React.Component{
    static defaultProps = {

    };
    static propTypes: {

        }
    render=()=>{
        console.log("++++++++++++++++++");
        console.log(this.props.content);
        return (

            <li className="listItem">
                <Row>
                    <Col span={20}>
                        <p className="gutter"><a className="author" onClick={this.props.onSelectAuthor}>{this.props.author} </a>&nbsp;&nbsp;.&nbsp;&nbsp;<a className="createDate">{this.props.createDate}</a></p>
                        <h3 className="title gutter"><a onClick={this.props.onSelect}>{this.props.title}</a></h3>
                        <p className="gutter foot"><a className="read" onClick={this.props.onSelect}>阅读&nbsp;{this.props.read}</a><a className="comment" onClick={this.props.onSelect}>评论&nbsp;{this.props.comment}</a><a className="like">赞&nbsp;{this.props.like}</a><a className="dislike">踩&nbsp;{this.props.dislike}</a></p>
                    </Col>
                    <Col span={4}>图片</Col>
                </Row>
            </li>

        )

    }
}