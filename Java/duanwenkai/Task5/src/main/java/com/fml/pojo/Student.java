package com.fml.pojo;

public class Student {
    /**学员ID*/
    private int stu_id;
    /**创建时间*/
    private long create_at;
    /**更新时间*/
    private long update_at;
    /**学员姓名*/
    private String stu_name;
    /**学员邮箱*/
    private String email;
    /**登录密码*/
    private String password;
    /***/
    private String salt;
    /**课程类型*/
    private int lesson_type;
    /**学员状态  1：正在学习 2：正找工作 3：找到工作 4：业界大牛*/
    private int stu_status;
    /**学员公司*/
    private String company;
    /**学员职位*/
    private String post;
    /**学员描述*/
    private String description;

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
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

    public int getLesson_type() {
        return lesson_type;
    }

    public void setLesson_type(int lesson_type) {
        this.lesson_type = lesson_type;
    }

    public int getStu_status() {
        return stu_status;
    }

    public void setStu_status(int stu_status) {
        this.stu_status = stu_status;
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
}
