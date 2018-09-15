package com.zyq.pojo;

import java.io.Serializable;

public class Profession implements Serializable {
    private Integer id;
    private String img;
    private String developmentDirection;

    private String professionName;
    private String description;
    private Integer limitCondition;

    private Integer difficulty;
    private Integer periodOne;
    private Integer periodTwo;

    private Integer carrerProspects;
    private Double salaryOne;
    private Double salaryTwo;

    private Double salaryThree;
    private Double salaryFour;
    private Integer studying;

    private String reminder;
    private Long createAt;
    private Long updateAt;

    public Profession() {
    }

    public Profession(Integer id, String img, String developmentDirection, String professionName, String description, Integer limitCondition, Integer difficulty, Integer periodOne, Integer periodTwo, Integer carrerProspects, Double salaryOne, Double salaryTwo, Double salaryThree, Double salaryFour, Integer studying, String reminder, Long createAt, Long updateAt) {
        this.id = id;
        this.img = img;
        this.developmentDirection = developmentDirection;
        this.professionName = professionName;
        this.description = description;
        this.limitCondition = limitCondition;
        this.difficulty = difficulty;
        this.periodOne = periodOne;
        this.periodTwo = periodTwo;
        this.carrerProspects = carrerProspects;
        this.salaryOne = salaryOne;
        this.salaryTwo = salaryTwo;
        this.salaryThree = salaryThree;
        this.salaryFour = salaryFour;
        this.studying = studying;
        this.reminder = reminder;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", developmentDirection='" + developmentDirection + '\'' +
                ", professionName='" + professionName + '\'' +
                ", description='" + description + '\'' +
                ", limitCondition=" + limitCondition +
                ", difficulty=" + difficulty +
                ", periodOne=" + periodOne +
                ", periodTwo=" + periodTwo +
                ", carrerProspects=" + carrerProspects +
                ", salaryOne=" + salaryOne +
                ", salaryTwo=" + salaryTwo +
                ", salaryThree=" + salaryThree +
                ", salaryFour=" + salaryFour +
                ", studying=" + studying +
                ", reminder='" + reminder + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDevelopmentDirection() {
        return developmentDirection;
    }

    public void setDevelopmentDirection(String developmentDirection) {
        this.developmentDirection = developmentDirection;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLimitCondition() {
        return limitCondition;
    }

    public void setLimitCondition(Integer limitCondition) {
        this.limitCondition = limitCondition;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getPeriodOne() {
        return periodOne;
    }

    public void setPeriodOne(Integer periodOne) {
        this.periodOne = periodOne;
    }

    public Integer getPeriodTwo() {
        return periodTwo;
    }

    public void setPeriodTwo(Integer periodTwo) {
        this.periodTwo = periodTwo;
    }

    public Integer getCarrerProspects() {
        return carrerProspects;
    }

    public void setCarrerProspects(Integer carrerProspects) {
        this.carrerProspects = carrerProspects;
    }

    public Double getSalaryOne() {
        return salaryOne;
    }

    public void setSalaryOne(Double salaryOne) {
        this.salaryOne = salaryOne;
    }

    public Double getSalaryTwo() {
        return salaryTwo;
    }

    public void setSalaryTwo(Double salaryTwo) {
        this.salaryTwo = salaryTwo;
    }

    public Double getSalaryThree() {
        return salaryThree;
    }

    public void setSalaryThree(Double salaryThree) {
        this.salaryThree = salaryThree;
    }

    public Double getSalaryFour() {
        return salaryFour;
    }

    public void setSalaryFour(Double salaryFour) {
        this.salaryFour = salaryFour;
    }

    public Integer getStudying() {
        return studying;
    }

    public void setStudying(Integer studying) {
        this.studying = studying;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}
