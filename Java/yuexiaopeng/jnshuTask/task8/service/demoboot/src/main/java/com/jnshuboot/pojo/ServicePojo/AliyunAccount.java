package com.jnshuboot.pojo.ServicePojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aliyun")
public class AliyunAccount {
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String endPoint;

    @Override
    public String toString() {
        return "AliyunAccount{" +
                "accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", bucketName='" + bucketName + '\'' +
                '}';
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
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

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
