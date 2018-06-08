package com.longhang.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;


public class AliyunEmail {

    private  String accessKeySecret;
    private  String accessKeyId;

    public AliyunEmail() {
    }

    public AliyunEmail(String accessKeyId , String accessKeySecret ) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;

    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public SingleSendMailResponse sample(String mail, String code)  {

       IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId, accessKeySecret);
//       IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKey.getAccessKeyId(),  accessKey.getAccessKeySecret());
        SingleSendMailResponse httpResponse=null;
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {

            request.setAccountName("illidan@email.lengsheng.top");
            request.setFromAlias("伊利丹");
            request.setAddressType(1);
            request.setTagName("Verification");
            request.setReplyToAddress(true);
            request.setToAddress(mail);
            request.setSubject("邮件主题");
            request.setHtmlBody("您的验证码:"+code);
            httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        return httpResponse;


    }
}
