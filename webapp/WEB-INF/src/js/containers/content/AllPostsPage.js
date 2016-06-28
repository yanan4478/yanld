/**
 * Created by xgz on 16/5/18.
 */
import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import { bindActionCreators } from 'redux';
import Tab from 'libComponent/Tab.js'
import List from 'libComponent/List.js'
import ListItem from 'libComponent/ListItem.js'
import { Tabs,Row,Col, } from 'antd';
const TabPane = Tabs.TabPane;

class AllPostsPage extends Component {

    static defaultProps = {
        content:[],

    };

    state = {

    };

    static propTypes = {
        title: React.PropTypes.string,
        content: React.PropTypes.array,

    };

    componentWillMount() {

    }

    componentDidMount() {

    }

    componentWillUnmount () {

    }

    componentWillReceiveProps(nextProps) {

    }

   renderItem=(item)=>{
       console.log("=======")
       return (
           <ListItem;
               author={item.author}
               title={item.title}
               createDate={item.CreateDate}
               read={item.read}
               like={item.like}
               comment={item.comment}
               dislike={item.dislike}
           />
       )
   }
    render(){
        console.log("props",this.props);
        var _this = this;
        const items =[
            {title:"快让开，你自作多情的样子太丑了",author:"顾一宸",CreateDate:"3月之前",read:" 7101",comment:" 191",like:"246",dislike:"10"},
            {title:"干货又来了！提高英语听力秘诀+关键+工具）",CreateDate:"顾一宸",time:"3月之前",read:" 7101",comment:" 191",like:"246",dislike:"10"},
            {title:"你这么怂，我看还是别上班了！",author:"顾一宸",CreateDate:"3月之前",read:" 7101",comment:" 191",like:"246",dislike:"10"},
            {title:"读完这本书，让你更加了解情爱",author:"顾一宸",CreateDate:"3月之前",read:" 7101",comment:" 191",like:"246",dislike:"10"},
            {title:"简书早报160628——《修德、网吧、师徒，今天不讲道理讲故事》",author:"顾一宸",CreateDate:"3月之前",read:" 7101",comment:" 191",like:"246",dislike:"10"},
            {title:"他们的文章很有趣，值得你关注",author:"顾一宸",CreateDate:"3月之前",read:" 7101",comment:" 191",like:"246",dislike:"10"},
            {title:"我们始终是爱自己，胜过爱爱情",author:"顾一宸",CreateDate:"3月之前",read:" 7101",comment:" 191",like:"246",dislike:"10"},
            {title:"既见君子，云胡不喜？",author:"顾一宸",CreateDate:"3月之前",read:" 7101",comment:" 191",like:"246",dislike:"10"},
            {title:"女为悦己者容，更为悦自己容",author:"顾一宸",CreateDate:"3月之前",read:" 7101",comment:" 191",like:"246",dislike:"10"},

        ];
        return (

            <div>
                <Row >
                    <Col; span={24}>
                        <Tab; key="hot"; text="热门"; onSelect={_this.handleSelect};;></Tab>
                        <Tab; key="java"; text="JAVA"; onSelect={_this.handleSelect}></Tab>
                        <Tab; key="web"; text="WEB前端"; onSelect={_this.handleSelect}></Tab>
                        <Tab; key="ios"; text="IOS"; onSelect={_this.handleSelect}></Tab>
                        <Tab; key="android"; text="安卓"; onSelect={_this.handleSelect}></Tab>
                    </Col>
                </Row>
                <Row; style={{"20px"};;}>
                    <Col; span={24}>
                        <List>
                            {
                              items.map(function(item){
                                     return _this.renderItem(item)
                             });
                            }
                        </List>
                    </Col>
                </Row>
            </div>;
        )
    }
}

function mapStateToProps(state) {
    console.log("props",state);
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