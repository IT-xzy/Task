package com.zyq.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sendCloudBean")
@Scope("singleton")
public class SendCloudBean {

    @Value("#{sendCloudProp.url}")
    private String url;

    @Value("#{sendCloudProp.apiUser}")
    private String apiUser;

    @Value("#{sendCloudProp.apiKey}")
    private String apiKey;

    @Value("#{sendCloudProp.from}")
    private String from;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiUser() {
        return apiUser;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

}
