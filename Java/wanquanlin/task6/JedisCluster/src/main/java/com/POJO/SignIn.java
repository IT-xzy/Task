package com.POJO;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: Jaime
 * @Date: 2018/4/11 22:13
 * @Description: *
 */
public class SignIn implements Serializable{
    private static final long serialVersionUID = -1267719235225203410L;
    @JSONField(name = "ID")
    private Long sign_id;
    @NotBlank(message="is required")
    @Size(min = 6,max=15,message="账号只允许在{2}-{1}之间")
    private String account;
    @Size(min = 6,max=15,message="密码只允许在{2}-{1}之间")
    @NotBlank(message="is required")
    private String password;


    public Long getSign_id() {
        return sign_id;
    }

    public void setSign_id(Long sign_id) {
        this.sign_id = sign_id;
    }

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
