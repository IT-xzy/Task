package com.jnshuboot.pojo.ServicePojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sms")
public class SMSAccount {
    private String accountSid;
    private String accountToken;
    private String appId;

    @Override
    public String toString() {
        return "SMSAccount{" +
                "accountSid='" + accountSid + '\'' +
                ", accountToken='" + accountToken + '\'' +
                ", appId='" + appId + '\'' +
                '}';
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountToken() {
        return accountToken;
    }

    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
