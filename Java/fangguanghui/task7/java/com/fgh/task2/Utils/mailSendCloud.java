package com.fgh.task2.Utils;



import com.alibaba.fastjson.JSONObject;
import com.fgh.task2.Utils.cache.RedisUtils;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class mailSendCloud {
    @Autowired
    RedisUtils redisUtils;

    Logger logger=LoggerFactory.getLogger(mailSendCloud.class);
    private String apiUser;
    private String apiKey;


    //标题设置
    private String subject="用户管理验证";
    //验证链接部分
    private  String sendBodyBegin = "<html><H1><a href= \" ";
    private  String sendBodyEnd = "\">点击验证邮箱</a></H1></html>";

     mailSendCloud(String apiUser,String apiKey){
        this.apiKey = apiKey;
        this.apiUser = apiUser;
    }

    //验证链接组装
    private String mail_link(String randCode,String sendUrl){
        return sendBodyBegin+sendUrl+"/mailVerify/"+randCode+sendBodyEnd;
    }

    public boolean send_common(String rcpt_to, String randCode, String sendUrl){
        return sendMail_common( rcpt_to,randCode,sendUrl);
    }

    /**
     *
     * @param rcpt_to
     *          默认的回复邮件地址. 如果为空, 则默认的回复邮件地址为 from
     * @param randCode
     *          验证码
     * @param sendUrl
     *          邮件中的验证链接
     * @return
     */
    public boolean sendMail_common(String rcpt_to, String randCode, String sendUrl) {
        final String url = "http://sendcloud.sohu.com/webapi/mail.send.json";
//        final String url = "http://api.sendcloud.net/apiv2/mail/send";
        logger.info("邮箱: "+rcpt_to);
        logger.info("验证码："+randCode);
        logger.info("url: "+sendUrl);
        logger.info("apiUser: "+apiUser);
        logger.info("apiKey: "+apiKey);

        //生成验证链接
        String html = mail_link(randCode, sendUrl);
        logger.info("验证链接："+html);
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();

        List <NameValuePair> params = new ArrayList <NameValuePair>();
        params.add(new BasicNameValuePair("api_user", apiUser));
        params.add(new BasicNameValuePair("api_key", apiKey));
        params.add(new BasicNameValuePair("to", rcpt_to));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.im"));
        params.add(new BasicNameValuePair("fromname", "SendCloud"));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", html));
        params.add(new BasicNameValuePair("resp_email_id", "true"));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            HttpResponse response = httpClient.execute(httpPost);
//            JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
            String mailStatus =EntityUtils.toString(response.getEntity());
            // 正常返回, 解析返回数据
//            JSONObject jsonObject=JSONObject.parseObject(EntityUtils.toString(response.getEntity()));

            // 处理响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

                if (mailStatus.indexOf("success")>0){
                    logger.info("邮件发送状态(成功)："+mailStatus);
                    //将验证码(key)和邮箱(value)存入缓存中,过期时间5min
                    redisUtils.add(randCode,rcpt_to,10000*60);
                    httpPost.releaseConnection();
                    return true;
                }else {
                    logger.info("邮件发送状态(失败)："+mailStatus);
                    return false;
                }
            } else {
                System.err.println("error");
                logger.info("邮件发送状态(内部错误导致失败)："+mailStatus);
                httpPost.releaseConnection();
                return false;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.info("编码异常导致失败!");
            return false;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
