package com.Task.one.model;

public class Student {

    private int Id;
    private String Name;
    private String Sex;
    private String QQ;
    private String Graduate;
    private String Number;
    private String AutoGraph;
    private String CreateTime;
    private String UpdateTime;

    public Student() {
        super();
    }

    public Student(int Id, String Name, String Sex, String QQ, String Graduate, String Number, String AutoGraph, String CreateTime, String UpdateTime) {
        super();
        this.Id = Id;
        this.Name = Name;
        this.Sex = Sex;
        this.Graduate = Graduate;
        this.Number = Number;
        this.AutoGraph = AutoGraph;
        this.CreateTime = CreateTime;
        this.UpdateTime = UpdateTime;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getGraduate() {
        return Graduate;
    }

    public void setGraduate(String graduate) {
        Graduate = graduate;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getAutoGraph() {
        return AutoGraph;
    }

    public void setAutoGraph(String autoGraph) {
        AutoGraph = autoGraph;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
              "Id=" + Id +
              ", Name='" + Name + '\'' +
              ", Sex='" + Sex + '\'' +
              ", QQ='" + QQ + '\'' +
              ", Graduate='" + Graduate + '\'' +
              ", Number='" + Number + '\'' +
              ", AutoGraph='" + AutoGraph + '\'' +
              ", CreateTime=" + CreateTime +
              ", UpdateTime=" + UpdateTime +
              '}';
    }
}

