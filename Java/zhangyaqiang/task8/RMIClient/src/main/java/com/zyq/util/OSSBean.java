package com.zyq.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ossBean")
@Scope("singleton")
public class OSSBean {
    @Value("#{ossProp.endpoint}")
    private String endpoint;

    @Value("#{ossProp.accessKeyId}")
    private String accessKeyId;

    @Value("#{ossProp.accessKeySecret}")
    private String accessKeySecret;

    @Value("#{ossProp.ossBucketName}")
    private String ossBucketName;

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

    public String getOssBucketName() {
        return ossBucketName;
    }

    public void setOssBucketName(String ossBucketName) {
        this.ossBucketName = ossBucketName;
    }
}
