package com.Utils;

/**
 * @author: 曹樾
 * @program: task7
 * @description: ali shortmessage API
 * @create: 2018/5/28 下午2:02
 */
import com.aliyun.oss.ClientException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class SMSUtil {
    //短信API产品名称
    static final String product="Dysmsapi";
    //短信API产品域名
    static final String domain="dysmsapi.aliyuncs.com";
    static final String accessKeyId = "LTAINW6xnz0Qw2Og"; //LTAIvOtdYPKYws6Y
    static final String accessKeySecret = "HLnU0Varkd6kqjppUFKm3owkyOHKK8"; //mXvfOYlPlt4wTeNoFE8PJW9N9dbgBO
    
    public static SendSmsResponse sendSms(String telphone,String vcode) throws ClientException, com.aliyuncs.exceptions.ClientException {
        //设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient
        IClientProfile profile=DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou",product, domain);
        IAcsClient acsClient=new DefaultAcsClient(profile);
        
        //组装请求对象
        SendSmsRequest request=new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //待发送的手机号
        request.setPhoneNumbers(telphone);
        //短信签名
        request.setSignName("曹樾");
        //短信模板ID
        request.setTemplateCode("SMS_136030311");
        
        //验证码
        SMSUtil sms = new SMSUtil();
        System.out.println("code:"+vcode);
        /*
         * 可选:模板中的变量替换JSON串,
         * 如模板内容为"亲爱的${name},您的验证码为${code}"时,
         * 此处的值为{"name":"Tom","code":"1454"}
         *   \  反斜杠为转义字符，使得输出双引号
         */
//        request.setTemplateParam("{\"code\":\""+vcode+"\"}");
        request.setTemplateParam("{\"code\":\"1234\"}");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("1454");
        SendSmsResponse response=acsClient.getAcsResponse(request);
        String s=response.getCode();
        if(response.getCode() != null && response.getCode().equals("OK")) {
            //请求成功
            System.out.println("发送成功！");
        }else {
            System.out.println("发送失败！");
        }
        return response;
    }
    public static void main(String[] args) throws ClientException, InterruptedException, com.aliyuncs.exceptions.ClientException {
        
        //发短信
        SendSmsResponse response = sendSms("15903468296","1234");
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());
        
        Thread.sleep(3000L);
        
        //查明细
        
        
    }
}
