package util.aliSmsUtil;

public class AliSmsBean {
    private String product;
    private String domain;
    private String accessKeyId;
    private String accessKeySecret;
    private String SignName;
    private String TemplateCode;
    private String ConnectTimeout;
    private String ReadTimeout;

    public AliSmsBean setProduct(String product) {
        this.product = product;
        return this;
    }

    public AliSmsBean setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public AliSmsBean setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public AliSmsBean setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
        return this;
    }

    public AliSmsBean setSignName(String signName) {
        SignName = signName;
        return this;
    }

    public AliSmsBean setTemplateCode(String templateCode) {
        TemplateCode = templateCode;
        return this;
    }

    public AliSmsBean setConnectTimeout(String connectTimeout) {
        ConnectTimeout = connectTimeout;
        return this;
    }

    public AliSmsBean setReadTimeout(String readTimeout) {
        ReadTimeout = readTimeout;
        return this;
    }

    public String getProduct() {
        return product;
    }

    public String getDomain() {
        return domain;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public String getSignName() {
        return SignName;
    }

    public String getTemplateCode() {
        return TemplateCode;
    }

    public String getConnectTimeout() {
        return ConnectTimeout;
    }

    public String getReadTimeout() {
        return ReadTimeout;
    }
}
