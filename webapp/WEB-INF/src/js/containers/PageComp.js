/**
 * Created by xgz on 15/11/19.
 */
import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState,goBack } from 'redux-router';
import { bindActionCreators } from 'redux';

class PageComp extends Component {

    constructor(props) {
        super(props);
    }

    render() {

        return this.props.children
    }
}

function mapStateToProps(state) {

    return {q: state.router.location.query.q};
}

function mapDispatchToProps(dispatch) {
    return {
        dispath:dispatch,
        pushState: bindActionCreators(pushState, dispatch),
        goBack:bindActionCreators(goBack, dispatch)
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(PageComp);