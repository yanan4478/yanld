var sign = require('./sign.js');
var https = require('https');
var http = require('http');

var Conf = require("../pay/wx/wxPay.pub.config").WxpayConfig();

var fs = require('fs');


//蜂蚁家园
//var config = {
//    APPID:'wx0d514615b458d55d',
//    APPSECRET:'35a16d385da5b37b62eb7b2021e984e8'
//};
//诺文科技
//var config = {
//    appId:'wx2569350388929e2e',
//    appSecret:'0069306a53db220d472a25a55192dd53'
//};
//yintian
//var Conf = {
//    APPID:'wx0be3dfda7a66c2fc',
//    APPSECRET:'697007698ee63427f7ef829cca573a6e'
//};
//var url_token   = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
//var url_ticket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=";
//var url_token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + Conf.APPID + "&secret=" + Conf.APPSECRET;
var url_token_back = "http://weprint.snsunion.cn/wxproxy/wxproxy/getAccessToken/13";
var url_ticket_back = "http://weprint.snsunion.cn/wxproxy/wxproxy/getJsTicket/13";
var appid = Conf.APPID;
var appid_father = Conf.APPID_FATHER;
function getTocken(callback){
    console.log("[url_token]=")

    http.get(url_token_back, function(res) {
        res.on('data', function(d) {
            var dd = d.toString("utf-8");
            var _res = JSON.parse(dd);
            console.log("access_token:",_res)
            //console.log("[[[[[[Token result Token result Token result Token result Token result Token result11]]]]]]]]=",_res.object.access_token)
            callback(_res.object.access_token);
        });

    }).on('error', function(e) {
        console.error(e);
    });

}

function getTicket(token,callback){

    http.get(url_ticket_back, function(res) {
        res.on('data', function(d) {
            var dd = d.toString("utf-8");
            var _res = JSON.parse(dd);
            console.log("jsticket:", _res)
            //console.log("[[[[[[url_ticket_back url_ticket_back url_ticket_back url_ticket_back url_ticket_back ]]]]]]]]=",_res)
            //console.log("[[[[[[url_ticket_back url_ticket_back url_ticket_back url_ticket_back url_ticket_back ]]]]]]]]=",dd)
            callback(token,_res.object.access_token)
        });

    }).on('error', function(e) {
        console.error(e);
    });
}

function initJSSDK(response, token, ticket, http_url, first){
	console.log("****************************** init JSSDK");
	var signPackage = sign(ticket, 'http://'+http_url);
    signPackage.appid = appid;

    console.log("[initJSSDK]",signPackage)

    response.cookie('jsapi_ticket', ticket, {path: '/', maxAge: 7000000});
    response.cookie('access_token', token, {path: '/', maxAge: 7000000});
    response.cookie('wx_appid', signPackage.appid, {path: '/', maxAge: 7000000});
    response.cookie('wx_timestamp', signPackage.timestamp, {path: '/', maxAge: 7000000});
    response.cookie('wx_nonceStr', signPackage.nonceStr, {path: '/', maxAge: 7000000});
    response.cookie('wx_signature', signPackage.signature, {path: '/', maxAge: 7000000});

    //response.cookie
    //fs.writeFileSync('./token.json',JSON.stringify({'access_token':token,'jsapi_ticket':ticket,'deadline_time':createDeadTimestamp()}));

}


exports.initSignPackage = function(request,response,callback) {
    //var url = req.hostname + req.originalUrl;
    var http_url = request.hostname + request.originalUrl;

    console.log("initSignPackage",http_url)

    getTocken(function(token){
        getTicket(token,function(token, ticket){
            initJSSDK(response, token, ticket, http_url, true);
            callback();
        });
    });
}