package com.yanld.module.utils;

/**
 * 描述：
 * 作者：袁伟倩
 * 创建日期：2017-02-01 16:22.
 */

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Recorder;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;
import com.qiniu.common.Zone;


import java.io.IOException;

    public class UploadUtils {

        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = "oe9fxXJHvcUFVoov0xqhjEhRcSYDo0aSMUPe4X8w";
        String SECRET_KEY = "uIimRjt9JyfdfkPxZ6QENdQS9AL8kFHzBKs7mYZ1";
        //要上传的空间
        String bucketname = "yanld-resource";
        //上传到七牛后保存的文件名
        String key = "mp3/my-java.map3";
        //上传文件的路径
        String filePath = "mp3/1.mp3";
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        ///////////////////////指定上传的Zone的信息//////////////////
        //第一种方式: 指定具体的要上传的zone
        //注：该具体指定的方式和以下自动识别的方式选择其一即可
        //要上传的空间(bucket)的存储区域为华东时
        // Zone z = Zone.zone0();
        //要上传的空间(bucket)的存储区域为华北时
        // Zone z = Zone.zone1();
        //要上传的空间(bucket)的存储区域为华南时
        // Zone z = Zone.zone2();

        //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);

        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);

        public static void main(String args[]) throws IOException {
            new UploadUtils().upload();
        }

        //简单上传，使用默认策略，只需要设置上传的空间名就可以了
        public String getUpToken() {
            return auth.uploadToken(bucketname);
        }

        public void upload() throws IOException {
            try {
                //调用put方法上传
                Response res = uploadManager.put(filePath, key, getUpToken());
                //打印返回的信息
                System.out.println(res.bodyString());
            } catch (QiniuException e) {
                Response r = e.response;
                // 请求失败时打印的异常的信息
                System.out.println(r.toString());
                try {
                    //响应的文本信息
                    System.out.println(r.bodyString());
                } catch (QiniuException e1) {
                    //ignore
                }
            }
        }
    }