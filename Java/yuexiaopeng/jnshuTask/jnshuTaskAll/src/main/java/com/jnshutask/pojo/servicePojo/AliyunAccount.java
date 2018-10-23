package com.jnshutask.pojo.servicePojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun")
public class AliyunAccount {
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String endPoint;

}
