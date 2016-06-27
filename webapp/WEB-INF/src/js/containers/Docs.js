import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import * as DocsCreators from './../actions/LoginActions.js';
import { bindActionCreators } from 'redux';
import 'antd/dist/antd.less';

import { DatePicker, message,Menu, Breadcrumb, Icon } from 'antd';

require("style/docs.less")

const SubMenu = Menu.SubMenu

class Docs extends Component {

    static defaultProps = {
        title : "Hello React",
        complist:[],
        rawData:{},
        isAuth:false,
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
        console.log(nextProps.isAuth)

        if(nextProps.isAuth === true){
            //document.location.href = "/client/page/nav1"
            console.log("isAuth",this.props.isAuth)
            this.props.pushState(null,"/client/page/nav1")
        }
    }

    onMenuClick = (item, key, keyPath)=>{
        console.log(key,item)

        this.props.actions.login(null);
    }

    render(){

        const collapse = this.state.collapse;
        return (
            <div>
            <div className="viewFramework-topbar">
                login
            </div>
            <div className={collapse ? "ant-layout-aside ant-layout-aside-collapse" : "viewFramework-body ant-layout-aside"}>
                <div className="viewFramework-sidebar viewFramework-sidebar-full">
                    <div className="sidebar-content">
                        <div>
                            <div className="sidebar-fold"><Icon type="menu-fold" /></div>
                            <div className="ant-layout-logo"></div>
                            <Menu onClick={this.onMenuClick} mode="inline" className="sidebar-bg" theme="dark" defaultSelectedKeys={['user']}>
                                <Menu.Item key="user">
                                    <Icon type="user" /><span className="nav-text">用户管理</span>
                                </Menu.Item>
                                <SubMenu title="系统管理">
                                    <Menu.Item>角色管理</Menu.Item>
                                </SubMenu>
                                <Menu.Item key="setting">
                                    <Icon type="setting" /><span className="nav-text">导航二</span>
                                </Menu.Item>
                                <Menu.Item key="laptop">
                                    <Icon type="laptop" /><span className="nav-text">导航三</span>
                                </Menu.Item>
                                <Menu.Item key="notification">
                                    <Icon type="notification" /><span className="nav-text">导航四</span>
                                </Menu.Item>
                                <Menu.Item key="folder">
                                    <Icon type="folder" /><span className="nav-text">导航五</span>
                                </Menu.Item>
                            </Menu>
                        </div>
                    </div>
                </div>
                <div className="viewFramework-product">
                    {this.props.children}
                </div>
            </div>
            </div>
        )
    }
}

function mapStateToProps(state) {

    return {q: state.router.location.query.q, rawData:state.auth,isAuth:state.auth.isAuthenticated};
}

function mapDispatchToProps(dispatch) {
    return {
        dispath:dispatch,
        actions: bindActionCreators(DocsCreators, dispatch),
        pushState: bindActionCreators(pushState, dispatch)
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Docs);