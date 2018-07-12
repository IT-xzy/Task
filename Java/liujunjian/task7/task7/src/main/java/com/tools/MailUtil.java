package com.tools;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailUtil {
    @Value("${mail.url}")
    private String url;
    @Value("${mail.apiUser}")
    private String apiUser;
    @Value("${mail.apiKey}")
    private String apiKey;
    @Value("${mail.subject}")
    private String subject;

    public String sendMail(String address) throws IOException {
        String checkCode = CheckCode.generateCheckCode();
        String html = "您本次注册的验证码是：" + checkCode + "，请勿告诉他人！";

        HttpPost httpPost = new HttpPost(url);
        HttpClient httpClient = new DefaultHttpClient();

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("to", address));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "SendCloud"));
        //邮件标题
        params.add(new BasicNameValuePair("subject", subject));
        //邮件内容
        params.add(new BasicNameValuePair("html", html));
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse response = httpClient.execute(httpPost);
        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回, 解析返回数据
            System.out.println(EntityUtils.toString(response.getEntity()));
            return checkCode;
        } else {
            System.err.println("error");
            return null;
        }
    }
}