package com.ev.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ev.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;


public class MailUtil {

    //阿里云控制台accessKeyId
    private String accessKeyId;
    //阿里云控制台accessKeySecret
    private String accessKeySecret;
    //管理控制台中配置的发信地址。
    private String accountName;
    //发信人昵称,长度小于15个字符。 例如:发信人昵称设置为”小红”，发信地址为 “test@example.com”，收信人看到的发信地址为"小红"<test@example.com>。
    private String formAlias;
    //邮件标签用于分类您所发送的邮件批次，是对不同批次的邮件进行备注的一种方法。
    private String tagName;
    //使用管理控制台中配置的回信地址（状态必须是验证通过）
    private boolean replyToAddress;
    //取值范围 0~1: 0 为随机账号；1 为发信地址。
    private Integer addressType;

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setFormAlias(String formAlias) {
        this.formAlias = formAlias;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setReplyToAddress(boolean replyToAddress) {
        this.replyToAddress = replyToAddress;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    public void sendMail(String toAddress, String htmlBody, String subject) throws Exception {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);

        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName(accountName);
            request.setFromAlias(formAlias);
            request.setAddressType(addressType);
            request.setTagName(tagName);
            request.setReplyToAddress(replyToAddress);
            request.setSubject(subject);
            request.setHtmlBody(htmlBody);
            request.setToAddress(toAddress);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public String getMailCode(User user){
        return DigestUtils.sha512Hex(user.toString()+System.currentTimeMillis());
    }



    public MailUtil() {
    }
}
