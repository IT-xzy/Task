package com.tools;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
public class AliEmail {

    //可配置属性profile
    private String accessKeyId;// = "LTAIFC5CQPjC7oGp";
    private String accessKeySecret;// = "0uN3YRhGjyALDiM5yKxMIzlgVNfRnw";
    private String regionId; //"cn-hangzhou"
    //可配置属性 request
    private String accountName; //"my@xx.xxqtx.com"
    private String fromAlias;//"个人邮箱测试"
    private int addressType; //1
    private String tagName;//"check1"
    private boolean replyToAddress;//ture
    private String subject;//"邮件主题"

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getFromAlias() {
        return fromAlias;
    }

    public void setFromAlias(String fromAlias) {
        this.fromAlias = fromAlias;
    }

    public int getAddressType() {
        return addressType;
    }

    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public boolean isReplyToAddress() {
        return replyToAddress;
    }

    public void setReplyToAddress(boolean replyToAddress) {
        this.replyToAddress = replyToAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public  void sample(String EmailAddress , String secureCode) {
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            request.setAccountName(accountName);
            request.setFromAlias(fromAlias);
            request.setAddressType(addressType);
            request.setTagName(tagName);
            request.setReplyToAddress(replyToAddress);
            request.setToAddress(EmailAddress);
            request.setSubject(subject);
            request.setHtmlBody("您好，您的验证码是："+secureCode+"，请妥善保管，打死不要告诉小三");
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
