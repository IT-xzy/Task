package com.ev.entity;

import java.io.Serializable;

public class Occupation  implements Serializable {

    private String name;
    private String direction;
    private String descriptionDetailed;
    private String descriptionGeneral;
    private int threshold;
    private int difficulty;
    private String growthCycle;
    private int scarcity;
    private String salaryFreshman;
    private String salaryJunior;
    private String salarySenior;
    private int isLearning;
    private String tips;
    private Long id;
    private Long createAt;
    private Long updateAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDescriptionDetailed() {
        return descriptionDetailed;
    }

    public void setDescriptionDetailed(String descriptionDetailed) {
        this.descriptionDetailed = descriptionDetailed;
    }

    public String getDescriptionGeneral() {
        return descriptionGeneral;
    }

    public void setDescriptionGeneral(String descriptionGeneral) {
        this.descriptionGeneral = descriptionGeneral;
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

    public int getScarcity() {
        return scarcity;
    }

    public void setScarcity(int scarcity) {
        this.scarcity = scarcity;
    }

    public String getSalaryFreshman() {
        return salaryFreshman;
    }

    public void setSalaryFreshman(String salaryFreshman) {
        this.salaryFreshman = salaryFreshman;
    }

    public String getSalaryJunior() {
        return salaryJunior;
    }

    public void setSalaryJunior(String salaryJunior) {
        this.salaryJunior = salaryJunior;
    }

    public String getSalarySenior() {
        return salarySenior;
    }

    public void setSalarySenior(String salarySenior) {
        this.salarySenior = salarySenior;
    }

    public int getIsLearning() {
        return isLearning;
    }

    public void setIsLearning(int isLearning) {
        this.isLearning = isLearning;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Occupation() {
    }

    public Occupation(String name, String direction, String descriptionDetailed, String descriptionGeneral, int threshold, int difficulty, String growthCycle, int scarcity, String salaryFreshman, String salaryJunior, String salarySenior, int isLearning, String tips, Long createAt, Long updateAt) {
        this.name = name;
        this.direction = direction;
        this.descriptionDetailed = descriptionDetailed;
        this.descriptionGeneral = descriptionGeneral;
        this.threshold = threshold;
        this.difficulty = difficulty;
        this.growthCycle = growthCycle;
        this.scarcity = scarcity;
        this.salaryFreshman = salaryFreshman;
        this.salaryJunior = salaryJunior;
        this.salarySenior = salarySenior;
        this.isLearning = isLearning;
        this.tips = tips;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", descriptionDetailed='" + descriptionDetailed + '\'' +
                ", descriptionGeneral='" + descriptionGeneral + '\'' +
                ", threshold=" + threshold +
                ", difficulty=" + difficulty +
                ", growthCycle='" + growthCycle + '\'' +
                ", scarcity=" + scarcity +
                ", salaryFreshman='" + salaryFreshman + '\'' +
                ", salaryJunior='" + salaryJunior + '\'' +
                ", salarySenior='" + salarySenior + '\'' +
                ", isLearning=" + isLearning +
                ", tips='" + tips + '\'' +
                ", id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
