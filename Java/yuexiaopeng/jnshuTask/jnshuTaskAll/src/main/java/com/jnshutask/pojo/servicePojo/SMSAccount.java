package com.jnshutask.pojo.servicePojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "sms")
public class SMSAccount {
    private String accountSid;
    private String accountToken;
    private String appId;


}
