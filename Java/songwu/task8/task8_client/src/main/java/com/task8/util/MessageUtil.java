package com.task8.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * Created on 17/6/7.
 * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dysmsapi.jar
 * <p>
 * 备注:Demo工程编码采用UTF-8
 * 国际短信发送请勿参照此DEMO
 */
@Component
@PropertySource(value = "classpath:message.properties",encoding = "utf-8")

public class MessageUtil {
    @Value("${product}")
   String product;
    @Value("${domain}")
      String domain;
    @Value("${accessKeyId}")
   String accessKeyId;
      @Value("${accessKeySecret}")
 String accessKeySecret;
     @Value("${signName}")
   String signName;
      @Value("${templateCode}")
  String templateCode;


//    //产品名称:云通信短信API产品,开发者无需替换
//    static final String product = "Dysmsapi";
//    //产品域名,开发者无需替换
//    static final String domain = "dysmsapi.aliyuncs.com";
//
//    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
//    static final String accessKeyId = "LTAIuCh2DuJng506";
//    static final String accessKeySecret = "cTjirAcjGdvmFoMt3Rk5oRZm9TBvWS";
//
//    static final String signName = "补俊";
//    static final String templateCode="SMS_141600060";

    //    SendSmsResponse
    public  String sendSms(String phone , String number) throws ClientException {


            //可自助调整超时时间
            System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");

            //初始化acsClient,暂不支持region化
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
        System.out.println(accessKeyId+accessKeyId+product+domain);
            //组装请求对象-具体描述见控制台-文档部分内容
            SendSmsRequest request = new SendSmsRequest();
            //使用post提交
            request.setMethod(MethodType.POST);
            //必填:待发送手机号
            request.setPhoneNumbers(phone);
        System.out.println("手机号"+phone);

        //必填:短信签名-可在短信控制台中找到
            request.setSignName(signName);
        System.out.println("签名："+signName);

        //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(templateCode);
        System.out.println("模板"+templateCode);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为

            request.setTemplateParam("{ \"code\":\""+number+"\"}");
            System.out.println(number);

            //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");

            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//        request.setOutId("yourOutId");


            //请求失败这里会抛ClientException异常
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            //请求成功
            return "发送成功";

        } else {
            return "发送失败";
        }


    }


    public static void main(String[] args) throws ClientException {

        //发短信
        String number= RandomUtil.random(6);
        MessageUtil messageUtil=new MessageUtil();
        System.out.println(messageUtil.sendSms("18274300297",number));



    }
}
