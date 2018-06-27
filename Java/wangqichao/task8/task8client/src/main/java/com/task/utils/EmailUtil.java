package com.task.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.task.exception.MyException;


public class EmailUtil {
    private static String Region;//发信地区
    private static String AccessKey;
    private static String AccessSecret;
    private static String AccountName;//发信地址
    private static String FromAlias;//发信人昵称
    private static int AddressType;//发信地址类型，0为随机地址，1为发信地址
    private static String TagName;//标签
    private static boolean ReplyToAddress;//是否回信
    private static String Subject;//邮件主题

    public EmailUtil() {
    }

    public EmailUtil(String region,String accessKey,String accessSecret,String accountName,String fromAlias,String tagName,String subject,int addressType,boolean replyToAddress) {
    this.Region=region;
    this.AccessKey=accessKey;
    this.AccessSecret=accessSecret;
    this.AccountName=accountName;
    this.FromAlias=fromAlias;
    this.AddressType=addressType;
    this.TagName=tagName;
    this.ReplyToAddress=replyToAddress;
    this.Subject=subject;
    }

    public static void  singleSent(String address, String code)throws Exception{

        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile(Region, AccessKey, AccessSecret);
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        System.out.println("创建client");
        SingleSendMailRequest request = new SingleSendMailRequest();
        System.out.println("创建request");
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName(AccountName);
            request.setFromAlias(FromAlias);
            request.setAddressType(AddressType);
            request.setTagName(TagName);
            request.setReplyToAddress(ReplyToAddress);
            request.setToAddress(address);
            request.setSubject(Subject);
            request.setHtmlBody("亲爱的用户：<br/>&nbsp&nbsp&nbsp&nbsp你好！<br/>&nbsp&nbsp&nbsp&nbsp你现在正在进行技能树邮箱绑定，如果是本人操作，<a href=\"http://localhost:8080/u/a/email?email="+address+"&code="+code+"\">请点击此处验证</a>。<br/>&nbsp&nbsp&nbsp&nbsp如果不是，请忽略！");
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            System.out.println("发送信息");
        }catch (ServerException e) {
            e.printStackTrace();
            //捕捉异常之后就转化为自定义异常抛出去
            throw new MyException("发送失败");
        }
        catch (ClientException e) {
            e.printStackTrace();
            //捕捉异常之后就转化为自定义异常抛出去
            throw new MyException("发送失败");
        }
    }

}
