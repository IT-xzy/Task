package com.ptteng.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ptteng.pojo.exception.UnacceptableException;
import com.ptteng.pojo.exception.UnavailableException;

//如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        /*try {
        DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        } catch (ClientException e) {
            e.printStackTrace();
        }*/
public class EmailUtil {
    private static final String regionId = "cn-hangzhou";
    private static final String accessKeyId = "LTAImod9kcQWKgYR";
    private static final String secret = "5U44jSVF3NJr38fc3jE7rYKsz0Dq4y";
    private static final IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, secret);
    //激活邮件的有效时间，单位分钟
    public static final int ALIVE_MIN = 10;
    //激活邮件的有效时间，单位毫秒
    public static final long ALIVE_MS = 1000L * 60 * ALIVE_MIN;

    public static SingleSendMailResponse sendSingleEmail(String address, String link) {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAddressType(1);
            //当SDK遇到阿里云服务器端错误(ServerException)时，Client会自动重试。
            request.setReplyToAddress(true);
            request.setAccountName("admin@depeatkk.xyz");
            request.setFromAlias("技能树");
            request.setTagName("signup");
            request.setToAddress(address);
            request.setSubject("账号注册");
            request.setHtmlBody("点击链接激活你的注册邮箱，该链接" + ALIVE_MIN + "分钟内有效：" + link);
            return client.getAcsResponse(request);
        } catch (ServerException e) {
            throw new UnavailableException("阿里服务端异常，邮件发送失败");
        } catch (ClientException e) {
            throw new UnacceptableException("邮件发送失败，请再次检查");
        }
    }
}
