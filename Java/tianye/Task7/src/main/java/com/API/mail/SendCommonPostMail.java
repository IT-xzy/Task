package com.API.mail;

import com.Tool.MemcachedUtils;
import com.Tool.RandomTool;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SendCommonPostMail {
    private static Logger logger= Logger.getLogger(SendCommonPostMail.class);
    MemcachedUtils memcachedUtils;
    private String apiUser;
    private String apiKey;

    // 邮件发送接口
    private String apiUrl;
    //    final String apiUser = "freak_lin_test_i0YI6o";
//    final String apiKey = "b6jNn55dZk3pvoMY";
    private String randomForMail=RandomTool.getRandomCode(6);
    private String sendBodyBegin = "<html><H1><a href=\"";
    private String sendBodyEnd = "\"</a>点击验证邮箱,五分钟后失效</H1></html>";
    SendCommonPostMail(String apiUser, String apiKey, String apiUrl) {
        this.apiUser = apiUser;
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    public boolean sendMail(String userMail ,String httpUrl,String userId) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httPost = new HttpPost(apiUrl);

        String sendBody=sendBodyBegin+httpUrl+"/"+userId+"/"+randomForMail+sendBodyEnd;
        logger.info(sendBody+"跳转的网址为");

        List params = new ArrayList();
        // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
        params.add(new BasicNameValuePair("apiUser", apiUser));//用户名
        params.add(new BasicNameValuePair("apiKey", apiKey));//密码
        params.add(new BasicNameValuePair("from", "service@sendcloud.im"));//发送的账号名
        params.add(new BasicNameValuePair("fromName", "晚安"));//发送人名
        params.add(new BasicNameValuePair("to", userMail));//发送到的邮箱名
        params.add(new BasicNameValuePair("subject", "邮箱短信验证"));//头部
        params.add(new BasicNameValuePair("html",sendBody));//中间主题

        try {
            httPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 请求
        HttpResponse response = null;
        try {
            response = httpclient.execute(httPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 处理响应
        if ((response.getStatusLine().getStatusCode()) == HttpStatus.SC_OK) {
            // 获取请求返回的内容值
            JSONObject jsonObject = null;
            try {
                //将返回的类型转化为JSON格式；
                jsonObject = JSONObject.fromObject(EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //如果状态码为200，则添加邮箱数据到缓存；
            if (((Integer) jsonObject.get("statusCode")) == 200) {
                System.out.println(jsonObject.get("statusCode"));
                logger.info(randomForMail);
                //放入缓存中，设定缓存时间为5分钟。
                logger.info(memcachedUtils.set(randomForMail,userMail,new Date(System.currentTimeMillis()+300000)));
                logger.info(memcachedUtils.get(randomForMail));
                 //读取xml文档；
                String result = null;
                try {
                    result = EntityUtils.toString(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(result);

                return true;
            } else {
                return false;
            }

//        httPost.releaseConnection();
//            return httPost;
//
        }else {
            return false;
//            return String.valueOf(response.getStatusLine().getStatusCode());
        }
    }
}