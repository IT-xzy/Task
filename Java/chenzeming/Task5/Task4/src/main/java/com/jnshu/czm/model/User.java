package com.jnshu.czm.model;

public class User {


    private Integer id;

    private String job;

    private String introduce;

    private int door;

    private int easy;

    private int cycle;

    private int company_num;

    private String salary1;

    private String salary2;

    private String salary3;

    private int learn_num;

    private String prompt;

    private String  photo;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public int getEasy() {
        return easy;
    }

    public void setEasy(int easy) {
        this.easy = easy;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public int getCompany_num() {
        return company_num;
    }

    public void setCompany_num(int company_num) {
        this.company_num = company_num;
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

    public int getLearn_num() {
        return learn_num;
    }

    public void setLearn_num(int learn_num) {
        this.learn_num = learn_num;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", job='" + job + '\'' +
                ", introduce='" + introduce + '\'' +
                ", door=" + door +
                ", easy=" + easy +
                ", cycle=" + cycle +
                ", company_num=" + company_num +
                ", salary1='" + salary1 + '\'' +
                ", salary2='" + salary2 + '\'' +
                ", salary3='" + salary3 + '\'' +
                ", learn_num=" + learn_num +
                ", prompt='" + prompt + '\'' +
                '}';
    }

}