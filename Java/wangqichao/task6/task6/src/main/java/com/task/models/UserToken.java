package com.task.models;

/**
 * 只是用来接收token加密的类
 */
public class UserToken {
    private String username;
    private long loginTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public UserToken(String username, long loginTime) {
        this.username = username;
        this.loginTime = loginTime;
    }

    public UserToken() {
    }
}
