package com.jnshu.task7.beans.api;

import org.springframework.stereotype.Component;

@Component
public class MailParams {
    private String apiUser;
    private String apiKey;
    private String from;
    private String fromName;
    private String templateInvokeName;
    private String subject;
    private String url;
    /**
     * 验证路径,其后需要加入token验证参数
     */
    private String toUrl;

    public String getToUrl() {
        return toUrl;
    }

    public void setToUrl(String toUrl) {
        this.toUrl = toUrl;
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

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getTemplateInvokeName() {
        return templateInvokeName;
    }

    public void setTemplateInvokeName(String templateInvokeName) {
        this.templateInvokeName = templateInvokeName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
