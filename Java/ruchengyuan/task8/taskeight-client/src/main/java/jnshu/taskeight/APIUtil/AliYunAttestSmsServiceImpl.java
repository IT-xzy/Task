package jnshu.taskeight.APIUtil;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import jnshu.taskeight.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-11-06
 * @Time: 下午 12:41
 * Description:
 **/
public class AliYunAttestSmsServiceImpl implements AttestSmsService {

    @Autowired
    RedisUtil redisUtil;

    private static Logger logAliYunSmsSerImpl = LoggerFactory.getLogger(AliYunAttestSmsServiceImpl.class);

    /**
     * 短信API产品名称（短信产品名固定，无需修改）
     */
    final String product = "Dysmsapi";
    /**
     * 短信API产品域名（接口地址固定，无需修改）
     */
    final String domain = "dysmsapi.aliyuncs.com";

    String accessKeyId;
    String accessKeySecret;
    String timeOut ;
    String signName;
    String templateCode;
    static IClientProfile profile;
    static IAcsClient acsClient;

    public AliYunAttestSmsServiceImpl(String accessKeyId, String accessKeySecret) throws ClientException {

        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        //初始化ascClient,暂时不支持多region（请勿修改）
        profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

    }


    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }


    public void setSignName(String signName) {
        this.signName = signName;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }


    /**
     * 创建oss链接
     */
    private void inti(){

        if (acsClient != null) {
            logAliYunSmsSerImpl.info(" acsClient started ");
            return;
        }

        if (acsClient == null) {
            logAliYunSmsSerImpl.info("acsClient need start ");
            acsClient = new DefaultAcsClient(profile);
        }

    }

    /**
     * 销毁oss链接
     */
    private static void destroy() {
        if( acsClient != null){
            acsClient = null;
            logAliYunSmsSerImpl.info("acsClient destory");
        }
    }



    @Override
  public String sendVerificationSMS(String phoneNumber){
      inti();
      String message = null;
      //组装请求对象
      SendSmsRequest request = new SendSmsRequest();
      //使用post提交
      request.setMethod(MethodType.POST);
      request.setPhoneNumbers(phoneNumber);
      //必填:短信签名-可在短信控制台中找到
      request.setSignName(signName);
      //必填:短信模板-可在短信控制台中找到
      request.setTemplateCode(templateCode);
      //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
      //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败

      int random = (int)((Math.random()*9+1)*100000);
      logAliYunSmsSerImpl.info("random: " + random);
      request.setTemplateParam("{\"code\":\""+ random+ "\"}");

      try {
          //请求失败这里会抛ClientException异常
          SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
          logAliYunSmsSerImpl.info(sendSmsResponse.getCode());
          if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
              logAliYunSmsSerImpl.info("OK");
              message = String.valueOf(random);
              redisUtil.setCacheValue(phoneNumber,message,1000*60*5);
          }
      } catch (ClientException ce){
          ce.printStackTrace();
          logAliYunSmsSerImpl.error("acsClient destory");
      } catch (Exception e){
          e.printStackTrace();
          logAliYunSmsSerImpl.error("acsClient destory");
      } finally {
          destroy();
      }
      return message;
  }



  @Override
  public String getCachePhoneNumber(String phone){
      String number = null;
      try {
          number = redisUtil.getValue(phone);
          redisUtil.removeValue(phone);
      }catch (Throwable t){
          t.printStackTrace();
      }
      return number;

  }


}