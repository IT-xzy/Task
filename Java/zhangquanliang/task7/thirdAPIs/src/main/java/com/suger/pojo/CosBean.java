package com.suger.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author suger
 * @date 2018/12/16 16:26
 */
@Component("cosBean")
@Scope("singleton")
public class CosBean {

    @Value("#{cos.cosBucketName}")
    private String cosBucketName;

    @Value("#{cos.secretId}")
    private String secretId;

    @Value("#{cos.secretKey}")
    private String secretKey;

    @Value("#{cos.regionName}")
    private  String regionName;

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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String reginName) {
        this.regionName = regionName;
    }
}
