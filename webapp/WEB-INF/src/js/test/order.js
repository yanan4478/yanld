/**
 * Created by xgz on 15/12/23.
 */

import { normalize, Schema, arrayOf } from 'normalizr';
var Immutable = require('immutable');

var data = {"code":0,"object":{"id":1,"addr":{"id":"10","name":"\u90ed\u9759\u4f73",
    "mobile":"18626885396","del_flag":"0","pid":"-1","cid":"-1","aid":"-1",
    "detail_addr":"\u7965\u8302\u8def2\u53f7",
    "pca_addr":"\u5185\u8499\u53e4\u547c\u4f26\u8d1d\u5c14\u6839\u6cb3\u5e02",
    "createtime":"2015-12-23 10:45:36","humanid":"-1","isdefault":"1",
    "openid":"od-5Ut75Nw6AJmiAIS8UnT-A6jDg","lastupdatetime":"1450844143"},
    "pro_model":{"id":"1","name":"\u53f0\u5386","type_id":"0","descrip":"2016\u4e2a\u6027\u53f0\u5386",
        "price":"0","score":"0","norm":"210x210 mm","unit":"\u672c","property":"",
        "btype":"0","remark":"","property1":"","property2":"","property3":"","inner_del":"0",
        "createtime":null,"agentid":"0"}}}

const album = new Schema('album');
const albumDetail = new Schema('address');

const pro_model = new Schema('pro_model');
//const collection = new Schema('collections');

album.define({
    addr: (albumDetail),
    pro_model: pro_model
    //collections: arrayOf(collection)
});

var res = normalize(data.object,(album))

console.log(res)

var posts = Immutable.fromJS(data.object);

console.log(posts)