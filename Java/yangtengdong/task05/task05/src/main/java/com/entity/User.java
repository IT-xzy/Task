package com.entity;

import com.checkGroups.LoginGroup;
import com.checkGroups.RegisterGroup;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {

    private Long id;

    @Length(min = 2 ,max = 8 , message = "{user.name.length.illegal}",
            groups = {RegisterGroup.class,LoginGroup.class})
    @NotNull(message = "{user.name.null}",groups ={RegisterGroup.class,LoginGroup.class})
    private String name;

    @NotNull(message = "{user.password.null}",groups ={RegisterGroup.class,LoginGroup.class})
    /*正则表达式验证 长度8-16位，必须包含数字字母特殊符号;特殊 字符 为~!@#$%^&*其中之一*/
   /* @Pattern(regexp = "/(?=.*[a-z])(?=.*\\d)(?=.*[#@!~%^&*])[a-z\\d#@!~%^&*]{8,16}/i",
            message = "{user.password.error}", groups ={RegisterGroup.class,LoginGroup.class})*/
    private String password;

    /*邮箱正则表达式只允许英文字母、数字、下划线、英文句号、以及中划线组成*/
    @Email(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "{user.email.error}",
            groups ={RegisterGroup.class})
    @NotNull(message = "{user.email.null}",groups ={RegisterGroup.class})
    private String email;

    private Long create_time;
    private String token;

    public User() {
    }

    public User(String name, String password, String email, Long create_time, String token) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.create_time = create_time;
        this.token = token;
    }

    @Override
    public String toString() {
        return "用户信息{" +
                "id=" + id +
                ", 用户名='" + name + '\'' +
                ", 密码='" + password + '\'' +
                ", 邮箱='" + email + '\'' +
                ", 注册时间=" + create_time +'\'' +
                ",token验证=" + token +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
