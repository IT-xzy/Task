//无需建表
package com.ptteng.pojo.model;

import java.io.Serializable;

public class Login implements Serializable {
    //登录时候用户提交的账号信息
    private String definition;
    //登录时候用户提交的密码信息
    private String key;
    //目前三种登录方式 userName mail cellphone
    private String type;
    //绑定ip的登录方式
    private String ip;

    public Login() {
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Login{" +
                "definition='" + definition + '\'' +
                ", key='" + key + '\'' +
                ", type='" + type + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
