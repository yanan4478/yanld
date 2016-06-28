import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import { bindActionCreators } from 'redux';
import 'antd/dist/antd.less';

class Circle extends Component {

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

    render(){
        const collapse = this.state.collapse;
        return (
            <div>
                circle
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
        //actions: bindActionCreators(DocsCreators, dispatch),
        pushState: bindActionCreators(pushState, dispatch)
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Circle);