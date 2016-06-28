import React, { Component } from 'react';
import { connect } from 'react-redux'

class App extends React.Component {

    render() {

        return this.props.children

    }
}

function mapStateToProps(state) {

    return {};
}

function mapDispatchToProps(dispatch) {
    return {
        dispath:dispatch
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(App);