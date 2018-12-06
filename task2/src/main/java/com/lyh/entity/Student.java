package com.lyh.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class Student {
//    参数校验注释
//@NotNull用于基本数据类型
//@NotBlank用于String类型
    @NotNull(message = "id不能为空")
    private Long id;
    @NotNull(message = "学号不能为空")
    private Long studentNumber;
    @NotBlank(message = "名字不能为空")
    private String name;
    @NotBlank(message = "qq不能为空")
    private String qq;
    @NotNull(message = "入学时间不能为空")
    private String wish;
    @NotBlank(message = "毕业院校不能为空")
    private String school;
    @NotNull(message = "入学时间不能为空")
    private String enrolmentTime;
    @NotBlank(message = "职业方向不能为空")
    private String type;
    @NotBlank(message = "了解渠道不能为空")
    private String knowFrom;
    @NotNull(message = "创建时间不能为空")
    private Long createAt;
    @NotNull(message = "更新时间不能为空")
    private Long updateAt;
    public Student(){}
    public Student(Long id,Long studentNumber,String name,String qq,String wish,String school,String enrolmentTime,String type,String knowFrom,Long createAt,Long updateAt){
        this.id = id;
        this.studentNumber = studentNumber;
        this.name = name;
        this.qq = qq;
        this.wish = wish;
        this.school = school;
        this.enrolmentTime = enrolmentTime;
        this.type = type;
        this.knowFrom = knowFrom;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEnrolmentTime() {
        return enrolmentTime;
    }

    public void setEnrolmentTime(String enrolmentTime) {
        this.enrolmentTime = enrolmentTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String knowFrom) {
        this.knowFrom = knowFrom;
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

    @Override
    public String toString() {
        return "student[id = "+id+",studentNumber = "+studentNumber+",name = "+name+",qq = "+qq+",wish = "+wish+",school = "+school+",enrolmentTime = "+enrolmentTime+"," +
                "type = "+type+",knowFrom = "+knowFrom+",createAt = "+createAt+",updateAt = "+updateAt+"]";
    }
}
