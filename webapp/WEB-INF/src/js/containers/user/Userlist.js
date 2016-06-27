import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import { bindActionCreators } from 'redux';
import 'antd/dist/antd.less';

import { DatePicker, message,Menu, Breadcrumb, Icon } from 'antd';

class Userlist extends Component {

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
        const collapse = this.state.collapse;
        return (
            <div>
                userlist
            </div>
        )
    }
}

function mapStateToProps(state) {
   
    return {q: state.router.location.query.q, rawData:state.orderReducers};
}

function mapDispatchToProps(dispatch) {
    return {
        dispath:dispatch,
        //actions: bindActionCreators(DocsCreators, dispatch),
        pushState: bindActionCreators(pushState, dispatch)
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Userlist);