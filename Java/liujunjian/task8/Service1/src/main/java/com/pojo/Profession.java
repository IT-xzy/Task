package com.pojo;

import java.io.Serializable;

public class Profession implements Serializable {
    private int id;
    private String profession;
    private String introduction;
    private String threshold;
    private String difficulty;
    private int growth_cycle;
    private int company_number;
    private String salary;
    private int stu_number;
    private int gra_number;
    private String basics;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getGrowth_cycle() {
        return growth_cycle;
    }

    public void setGrowth_cycle(int growth_cycle) {
        this.growth_cycle = growth_cycle;
    }

    public int getCompany_number() {
        return company_number;
    }

    public void setCompany_number(int company_number) {
        this.company_number = company_number;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getStu_number() {
        return stu_number;
    }

    public void setStu_number(int stu_number) {
        this.stu_number = stu_number;
    }

    public int getGra_number() {
        return gra_number;
    }

    public void setGra_number(int gra_number) {
        this.gra_number = gra_number;
    }

    public String getBasics() {
        return basics;
    }

    public void setBasics(String basics) {
        this.basics = basics;
    }
}
