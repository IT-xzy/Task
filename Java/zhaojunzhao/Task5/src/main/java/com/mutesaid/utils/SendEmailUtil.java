package com.mutesaid.utils;

import com.mutesaid.pojo.Usr;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Component
public class SendEmailUtil {
    private static SendEmailUtil sendEmailUtil;

    @Autowired
    @Qualifier("emailParams")
    private ArrayList emailParams;

    @Autowired
    @Qualifier("sendEmail")
    private HttpPost sendEmail;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init() {
        sendEmailUtil = this;
    }

    private static final String SIGN_KEY = "www.jnshu.com";

    @SuppressWarnings("unchecked")
    public static void sendEmail(Usr usr) {
        HashMap usrMap = new HashMap(1);
        usrMap.put("email", usr.getEmail());
        String token = JJWTUtil.sign(usrMap, SIGN_KEY);
        String html = "<a href=\"https://www.joeeeee.xyz/Tiles/signEmail/?token=" + token.replace(".", "*") + "\">点此验证</a>";

        sendEmailUtil.redisTemplate.opsForValue().set(usr.getEmail(), token);
//        sendEmailUtil.redisTemplate.expire(usr.getEmail(), 60, TimeUnit.SECONDS);
        sendEmailUtil.redisTemplate.opsForValue().set(usr.getEmail() + "usr", usr);
//        sendEmailUtil.redisTemplate.expire(usr.getEmail() + "usr", 60, TimeUnit.SECONDS);

        sendEmailUtil.emailParams.add(new BasicNameValuePair("to", usr.getEmail()));
        sendEmailUtil.emailParams.add(new BasicNameValuePair("html", html));

        try {
            sendEmailUtil.sendEmail.setEntity(new UrlEncodedFormEntity(sendEmailUtil.emailParams, "UTF-8"));

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpResponse response = httpclient.execute(sendEmailUtil.sendEmail);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new IllegalArgumentException(Integer.toString(statusCode));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
