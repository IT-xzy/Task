package com.suger.pojo;

import org.springframework.stereotype.Component;

/**
 * @author suger
 * @date 2018/12/25 10:48
 */
@Component(value = "ossBean")
public class OssBean {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String contentype;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
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

    public String getContentype() {
        return contentype;
    }

    public void setContentype(String contentype) {
        this.contentype = contentype;
    }

    public OssBean() {
    }

    public OssBean(String endpoint, String accessKeyId, String accessKeySecret, String bucketName, String contentype) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
        this.contentype = contentype;
    }
}
