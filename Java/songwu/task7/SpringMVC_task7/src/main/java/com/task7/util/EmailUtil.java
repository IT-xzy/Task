package com.task7.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
 * Create by SongWu on 2018/8/4
 */
@Component
public class EmailUtil {
    static Logger logger = Logger.getLogger(EmailUtil.class);

    @Value("${url}")
    String url;

    @Value("${apiUser}")
    String apiUser;
    @Value("${apiKey}")
    String apiKey;


    @Value("${subject}")
    String subject;

//    @Value("${html}")
//     String html;


//  public static String  url;
//  public static String  apiUser;
//  public static String  apiKey;
//  public static String  subject;
//  public static String  html;

//    @Value("${url}")
//    public void setUrl(String url) {
//        EmailUtil.url = url;
//    }
//    @Value("${apiUse}")
//    public  void setApiUser(String apiUser) {
//        EmailUtil.apiUser = apiUser;
//    }
//    @Value("${apiKey}")
//    public  void setApiKey(String apiKey) {
//        EmailUtil.apiKey = apiKey;
//    }
//    @Value("${subject}")
//    public  void setSubject(String subject) {
//        EmailUtil.subject = subject;
//    }
//    @Value("${html}")
//    public  void setHtml(String html) {
//        EmailUtil.html = html;
//    }


//    static final String url = "http://api.sendcloud.net/apiv2/mail/send";
//
//    static final String apiUser = "songwu_test_mgKaHU";
//    static final String apiKey = " 6FmlMydHMla5Yud0";
//
//
//        //        final String rcpt_to = "827227171@qq.com";
//    static String subject = "邮件验证";
//   static String  number = RandomUtil.random(6);
//    static String html = "你的验证码为"+number;

    public void send_common(String rcpt_to, String html) throws IOException {
        System.out.println("url:" + url);
        logger.info(url);
        HttpPost httpPost = new HttpPost(url);
        HttpClient httpClient = new DefaultHttpClient();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("to", rcpt_to));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "SendCloud"));
        params.add(new BasicNameValuePair("subject", subject));
//        params.add(new BasicNameValuePair("html", html));

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

    public String send_common_with_attachment(String rcpt_to, String html) throws ClientProtocolException, IOException {


        HttpPost httpPost = new HttpPost(url);
        HttpClient httpClient = new DefaultHttpClient();

        // 涉及到附件上传, 需要使用 MultipartEntity
        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, null, Charset.forName("UTF-8"));
        entity.addPart("apiUser", new StringBody(apiUser, Charset.forName("UTF-8")));
        entity.addPart("apiKey", new StringBody(apiKey, Charset.forName("UTF-8")));
        entity.addPart("to", new StringBody(rcpt_to, Charset.forName("UTF-8")));
        entity.addPart("from", new StringBody("sendcloud@sendcloud.org", Charset.forName("UTF-8")));
        entity.addPart("fromName", new StringBody("SendCloud", Charset.forName("UTF-8")));
        entity.addPart("subject", new StringBody(subject, Charset.forName("UTF-8")));
        entity.addPart("html", new StringBody(html, Charset.forName("UTF-8")));

        // 添加附件
        File file = new File("E:\\ideal-workspace（copy）\\task7\\SpringMVCT（task7）\\src\\main\\webapp\\img\\qy1.png");
        FileBody attachment = new FileBody(file, "application/octet-stream", "UTF-8");
        entity.addPart("attachments", attachment);
        //多附件
        File file1 = new File("E:\\ideal-workspace（copy）\\task7\\SpringMVCT（task7）\\src\\main\\webapp\\img\\qy1.png");
        FileBody attachment1 = new FileBody(file1, "application/octet-stream", "UTF-8");
        entity.addPart("attachments", attachment1);

        //添加附件, 文件流形式
        //File file = new File("D:\\1.txt");
        //String attachName = "attach.txt";
        //InputStreamBody is = new InputStreamBody(new FileInputStream(file),
        //attachName);
        //entity.addPart("attachments", is);
        //多附件
        //File file1 = new File("D:\\1.txt");
        //String attachName1 = "attach.txt";
        //InputStreamBody is1 = new InputStreamBody(new FileInputStream(file1),
        //attachName1);
        //entity.addPart("attachments", is1);

        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);
        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回, 解析返回数据
            System.out.println(EntityUtils.toString(response.getEntity()));
            httpPost.releaseConnection();
            return "发送成功";

        } else {
            System.err.println("error");
            httpPost.releaseConnection();
            return "发送失败";
        }


    }

    public static void main(String[] args) throws IOException {
        EmailUtil emailUtil = new EmailUtil();
        String code = RandomUtil.random(6);
//       send_common("827227171@qq.com");
//        send_common_with_attachment("827227171@qq.com");
        emailUtil.send_common_with_attachment("827227171@qq.com", code);

    }

}
