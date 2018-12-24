package jnshu.tool.api;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.log4j.Logger;

public class Email {
    private static Logger logger = Logger.getLogger (Email.class);
//

    private   String accessKeyId ;

    private   String accessKeySecret ;
    private   String regionId;

    private   String accountName ;//控制台创建的发信地址

    private   String tagName ;//控制台创建的标签

    private  String fromAlias ; //发信人昵称

    private  String subject;//邮件主题

    /**
     * 阿里云邮件服务
     * @param code  验证码
     * @param email  注册的邮箱
     */
    public  int sample(String code,String email) {

        int rs=0;
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。

        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName(accountName);
            request.setFromAlias(fromAlias);
            request.setAddressType(1);
            request.setTagName(tagName);
            request.setReplyToAddress(true);
//            目标地址
            request.setToAddress(email);
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("邮箱1,邮箱2");
            request.setSubject(subject);
//            要发送的内容
            request.setHtmlBody(code);

            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            logger.info ("邮件发送成功");
            rs=1;
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setFromAlias(String fromAlias) {
        this.fromAlias = fromAlias;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
