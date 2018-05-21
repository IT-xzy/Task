//需要建表，建表语句：
/*create table if not exists`tb_user`(
`user_name` varchar(20) not null,
`user_key` varchar(50) not null,
`cellphone` varchar(15),
`mail` varchar(60),
`student_id` bigint,
`id` bigint auto_increment,
`create_at` bigint not null,
`update_at` bigint,
`login_at` bigint,
primary key(`id`),
unique `un_name`(`user_name`),
unique `un_phone`(`cellphone`),
unique `un_mail`(`mail`)
)engine = innodb default charset = utf8;*/
package com.ptteng.pojo.model;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    //密码长度是加密前的长度
    private String userKey;
    private String cellphone;
    private String mail;
    private Long StudentId;
    private Student student;
    private Long loginAt;
    private Long createAt;
    private Long updateAt;
    private Long id;

    public User(String userName, String userKey, String cellphone, String mail) {
        this.userName = userName;
        this.userKey = userKey;
        this.cellphone = cellphone;
        this.mail = mail;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getStudentId() {
        return StudentId;
    }

    public void setStudentId(Long studentId) {
        StudentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Long loginAt) {
        this.loginAt = loginAt;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userKey='" + userKey + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", mail='" + mail + '\'' +
                ", StudentId=" + StudentId +
                ", student=" + student +
                ", loginAt=" + loginAt +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", id=" + id +
                '}';
    }
}
