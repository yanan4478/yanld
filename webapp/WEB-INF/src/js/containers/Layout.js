import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import * as DocsCreators from './../actions/docsActions.js';
import { bindActionCreators } from 'redux';
import 'antd/dist/antd.less';

import { DatePicker, message,Menu, Breadcrumb, Icon } from 'antd';

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
            case "user":
                this.props.pushState(null,"/client/page/nav1")
                break;
            case "order":
                this.props.pushState(null,"/client/page/nav3")
                break;
            default:
                this.props.pushState(null,"/client/page/nav2")
                break;
        }
        /*if(item.key == "user")
            this.props.pushState(null,"/client/page/nav1")
        else{
            this.props.pushState(null,"/client/page/nav2")
        }*/
    }

    render(){
        const collapse = this.state.collapse;

        /*
         <SubMenu title={<span><Icon type="folder" /><span className="nav-text">内容管理</span></span>}>
         <Menu.Item><Icon type="folder" /><span className="nav-text">内容管理</span></Menu.Item>
         </SubMenu>
         */
        return (
            <div>
            <div className="viewFramework-topbar">

            </div>
            <div className={collapse ? "ant-layout-aside ant-layout-aside-collapse" : "viewFramework-body ant-layout-aside"}>
                <div className="viewFramework-sidebar viewFramework-sidebar-full">
                    <div className="sidebar-content">
                        <div>
                            <div className="sidebar-fold"><Icon type="menu-fold" /></div>
                            <div className="ant-layout-logo"></div>
                            <Menu onClick={this.onMenuClick} mode="inline" className="sidebar-bg" theme="dark" defaultSelectedKeys={['content']}>

                                <Menu.Item key="content"><Icon type="folder" /><span className="nav-text">内容管理</span></Menu.Item>

                                <Menu.Item key="setting">
                                    <Icon type="setting" /><span className="nav-text">圈子管理</span>
                                </Menu.Item>
                                <Menu.Item key="laptop">
                                    <Icon type="laptop" /><span className="nav-text">产品管理</span>
                                </Menu.Item>
                                <Menu.Item key="notification">
                                    <Icon type="notification" /><span className="nav-text">供需管理</span>
                                </Menu.Item>
                                <Menu.Item key="user">
                                    <Icon type="user" /><span className="nav-text">用户管理</span>
                                </Menu.Item>
                                <Menu.Item key="order">
                                    <Icon type="pay-circle-o" /><span className="nav-text">订单管理</span>
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

    renderItem() {

        return <div style={{width: 400, margin: '100px auto'}}>
            <DatePicker onChange={this.handleChange} />
            <div style={{marginTop: 20}}>当前日期：{this.state.date.toString()}</div>
        </div>;
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