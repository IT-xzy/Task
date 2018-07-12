package com.ptt.pojo;

import java.io.Serializable;

/**
 * @ProjectName: task4
 * @Package: com.ptt.pojo
 * @ClassName: GraduateStudent
 * @Description: 毕业学生
 * @Author: Jin
 * @CreateDate: 2018/5/24 18:33
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 18:33
 * @UpdateRemark:
 * @Version: 1.0
 */
public class GraduateStudent implements Serializable{
    private static final long serialVersionUID = 1112L;
    private Integer id;
    private String name;
    private String introduction; //简介

    public GraduateStudent(){}

    public GraduateStudent(Integer id, String name, String introduction) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
    }

    @Override
    public String toString(){
        return "序号：" + id + "，姓名：" + name + "，简介：" +introduction;
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
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
