/**
 * 路由拦截器
 * Created by wdb
 */
var wxUtils         = require("./weixin/utils");
var wxConf          = require("./pay/wx/wxPay.pub.config").WxpayConfig();
var utils           = require("./utils");

var jssdk        = require('./weixin/jssdk');


var clientFun = function(req, res, next) {

    var url = req.originalUrl;

    if(utils.brows(req.headers['user-agent']).weixin || true){//微信浏览器  //
        //console.log("[[[[[[[hahahahahahaurl222222222]]]]]]]]]]]]]]]============",url);
        jssdk.initSignPackage(req,res,function(){
            return next();
        });
    }else{
        //console.log("[[[[[[[hahahahahahaurl11111111]]]]]]]]]]]]]]]============",url);
        return next();
    }
}

exports.filterFun = function (req, res, next) {
    //console.log(req.hostname + req.originalUrl)
    var url = req.hostname + req.originalUrl;

    console.log("url============",url);
    if(utils.brows(req.headers['user-agent']).weixin || true){
        return clientFun(req,res,next);
    } else {
        return next();
    }
}
