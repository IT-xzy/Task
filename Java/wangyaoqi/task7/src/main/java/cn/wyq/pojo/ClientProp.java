package cn.wyq.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class ClientProp {
//    @Value("#{prop['endpoint']}")
    public String endpoint;

//    @Value("#{prop['accessKeyId']}")
    private String accessKeyId;

//    @Value("#{prop['accessKeySecret']}")
    private String accessKeySecret;

//    @Value("#{prop['bucketName']}")
    private String bucketName;

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

}
