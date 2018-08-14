package util.aliSmsUtil;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.log4j.Logger;
import org.mvel2.templates.util.io.StandardOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AliSmsUtil {
    Logger logger = Logger.getLogger(AliSmsUtil.class);
    @Autowired
    AliSmsBean aliSmsBean;

    final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
    final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
//    final String accessKeyId =aliSmsBean.getAccessKeyId();//你的accessKeyId,参考本文档步骤2
//    final String accessKeySecret = aliSmsBean.getAccessKeySecret();//你的accessKeySecret，参考本文档步骤2

    public void sendMesg(String phoneNum, String regCode) throws ClientException {

        System.setProperty("sun.net.client.defaultConnectTimeout", aliSmsBean.getConnectTimeout());
        System.setProperty("sun.net.client.defaultReadTimeout", aliSmsBean.getReadTimeout());

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliSmsBean.getAccessKeyId(), aliSmsBean.getAccessKeySecret());
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNum);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(aliSmsBean.getSignName());
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(aliSmsBean.getTemplateCode());
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{code:" + regCode + "}");
        request.setOutId("yourOutId");
        SendSmsResponse sendSmsResponse = null;
        sendSmsResponse = acsClient.getAcsResponse(request);
        //跟踪短信发送情况
        if (sendSmsResponse.getCode() == null | !sendSmsResponse.getCode().equals("OK")) {
            logger.error("Code" + sendSmsResponse.getCode());
            logger.error("Message.properties" + sendSmsResponse.getMessage());
            logger.error("RequestId=" + sendSmsResponse.getRequestId());
            logger.error("BizId=" + sendSmsResponse.getBizId());
        }
    }


}

