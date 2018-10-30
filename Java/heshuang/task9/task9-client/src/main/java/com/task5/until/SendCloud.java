package com.task5.until;

import com.task5.FAQ.SendCloudBean;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendCloud {
    @Autowired
    RedisUntil redisUntil;
    public void send_common(String email,String emailCode) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SendCloudBean sendCloudBean = (SendCloudBean) applicationContext.getBean("scBean");

//        final String url = "http://api.sendcloud.net/apiv2/mail/send";
//
//        final String apiUser = "heshuang_test_Uk99hU";
//        final String apiKey = "VHQAUnlLDT001pJK";
        final String rcpt_to = email;

//        String subject = "注册验证码";
//        String html = "您的验证码是："+emailCode;

        HttpPost httpPost = new HttpPost(sendCloudBean.getUrl());
        HttpClient httpClient = new DefaultHttpClient();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", sendCloudBean.getApiUser()));
        params.add(new BasicNameValuePair("apiKey", sendCloudBean.getApiKey()));
        params.add(new BasicNameValuePair("to", rcpt_to));
        params.add(new BasicNameValuePair("from", sendCloudBean.getFrom()));
        params.add(new BasicNameValuePair("fromName", sendCloudBean.getFromName()));
        params.add(new BasicNameValuePair("subject", sendCloudBean.getSubject()));
        params.add(new BasicNameValuePair("html", sendCloudBean.getHtml()+emailCode));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);

        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回, 解析返回数据
            System.out.println(EntityUtils.toString(response.getEntity()));
//            System.out.println(EntityUtils.toString(response.getEntity()).substring(10,14));
            redisUntil.set("emailCode",emailCode,60);
            System.out.println(emailCode);
        } else {
            System.err.println("error");
        }
        httpPost.releaseConnection();
    }
}


