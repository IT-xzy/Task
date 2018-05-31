package com.fml.Demo;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class AliyunEmailDemo {
    public static void main(String args[]){

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIKZZR5he1rKBk", "D1Nq9I5olH01GCDn8PQWhbjDu5G1en");

        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");//这句话必须注释掉，否则报错
            request.setAccountName("dwk@fcml.xyz");
            request.setFromAlias("段文凯");
            request.setAddressType(1);
            request.setTagName("register");
            request.setReplyToAddress(true);
            request.setToAddress("272482942@qq.com");
            request.setSubject("邮件主题");
            request.setHtmlBody("闵仕宇傻逼");

            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
