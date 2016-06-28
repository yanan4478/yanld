import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import * as DocsCreators from './../actions/docsActions.js';
import { bindActionCreators } from 'redux';
import 'antd/dist/antd.less';

import { DatePicker, message,Menu, Breadcrumb, Icon,Col,Row } from 'antd';

require("style/layout.less")

const SubMenu = Menu.SubMenu

class Layout extends Component {

    static defaultProps = {
        title : "Hello React",
        complist:[],
        rawData:{}
    };

    state = {
        date: '',
        collapse:false,
    }

    static propTypes = {
        title: React.PropTypes.string,
    }

    componentWillMount() {

    }

    componentDidMount() {

    }

    componentWillUnmount () {

    }

    componentWillReceiveProps(nextProps) {

    }

    onMenuClick = (item, key, keyPath)=>{
        console.log(key,item)

        switch (item.key){
            case "content":
                this.props.pushState(null,"/client/page/content")
                break;
            case "topic":
                this.props.pushState(null,"/client/page/topic")
                break;
             }
}

    render(){
        return (
            <div>
            {/*left size*/}
                <Row>
                    <Col span={2}>
                            <Menu onClick={this.onMenuClick} mode="inline" className="sidebar-bg" theme="dark" defaultSelectedKeys={['content']} style={{height:window.screen.availHeight ,backgroundColor:"#404040",overflow:'hidden',position:"fixed",left:"0",top:"0",zIndex:"1048"}}>
                              <Menu.Item key="content"><Icon type="home" /><span className="nav-text">首页</span></Menu.Item>
                                <Menu.Item key="topic"><Icon type="appstore" /><span className="nav-text">专题</span></Menu.Item>
                            </Menu>
                    </Col>
                    <Col span={22}>
                        {this.props.children}
                    </Col>
                </Row>
            </div>
        )
    }


}

function mapStateToProps(state) {

    return {q: state.router.location.query.q, rawData:state.docsReducer};
}

function mapDispatchToProps(dispatch) {
    return {
        dispath:dispatch,
        actions: bindActionCreators(DocsCreators, dispatch),
        pushState: bindActionCreators(pushState, dispatch)
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Layout);