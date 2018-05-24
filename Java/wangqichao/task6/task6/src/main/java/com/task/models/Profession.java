package com.task.models;

import java.io.Serializable;

public class Profession implements Serializable {
    private static final long serialVersionUID = -2802739874490624761L;
    private  int id;
    private  long createdAt;
    private long updatedAt;
    private  String name;
    private  String intro;
    private  String difficulty;
    private  String request;
    private  String growthPeriod;
    private  String rareness;
    private  String firstSalary;
    private  String thirdSalary;
    private  String fourthSalary;
    private  String requestSkills;

    public Profession(long createdAt, String name, String intro, String difficulty, String request, String growthPeriod, String rareness, String firstSalary, String thirdSalary, String fourthSalary, String requestSkills) {
        this.createdAt = createdAt;
        this.name = name;
        this.intro = intro;
        this.difficulty = difficulty;
        this.request = request;
        this.growthPeriod = growthPeriod;
        this.rareness = rareness;
        this.firstSalary = firstSalary;
        this.thirdSalary = thirdSalary;
        this.fourthSalary = fourthSalary;
        this.requestSkills = requestSkills;
    }

    public Profession(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String profession) {
        this.name = profession;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getGrowthPeriod() {
        return growthPeriod;
    }

    public void setGrowthPeriod(String growthPeriod) {
        this.growthPeriod = growthPeriod;
    }

    public String getRareness() {
        return rareness;
    }

    public void setRareness(String rareness) {
        this.rareness = rareness;
    }

    public String getFirstSalary() {
        return firstSalary;
    }

    public void setFirstSalary(String firstSalary) {
        this.firstSalary = firstSalary;
    }

    public String getThirdSalary() {
        return thirdSalary;
    }

    public void setThirdSalary(String thirdSalary) {
        this.thirdSalary = thirdSalary;
    }

    public String getFourthSalary() {
        return fourthSalary;
    }

    public void setFourthSalary(String fourthSalary) {
        this.fourthSalary = fourthSalary;
    }

    public String getRequestSkills() {
        return requestSkills;
    }

    public void setRequestSkills(String requestSkills) {
        this.requestSkills = requestSkills;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", request='" + request + '\'' +
                ", growthPeriod='" + growthPeriod + '\'' +
                ", rareness='" + rareness + '\'' +
                ", firstSalary='" + firstSalary + '\'' +
                ", thirdSalary='" + thirdSalary + '\'' +
                ", fourthSalary='" + fourthSalary + '\'' +
                ", requestSkills='" + requestSkills + '\'' +
                '}';
    }
}
