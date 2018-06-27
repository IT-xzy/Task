package com.ptt.pojo;

import com.ptt.dao.ILoginGroup;
import com.ptt.dao.IRegisterGroup;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class User {
    private Long id;
    @Size(min = 3, max = 20, message = "用户名长度错误", groups = {ILoginGroup.class, IRegisterGroup.class})
    @NotBlank(message = "{user.name.blank.error}", groups = {ILoginGroup.class, IRegisterGroup.class})
    private String name;
    @Size(min = 6, max = 20, message = "{user.password.length.error}", groups = {ILoginGroup.class, IRegisterGroup.class})
    @NotBlank(message = "{user.password.blank.error}", groups = {ILoginGroup.class, IRegisterGroup.class})
    private String password;
    @Email(message = "{user.email.error}", groups = IRegisterGroup.class)
    @NotBlank(message = "{user.email.blank.error}", groups = IRegisterGroup.class)
    private String email;
    private Long createAt;

    public User(Long id, String name, String password, String email, Long createAt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.createAt = createAt;
    }

    public User() {
        super();
    }

    public String toString() {
        return "name:" + name + ",password:" + password + ",email:" + email + ",createAt:" + createAt;
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
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }
}