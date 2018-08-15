package hzw.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.log4j.Logger;

/**
 * 阿里云短信发送工具类
 */
public class SMSUtil {
    static Logger logger = Logger.getLogger(SMSUtil.class);
    //初始化ascClient需要的几个参数
    private String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
    private String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
    //替换成你的AK
//    final String accessKeyId = "LTAIw8a285xdQ9ge";//你的accessKeyId,参考本文档步骤2
//    final String accessKeySecret = "mddtauRgDZd0BeW2f6DGQi8fQB3Epv";//你的accessKeySecret，参考本文档步骤2
    //短信签名
//    final String SignName = "韩忠伟";
    //短信模板
//    final String TemplateCode = "SMS_136465099";

    private String accessKeyId;
    private String accessKeySecret;
    private String SignName;
    private String TemplateCode;

    public SMSUtil(String accessKeyId,String accessKeySecret,String SignName,String TemplateCode){
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.SignName = SignName;
        this.TemplateCode = TemplateCode;
    }

    public Boolean SMSclient(String PhoneNumbers,String Rand_Code) throws ClientException {
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
        request.setPhoneNumbers(PhoneNumbers);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SignName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(TemplateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");
        System.out.println("获得的验证码是： "+Rand_Code);
        request.setTemplateParam("{ \"code\":\""+Rand_Code+"\"}");
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            System.out.println("请求成功，发送短信"+request.getPhoneNumbers());
            System.out.println("请求成功，发送短信"+request.getSignName());
            System.out.println("请求成功，发送短信"+request.getTemplateCode());
            System.out.println("请求成功，发送短信"+request.getTemplateParam());
            System.out.println("请求成功，发送短信"+sendSmsResponse.getCode());
            //获取回执ID
            sendSmsResponse.getBizId();
            //请求成功
            return true;
        }else {
            System.out.println("发送验证码失败");
            return false;
        }
    }
}
