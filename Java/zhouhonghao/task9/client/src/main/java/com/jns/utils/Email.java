package com.jns.utils;

import ytx.org.apache.http.HttpResponse;
import ytx.org.apache.http.HttpStatus;
import ytx.org.apache.http.client.HttpClient;
import ytx.org.apache.http.client.entity.UrlEncodedFormEntity;
import ytx.org.apache.http.client.methods.HttpPost;
import ytx.org.apache.http.impl.client.DefaultHttpClient;
import ytx.org.apache.http.message.BasicNameValuePair;
import ytx.org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Email {
    public void params(String[] data) throws IOException {
        final String url = "http://api.sendcloud.net/apiv2/mail/send";
        final String apiUser = "您账户中的API_USER";
        final String apiKey = "您自己设置的API_KEY";

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httPost = new HttpPost(data[0]);

        List params = new ArrayList();
        // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
        params.add(new BasicNameValuePair("apiUser", data[1]));
        params.add(new BasicNameValuePair("apiKey", data[2]));
        params.add(new BasicNameValuePair("from", data[3]));
        params.add(new BasicNameValuePair("fromName", data[4]));
        params.add(new BasicNameValuePair("to", data[5]));
        params.add(new BasicNameValuePair("subject", data[6]));
        params.add(new BasicNameValuePair("html", data[7]));
        httPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        // 请求
        HttpResponse response = httpclient.execute(httPost);
        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
            // 读取xml文档
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else {
            System.err.println("error");
        }
        httPost.releaseConnection();
    }
}
