package com.jnshu.model;

public class Career {
    private Long id;

    private String name;

    private String introduction;

    private Long threshold;

    private Long difficult;

    private Long growthCycle;

    private Long scarcity;

    private String oneDegree;

    private String twoDegree;

    private String threeDegree;

    private Long belongModel;

    private Long createAt;

    private String createBy;

    private Long updateAt;

    private String updateBy;

    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", threshold=" + threshold +
                ", difficult=" + difficult +
                ", growthCycle=" + growthCycle +
                ", scarcity=" + scarcity +
                ", oneDegree='" + oneDegree + '\'' +
                ", twoDegree='" + twoDegree + '\'' +
                ", threeDegree='" + threeDegree + '\'' +
                ", belongModel=" + belongModel +
                ", createAt=" + createAt +
                ", createBy='" + createBy + '\'' +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Long getThreshold() {
        return threshold;
    }

    public void setThreshold(Long threshold) {
        this.threshold = threshold;
    }

    public Long getDifficult() {
        return difficult;
    }

    public void setDifficult(Long difficult) {
        this.difficult = difficult;
    }

    public Long getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(Long growthCycle) {
        this.growthCycle = growthCycle;
    }

    public Long getScarcity() {
        return scarcity;
    }

    public void setScarcity(Long scarcity) {
        this.scarcity = scarcity;
    }

    public String getOneDegree() {
        return oneDegree;
    }

    public void setOneDegree(String oneDegree) {
        this.oneDegree = oneDegree == null ? null : oneDegree.trim();
    }

    public String getTwoDegree() {
        return twoDegree;
    }

    public void setTwoDegree(String twoDegree) {
        this.twoDegree = twoDegree == null ? null : twoDegree.trim();
    }

    public String getThreeDegree() {
        return threeDegree;
    }

    public void setThreeDegree(String threeDegree) {
        this.threeDegree = threeDegree == null ? null : threeDegree.trim();
    }

    public Long getBelongModel() {
        return belongModel;
    }

    public void setBelongModel(Long belongModel) {
        this.belongModel = belongModel;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}