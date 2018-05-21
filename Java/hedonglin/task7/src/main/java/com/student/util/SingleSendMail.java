package com.student.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.student.model.Student;
import com.student.service.StudentService;

import javax.annotation.Resource;
import java.util.UUID;



public class SingleSendMail {

    @Resource
    private StudentService studentService;

    private String regionId;

    private String accessKeyId;

    private String secret;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void sample(String email,String emailCode,String name) {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, secret);
//         如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
//        try {
//        DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
//        } catch (ClientException e) {
//        e.printStackTrace();
//        }
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
//            request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("hedonglin@www.hedonglin.top");
            request.setFromAlias("何东霖");
            request.setAddressType(1);
            request.setTagName("hedonglin");
            request.setReplyToAddress(true);
            request.setToAddress(email);
            request.setSubject("基佬分院注册验证");
            request.setHtmlBody("此邮件为基佬分院官方激活邮件，请点击下面的链接激活账号"+"http://localhost:8888/email/activation?email="+emailCode+"&name="+name);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public String getEmailCode() {

        String emailCode = UUID.randomUUID().toString().replace("-", "");
        return emailCode;
    }
}
