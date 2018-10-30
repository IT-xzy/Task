package com.task5.FAQ;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cos")
public class Cos {
    @Value("#{COSP.bucketName}")
    private String bucketName;

    @Value("#{COSP.secretId}")
    private String secretId;

    @Value("#{COSP.secretKey}")
    private String secretKey;

    @Value("#{COSP.region}")
    private String region;

    @Value("#{COSP.appId}")
    private String appId;

    @Value("#{COSP.folder}")
    private String folder;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
