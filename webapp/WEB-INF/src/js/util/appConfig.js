/**
 * Created by xgz on 15/12/11.
 */

var debug = process.env.NODE_ENV !== 'production'?true:false;

//var host = "http://192.168.0.140:3000"
var host = "http://localhost:3010";
var wxHostName = "http://node.dobooking.cn";
var zsWxAppId = "wxcdf9cad8bd2d21c9";

if(process.env.NODE_ENV === 'production'){
    host = "http://node.dobooking.cn";
    if(process.env.DOMAIN !== undefined){
        host = `http://${process.env.DOMAIN}.dobooking.cn`
    }
}else if(process.env.NODE_ENV === 'dev'){
    host = "http://devnode.dobooking.cn";
    wxHostName = "http://devnode.dobooking.cn";
    //zsWxAppId = "wx295fcf13ac9af142";
}

var AppConfig = {

    hostName: host,

    wxHostName:wxHostName,

    zsWxAppId: zsWxAppId,

    alipay_notify_url:"aHR0cDovL3dlcHJpbnQuc25zdW5pb24uY24vd3hib29rL3pzL3BheWNhbGxiYWNrL2xpaml6aGlmdUNhbGxiYWNr",
    alipay_return_url:"aHR0cDovL25vZGUuZG9ib29raW5nLmNuL2NsaWVudC9wYWdlL3BheS9wYXlTdWNjZXNz",

    weixin_notify_url:"aHR0cDovL3dlcHJpbnQuc25zdW5pb24uY24vd3hib29rL3pzL3BheWNhbGxiYWNrL3dlaXhpbkNhbGxiYWNr",

    pageTitle:{
        album:{
            main:"照片书|筑书网络",
            sub:"照片书"
        }
    },

    share:{
        album:{
            title : "筑书-2016年个性照片书火热上线",
            desc : "2016年个性照片书火热上线，操作简单，价格优惠，赶紧点进来做一本吧",
            link : host + "/client/page/share/album",
            imgUrl : host + "/img/fb35dd41.jyb.jpg"
        }
    }

};

module.exports = AppConfig