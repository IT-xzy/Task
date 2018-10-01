package com.ptt.pojo;

import java.io.Serializable;

/**
 * @ProjectName: task4
 * @Package: com.ptt.pojo
 * @ClassName: StudyStudent
 * @Description: 在学学生
 * @Author: Jin
 * @CreateDate: 2018/5/24 19:10
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 19:10
 * @UpdateRemark:
 * @Version: 1.0
 */
public class StudyStudent implements Serializable{
    private static final long serialVersionUID = 1116L;
    private int id;
    private String name;
    public StudyStudent(){}

    public StudyStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "序号：" + id + "，姓名：" + name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
