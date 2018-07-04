package com.ptt.util;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SendEmailUtil
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/6/16 11:47
 * @Version: 1.0
 */
@Component
public class SendEmailUtil {
    private static Logger logger = LoggerFactory.getLogger(SendEmailUtil.class);
    private static String apiUser;//账号
    private static String apiKey;//密码
    private static String url;

    public static Integer send(String address, String vCode) {
        try {
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpClient httpClient = HttpClients.createDefault();

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("apiUser", apiUser));
            params.add(new BasicNameValuePair("apiKey", apiKey));
            params.add(new BasicNameValuePair("to", address));
            //MNHI1GBcoQlQLzfw5JNCjYLRcTKHsY1.sendcloud.org是发信域名，“@”之前的自己定义
            params.add(new BasicNameValuePair("from", "jin@sMNHI1GBcoQlQLzfw5JNCjYLRcTKHsY1.sendcloud.org"));
            params.add(new BasicNameValuePair("fromName", "jin"));
            params.add(new BasicNameValuePair("subject", "ptt 验证码"));
            params.add(new BasicNameValuePair("html", "验证码是：" + vCode));
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            // 处理响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 正常返回, 解析返回数据
                logger.info("发送成功，返回数据：{}", EntityUtils.toString(response.getEntity()));
                return 0;//发送成功
            } else {
                logger.info("error");
            }
            httpPost.releaseConnection();
        } catch (Exception e){
            e.printStackTrace();
            logger.info("发送邮件出错：{}", e.getMessage());
        }
        return 1;//发送失败
    }

    @Value("${apiUser}")
    public void setApiUser(String apiUser) {
        SendEmailUtil.apiUser = apiUser;
    }

    @Value("${apiKey}")
    public void setApiKey(String apiKey) {
        SendEmailUtil.apiKey = apiKey;
    }

    @Value("${url}")
    public void setUrl(String url) {
        SendEmailUtil.url = url;
    }
}
