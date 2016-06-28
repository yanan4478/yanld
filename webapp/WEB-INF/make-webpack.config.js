/**
 * Created by xgz on 15/10/7.
 */
/*
 * @Author: dmyang
 * @Date:   2015-08-02 14:16:41
 * @Last Modified by:   dmyang
 * @Last Modified time: 2015-09-14 15:08:13
 */

'use strict';

var path = require("path");
var webpack = require("webpack");

var ExtractTextPlugin = require('extract-text-webpack-plugin');

var env = require('node-env-file');

function absPath(relativePath){
    var htmlpath = __dirname + "/" + relativePath;
    return path.resolve(htmlpath);
}

function getEntrySources(sources) {
    //console.log(process.env.NODE_ENV);
    if (process.env.NODE_ENV === 'local') {
        sources.push('webpack-hot-middleware/client');
    }
    //console.log(sources)
    return sources;
}

function getPlugins(plugins) {
    //console.log(process.env.NODE_ENV);
    if (process.env.NODE_ENV !== 'local') {
        plugins.push(new ExtractTextPlugin("[name].css"));
        plugins.push(
            new webpack.optimize.CommonsChunkPlugin('common.js'));
    }
    console.log(plugins)
    return plugins;
}

function getLoaders(loaders) {
    //console.log(process.env.NODE_ENV);
    if (process.env.NODE_ENV === 'local') {
        loaders.push({
            test: /\.less$/,
            //loader: ExtractTextPlugin.extract("style-loader",'css-loader!autoprefixer-loader!less-loader')
            loader: "style-loader!css-loader!autoprefixer-loader!less-loader"
        })
    }else{
        loaders.push({
            test: /\.less$/,
            loader: ExtractTextPlugin.extract("style-loader",'css-loader!autoprefixer-loader!less-loader')
            //loader: "style-loader!css-loader!autoprefixer-loader!less-loader"
        })
    }
    //console.log(sources)
    return loaders;
}

function makeConf(options) {

    options = options || {};

    //var debug = options.debug !== undefined ? options.debug : true;

    var NODE_EVN = "local";
    //var publicpath = "http://192.168.0.140:3000/"
    var publicpath = "http://localhost:3010/"
    if(options.mode == 2){
        NODE_EVN = "dev";
        publicpath = "http://devnode.dobooking.cn/"
    }else if(options.mode == 1){
        NODE_EVN = "production"
        publicpath = "http://node.dobooking.cn/"
        if(process.env.DOMAIN !== undefined){
            publicpath = "http://"+process.env.DOMAIN+".dobooking.cn"
        }
    }

    console.log("config:======="+publicpath);

    process.env.NODE_ENV = NODE_EVN;

    var config = {
        entry: {
            //-hot
            main:getEntrySources(['./src/js/index.js']),
            //album: getEntrySources(['./src/js/album.js'])
        },

        output: {
            // 在debug模式下，__build目录是虚拟的，webpack的dev server存储在内存里
            path: path.resolve('__build'),
            filename: 'js/[name].js',
            chunkFilename: "[chunkhash:8].chunk.js",
            //publicPath:"__build"
            //http://localhost:8080/__build/ because of express set the view folder as __build,so don't add __build
            publicPath: publicpath
        },

        module: {
            loaders: getLoaders([
                {
                    test: /\.(jpe?g|png|gif|svg)$/i,
                    loaders: [
                        'image?{bypassOnDebug: true, progressive:true, \
                            optimizationLevel: 3, pngquant:{quality: "65-80", speed: 4}}',
                        // url-loader更好用，小于10KB的图片会自动转成dataUrl，
                        // 否则则调用file-loader，参数直接传入
                        'url?limit=10000&name=img/[hash:8].[name].[ext]',
                    ]
                },
                {
                    test: /\.(eot|woff|woff2|ttf|svg)/,
                    loader: 'url-loader?limit=30000&name=[name]-[hash].[ext]'
                },
                { test: /\.css$/, loader: "style!css" },

                //for handlerbars
                { test: /\.hbs/, loader: "handlebars-loader" },

                {
                    test: /\.js$/,
                    loader: 'react-hot!babel?stage=0',
                    exclude: /node_modules/,
                    include: path.join(__dirname, 'src')
                },
                { test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/, loader: "file-loader" }
            ])
        },

        externals: {
            wxjssdk: "wx"
        },

        resolve: {
            alias: {
                libComponent: absPath("src/js/components"),
                util: absPath("src/js/util"),
                style: absPath("src/less"),
                actions: absPath("src/js/actions"),
                js: absPath("src/js"),
                res: absPath("src/res"),
                image: absPath("src/res/img"),
                data:absPath("src/js/data")
            }
        },

        plugins: getPlugins([
            new webpack.optimize.OccurenceOrderPlugin(),
            new webpack.HotModuleReplacementPlugin(),
            new webpack.NoErrorsPlugin(),
            new webpack.DefinePlugin({
                "process.env": {
                    NODE_ENV: JSON.stringify(NODE_EVN)
                }
            })

        ])
    };

    //console.log(process.env.NODE_ENV)

    return config;
}

module.exports = makeConf;