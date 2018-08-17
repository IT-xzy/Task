package com.jnshu.czm.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;


public class EmailUtil {


    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String address;
    private static String sender;
    private static String tagName;


    private static String subject;

    public void setAccessKeyId(String accessKeyId) {
        EmailUtil.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        EmailUtil.accessKeySecret = accessKeySecret;
    }

    public void setAddress(String address) {
        EmailUtil.address = address;
    }

    public void setSender(String sender) {
        EmailUtil.sender = sender;
    }

    public void setTagName(String tagName) {
        EmailUtil.tagName = tagName;
    }

    public void setSubject(String subject) {
        EmailUtil.subject = subject;
    }

    public EmailUtil sample(String Email, String Emailcode) {

        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
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
            // 控制台创建的发信地址
            request.setAccountName(address);
            //发信人昵称
            request.setFromAlias(sender);
            request.setAddressType(1);
            //控制台创建的标签
            request.setTagName(tagName);
            request.setReplyToAddress(true);
            //目标地址
            request.setToAddress(Email);
            //邮件主题
            request.setSubject(subject);
            //邮件正文
            request.setHtmlBody("您的验证码："+Emailcode+"，您正进行身份验证，打死不告诉别人！");
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}