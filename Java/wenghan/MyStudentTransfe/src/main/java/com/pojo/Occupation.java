package com.pojo;

public class Occupation {
    private int id;
    private String occupationName;
    private String careerIntroduction;
    private String occupationDirection;
    private int threshold;
    private int difficultyDegree;
    private String growthCycle;
    private int requirement;
    private String earlySalary;
    private String mediumTermSalary;
    private String lateSalary;
    private String relatedSkills;
    private long createAt;
    private long updateAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }

    public String getCareerIntroduction() {
        return careerIntroduction;
    }

    public void setCareerIntroduction(String careerIntroduction) {
        this.careerIntroduction = careerIntroduction;
    }

    public String getOccupationDirection() {
        return occupationDirection;
    }

    public void setOccupationDirection(String occupationDirection) {
        this.occupationDirection = occupationDirection;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getDifficultyDegree() {
        return difficultyDegree;
    }

    public void setDifficultyDegree(int difficultyDegree) {
        this.difficultyDegree = difficultyDegree;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle;
    }

    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    public String getEarlySalary() {
        return earlySalary;
    }

    public void setEarlySalary(String earlySalary) {
        this.earlySalary = earlySalary;
    }

    public String getMediumTermSalary() {
        return mediumTermSalary;
    }

    public void setMediumTermSalary(String mediumTermSalary) {
        this.mediumTermSalary = mediumTermSalary;
    }

    public String getLateSalary() {
        return lateSalary;
    }

    public void setLateSalary(String lateSalary) {
        this.lateSalary = lateSalary;
    }

    public String getRelatedSkills() {
        return relatedSkills;
    }

    public void setRelatedSkills(String relatedSkills) {
        this.relatedSkills = relatedSkills;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Occupation{" + "id=" + id + ", occupationName='" + occupationName + '\'' + ", careerIntroduction='" + careerIntroduction + '\'' + ", occupationDirection='" + occupationDirection + '\'' + ", threshold=" + threshold + ", difficultyDegree=" + difficultyDegree + ", growthCycle='" + growthCycle + '\'' + ", requirement=" + requirement + ", earlySalary='" + earlySalary + '\'' + ", mediumTermSalary='" + mediumTermSalary + '\'' + ", lateSalary='" + lateSalary + '\'' + ", relatedSkills='" + relatedSkills + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
}
