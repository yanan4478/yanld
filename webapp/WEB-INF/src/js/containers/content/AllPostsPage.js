/**
 * Created by xgz on 16/5/18.
 */
import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import { bindActionCreators } from 'redux';

import { Tabs } from 'antd';
const TabPane = Tabs.TabPane;

class AllPostsPage extends Component {

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


    render(){
        console.log("props",this.props)
        return (
            <div>
               allPosts
            </div>
        )
    }
}

function mapStateToProps(state) {
    console.log("props",state)
    return {q: state.router.location.query.q};
}

function mapDispatchToProps(dispatch) {
    return {
        dispath:dispatch,
        //actions: bindActionCreators(DocsCreators, dispatch),
        pushState: bindActionCreators(pushState, dispatch)
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(AllPostsPage);