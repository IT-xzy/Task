package com.zyq.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cosBean")
@Scope("singleton")
public class COSBean {
    @Value("#{cosProp.cosBucketName}")
    private String cosBucketName;

    @Value("#{cosProp.secretId}")
    private String secretId;

    @Value("#{cosProp.secretKey}")
    private String secretKey;

    @Value("#{cosProp.reginName}")
    private String reginName;

    public String getCosBucketName() {
        return cosBucketName;
    }

    public void setCosBucketName(String cosBucketName) {
        this.cosBucketName = cosBucketName;
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

    public String getReginName() {
        return reginName;
    }

    public void setReginName(String reginName) {
        this.reginName = reginName;
    }
}
