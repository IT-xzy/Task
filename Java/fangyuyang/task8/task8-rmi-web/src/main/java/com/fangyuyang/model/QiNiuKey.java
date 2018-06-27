package com.fangyuyang.model;

import java.io.Serializable;

public class QiNiuKey implements Serializable {
    private String accessKeyId;
    private String accessKeySecret;

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }
}
