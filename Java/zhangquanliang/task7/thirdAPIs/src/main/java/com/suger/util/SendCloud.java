package com.suger.util;

import com.suger.pojo.SendCloudBean;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author suger
 * @date 2018/12/14 20:50
 */
public class SendCloud {

    public static String sendCommon(String email,String msgCode) throws IOException {


        //final String rcpt_to = "suger_z@126.com";

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");


       SendCloudBean sendCloudBean = ctx.getBean(SendCloudBean.class);

        String subject = "jnshu邮箱注册验证码";
        String html = "验证码: "+msgCode+", 10分钟内有效,请勿告诉其他人！";

        HttpPost httpPost = new HttpPost(sendCloudBean.getUrl());
        HttpClient httpClient = new DefaultHttpClient();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", sendCloudBean.getApiUser()));
        params.add(new BasicNameValuePair("apiKey", sendCloudBean.getApiKey()));
        params.add(new BasicNameValuePair("to", email));
        params.add(new BasicNameValuePair("from", "suger1611@gmail.com"));
        params.add(new BasicNameValuePair("fromName", "jnshu测试"));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", html));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);

        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回, 解析返回数据
            System.out.println(EntityUtils.toString(response.getEntity()));
        } else {
            System.err.println("error");
            return  "false";
        }
        httpPost.releaseConnection();
        return "true";
    }


    public static void main(String[] args) throws Exception {

        // 随机生成6位验证码，测试
        String msgCode = DataUtils.getNumber(6);
        System.out.println("msgCode = " + msgCode);

        String email = "测试邮箱";
        msgCode = sendCommon(email,msgCode);
        System.out.println("msgCode = " + msgCode);

    }

}
