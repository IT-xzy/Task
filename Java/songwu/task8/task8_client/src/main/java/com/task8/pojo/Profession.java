package com.task8.pojo;

import java.io.Serializable;

public class Profession implements Serializable {
    private static final long serialVersionUID = 4603642343377807741L;
    private int id;
    //    图片
    private String picture;
    //    修真类型
    private String type;
    //    职业介绍
    private String introduction;
    //    门槛
    private int threshold;
    //    难易程度
    private int difficulty;
    //    成长周期
    private String growthCycle;
    //    稀缺程度
    private String scarcity;
    //    不同年限对应薪资（1,2,3）
    private String salary1;
    private String salary2;
    private String salary3;
    //    学习人数
    private int number;
    //    找到工作人数
    private int worker;
    //    职业提示
    private String hint;
    //    工作内容
    private String jobDuties;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle;
    }

    public String getScarcity() {
        return scarcity;
    }

    public void setScarcity(String scarcity) {
        this.scarcity = scarcity;
    }

    public String getSalary1() {
        return salary1;
    }

    public void setSalary1(String salary1) {
        this.salary1 = salary1;
    }

    public String getSalary2() {
        return salary2;
    }

    public void setSalary2(String salary2) {
        this.salary2 = salary2;
    }

    public String getSalary3() {
        return salary3;
    }

    public void setSalary3(String salary3) {
        this.salary3 = salary3;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWorker() {
        return worker;
    }

    public void setWorker(int worker) {
        this.worker = worker;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getJobDuties() {
        return jobDuties;
    }

    public void setJobDuties(String jobDuties) {
        this.jobDuties = jobDuties;
    }


    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", type='" + type + '\'' +
                ", introduction='" + introduction + '\'' +
                ", threshold=" + threshold +
                ", difficulty=" + difficulty +
                ", growthCycle='" + growthCycle + '\'' +
                ", scarcity='" + scarcity + '\'' +
                ", salary1='" + salary1 + '\'' +
                ", salary2='" + salary2 + '\'' +
                ", salary3='" + salary3 + '\'' +
                ", number=" + number +
                ", hint='" + hint + '\'' +
                ", jobDuties='" + jobDuties + '\'' +'\n'+
                '}';
    }
}
