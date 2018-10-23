package com.jnshuboot.util.thirdUtil;

import com.jnshuboot.pojo.ServicePojo.MailSLAccount;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class SendMaiUtil {
    @Autowired
    MailSLAccount mailSLAccount;

    /**
     * 发送单个邮件
     *
     * @param mail 邮箱名称；发送之前需已验证过邮箱格式；
     * @return 返回成功后的验证码或null；
     */
    public String sendCommon(String mail) {

        final String url = "http://api.sendcloud.net/apiv2/mail/send";

        final String apiUser = mailSLAccount.getApiUser();
        final String from = mailSLAccount.getFrom();
        final String fromName = mailSLAccount.getFromName();
        final String apiKey = mailSLAccount.getApiKey();
        final String rcpt_to = mail;
        //生成6位数的验证码；
        String code = (int) ((Math.random() * 9 + 1) * 100000) + "";
        String subject = "SendCloud的testTask激活码邮件！";
        String html = "您的task验证码为:" + code + ",请在邮箱注册及激活界面输入使用!";
        //验证邮箱格式；xxxxxxx@xx.xx.xx 第二个点及后的内容为缺省；
//		String regex="^\\w+@\\w+\\.\\w+(\\.?|\\w?)\\w+$";
//		Boolean booMail=Pattern.matches(regex,to);
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("to", rcpt_to));
        params.add(new BasicNameValuePair("from", from));
        params.add(new BasicNameValuePair("fromName", fromName));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", html));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            // 处理响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 正常返回, 解析返回数据
                log.info(EntityUtils.toString(response.getEntity()));
                return code;
            } else {
                log.info("邮箱发送错误");
            }
            httpPost.releaseConnection();
        } catch (Exception e) {
            log.error("邮箱发送异常" + e);
        }
        code = null;
        return code;
    }

}
