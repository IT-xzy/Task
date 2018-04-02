package jnshu.taskeight.APIUtil;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
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
 * @date: 2017-11-07
 * @Time: 下午 3:08
 * Description:
 **/
public class AliYunEmailServiceImpl implements EmailService{

    private static Logger logAliEmaSerUtil = LoggerFactory.getLogger(AliYunEmailServiceImpl.class);

    @Autowired
    RedisUtil redisUtil;


    String accessKeyId;
    String accessKeySecret;
    String accountName;
    String fromAlias;

    IClientProfile profile;
    IAcsClient iAcsClient;

    public AliYunEmailServiceImpl(String accessKeyId, String accessKeySecret) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
    }


    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setFromAlias(String fromAlias) {
        this.fromAlias = fromAlias;
    }



    /**
     * 创建 邮箱 链接
     */
    private void inti(){

        if (iAcsClient != null) {
            logAliEmaSerUtil.info(" iAcsClient started ");
            return;
        }

        if (iAcsClient == null) {
            logAliEmaSerUtil.info("iAcsClient need start ");
            iAcsClient = new DefaultAcsClient(profile);
        }

    }

    /**
     * 销毁 iAcsClient 链接
     */
    private void destroy() {
        if(iAcsClient != null){
            iAcsClient = null;
            logAliEmaSerUtil.info("iAcsClient destory");
        }
    }

    @Override
    public String verificationEmail(String toAddress,String user){
        inti();

        String tagName = null;
        String subject = null;
        String htmlBody = null;
        String message = null;
        SingleSendMailResponse httpResponse = null;
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            int random = (int)((Math.random()*9+1)*100000);
            tagName = "rcy9527";
            subject = "rcy9527.top的邮箱验证";
            htmlBody = "亲爱的 "+ user + "， 你好:" + "感谢您在rcy9527.top进行邮箱绑定<br>" +
                    "<br>" +
                    "您的验证码为： " + random +" 请勿泄露！" +
                    "本邮件是系统自动发送的，请勿直接回复！感谢您的访问，祝您使用愉快！";
            request.setAccountName(accountName);
            request.setFromAlias(fromAlias);
            request.setAddressType(1);
            request.setTagName(tagName);
            request.setReplyToAddress(true);
            request.setToAddress(toAddress);
            request.setSubject(subject);
            request.setHtmlBody(htmlBody);
            request.setTextBody(htmlBody);
            httpResponse = iAcsClient.getAcsResponse(request);
            message = String.valueOf(random);
            redisUtil.setCacheValue(toAddress,message,1000*60*5);
            logAliEmaSerUtil.info("返回信息 httpResponse： "+ httpResponse.getRequestId());
        }catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return message;
    }


    @Override
    public String getCacheEmailNumber(String email){
        String number = null;
        try {
            number = redisUtil.getValue(email);
            redisUtil.removeValue(email);
        }catch (Throwable t){
            t.printStackTrace();
        }
        return number;

    }



}

