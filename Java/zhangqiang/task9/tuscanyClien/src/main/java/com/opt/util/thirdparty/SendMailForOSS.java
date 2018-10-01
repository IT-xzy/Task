package com.opt.util.thirdparty;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SendMailForOSS {

    static Logger logger = Logger.getLogger(SendMailForOSS.class);

    public static JSON send_common(String rcpt_to, String subject, String html){

        Properties properties = readerPro();
        JSON back = null;

        final String url = "http://api.sendcloud.net/apiv2/mail/send";

        final String apiUser = properties.getProperty("api_user");
        final String apiKey = properties.getProperty("api_key");

//        final String rcpt_to = "137416943@qq.com";
//        String subject = "验证邮件";
//        String html = "22222";

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("to", rcpt_to));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "lionzq"));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", html));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

                 HttpResponse response = httpClient.execute(httpPost);

            // 处理响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 正常返回, 解析返回数据
    //            System.out.println(EntityUtils.toString(response.getEntity()));
                back = JSON.parseObject(EntityUtils.toString(response.getEntity()));
            } else {
                back = JSON.parseObject("{'error':'error'}");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        httpPost.releaseConnection();
        return back;
    }


    public static Properties readerPro(){
        Properties properties = new Properties();
        FileInputStream in = null;
        try {
            String path = new Object() {
                public String getPath() {
                    return this.getClass().getClassLoader().getResource("properties/sendCloud.properties").getPath();
                }
            }.getPath().substring(1);

            in = new FileInputStream(path);

            properties.load(in);

            logger.info(properties.getProperty("api_user"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.debug("配置文件未找到："+e);
        } catch (IOException e) {
            e.printStackTrace();
        }if (in!=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }


//    public void sample(String toAddress,String accountName ,String mailCode) {
//        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", OSSClientConstants.ACCESS_KEY_ID, OSSClientConstants.ACCESS_KEY_SECRET);
//        IAcsClient client = new DefaultAcsClient(profile);
//        SingleSendMailRequest request = new SingleSendMailRequest();
//        try {
//            //控制台创建的发信地址
//            request.setAccountName(accountName);
//            request.setAddressType(1);
//            request.setTagName("控制台创建的标签");
//            request.setReplyToAddress(true);
//            //发送的邮箱地址
//            request.setToAddress(toAddress);
//            request.setSubject("测试验证");
//            //发送的验证码
//            request.setHtmlBody(mailCode);
//            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
//        } catch (ServerException e) {
//            e.printStackTrace();
//        }
//        catch (ClientException e) {
//            e.printStackTrace();
//        }
//    }


    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream(getClass().getClassLoader().getResource("properties/sendCloud.properties").getPath());
        properties.load(in);
        logger.info(properties.getProperty("send_api"));

        send_common("137416943@qq.com","我是标题","我是内容：22222");

    }



}
