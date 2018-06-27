package com.jnshu.model;

import java.io.Serializable;

/**
 * @program: smsdemo
 * @description: 综合类
 * @author: Mr.xweiba
 * @create: 2018-05-29 23:16
 **/

public class StudentQV implements Serializable{
    private static final long serialVersionUID = -2830902165464284179L;
    private Student student;
    private StudentCustom studentCustom;

    @Override
    public String toString() {
        return "StrudentQV{" +
                "student=" + student +
                ", studentCustom=" + studentCustom +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentCustom getStudentCustom() {
        return studentCustom;
    }

    public void setStudentCustom(StudentCustom studentCustom) {
        this.studentCustom = studentCustom;
    }
}
