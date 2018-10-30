package model;

import java.io.Serializable;

public class Prof implements Serializable {

    private static final long serialVersionUID = -8862313383500944582L;

    Integer id;
    String profession;
    String introduction;
    Long threshold;
    Long difficulty;
    String request;
    String growthPeriod;
    Long rareness;
    String firstSalary;
    String secondSalary;
    String thirdSalary;
    Long createAt;
    Long updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Long getThreshold() {
        return threshold;
    }

    public void setThreshold(Long threshold) {
        this.threshold = threshold;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
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

    public Long getRareness() {
        return rareness;
    }

    public void setRareness(Long rareness) {
        this.rareness = rareness;
    }

    public String getFirstSalary() {
        return firstSalary;
    }

    public void setFirstSalary(String firstSalary) {
        this.firstSalary = firstSalary;
    }

    public String getSecondSalary() {
        return secondSalary;
    }

    public void setSecondSalary(String secondSalary) {
        this.secondSalary = secondSalary;
    }

    public String getThirdSalary() {
        return thirdSalary;
    }

    public void setThirdSalary(String thirdSalary) {
        this.thirdSalary = thirdSalary;
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
