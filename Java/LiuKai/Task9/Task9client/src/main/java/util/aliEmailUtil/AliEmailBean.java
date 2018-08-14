package util.aliEmailUtil;

public class AliEmailBean {
    private String accessKeyId;
    private String accessKeySecret;
    private String accountName;
    private String fromAlias;
    private String tagName;
    private String subject;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public AliEmailBean setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public AliEmailBean setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public AliEmailBean setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getFromAlias() {
        return fromAlias;
    }

    public AliEmailBean setFromAlias(String fromAlias) {
        this.fromAlias = fromAlias;
        return this;
    }

    public String getTagName() {
        return tagName;
    }

    public AliEmailBean setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public AliEmailBean setSubject(String subject) {
        this.subject = subject;
        return this;
    }
}
