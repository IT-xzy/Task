package util.ossUtil;

public class OssBean {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String contentype;

    public String getEndpoint() {
        return endpoint;
    }

    public OssBean setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public OssBean setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public OssBean setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
        return this;
    }

    public String getBucketName() {
        return bucketName;
    }

    public OssBean setBucketName(String bucketName) {
        this.bucketName = bucketName;
        return this;
    }

    public String getContentype() {
        return contentype;
    }

    public OssBean setContentype(String contentype) {
        this.contentype = contentype;
        return this;
    }
}
