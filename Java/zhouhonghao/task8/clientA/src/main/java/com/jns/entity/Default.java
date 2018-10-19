package com.jns.entity;

import org.springframework.beans.factory.annotation.Value;

public class Default {

    @Value("${user.url}")
    private String url;
    @Value("${user.sign}")
    private String sign;
    @Value("${user.name}")
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
