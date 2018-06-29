package com.ptteng.util.thirdAPI;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ptteng.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailCaptchaUtil {

    @Autowired
    RedisUtil redisUtil;
    /**
     * 发送邮件验证码
     * @param email
     *
     */
    public void sample(String email) {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIs5HQAO7GlXZU", "pFFL3YTu4Xh8oFtRMDetGuFUs8HfeE");
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("mail@jason92.tech");
            request.setFromAlias("沉香");
            request.setAddressType(1);
            request.setTagName("test0602");
            request.setReplyToAddress(true);
            //用户邮箱
            request.setToAddress(email);
            request.setSubject("测试邮件调用SDK");
            //生成验证码
            String captchaCode = String.valueOf((int)((Math.random()*9+1)*1000));
            redisUtil.set(email, captchaCode);
            request.setHtmlBody("邮件正文:"+captchaCode);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
