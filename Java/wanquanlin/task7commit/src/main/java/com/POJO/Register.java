package com.POJO;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;
import java.io.File;
import java.io.Serializable;

/**
 * @Author: Jaime
 * @Date: 2018/4/11 22:13
 * @Description: *
 */
public class Register implements Serializable{
    @NotBlank(message="账号未输入")
    @Size(min = 6,max=15,message="账号只允许在{2}-{1}之间")
    private String account;
    @Size(min = 6,max=15,message="密码只允许在{2}-{1}之间")
    @NotBlank(message="密码未输入")
    private String password;
    @NotBlank(message="手机号码未输入")
    private String telephone;
    @NotBlank(message="邮箱未输入")
    private String email;
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "SignIn{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
