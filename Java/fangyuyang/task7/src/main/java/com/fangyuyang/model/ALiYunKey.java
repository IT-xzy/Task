package com.fangyuyang.model;

import org.springframework.beans.factory.annotation.Required;

public class ALiYunKey {
    private String accessKeyId;
    private String accessKeySecret;

    public String getAccessKeySecret() {
        return accessKeySecret;
    }
   @Required
    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }
    @Required
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }
}
