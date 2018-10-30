package com.jnshutask.pojo.servicePojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mail")
public class MailSLAccount {
    private String apiUser;
    private String apiKey;
    private String rcpt_to;
    private String from;
    private String fromName;


}
