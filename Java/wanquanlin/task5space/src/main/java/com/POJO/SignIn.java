package com.POJO;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author: Jaime
 * @Date: 2018/4/11 22:13
 * @Description: *
 */
public class SignIn {
    private Long ID;
    @NotBlank(message="is required")
    @Size(min = 6,max=15,message="账号只允许在{2}-{1}之间")
    private String account;
    @Size(min = 6,max=15,message="密码只允许在{2}-{1}之间")
    @NotBlank(message="is required")
    private String password;
    private String salt;
    private String des;

    public void setAccount(String account) {
        this.account = account;
    }
    public String getAccount() {
        return account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "SignIn{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
