/**
 * Created by xgz on 15/12/24.
 */

    var appConfig = require("../util/appConfig")

var data = new Buffer(appConfig.weixin_return_url).toString('base64')

//console.log()

console.log(data)