package com.fangyuyang.model;

public class Career {
    private Integer id;

    private String career;

    private String careerAbout;

    private String money3;

    private String money2;

    private String money1;

    private Integer learningMan;

    private String time;

    private Integer beNeeded;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career == null ? null : career.trim();
    }

    public String getCareerAbout() {
        return careerAbout;
    }

    public void setCareerAbout(String careerAbout) {
        this.careerAbout = careerAbout == null ? null : careerAbout.trim();
    }

    public String getMoney3() {
        return money3;
    }

    public void setMoney3(String money3) {
        this.money3 = money3 == null ? null : money3.trim();
    }

    public String getMoney2() {
        return money2;
    }

    public void setMoney2(String money2) {
        this.money2 = money2 == null ? null : money2.trim();
    }

    public String getMoney1() {
        return money1;
    }

    public void setMoney1(String money1) {
        this.money1 = money1 == null ? null : money1.trim();
    }

    public Integer getLearningMan() {
        return learningMan;
    }

    public void setLearningMan(Integer learningMan) {
        this.learningMan = learningMan;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getBeNeeded() {
        return beNeeded;
    }

    public void setBeNeeded(Integer beNeeded) {
        this.beNeeded = beNeeded;
    }
}