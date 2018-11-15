package task7.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class DysSmsUtil {
    private static Logger logger = Logger.getLogger(DysSmsUtil.class);

    /**
     * 下面的静态属性可以封装在一个property文件里面
     */
    //产品名称:云通信短信API产品,开发者无需替换
    private static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";
    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private static final String accessKeyId = "LTAIYJkbrR5aHKIX";
    private static final String accessKeySecret = "NPfctvHtPjIfS0f3Z5F1YgM3lHK4ut";
    //短信签名,必填:短信签名-可在短信控制台中找到
    private static String signName ="技能树";
    //短信模版id,必填:短信模板-可在短信控制台中找到
    private static String templateCode ="SMS_150182612";
    //产生分随机数封装在工具类的属性里面，用于缓存的装入
    public static String number =randomNumber();

    //初始化acsClient,暂不支持region化
    private static IAcsClient acsClient;
    static {
        if (acsClient==null){
            //System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            //System.setProperty("sun.net.client.defaultReadTimeout", "10000");
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
            try {
                DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            } catch (ClientException e) {
                logger.info("初始化acsClient异常");
                e.printStackTrace();
            }
            acsClient = new DefaultAcsClient(profile);
        }
    }

    /**
     * 发送验证码方法。
     * @param phone 入参为电话号码
     * @return Boolean flag，返回true发送成功，flase失败。
     */
    public static Boolean sendSms(String phone) {
        logger.info("进入sendSms()");
        logger.info(phone);
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"number\":\""+number+"\"}");
        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = null;
        try {
            logger.info("初始化SendSmsResponse");
             sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            logger.info("创建SendSmsResponse异常");
            e.printStackTrace();
        }
        boolean flag=false;
        if (sendSmsResponse!=null){
            logger.info("判断信息是否发送成功");
            if("OK".equals(sendSmsResponse.getCode())){
                logger.info("成功！");
                flag=true;
            }
        }
        return flag;
    }

    //封装一个产生随机6位数的字符串
    private static String randomNumber(){
        int i =(int)((Math.random()*9+1)*100000);
        return Integer.toString(i);
    }



}
