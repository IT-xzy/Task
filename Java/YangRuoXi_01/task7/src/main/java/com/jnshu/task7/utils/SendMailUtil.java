package com.jnshu.task7.utils;

import com.alibaba.fastjson.JSONObject;
import com.jnshu.task7.beans.api.MailParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
@Slf4j
public class SendMailUtil {

    @Autowired
    MailParams mailParams;


    @SuppressWarnings("unchecked")
    public void sendCommon(String email,String token) throws IOException {
//        final String url = "http://api.sendcloud.net/apiv2/mail/sendtemplate";
//        System.out.println(sendMailUrl);
//        final String apiUser = "yrxxxx_test_bacfgs";
//        final String apiKey = "MSBMtK6JAlgpPcsv";
        //邮件标题
//        String subject = "验证邮箱!";
        //页面信息
        String test = mailParams.getApiKey();
        System.out.println(test);
//        String html = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8080/emailVerification?token=" + token + "'>http://localhost:8080/emailVerification?token=" + token + "</href></h3></body></html>";
        HttpPost httpPost = new HttpPost(mailParams.getUrl());
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //模板属性配置相关属性配置
        Map xsmtpapi = new HashMap(16);
        Map toMap = new HashMap(16);
        Set toSet = new HashSet(16);
        Map subMap = new HashMap(16);
        Set subName = new HashSet(16);
        Set subUrl = new HashSet(16);

        toSet.add(email);
//        toMap.put("to",toSet);

        subName.add(email);
        subMap.put("%name%",subName);

        subUrl.add(mailParams.getToUrl() + token);
        subMap.put("%url%", subUrl);

        xsmtpapi.put("to",toSet);
        xsmtpapi.put("sub",subMap);
        String json = JSONObject.toJSONString(xsmtpapi);
        System.out.println("json" + json);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", mailParams.getApiUser()));
        params.add(new BasicNameValuePair("apiKey", mailParams.getApiKey()));
        params.add(new BasicNameValuePair("to", email));
        params.add(new BasicNameValuePair("from", mailParams.getFrom()));
        params.add(new BasicNameValuePair("fromName", mailParams.getFromName()));
        params.add(new BasicNameValuePair("subject", mailParams.getSubject()));
//        params.add(new BasicNameValuePair("html", html));
        params.add(new BasicNameValuePair("templateInvokeName", mailParams.getTemplateInvokeName()));
        params.add(new BasicNameValuePair("xsmtpapi",json));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);

        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回, 解析返回数据
            System.out.println(EntityUtils.toString(response.getEntity()));

        } else {
            System.err.println("error");
        }
        httpPost.releaseConnection();
    }

}
