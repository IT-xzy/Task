package com.task5.pojo;

import java.io.Serializable;

public class Profession implements Serializable {
    private static final long serialVersionUID = 1563056272025335248L;
    long id;
    String proName;
    //头像
    String icon;
    //职业方向
    String careerDirection;
    //职业介绍
    String proIntroduction;
    //门槛难度
    byte proThreshold;
    //职业难度
    byte proDifficulty;
    //成长周期
    String growthCycle;
    //公司
    String proCompany;
    //最低工资
    String proSalaryMin;
    //正常工资
    String proSalaryNormal;
    //最高工资
    String proSalaryMax;
    //在学人数
    long studyNumber;
    //提示
    String hint;
    long createAt;
    long updateAt;

    public Profession() {
    }

    public Profession(long id, String proName, String icon, String careerDirection, String proIntroduction,
                      byte proThreshold, byte proDifficulty, String growthCycle, String proCompany, String proSalaryMin,
                      String proSalaryNormal, String proSalaryMax, long studyNumber, String hint, long createAt, long updateAt) {
        this.id = id;
        this.proName = proName;
        this.icon = icon;
        this.careerDirection = careerDirection;
        this.proIntroduction = proIntroduction;
        this.proThreshold = proThreshold;
        this.proDifficulty = proDifficulty;
        this.growthCycle = growthCycle;
        this.proCompany = proCompany;
        this.proSalaryMin = proSalaryMin;
        this.proSalaryNormal = proSalaryNormal;
        this.proSalaryMax = proSalaryMax;
        this.studyNumber = studyNumber;
        this.hint = hint;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", icon='" + icon + '\'' +
                ", careerDirection='" + careerDirection + '\'' +
                ", proIntroduction='" + proIntroduction + '\'' +
                ", proThreshold=" + proThreshold +
                ", proDifficulty=" + proDifficulty +
                ", growthCycle='" + growthCycle + '\'' +
                ", proCompany='" + proCompany + '\'' +
                ", proSalaryMin='" + proSalaryMin + '\'' +
                ", proSalaryNormal='" + proSalaryNormal + '\'' +
                ", proSalaryMax='" + proSalaryMax + '\'' +
                ", studyNumber=" + studyNumber +
                ", hint='" + hint + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCareerDirection() {
        return careerDirection;
    }

    public void setCareerDirection(String careerDirection) {
        this.careerDirection = careerDirection;
    }

    public String getProIntroduction() {
        return proIntroduction;
    }

    public void setProIntroduction(String proIntroduction) {
        this.proIntroduction = proIntroduction;
    }

    public byte getProThreshold() {
        return proThreshold;
    }

    public void setProThreshold(byte proThreshold) {
        this.proThreshold = proThreshold;
    }

    public byte getProDifficulty() {
        return proDifficulty;
    }

    public void setProDifficulty(byte proDifficulty) {
        this.proDifficulty = proDifficulty;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle;
    }

    public String getProCompany() {
        return proCompany;
    }

    public void setProCompany(String proCompany) {
        this.proCompany = proCompany;
    }

    public String getProSalaryMin() {
        return proSalaryMin;
    }

    public void setProSalaryMin(String proSalaryMin) {
        this.proSalaryMin = proSalaryMin;
    }

    public String getProSalaryNormal() {
        return proSalaryNormal;
    }

    public void setProSalaryNormal(String proSalaryNormal) {
        this.proSalaryNormal = proSalaryNormal;
    }

    public String getProSalaryMax() {
        return proSalaryMax;
    }

    public void setProSalaryMax(String proSalaryMax) {
        this.proSalaryMax = proSalaryMax;
    }

    public long getStudyNumber() {
        return studyNumber;
    }

    public void setStudyNumber(long studyNumber) {
        this.studyNumber = studyNumber;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
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
}
