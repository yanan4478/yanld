/**
 * Created by xgz on 16/5/18.
 */
import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import { bindActionCreators } from 'redux';

import AllPostsPage from './AllPostsPage'

import { Tabs,Row,Col } from 'antd';
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

                <Row>
                    <Col span={8} >
                            <img src={require("res/img/cover/contentCover.jpg")} style={{position:"fixed",left:"45px",top:"0",display:"block"}} />
                            <div style={{position:"absolute",bottom:"0",color:"#fff"}}>
                                <h1>IT老炮</h1>
                                <h3>上班嚼干活，下班聊八卦</h3>
                                <p>一个集内涵与深度于一体的社区</p>
                                <a class="btn btn btn-large btn-success" id="write-button" data-signin-link="true" data-toggle="modal" href="/sign_in">提笔写篇文章</a>
                            </div>


                    </Col>
                    <Col span={15} >
                         <Tabs defaultActiveKey="1" onChange={this.callback} >
                            <TabPane tab="上班时间看干货" key="1">{this.renderAllPosts()}</TabPane>
                            <TabPane tab="闲暇看八卦" key="2">{this.props.children}</TabPane>
                         </Tabs>
                    </Col>
                </Row>


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