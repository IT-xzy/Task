package com.lihoo.jnshu.common.util.emailUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * #Title: SendCommonPostMail
 * #ProjectName task7_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/29-16:32
 * @author lihoo
 */

//邮箱验证码

public class SendCommonPostMail {
    private static Logger logger = LoggerFactory.getLogger(SendCommonPostMail.class);

    public static void sendEmailCode(String email, String code) throws IOException {

        final String url = "http://api.sendcloud.net/apiv2/mail/send";
        final String apiUser = "lihaaa_test_PONQYr";
        final String apiKey = "CLTiQEQtdkgPoPtE";

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httPost = new HttpPost(url);

        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("from", "whalesong939@163.com"));
        params.add(new BasicNameValuePair("fromName", "李浩"));
        params.add(new BasicNameValuePair("to", email));
        params.add(new BasicNameValuePair("subject", "注册<我的智慧树>账号邮箱验证"));
        params.add(new BasicNameValuePair
                ("html", "您好！欢迎注册<我的智慧树>，请将验证码填写到注册页面。验证码：" + code));

        httPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        // 请求
        HttpResponse response = httpclient.execute(httPost);
        // 处理响应

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回
            logger.info("正常返回验证码");
            // 读取xml文档
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            logger.info("第一手邮箱验证码全部信息：" + result);
//            String getFront4 = result.substring(0, 4);
//            System.out.println(code);
            logger.info("第一手邮箱验证码：" + code);
        } else {
            System.err.println("error");
        }
        httPost.releaseConnection();
    }

//    /***************
//     *
//     * 生成4位随机验证码
//     */
//    public static String get4Code() {
//        System.out.println("邮箱code");
//        String[] beforeShuffle = new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9" };
//        List list = Arrays.asList(beforeShuffle);
//        Collections.shuffle(list);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(list.get(i));
//        }
//        String afterShuffle = sb.toString();
//        String rs = afterShuffle.substring(5, 9);
//        System.out .print(rs);
//        return rs;
//    }
}
