package com.zyq.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("telBean")
@Scope("singleton")
public class TelBean {
    @Value("#{telProp.serverIp}")
    private String serverIp;

    @Value("#{telProp.serverPort}")
    private String serverPort;

    @Value("#{telProp.accountSid}")
    private String accountSid;

    @Value("#{telProp.accountToken}")
    private String accountToken;

    @Value("#{telProp.appId}")
    private String appId;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
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
