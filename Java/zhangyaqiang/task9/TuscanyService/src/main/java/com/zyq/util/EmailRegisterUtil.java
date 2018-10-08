package com.zyq.util;

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

public class EmailRegisterUtil {
    public static String send_common(String email, String msgCode) throws IOException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SendCloudBean sendCloudBean = (SendCloudBean) applicationContext.getBean("sendCloudBean");

        HttpPost httpPost = new HttpPost(sendCloudBean.getUrl());
        HttpClient httpClient = new DefaultHttpClient();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", sendCloudBean.getApiUser()));
        params.add(new BasicNameValuePair("apiKey", sendCloudBean.getApiKey()));
        params.add(new BasicNameValuePair("to", email));
        params.add(new BasicNameValuePair("from", sendCloudBean.getFrom()));
        params.add(new BasicNameValuePair("fromName", "Task7邮箱注册"));
        params.add(new BasicNameValuePair("subject", "Task7练习注册邮箱验证码"));
        params.add(new BasicNameValuePair("html", "验证码是" + msgCode + ",打死也不能告诉别人啊！"));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);
        String msgStatus;

        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回, 解析返回数据
//            System.out.println(EntityUtils.toString(response.getEntity()));
            msgStatus = EntityUtils.toString(response.getEntity()).substring(10, 14);
        } else {
//            System.err.println("error");
            msgStatus = "error";
        }
        httpPost.releaseConnection();
        return msgStatus;
    }
}
