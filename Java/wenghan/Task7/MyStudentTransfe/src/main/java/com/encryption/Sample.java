package com.encryption;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

    public class Sample {
    public static void mySample(String verification,String mail) {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIFumOhh6Kvow5", "qGPqDbBzKMJvoILXDh5AXzbaeogXFY");
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //控制台创建的发信地址
            request.setAccountName("wenghannew@mymail.wenghan.top");
            //发信人昵称
            request.setFromAlias("翁涵");
            //0：随机账号、1：发信地址
            request.setAddressType(1);
            //控制台创建的标签
            request.setTagName("mytest");
            //是否启用回信地址
            request.setReplyToAddress(true);
            //目标地址，多个地址可以用逗号分隔
            request.setToAddress(mail);
            //发信人昵称
            request.setFromAlias("翁涵");
            //邮件主题
            request.setSubject("验证码");
            //邮件html正文
            request.setHtmlBody(verification);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            //用户发送的每次接口调用请求，无论成功与否，系统都会返回一个唯一识别码 RequestId 给用户。
            System.out.println("唯一识别码："+httpResponse.getRequestId());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String verification=MyRandom.getVerification();
        System.out.println(verification);
        Sample.mySample(verification,"wenghan543043294@sina.com");
    }
}

