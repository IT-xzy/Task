package com.longhang.model;

public class Curriculum {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public String getWages1() {
        return wages1;
    }

    public void setWages1(String wages1) {
        this.wages1 = wages1;
    }

    public String getWages2() {
        return wages2;
    }

    public void setWages2(String wages2) {
        this.wages2 = wages2;
    }

    public String getWages3() {
        return wages3;
    }

    public void setWages3(String wages3) {
        this.wages3 = wages3;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    public int getOnnum() {
        return onnum;
    }

    public void setOnnum(int onnum) {
        this.onnum = onnum;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Curriculum(){}
    public Curriculum(int onnum,String name){
        this.onnum=onnum;
        this.id=id;
    }

    public Curriculum(Long id, String picture,String name, String introduce, int threshold, int difficulty, String cycle, int demand, String wages1, String wages2, String wages3, String prompt,int onnum) {
        this.id = id;
        this.picture=picture;
        this.name = name;
        this.introduce = introduce;
        this.threshold = threshold;
        this.difficulty = difficulty;
        this.cycle = cycle;
        this.demand = demand;
        this.wages1 = wages1;
        this.wages2 = wages2;
        this.wages3 = wages3;
        this.prompt = prompt;
        this.onnum=onnum;
    }

    private Long id;
    private String picture;
    private String name;//类型名
    private String introduce;//介绍
    private int threshold;//门槛
    private int difficulty;//难度
    private String cycle;//周期
    private int demand;//需求
    private String wages1;//工资
    private String wages2;
    private String wages3;
    private String prompt;//提示
    private int  onnum;//在学人数






}
