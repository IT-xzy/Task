package com.jns.entity;

import org.springframework.beans.factory.annotation.Value;

public class Oss {

    @Value("${oss.bucketName}")
    private String bucketName;//存储桶名称

    @Value("${oss.accessKeyId}")
    private String accessKeyId;//腾讯云API秘钥ID

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;//腾讯云API秘钥值

    @Value("${oss.endpoint}")
    private String endpoint;//所属地域


    @Value("${oss.folder}")
    private String folder;//存储imgage文件夹下

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }


    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
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

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
