/*
 * @Author: dmyang
 * @Date:   2015-05-18 14:16:41
 * @Last Modified by:   dmyang
 * @Last Modified time: 2015-06-19 02:30:16
 */

'use strict';

var genConf = require('./make-webpack.config.js');

//console.log(process.env.NODE_ENV)

var mode = 0;

if(process.env.NODE_ENV === 'production'){
    mode = 1;
}else if(process.env.NODE_ENV === 'dev'){
    mode = 2;
}

module.exports = genConf({mode: mode});