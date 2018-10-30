package com.ptteng.entity;

public class Profession {

    private Long id;
    private String direction;
    private String classify;
    private String duty;
    private Integer strip;
    private Integer difficultyLevel;
    private String growthCycle;
    private Integer scarcityDegree;
    private String firstSalary;
    private String secondSalary;
    private String thirdSalary;
    private String basicKnowledge;
    private String engineer;
    private String engineerIntro;
    private Long createAt;
    private Long updateAt;
    private Long createBy;
    private Long updateBy;
    private Long count;

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", direction='" + direction + '\'' +
                ", classify='" + classify + '\'' +
                ", duty='" + duty + '\'' +
                ", strip=" + strip +
                ", difficultyLevel=" + difficultyLevel +
                ", growthCycle='" + growthCycle + '\'' +
                ", scarcityDegree=" + scarcityDegree +
                ", firstSalary='" + firstSalary + '\'' +
                ", secondSalary='" + secondSalary + '\'' +
                ", thirdSalary='" + thirdSalary + '\'' +
                ", basicKnowledge='" + basicKnowledge + '\'' +
                ", engineer='" + engineer + '\'' +
                ", engineerIntro='" + engineerIntro + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", count=" + count +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Integer getStrip() {
        return strip;
    }

    public void setStrip(Integer strip) {
        this.strip = strip;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle;
    }

    public Integer getScarcityDegree() {
        return scarcityDegree;
    }

    public void setScarcityDegree(Integer scarcityDegree) {
        this.scarcityDegree = scarcityDegree;
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

    public String getBasicKnowledge() {
        return basicKnowledge;
    }

    public void setBasicKnowledge(String basicKnowledge) {
        this.basicKnowledge = basicKnowledge;
    }

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    public String getEngineerIntro() {
        return engineerIntro;
    }

    public void setEngineerIntro(String engineerIntro) {
        this.engineerIntro = engineerIntro;
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

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
