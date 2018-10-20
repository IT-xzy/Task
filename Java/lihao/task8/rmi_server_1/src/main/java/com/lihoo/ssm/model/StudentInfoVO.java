package com.lihoo.ssm.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * #Title: StudentInfoVO
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/4-15:08
 */

@Component
public class StudentInfoVO implements Serializable {
    private static final long serialVersionUID = 1079L;

    private Long id;

    private String username;

    private String salt;

    private String pwd;

    private Long logAt;

    private Long expireAt;

    public StudentInfoVO() {
    }

    public StudentInfoVO(Long id, String username, String salt, String pwd, Long logAt, Long expireAt) {
        this.id = id;
        this.username = username;
        this.salt = salt;
        this.pwd = pwd;
        this.logAt = logAt;
        this.expireAt = expireAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getLogAt() {
        return logAt;
    }

    public void setLogAt(Long logAt) {
        this.logAt = logAt;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

    @Override
    public String toString() {
        return "StudentInfoVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salt='" + salt + '\'' +
                ", pwd='" + pwd + '\'' +
                ", logAt=" + logAt +
                ", expireAt=" + expireAt +
                '}';
    }
}
