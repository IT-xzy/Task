package com.mutesaid.rmi_demo_web.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
@ConfigurationProperties(prefix = "msg")
@Slf4j
public class MsgUtil {
    private static MsgUtil msgUtil;

    private static String url;

    private static String idToken;

    private static String sid;

    private static Map<String, String> params = new HashMap<>();

    public void setUrl(String url) {
        MsgUtil.url = url;
    }

    public void setIdToken(String idToken) {
        MsgUtil.idToken = idToken;
    }

    public void setSid(String sid) {
        MsgUtil.sid = sid;
    }

    public void setParams(Map<String, String> params) {
        MsgUtil.params = params;
    }

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @PostConstruct
    public void init() {
        msgUtil = this;
    }

    private static String setInfo(String phone) throws IOException {
        // API验证参数 MD5(账户Id + 账户授权令牌 + 时间戳)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = dateFormat.format(new Date());
        String sigParameter = Objects.requireNonNull(MD5Util.encrypt(idToken + time, "")).toUpperCase();

        // 验证信息， Base64(账户Id + 冒号 + 时间戳)
        String authorization = sid + ":" + time;
        String base = Base64.getEncoder().encodeToString(authorization.getBytes());

        // 发送手机号， 验证码
        int num = 100000 + (int) (Math.random() * 900000);
        params.put("to", phone);
        params.put("datas", Arrays.toString(new int[]{num, 10}));
        String json = JSONObject.wrap(params).toString();

        // 存储到Redis用于校验 验证时间10分钟
        msgUtil.redisTemplate.opsForValue().set(phone, Integer.toString(num));
        msgUtil.redisTemplate.expire(phone, 10, TimeUnit.MINUTES);

        // 发送HTTP请求
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url + sigParameter);
        // 请求体
        StringEntity stringEntity = new StringEntity(json, "UTF-8");
        stringEntity.setContentType("application/json");
        httpPost.addHeader("Authorization", base);
        httpPost.setEntity(stringEntity);

        HttpResponse response = httpclient.execute(httpPost);
        return EntityUtils.toString(response.getEntity());
    }

    public static Boolean sendMsg(String phone) throws IOException {
        System.out.println(url);
        String xml = setInfo(phone);
        Map json = XML.toJSONObject(xml).toMap();
        Map statusInfo = (Map) json.get("Response");
        if(!"000000".equals(statusInfo.get("statusCode"))){
            log.info("请求错误 msg = {}", statusInfo.get("statusMsg"));
            return false;
        }
        return true;
    }
}
