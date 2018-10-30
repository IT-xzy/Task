package com.lihoo.jnshu;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
/**
 * #Title: AliyunEmailTest
 * #ProjectName task7_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/4-14:16
 */


public class AliyunEmailTest {
//    // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
//    private IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your accessKey>", "<your accessSecret>");
//    // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
//    //try {
//    //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
//    //} catch (ClientException e) {
//    //e.printStackTrace();
//    //}
//    private IAcsClient client = new DefaultAcsClient(profile);
//    SingleSendMailRequest request = new SingleSendMailRequest();
//    try {
//        //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
//        request.setAccountName("控制台创建的发信地址");
//        request.setFromAlias("发信人昵称");
//        request.setAddressType(1);
//        request.setTagName("控制台创建的标签");
//        request.setReplyToAddress(true);
//        request.setToAddress("目标地址");
//        //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
//        //request.setToAddress("邮箱1,邮箱2");
//        request.setSubject("邮件主题");
//        request.setHtmlBody("邮件正文");
//        SingleSendMailResponse httpResponse = client.getAcsResponse(request);
//    } catch (ServerException e) {
//        e.printStackTrace();
//    } catch (ClientException e) {
//        e.printStackTrace();
//    }
}
