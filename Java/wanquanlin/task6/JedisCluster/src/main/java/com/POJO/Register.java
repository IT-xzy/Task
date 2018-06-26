package com.POJO;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: Jaime
 * @Date: 2018/4/11 22:13
 * @Description: *
 */
public class Register implements Serializable{
    @NotBlank(message="is required")
    @Size(min = 6,max=15,message="账号只允许在{2}-{1}之间")
    private String account;
    @Size(min = 6,max=15,message="密码只允许在{2}-{1}之间")
    @NotBlank(message="is required")
    private String password;

    private String email;
    private String nickname;
    private String salt;
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

    @Override
    public String toString() {
        return "SignIn{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
