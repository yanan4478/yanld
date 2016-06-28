var info = require("./config").AlipayConfig();
var api = require("./alipay-wap-api");
var async = require('async');
var xmlreader = require('xmlreader');
var Action = require("../routes/apiaction");
var CommonUse = require("../routes/front/common_use");
exports.alipayto = function(request,response) {

    //请与贵网站订单系统中的唯一订单号匹配
    var out_trade_no = request.param("orderid");


    //订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
    var subject = request.param("title");


    //订单总金额，显示在支付宝收银台里的“应付总额”里
    var total_fee = request.param("amount");


    var host = "http://" + request.headers.host;
    //var host =  "http://www.fy918.net"
    //var alipay = json.data;

    var partner = info.partner;
    var seller_account_name = info.seller_account_name;
    var key = info.key;
        var req = api.createReq(api.services.create, partner);
        var ret = {
            redirect: '',
            token: null
        };
        req.req_id = out_trade_no;
        return async.series([
            function(cb) {
                req.req_data = {
                    subject: subject,
                    out_trade_no: out_trade_no,
                    total_fee: total_fee,
                    seller_account_name: seller_account_name,
                    call_back_url: host + info.call_back_url,
                    notify_url: info.notify_url,
                    merchant_url: host + info.merchant_url
                };

                req.req_data = api.toReqData('direct_trade_create_req', req.req_data);
                req.sign = api.getSign(req, key);
                console.log(req)
                return api.sendCreate(req,function(err, res) {
                    if (err) {
                        return cb(err);
                    }
                    //if (req.sign !== api.getSign(req)) {
                    //    return cb('bad sign from alipay server');
                    //}
                    ret.token = api.parseTokenFromXml(res.res_data);
                    ret.redirect = api.createAuthUrl(ret.token,partner,key);
                    return cb(null);
                });
            }
        ], function(err) {
            console.log(ret.redirect);
            response.redirect(ret.redirect);//手机即时到帐
        });
};

exports.notify = function(req,res) {
    console.log("notify",req.notify_data);
    return xmlreader.read(req.notify_data, function(err, xdoc) {
        var done, notify, notify_id, _ref;
        if (err) {
            return done(err);
        }
        notify = xdoc.notify;
        notify_id = notify != null ? (_ref = notify.notify_id) != null ? _ref.text() : void 0 : void 0;
        if (!notify_id) {
            return done('bad notify_data');
        }
        done = function(response) {
            var _ref1, _ref2;
            if ('string' !== typeof response) {
                console.error("response notify error: " + ((_ref1 = (_ref2 = response != null ? response.stack : void 0) != null ? _ref2 : response) != null ? _ref1 : ''));
                response = 'server error';
            }
            if (response !== 'success') {
                console.error("response notify: " + response);
            }
            return callback(response === 'success' ? err : response);
        };
        var out_trade_no, trade_status;
        trade_status = notify.trade_status.text();
        if (trade_status === 'TRADE_FINISHED' || trade_status === 'TRADE_SUCCESS') {
            if (req.sign !== api.getNotitySign(req)) {
                return done('bad sign');
            }
            out_trade_no = notify.out_trade_no.text();
            console.log("=========",out_trade_no);
            return done('success');
        } else {
            return done('unknown trade status');
        }
    });
};
exports.back = function(req,res) {
    var result = req.param("result"),
        out_trade_no = req.param("out_trade_no"),
        request_token = req.param("request_token"),
        trade_no = req.param("trade_no"),
        sign = req.param("sign");

    var orderid = out_trade_no;
    var signJson = {
        "out_trade_no":out_trade_no,
        "request_token":request_token,
        "result" :result,
        "trade_no":trade_no
    };
    var payopenid = CommonUse.get_pay_back_openid(req,res);
    console.log("payopenid返回======"+payopenid);
    //后台验证订单状态，必须为等待付款的状态下才可修改
    Action.send(req,res,"/orders/payreturn",{order_id:orderid ? orderid : -1,trade_no:trade_no,pay_way:2},function(res,data){
        var json = JSON.parse(data);
        console.log(json)
        if(json.code == 0) {
            var orders = json.data;
            //res.render('front/order/myorder',{
            //    layout:CommonUse.get_main_layout_path(),
            //    fromflag:0,
            //    open_id:payopenid,
            //    title:"我的微信日记|微信日记网页版"
            //});
        } else if(json.code == 1) {
            console.log("微信支付回调,修改订单有误：",json.msg);
        }
    });

    Action.send(req, res,"/user/ShowUserInfo",{open_id:payopenid},function(res,data) {
        var json = JSON.parse(data);
        console.log("step=="+data);
        if(json.code != "0" || json.data.follow_public_number != 1){ //查不到数据
            window.loation = "";
            res.render('front/main/wxpublic', {
                title:"筑书网络|网页版"
            });
        }else{
            res.render('front/order/myorder',{
                layout:CommonUse.get_main_layout_path(),
                fromflag:0,
                open_id:payopenid,
                title:"我的微信日记|微信日记网页版"
            });
        }

    });

};

