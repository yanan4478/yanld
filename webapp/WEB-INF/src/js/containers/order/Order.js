/**
 * Created by XK on 2016/6/7.
 */
import React, { Component } from 'react';

import { connect } from 'react-redux'
import { pushState } from 'redux-router';
import { bindActionCreators } from 'redux';
import 'antd/dist/antd.less';
import * as OrderList from "actions/OrderActions.js";
import Immutable from "immutable"

import { DatePicker, message,Menu, Breadcrumb, Icon,Table } from 'antd';
import { Row,Col,Tag,Tabs} from 'antd';
import { Button,Dropdown } from 'antd';
import { Form,Input,Checkbox,Select,QueueAnim } from 'antd';
const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;
const TabPane = Tabs.TabPane;
const FormItem = Form.Item;
const RangePicker = DatePicker.RangePicker;
const ButtonGroup = Button.Group;
class Order extends Component {
    static defaultProps = {

    };
    state = {
        page:1,
        pageSize:10,
        loading:false,
        disabled:true,
        orderNo:"",
        receiver_name:"",
        status:"",
        type:0,
        order_type:"",
        fromDate:"",
        toDate:"",
        selectedRowOrder:[],
        loading:false,
    }
    static propTypes = {
        title: React.PropTypes.string,
    }
    componentWillMount() {
        var _this = this;
        this.props.actions.getOrderList(this.state.page,this.state.pageSize,(err,res)=>{
        });
    }
    componentDidMount() {

    }
    componentWillUnmount () {

    }
    componentWillReceiveProps(nextProps) {

    }
    handleTableChange(current, pageSize){
        console.log("-------当前页数----------")
       /* var _this = this;
        _this.setState({
            page:current+1,
        })
        console.log('Current: ', current);
        _this.props.actions.getOrderList(_this.state.page,_this.state.pageSize,(err,res)=>{
        });*/
    }
    callback(key) {
        console.log(key);
    }
    handleSelectChange=(value) =>{
        value!="*"?this.setState({
            status:value,
        }):this.setState({
            status:"",
        });
    }
    handleTypeSlctChange=(value)=>{
        value!="*"?this.setState({
            order_type:value,
        }):this.setState({
            order_type:"",
        });
    }
    onDateChange=(value, dateString)=> {
        console.log('From: ', value[0], ', to: ', value[1]);
        console.log('From: ', dateString[0], ', to: ', dateString[1]);
        var _this = this;
        _this.setState({
           fromDate: dateString[0],
            toDate:dateString[1],
        });
    }
    handleChange=(e)=>{
        var _this = this;

       switch(e.target.id){
            case "orderNo":
                _this.setState({
                    orderNo : e.target.value,
                });
                break ;
            case "receiver_name":
                _this.setState({
                    receiver_name : e.target.value,
                });
                break;
            default:break;
        }
    }
    handleSearch=()=>{
        var _this = this;
        console.log("status",this.state.status);
        _this.setState({
            type:1,
        });
        let page = 1;
        _this.props.actions.getOrderListByOrderNo(_this.state.receiver_name,_this.state.orderNo,_this.state.status,_this.state.page,_this.state.pageSize,_this.state.order_type,_this.state.fromDate,_this.state.toDate,(err,res)=>{
            console.log("---------------")
            console.log(res);
        });

    }
    handleSendOut=()=>{
        var _this = this ;
        /*_this.setState({
            loading:true,
        })*/
        _this.props.actions.UpdateOrderStatus(_this.state.selectedRowOrder,(err,res)=>{
           /* this.props.actions.getOrderList(this.state.page,this.state.pageSize,(err,res)=>{
            });*/
           if(res.total){
               if(_this.state.type==0){
                   _this.props.actions.getOrderList(_this.state.page,_this.state.pageSize,(err,res)=>{
                   });
               }else{
                   _this.props.actions.getOrderListByOrderNo(_this.state.receiver_name,_this.state.orderNo,_this.state.status,_this.state.page,_this.state.pageSize,_this.state.order_type,_this.state.fromDate,_this.state.toDate,(err,res)=>{

                   });
               }

           }
        });
    }
    handleDelete=()=>{
        var _this = this ;
        /*_this.setState({
         loading:true,
         })*/
        _this.props.actions.DeleteByOrder_no(_this.state.selectedRowOrder,(err,res)=>{
            if(res.total){
                if(_this.state.type==0){
                    _this.props.actions.getOrderList(_this.state.page,_this.state.pageSize,(err,res)=>{
                    });
                }else{
                    _this.props.actions.getOrderListByOrderNo(_this.state.receiver_name,_this.state.orderNo,_this.state.status,_this.state.page,_this.state.pageSize,_this.state.order_type,_this.state.fromDate,_this.state.toDate,(err,res)=>{

                    });
                }

            }
        });
    }
    handleReset=()=>{
        _this.props.actions.UpdateTaskStatus(_this.state.selectedRowOrder,(err,res)=>{
            /* this.props.actions.getOrderList(this.state.page,this.state.pageSize,(err,res)=>{
             });*/
            if(res.total){
                if(_this.state.type==0){
                    _this.props.actions.getOrderList(_this.state.page,_this.state.pageSize,(err,res)=>{
                    });
                }else{
                    _this.props.actions.getOrderListByOrderNo(_this.state.receiver_name,_this.state.orderNo,_this.state.status,_this.state.page,_this.state.pageSize,_this.state.order_type,_this.state.fromDate,_this.state.toDate,(err,res)=>{

                    });
                }

            }
        });
    }
    handleError=()=>{
        let status ='4';
        var _this = this;
        _this.props.actions.getOrderListByOrderNo(_this.state.receiver_name,_this.state.orderNo,status,_this.state.page,_this.state.pageSize,_this.state.order_type,_this.state.fromDate,_this.state.toDate,(err,res)=>{
            console.log("---------------")
            console.log(res);
        });
    }
    render(){
        var Srchdisabled=!(this.state.orderNo.length>0||this.state.receiver_name.length>0||this.state.status.length>0||this.state.order_type.length>0||((this.state.fromDate.length>0)&&(this.state.toDate.length>0)));
        var _this = this;
        const collapse = this.state.collapse;
        var arrItems = [];
        this.props.arrItems.map((item, key)=> {
            //console.log("render: "+item);
            let status;
            switch(item.get("status")){
                case '0':status="待发货";break;
                case '1':status="待付款";break;
                case '2':status="已发货";break;
                case '3':status="已付款";break;
                default:status="异常";
            };
            let order_type;
            switch(item.get("order_type")){
                case '0':order_type="日记";break;
                case '1':order_type="照片书";break;
                case '2':order_type="台历";break;

            };

           arrItems.push({
               key:key,
               order_id:item.get("order_id"),
               order_no:item.get("order_no"),
               receiver_name:item.get("receiver_name"),
               open_id:item.get("open_id"),
               receiver_mobile:item.get("receiver_mobile"),
               status:status,
               receiver_address:item.get("receiver_address"),
               order_type:order_type,
               page_num:item.get("page_num")+"页/本",
               total_price_real:item.get("total_price_real"),
               created_date:item.get("CREATED_DATE"),
               pay_time:item.get("pay_time"),
               Express_NO:item.get("Express_NO"),
               operator:item.get("operator"),
               remark:item.get("remark"),
               error_reason:item.get("error_reason")
           });
        })
        const dataSource = arrItems;
        arrItems = [];
        const columns = [{
            title: 'ID',
            dataIndex: 'order_id',
            key: 'order_id',
            width:100
        },{
            title: '订单编号',
            dataIndex: 'order_no',
            key: 'order_no',
            width:200
        },{
            title: '姓名',
            dataIndex: 'receiver_name',
            key: 'receiver_name',
            width:100
        },{
            title: '微信昵称',
            dataIndex: 'open_id',
            key: 'open_id',
            width:250
        },{
            title: '电话号码',
            dataIndex: 'receiver_mobile',
            key: 'receiver_mobile',
            width:150
        },{
            title: '状态',
            dataIndex: 'status',
            key: 'status',
            width:100
        },{
            title: '收件地址',
            dataIndex: 'receiver_address',
            key: 'receiver_address',
            width:200
        },{
            title: '类型',
            dataIndex: 'order_type',
            key: 'order_type',
            width:100
        },{
            title: '页数/本数 ',
            dataIndex: 'page_num',
            key: 'page_num',
            width:100
        },{
            title: '价格',
            dataIndex: 'total_price_real',
            key: 'total_price_real',
            width:100
        },{
            title: '创建时间',
            dataIndex: 'created_date',
            key: 'created_date',
            width:200
        },{
            title: '付款时间',
            dataIndex: 'pay_time',
            key: 'pay_time',
            width:200
        },{
            title: '快递单号 ',
            dataIndex: 'Express_NO',
            key: 'Express_NO',
            width:150
        },{
            title: '备注',
            dataIndex: 'remark',
            key: 'remark',
            width:100
        },{
            title: '异常原因 ',
            dataIndex: 'error_reason',
            key: 'error_reason',
            width:100
        } ,{
            title: '操作',
            dataIndex: 'operator',
            key: 'operator',
            width:100
        },{
            title: '操作',
            dataIndex: 'print',
            key: 'print',
            width:100
        }];
      const pagination = {
            total: _this.props.total,
            current:this.state.page,
            showSizeChanger: true,
            pageSize:this.state.pageSize,
            showTotal(total){
                return '共'+total+'条';
            },
            onShowSizeChange(current, pageSize) {
                console.log('Current: ', current, '; PageSize: ', pageSize);
            },
            onChange(current) {

                console.log('Current: ', current);
                _this.setState({
                    page:current,
                });
                console.log("page",_this.state.page)
               _this.state.type==0? _this.props.actions.getOrderList(current,pagination.pageSize,(err,res)=>{
                }):_this.props.actions.getOrderListByOrderNo(_this.state.receiver_name,_this.state.orderNo,_this.state.status,current,pagination.pageSize,_this.state.order_type,_this.state.fromDate,_this.state.toDate,(err,res)=>{
                   console.log("---------------")
                   console.log(res);
               });
            },
        };
        const rowSelection = {
            onChange(selectedRowKeys) {
                console.log('selectedRowKeys changed: ' + selectedRowKeys);

            },
            onSelect: function(record, selected, selectedRows) {
                var  order_no = [];
                //console.log(record, selected, selectedRows);
                for(var key in selectedRows){
                    order_no.push(selectedRows[key].order_no);
                }
                _this.setState({
                    selectedRowOrder:order_no,
                });

            },
            onSelectAll: function(selected, selectedRows) {
                console.log(selected, selectedRows);
                var  order_no = [];
                for(var key in selectedRows){
                    console.log(selectedRows[key].order_no);
                    order_no.push(selectedRows[key].order_no);
                }

                _this.setState({
                    selectedRowOrder:order_no,
                });
            }
        };

        return (

            <div>

                <Row style={{marginBottom:'20px',}}>
                    <Col span="24" style={{height:'100px',}}>
                                <Form inline style={{height:'100%',paddingTop:"15px"}}>
                                    <FormItem
                                        label="订单号："
                                        labelCol={{ span: 7 }}
                                        wrapperCol={{ span: 14 }} >
                                        <Input id="orderNo" onChange={_this.handleChange} />
                                    </FormItem>
                                    <FormItem
                                     label="收件人："
                                     labelCol={{ span: 7 }}
                                     wrapperCol={{ span: 14 }} >
                                     <Input id="receiver_name" onChange={_this.handleChange}/>
                                     </FormItem>

                                     <FormItem
                                     label="状态："
                                     labelCol={{ span:10 }}
                                     wrapperCol={{ span: 14 }} >
                                     <Select id="status" size="large" defaultValue="*" style={{ width: '150',marginLeft:'15px' }} onChange={_this.handleSelectChange} >
                                         <Option value="*">全部  </Option>
                                         <Option value="0">待发货</Option>
                                         <Option value="1">待付款</Option>
                                         <Option value="2">已发货</Option>
                                         <Option value="3">已付款</Option>
                                         <Option value="4">异常</Option>
                                     </Select>
                                     </FormItem>
                                   <FormItem
                                     label="类型："
                                     labelCol={{ span: 10 }}
                                     wrapperCol={{ span: 14 }}>
                                     <Select ref="order_type" id="order_type" size="large" defaultValue="*" style={{ width: 150 ,marginLeft:'15px'}} onChange={this.handleTypeSlctChange}>
                                            <Option value="*">全部</Option>
                                            <Option value="0">日记</Option>
                                            <Option value="1">照片书</Option>
                                            <Option value="2">台历</Option>
                                     </Select>
                                     </FormItem>
                                     <FormItem
                                         label="创建时间"
                                         labelCol={{ span: 10}} wrapperCol={{ span: 14 }}>
                                        <RangePicker style={{ width: 184 }} onChange={_this.onDateChange} />

                                     </FormItem>
                                    <ButtonGroup style={{ width: "100%",marginTop:"15px" }}>
                                        <Button type="dashed"  htmlType="submit" disabled={Srchdisabled} onClick={_this.handleSearch}><Icon type="search" />查询</Button>
                                         <Button type="dashed" htmlType="submit" disabled={!this.state.selectedRowOrder.length} loading={this.state.loading} onClick={_this.handleSendOut}><Icon type="edit" />发货</Button>
                                         <Button type="dashed" htmlType="submit" disabled={!this.state.selectedRowOrder.length} onClick={_this.handleReset}><Icon type="retweet" />重置</Button>
                                        <Button type="dashed" htmlType="submit" onClick={_this.handleError}><Icon type="exclamation-circle" />异常</Button>
                                         <Button type="dashed" htmlType="submit"><Icon type="book" />封面</Button>
                                         <Button type="dashed" htmlType="submit"><Icon type="download" />导出excel</Button>
                                         <Button type="dashed" htmlType="submit"><Icon type="edit" />处理</Button>
                                         <Button type="dashed" htmlType="submit" disabled={!this.state.selectedRowOrder.length} onClick={_this.handleDelete}><Icon type="delete" />删除</Button>
                                        {/**/}
                                    </ButtonGroup>
                                </Form>

                    </Col>
                </Row>
                <Row>
                    <Col span="24">
                        <Table rowSelection={rowSelection} dataSource={dataSource} columns={columns} pagination={pagination} scroll={{ y:400 }} size="small"/>
                    </Col>
                </Row>

            </div>
        )
    }
}

function mapStateToProps(state) {


    let arrItem = [];
    let total ;
    let items = state.OrderReducers.Action_GetOrderList_Response;
    if(items && items.size && items.size > 0) {
        items.get("list").map((item, key)=> {
            arrItem.push(item)
        })
        total=parseInt(items.get("total"));
        console.log(arrItem);
        arrItem.sort((a,b)=>{
                return Number(b.get("order_id")) - Number(a.get("order_id"));
        });

    }
    return {q: state.router.location.query.q, rawData:state.OrderReducers,arrItems:arrItem,total:total};
}

function mapDispatchToProps(dispatch) {
    return {
        dispath:dispatch,
        actions: bindActionCreators(OrderList, dispatch),
        pushState: bindActionCreators(pushState, dispatch)
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Order);