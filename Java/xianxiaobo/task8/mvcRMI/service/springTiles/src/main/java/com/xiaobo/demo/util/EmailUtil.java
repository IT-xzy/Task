package com.xiaobo.demo.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    private static Logger log = Logger.getLogger(EmailUtil.class);

    public Boolean sendMail(String to,String content) throws IOException {
        final String url = "http://api.sendcloud.net/apiv2/mail/send";
        final String apiUser = "xianxiaobo_test_i4mWXb";
        final String apiKey = "ZnXCVX0vDmnOK6H3";

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        List params = new ArrayList();
        // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("from", "service@sendcloud.im"));
        params.add(new BasicNameValuePair("fromName", ""));
        params.add(new BasicNameValuePair("to", to));
        params.add(new BasicNameValuePair("subject", "欢迎你注册修真院task7,请验证邮箱"));
        params.add(new BasicNameValuePair("html", content));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        // 请求
        HttpResponse response = httpclient.execute(httpPost);
        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
            // 读取xml文档
            String result = EntityUtils.toString(response.getEntity());
            httpPost.releaseConnection();
            return true;
        } else {
            System.err.println("error");
            log.error("邮件下发http请求失败");
            httpPost.releaseConnection();
            return false;
        }
    }
}
