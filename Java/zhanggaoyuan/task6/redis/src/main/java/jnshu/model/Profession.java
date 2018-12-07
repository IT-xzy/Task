package jnshu.model;

import java.io.Serializable;

public class Profession implements Serializable {
    private Integer id;

    private String img;

    private String professionName;

    private String professionDescription;

    private String professionDetail;

    private String threshold;

    private String difficultyLevel;

    private String growthCycle;

    private String need;

    private String salary;

    private String learning;

    private String hint;

    private Long creatTime;

    private Long updateTime;

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
        this.img = img == null ? null : img.trim();
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName == null ? null : professionName.trim();
    }

    public String getProfessionDescription() {
        return professionDescription;
    }

    public void setProfessionDescription(String professionDescription) {
        this.professionDescription = professionDescription == null ? null : professionDescription.trim();
    }

    public String getProfessionDetail() {
        return professionDetail;
    }

    public void setProfessionDetail(String professionDetail) {
        this.professionDetail = professionDetail == null ? null : professionDetail.trim();
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold == null ? null : threshold.trim();
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel == null ? null : difficultyLevel.trim();
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle == null ? null : growthCycle.trim();
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need == null ? null : need.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public String getLearning() {
        return learning;
    }

    public void setLearning(String learning) {
        this.learning = learning == null ? null : learning.trim();
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint == null ? null : hint.trim();
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}