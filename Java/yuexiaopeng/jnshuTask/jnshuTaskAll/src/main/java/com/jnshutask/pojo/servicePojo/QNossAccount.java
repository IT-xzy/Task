package com.jnshutask.pojo.servicePojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//七牛云账户信息
@Data
@Component
@ConfigurationProperties(prefix = "qniuoss")
public class QNossAccount {
    private String accessKey;
    private String secretKey;
    private String bucketName;
    private String domainOfBucket;
    private String imgType;
    private String imgLocalPath;

}
