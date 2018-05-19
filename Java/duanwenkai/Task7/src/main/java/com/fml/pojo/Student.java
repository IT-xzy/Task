package com.fml.pojo;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 400236880053504623L;
    /**学员ID*/
    private long stuId;
    /**用户名*/
    @Size(min = 2, max = 8, message = "user.name.length.illegal")
    private String userName;
    /**邮箱*/
    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",message = "user.email.pattern.illegal")
    private String email;
    /**邮箱是否绑定 0未验证 1已验证*/
    private int emailStatus;
    /**手机*/
    @Pattern(regexp = "^[1][3578]\\d{9}$" , message = "user.phone.illegal")
    private String phone;
    /**密码*/
    @Length(min = 6, max = 12, message = "user.password.length.illegal")
    private String password;
    /**盐*/
    private String salt;
    /**课程类型*/
    private int lessonType;
    /**学员状态  1：正在学习 2：正找工作 3：找到工作 4：业界大牛*/
    private int stuStatus;
    /**头像*/
    private String photo;
    /**学员公司*/
    private String company;
    /**学员职位*/
    private String post;
    /**学员描述*/
    private String description;
    /**创建时间*/
    private long createAt;
    /**更新时间*/
    private long updateAt;

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(int emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getLessonType() {
        return lessonType;
    }

    public void setLessonType(int lessonType) {
        this.lessonType = lessonType;
    }

    public int getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(int stuStatus) {
        this.stuStatus = stuStatus;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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


    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", emailStatus=" + emailStatus +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", lessonType=" + lessonType +
                ", stuStatus=" + stuStatus +
                ", photo='" + photo + '\'' +
                ", company='" + company + '\'' +
                ", post='" + post + '\'' +
                ", description='" + description + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
