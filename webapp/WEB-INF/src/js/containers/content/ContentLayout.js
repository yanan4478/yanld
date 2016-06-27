/**
 * Created by xgz on 16/5/18.
 */
import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import { bindActionCreators } from 'redux';

import AllPostsPage from './AllPostsPage'

import { Tabs } from 'antd';
const TabPane = Tabs.TabPane;

class ContentLayout extends Component {

    static defaultProps = {

    };

    state = {

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

    callback = (key)=>{
        console.log(key);
        //this.props.pushState(null,"/client/page/content/")
        //document.location.href = `/client/page/content/${key}`

    }

    renderAllPosts(){
        return <AllPostsPage />;
    }

    render(){

        return (
            <div>
                <Tabs defaultActiveKey="1" onChange={this.callback}>
                    <TabPane tab="所有贴" key="1">{this.renderAllPosts()}</TabPane>
                    <TabPane tab="图文贴" key="2">{this.props.children}</TabPane>
                    <TabPane tab="产品贴" key="3">{this.props.children}</TabPane>
                    <TabPane tab="活动贴" key="4">{this.props.children}</TabPane>
                    <TabPane tab="直播贴" key="5">{this.props.children}</TabPane>
                </Tabs>
            </div>
        )
    }
}

function mapStateToProps(state) {

    return {q: state.router.location.query.q};
}

function mapDispatchToProps(dispatch) {
    return {
        dispath:dispatch,
        //actions: bindActionCreators(DocsCreators, dispatch),
        pushState: bindActionCreators(pushState, dispatch)
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(ContentLayout);