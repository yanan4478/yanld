import React from 'react';
import {connect} from 'react-redux';
import {pushState} from 'redux-router';

export function requireAuthentication(Component) {

    class AuthenticatedComponent extends React.Component {

        componentWillMount () {
            this.checkAuth(this.props.isAuthenticated);
        }

        componentWillReceiveProps (nextProps) {
            this.checkAuth(nextProps.isAuthenticated);
        }

        checkAuth (isAuthenticated) {
            console.log("_isAuthenticated",isAuthenticated)
            if (!isAuthenticated) {
                let redirectAfterLogin = this.props.location.pathname;
                this.props
                    .dispatch(pushState(null, `/client/login?next=${redirectAfterLogin}`));
            }
        }

        render () {
            return (
                <div>
                    {this.props.isAuthenticated === true
                        ? <Component {...this.props}/>
                        : null
                    }
                </div>
            )

        }
    }

    const mapStateToProps = (state) => ({
        token: state.auth && state.auth.token,
        userName: state.auth && state.auth.userName,
        //isAuthenticated: state.auth && state.auth.isAuthenticated
        //ToDO
        isAuthenticated:true,
    });

    return connect(mapStateToProps)(AuthenticatedComponent);

}
