package pojo;

/**
 * 短信发送模板
 * 必填项属性
 */
public class ShortMessage {
    private String product ; //阿里默认参数
    private String domain; //阿里默认参数
    private String accessKeyId ;  //个人的accessKeyId
    private String accessKeySecret;   //个人的accessKeySecret
    private String templateCode;  //个人的短信模板代码 SMS_12233
    private String signName;  //短信签名
    private String clientName; //客户姓名
    private String verifiedCode ;  //短信验证码
    private String phoneNumber;  //客户手机号

    @Override
    public String toString() {
        return "ShortMessage{" +
                "product='" + product + '\'' +
                ", domain='" + domain + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", templateCode='" + templateCode + '\'' +
                ", signName='" + signName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", verifiedCode='" + verifiedCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

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

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVerifiedCode() {
        return verifiedCode;
    }

    public void setVerifiedCode(String verifiedCode) {
        this.verifiedCode = verifiedCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
