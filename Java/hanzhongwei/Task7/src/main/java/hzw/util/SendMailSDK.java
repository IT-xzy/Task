package hzw.util;

import hzw.model.User;
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
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * SendCloud邮件发送工具类
 */

public class SendMailSDK {

    private static Logger logger = LoggerFactory.getLogger(SendMailSDK.class);

    //认证
    private String apiUser = "jimo621_test_5Nteja";
    private String apiKey = "fscfO9QIj9YgX6k7";
    //邮箱发送接口
    private String apiUrl = "http://api.sendcloud.net/apiv2/mail/send";
    //发件人邮箱
    private  String from = "sendcloud@sendcloud.org";
    //收件人邮箱
//    private String rcpt_to = "2595519485@qq.com";

    // 邮件标题
    private String subject = "学生管理系统邮箱验证";
    //邮件内容
   // private String html = "这个是一个测试";
    private String sendBodyBegin = "<html><H1><a href=\"";
    private String sendBodyEnd = "\">点击验证邮箱,五分钟后失效</a></H1></html>";
    //发件人名称
    private String fromName = "小七";

//    SendMailSDK(String apiUser, String apiKey, String apiUrl) {
//        this.apiUser = apiUser;
//        this.apiKey = apiKey;
//        this.apiUrl = apiUrl;
//    }

    // 外部调用发送方法
    // 只提供发送邮箱
    public boolean sendMail(String httpUrl, User user,String randInt) {

        return sendMailReal(user, subject, httpUrl, fromName,randInt);
    }


    private boolean sendMailReal(User user, String subject, String httpUrl, String fromName,String randInt) {

        // 构建http请求
        HttpPost httpPost = new HttpPost(apiUrl);;
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 拼接验证url httpUrl 当前项目的根目录
        String sendBody = sendBodyBegin + httpUrl + "/" +randInt + sendBodyEnd;
        logger.info("拼接发送内容: " + sendBody);
        // http 发送内容
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("to", user.getUserEmail()));
        // 该值是我们的发件邮箱, 只能设置sendcloud上绑定的
        params.add(new BasicNameValuePair("from",from));
        params.add(new BasicNameValuePair("fromName", fromName));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", sendBody));


        try {
            // 发送请求 将数据转换为JSON格式
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            // 接收请求
            HttpResponse response = httpClient.execute(httpPost);
            // 判断请求是否发送成功
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 正常返回, 解析返回数据
                response.getEntity();
                System.out.println(EntityUtils.toString(response.getEntity()));
                return true;
            } else {
                logger.debug("请求发送失败 ~");

                return false;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.debug("UrlEncodedFormEntity 转换失败导致发送请求失败");
            return false;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            logger.debug("httpClient.execute(httpPost) 请求接收失败");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("EntityUtils.toString(response.getEntity()) 转换失败");
            return false;
        } finally {
            httpPost.releaseConnection();
        }
    }
}
