package com.model;


import com.validator.Register;
import com.validator.Update;
import com.validator.Verify;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

//@Null 被注释的元素必须为 null
//@NotNull 被注释的元素必须不为 null
//@AssertTrue 被注释的元素必须为 true
//@AssertFalse 被注释的元素必须为 false
//@Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
//@Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
//@DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
//@DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
//@Size(max=, min=) 被注释的元素的大小必须在指定的范围内
//@Digits (integer, fraction) 被注释的元素必须是一个数字，其值必须在可接受的范围内
//@Past 被注释的元素必须是一个过去的日期
//@Future 被注释的元素必须是一个将来的日期
//@Pattern(regex=,flag=) 被注释的元素必须符合指定的正则表达式
//
//        Hibernate Validator 附加的 constraint
//@NotBlank(message =) 验证字符串非null，且长度必须大于0
//@Email 被注释的元素必须是电子邮箱地址
//@Length(min=,max=) 被注释的字符串的大小必须在指定的范围内
//@NotEmpty 被注释的字符串的必须非空
//@Range(min=,max=,message=) 被注释的元素必须在合适的范围内

@Repository
public class Student implements Serializable {

    private Integer id;
    private String name;
    private Integer score = 0;   //0分
    private Integer status = 0;  //0在学，1工作
    private Integer classId = 1; //1前端，2后端，3PM
    private Date createTime;
    private Date updateTime;

    @NotBlank(groups = {Register.class})
    @Size(min = 6, max = 20,message = "用户名必须在6和20之间",groups = {Register.class})
    private String userName;

    @NotBlank(groups = {Register.class})
    @Size(min = 6, max = 20,message = "密码必须在6和20之间",groups = {Register.class})
    private String passWord;
    //默认的头像图片名
    private String headPicture = "default.png";
    private Integer accountStatus= 0;  //0未激活，1激活

    @NotBlank(groups = {Register.class})
    @Email(message = "邮箱地址不正确",groups = {Register.class})
    private String email;
    private String emailCode;

    @NotBlank(groups = {Register.class, Update.class, Verify.class})
    @Pattern(regexp="[1-9][0-9]{10}",message = "请填写正确手机号",groups = {Register.class, Update.class, Verify.class})
    private String phoneNumber;

    @NotBlank(groups = {Update.class})
    @Pattern(regexp="[1-9][0-9]{5,10}",message = "请输入正确的qq号",groups = {Update.class})
    private String qq;



    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public Integer getAcountStatus() {
        return accountStatus;
    }

    public void setAcountStatus(Integer acountStatus) {
        this.accountStatus = acountStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", status=" + status +
                ", classId=" + classId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", headPicture='" + headPicture + '\'' +
                ", acountStatus=" + accountStatus +
                ", email='" + email + '\'' +
                ", emailCode=" + emailCode +
                ", phoneNumber=" + phoneNumber +
                ", qq=" + qq +
                '}';
    }
}