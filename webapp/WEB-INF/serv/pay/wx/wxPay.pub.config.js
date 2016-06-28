/**
 * Created by novem on 2/10/15.
 */
exports.WxpayConfig = function() {
    var Config = {
        hosturl:'',
        //=======【基本信息设置】=====================================
        //微信公众号身份的唯一标识。审核通过后，在微信发送的邮件中查看
        APPID : 'wxcdf9cad8bd2d21c9',  //当前公众号的id
        APPID_FATHER:'wxcdf9cad8bd2d21c9',  //调用微信支付的公众号的id

        //微印
        //APPID : 'wxa8175e865b745929',  //当前公众号的id
        //APPID_FATHER:'wxa8175e865b745929',
        //JSAPI接口中获取openid，审核后在公众平台开启开发模式后可查看
        APPSECRET : '5b820c32171224e9d76c80b551966d0d',
        APPSECRET_FATHER : '5b820c32171224e9d76c80b551966d0d',

        //微印
        //APPSECRET : 'cd2220518e167fa57b926060241f60b2',
        //APPSECRET_FATHER : 'cd2220518e167fa57b926060241f60b2',

        //受理商ID，身份标识
        MCHID : '1241392202',

        //微印
        //MCHID : '1236467002',
        //商户支付密钥Key。
        //KEY : 'wdb8hufh7dsfsy7y72udhshsdudsj9tu',
        KEY : 'weprint100novemideasjshziplmhg88',

        //=======【JSAPI路径设置】===================================
        //获取access_token过程中的跳转uri，通过跳转将code传入jsapi支付页面
        JS_API_CALL_URL : '/',

        //=======【证书路径设置】=====================================
        //证书路径,注意应该填写绝对路径
        SSLCERT_PATH : '/xxx/xxx/xxxx/WxPayPubHelper/cacert/apiclient_cert.pem',
        SSLKEY_PATH : '/xxx/xxx/xxxx/WxPayPubHelper/cacert/apiclient_key.pem',

        //=======【异步通知url设置】===================================
        //异步通知url，商户根据实际开发过程设定
        NOTIFY_URL : 'http://weprint.snsunion.cn/wxbook/wxbookWx/callback',

        //=======【curl超时设置】===================================
        //本例程通过curl使用HTTP POST方法，此处可修改其超时时间，默认为30秒
        CURL_TIMEOUT : 30
    }
    return Config;
};
