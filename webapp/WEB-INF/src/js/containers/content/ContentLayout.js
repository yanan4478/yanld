/**
 * Created by xgz on 16/5/18.
 */
import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import { bindActionCreators } from 'redux';

import AllPostsPage from './AllPostsPage'

import { Tabs,Row,Col,Icon } from 'antd';
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

            <Row >
                <Col xs={{span:0}} sm={{span:5}} lg={{span:6}} style={{position:"fixed"}} >
                    <img src={require("res/img/cover/contentCover.jpg")}  style={{width:"100%",height:window.screen.availHeight}}/>
                    <div style={{position:"fixed",bottom:"10%",color:"#fff",opacity:"0.8",paddingLeft:"14px",fontFamily: '"lucida grande", "lucida sans unicode", lucida, helvetica, "Hiragino Sans GB", "Microsoft YaHei", "WenQuanYi Micro Hei", sans-serif'}}>
                        <h1 style={{lineHeight:"50px",fontSize:"30px"}}>IT老炮</h1>
                        <h3 style={{lineHeight:"30px",fontSize:"20px"}}>上班嚼干货，下班聊八卦</h3>
                        <p style={{lineHeight:"30px",fontSize:"11px"}}>一个集内涵与深度于一体的IT社区</p>
                        <a class="btn btn btn-large btn-success" id="write-button" data-signin-link="true" data-toggle="modal"  style={{textAlign:"center",padding:"5px",lineHeight:"40px",fontSize:"14px",color:"#fff",backgroundColor:"#49BE38",borderRadius:"5px"}}><Icon type="edit" />  提笔写篇文章</a>
                    </div>{/**/}


                </Col>
                <Col xs={{span:24,offset:0}} sm={{span:19,offset:5}} lg={{span:18,push:2}}  >
                    <Row>
                        <Col xs={{span:24,offset:0}} sm={{span:16}}  >
                            <Tabs defaultActiveKey="1" onChange={this.callback} >
                                <TabPane tab="上班时间看干货" key="1">{this.renderAllPosts()}</TabPane>
                                <TabPane tab="闲暇看八卦" key="2">{this.props.children}</TabPane>
                            </Tabs>
                        </Col>
                        <Col xs={{span:0,offset:0}} sm={{span:8}} ></Col>
                    </Row>
                    {/**/}
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