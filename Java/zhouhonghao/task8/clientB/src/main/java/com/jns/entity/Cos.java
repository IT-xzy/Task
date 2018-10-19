package com.jns.entity;

import org.springframework.beans.factory.annotation.Value;

public class Cos {
    @Value("${cos.bucketName}")
    private String bucketName;//存储桶名称

    @Value("${cos.secretId}")
    private String secretId;//腾讯云API秘钥ID

    @Value("${cos.secretKey}")
    private String secretKey;//腾讯云API秘钥值

    @Value("${cos.region}")
    private String region;//所属地域

    @Value("${cos.appId}")
    private String appId;//APPID

    @Value("${cos.folder}")
    private String folder;//存储imgage文件夹下

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
