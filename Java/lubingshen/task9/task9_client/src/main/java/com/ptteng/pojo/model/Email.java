//无需建表
package com.ptteng.pojo.model;

import java.io.Serializable;

public class Email implements Serializable {
    private String name;
    private String key;
    private String mailbox;
    private String ip;

    public Email() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Email{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
