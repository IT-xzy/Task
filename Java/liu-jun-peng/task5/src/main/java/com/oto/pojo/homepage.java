package com.oto.pojo;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/5 下午5:25
 */

public class homepage {
    private Integer id;
    private String student;//优秀学员
    private String duty;//职务

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
