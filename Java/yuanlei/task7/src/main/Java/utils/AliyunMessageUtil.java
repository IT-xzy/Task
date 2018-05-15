package utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Map;

public class AliyunMessageUtil {
    private static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";
    // 此处需要替换成开发者自己的AK
    private static final String accessKeyId = "LTAILMiaU3VVk3zJ";
    private static final String accessKeySecret = "WkVDXgdZaKhP93g4ZrL9N6PXdBlJys";
    public static SendSmsResponse sendSms(String mobile_phone,String code) throws com.aliyuncs.exceptions.ClientException{
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectionTimeout","10000");
        System.setProperty("sun.net.client.defaultReadTimeout","10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou","cn-hangzhou",product,domain);
        IAcsClient acsClient =  new DefaultAcsClient(profile);
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号
        request.setPhoneNumbers(mobile_phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("大宝剑情義");
        request.setTemplateCode("SMS_134205001");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\""+code+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }
}
