package com.ssm.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SendEmailUtil {

    @Value("${aliyun.accessKeyId}")
    private String ak;
    @Value("${aliyun.accessKeySecret}")
    private String sk;

    public String getAk() {
        return ak;
    }
    public String getSk() {
        return sk;
    }

    public static SingleSendMailResponse send(String address, String code,String accessKeyId,String accessKeySecret) {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        SingleSendMailResponse httpResponse = new SingleSendMailResponse();
        try {
            request.setAccountName("chenduxiu@push.ycgoing.top");
            request.setFromAlias("田园护工陈独秀");
            request.setAddressType(1);
            request.setTagName("verification");
            request.setReplyToAddress(true);
            request.setToAddress(address);
            request.setSubject("田园护工-账号验证");
            request.setHtmlBody("您好，您的账户验证码为：" + code + ",请在15分钟之内使用，以免过期！");
            httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }
}
