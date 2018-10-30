package yxpTask6.pojo.ServicePojo;
//七牛云账户信息
public class QNossAccount {
    private String accessKey;
    private String secretKey;
    private String bucketName;
    private String domainOfBucket;
    private String imgType;
    private String imgLocalPath;

    @Override
    public String toString() {
        return "QNossAccount{" +
                "accessKey='" + accessKey + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", bucketName='" + bucketName + '\'' +
                ", domainOfBucket='" + domainOfBucket + '\'' +
                ", imgType='" + imgType + '\'' +
                ", imgLocalPath='" + imgLocalPath + '\'' +
                '}';
    }

    public String getImgLocalPath() {
        return imgLocalPath;
    }

    public void setImgLocalPath(String imgLocalPath) {
        this.imgLocalPath = imgLocalPath;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getDomainOfBucket() {
        return domainOfBucket;
    }

    public void setDomainOfBucket(String domainOfBucket) {
        this.domainOfBucket = domainOfBucket;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }
}
