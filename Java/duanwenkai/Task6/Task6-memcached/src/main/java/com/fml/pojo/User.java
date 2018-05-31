package com.fml.pojo;


import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 我原本的想法是用户注册，注册之后想报名的话再成为学员，后来发现其实可以直接使用学员类
 */
public class User implements Serializable {

    /*用户ID*/
    private long userId;
    /*用户名*/
    @Size(min = 2, max = 8, message = "user.name.length.illegal")
    private String userName;
    /*电话*/
    @Size(min = 11, max = 11, message = "user.phone.length.illegal")
    private String phone;
    /*邮箱*/
    @Pattern(regexp = "^(.+)@(.+)$",message = "user.email.pattern.illegal")
    private String email;
    /*密码*/
    @Length(min = 6, max = 12, message = "user.password.length.illegal")
    private String password;
    /*密码盐*/
    private String salt;
    /*创建时间*/
    private long createAt;
    /*更新时间*/
    private long updateAt;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }
}
