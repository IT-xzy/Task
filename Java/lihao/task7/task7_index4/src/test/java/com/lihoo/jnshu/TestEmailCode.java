package com.lihoo.jnshu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/**
 * #Title: TestEmailCode
 * #ProjectName task7_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/4-13:03
 */


public class TestEmailCode {

    public static void main(String[] args) throws IOException {
        final String url = "http://api.sendcloud.net/apiv2/mail/send";
        final String apiUser = "odd4Loah_test_cl9Gyt";
        final String apiKey = "twwIEaMgoFY7dyGF";

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httPost = new HttpPost(url);

        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("from", "whalesong939@163.com"));
        params.add(new BasicNameValuePair("fromName", "李浩"));
        params.add(new BasicNameValuePair("to", "audit4835@126.com"));
        params.add(new BasicNameValuePair("subject", "来自SendCloud的第一封邮件！"));
        params.add(new BasicNameValuePair("html", "皮皮皮皮皮皮"));

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

