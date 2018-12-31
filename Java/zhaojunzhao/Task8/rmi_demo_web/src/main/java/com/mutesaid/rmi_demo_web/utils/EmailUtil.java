package com.mutesaid.rmi_demo_web.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@ConfigurationProperties(prefix = "email")
@Slf4j
public class EmailUtil {
    private static EmailUtil emailUtil;

    private static String url;

    private static List<NameValuePair> params = new ArrayList<NameValuePair>();

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @PostConstruct
    public void init() {
        emailUtil = this;
    }

    public void setUrl(String url) {
        EmailUtil.url = url;
    }

    public void setApiUser(String apiUser) {
        params.add(new BasicNameValuePair("apiUser", apiUser));
    }

    public void setApiKey(String apiKey) {
        params.add(new BasicNameValuePair("apiKey", apiKey));
    }

    public void setFrom(String from) {
        params.add(new BasicNameValuePair("from", from));
    }

    public void setFromName(String fromName) {
        params.add(new BasicNameValuePair("fromName", fromName));
    }

    public void setSubject(String subject) {
        params.add(new BasicNameValuePair("subject", subject));
    }

    private static String setInfo(String email) throws IOException {
        String token = MD5Util.encrypt(email, "");
        String html = "<a href=\"localhost:8080/a?token=" + token + "\">localhost:8080/a?token=" + token + "</a>";

        // 验证时间10分钟
        emailUtil.redisTemplate.opsForValue().set(token, email);
        emailUtil.redisTemplate.expire(token, 10, TimeUnit.MINUTES);

        params.add(new BasicNameValuePair("to", email));
        params.add(new BasicNameValuePair("html", html));

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse response = httpClient.execute(httpPost);
        return EntityUtils.toString(response.getEntity());
    }

    public static Boolean sendMsg(String email) throws IOException {
        String json = setInfo(email);
        Map statusInfo = new JSONObject(json).toMap();
        System.out.println(statusInfo);
        if(!"200".equals(statusInfo.get("statusCode").toString())){
            log.info("请求错误 msg = {}", statusInfo.get("message"));
            return false;
        }
        return true;
    }
}
