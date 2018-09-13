package com.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EMailUtil {
    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String address;
    private static String sender;
    private static String tagName;
    private static String subject;

    private static  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-account.xml");

    public void setAccessKeyId(String accessKeyId) {
        EMailUtil.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        EMailUtil.accessKeySecret = accessKeySecret;
    }

    public void setAddress(String address) {
        EMailUtil.address = address;
    }

    public void setSender(String sender) {
        EMailUtil.sender = sender;
    }

    public void setTagName(String tagName) {
        EMailUtil.tagName = tagName;
    }

    public void setSubject(String subject) {
        EMailUtil.subject = subject;
    }

    public static EMailUtil sample(String Email, String Emailcode) {
        applicationContext.getBean("eMailUtil");

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
            //账号类型0为随机账号，1为发信地址
            request.setAddressType(1);
            //控制台创建的标签
            request.setTagName(tagName);
            request.setReplyToAddress(true);
            //目标地址
            request.setToAddress(Email);
            //邮件主题
            request.setSubject(subject);
            //邮件正文
            System.out.println("11111111111111" + subject);
            System.out.println("2222222222222" + address);
            request.setHtmlBody("尊敬的用户，您好：\n您的验证码：" + Emailcode + "，请您及时进行注册验证，如不是您操作，请忽略本消息！");
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            System.out.println("EMailUtil++执行完成后");
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}





















//
//    private static String AccountName;
//    private static String TagName;
//    private static String ToAddress;
//    private static String HtmlBody;
//    private static String accessKeyId;
//    private static String accessKeySecret;
//
//    public void setAccessKeyId(String accessKeyId) {
//        EMailUtil.accessKeyId = accessKeyId;
//    }
//    public void setAccessKeySecret(String accessKeySecret) {
//        EMailUtil.accessKeySecret = accessKeySecret;
//    }
//    public void setAccountName(String AccountName) {
//        EMailUtil.AccountName = AccountName;
//    }
//
//    public void setTagName(String TagName) {
//        EMailUtil.TagName = TagName;
//    }
//
//    public void setToAddress(String ToAddress) {
//        EMailUtil.ToAddress = ToAddress;
//    }
//
//    public void setHtmlBody(String HtmlBody) {
//        EMailUtil.HtmlBody = HtmlBody;
//    }
//
//    public void sample() {
//        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
//        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your accessKey>", "<your accessSecret>");
//        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
//        //try {
//        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
//        //} catch (ClientException e) {
//        //e.printStackTrace();
//        //}
//        IAcsClient client = new DefaultAcsClient(profile);
//        SingleSendMailRequest request = new SingleSendMailRequest();
//        try {
//            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
//            request.setAccountName(AccountName);
//            //request.setFromAlias("发信人昵称");
//            request.setAddressType(1);
//            request.setTagName(TagName);
//            request.setReplyToAddress(true);
//            request.setToAddress(ToAddress);
//            //request.setSubject("邮件主题");
//            request.setHtmlBody(HtmlBody);
//            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
//        } catch (ServerException e) {
//            e.printStackTrace();
//        }
//        catch (ClientException e) {
//            e.printStackTrace();
//        }
//    }
//}
