package com.xiaobo.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CaptchaUtil {
    private static Logger log = Logger.getLogger(CaptchaUtil.class);

    public Boolean isTokenValid(String token) throws IOException {
        final String url = "http://api.vaptcha.com/v2/validate";
        final String id = "5bfca3effc650e1410f00f1f";
        final String secretKey = "76a3b1be252d442ab89192a43f082fe1";
        final String scene = "";

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        List params = new ArrayList();
        // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
        params.add(new BasicNameValuePair("id", id));
        params.add(new BasicNameValuePair("secretKey", secretKey));
        params.add(new BasicNameValuePair("scene", scene));
        params.add(new BasicNameValuePair("token", token));


        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        // 请求
        HttpResponse response = httpclient.execute(httpPost);
        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
            // 读取xml文档
            String result = EntityUtils.toString(response.getEntity());
            return JSON.parseObject(result).getBoolean("success");
        } else {
            log.error("校验captchaToken http请求发送失败");
        }
        httpPost.releaseConnection();
        return false;
    }
}
