package com.ptteng;


import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.comm.Protocol;
import com.ptteng.util.thirdAPI.AliyunOSSUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;

//阿里云OSS，图片上传测试。
public class ImageUploadTest {
    //endpoint是杭州的公网
    String endpoint = "http://oos-cn-hongzhou.aliyuncs.com";
    //阿里云主账号的accessKey拥有所有API的AccessKey的访问权限。
    String accessKeyId = "LTAIs5HQAO7GlXZU";
    String accessKeyScret = "pFFL3YTu4Xh8oFtRMDetGuFUs8HfeE";


    //创建OSSClient实例
    OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeyScret);

    public void t() throws Exception {
        // 创建ClientConfiguration实例（ClientConfiguration是OSSClient的配置类，可配置代理、连接超时、最大连接数等参数）。
        ClientConfiguration conf = new ClientConfiguration();
        // 设置OSSClient允许打开的最大HTTP连接数，默认1024。
        conf.setMaxConnections(200);
        // 设置Socket层传输数据的超时时间（单位：毫秒），默认为50000毫秒。
        conf.setSocketTimeout(10000);
        //设置建立连接的超时时间（单位：毫秒），默认为50000毫秒。
        conf.setConnectionTimeout(10000);
        //设置从连接池中获取连接的超时时间（单位：毫秒）,默认不超时。
        conf.setConnectionRequestTimeout(1000);
        //如果空闲时间超过此参数的设定值，则关闭连接（单位：毫秒），默认为60000毫秒 。
        conf.setIdleConnectionTime(10000);
        // 设置失败请求重试次数，默认3次。
        conf.setMaxErrorRetry(5);
        //设置是否支持CNAME作为Endpoint，默认支持。
        conf.setSupportCname(true);
        //设置是否开启二级域名（Second Level Domain）的访问方式，默认不开启。
        conf.setSLDEnabled(true);
        //设置连接OSS所采用的协议（HTTP/HTTPS），默认为HTTP。
        conf.setProtocol(Protocol.HTTP);
        //设置用户代理，指HTTP的User-Agent头，默认为“aliyun-sdk-java”。
        conf.setUserAgent("aliyun-sdk-java");
//        //设置代理服务器端口，默认值无。
//        conf.setProxyHost("<yourProxyHost>");
//        //设置代理服务器验证的用户名，默认值无。
//        conf.setProxyUsername("<yourProxyUserName>");
//        //设置代理服务器验证的密码，默认值无。
//        conf.setProxyPassword("<yourProxyPassword>");
    }
}
