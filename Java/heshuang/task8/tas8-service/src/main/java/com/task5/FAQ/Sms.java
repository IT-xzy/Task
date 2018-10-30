package com.task5.FAQ;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("sms")
public class Sms {

    @Value("#{SDKSMS.serverIP}")
    private String serverIP;

    @Value("#{SDKSMS.accountSid}")
    private String accountSid;

    @Value("#{SDKSMS.accountToken}")
    private String accountToken;

    @Value("#{SDKSMS.APPID}")
    private String APPID;

    @Value("#{SDKSMS.templateId}")
    private String templateId;

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
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

    public String getAPPID() {
        return APPID;
    }

    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
