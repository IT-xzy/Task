package com.jnshu.pojo;

import java.io.Serializable;

public class Job implements Serializable {


    private static final long serialVersionUID = -4040795310700520839L;
    private Long id;

    private String img;

    private String professionName;

    private String professionIntroduction;

    private Integer threshold;

    private Integer complexity;

    private String growthCycle;

    private String scarcityLevel;

    private String salary;

    private String hint;

    private Long createAt;

    private Long updateAt;

    private String createBy;

    private Integer learning;

    public Integer getLearning() {
        return learning;
    }

    public void setLearning(Integer learning) {
        this.learning = learning;
    }

    public Job() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getProfessionIntroduction() {
        return professionIntroduction;
    }

    public void setProfessionIntroduction(String professionIntroduction) {
        this.professionIntroduction = professionIntroduction == null ? null : professionIntroduction.trim();
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle == null ? null : growthCycle.trim();
    }

    public String getScarcityLevel() {
        return scarcityLevel;
    }

    public void setScarcityLevel(String scarcityLevel) {
        this.scarcityLevel = scarcityLevel == null ? null : scarcityLevel.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint == null ? null : hint.trim();
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", professionName='" + professionName + '\'' +
                ", professionIntroduction='" + professionIntroduction + '\'' +
                ", threshold=" + threshold +
                ", complexity=" + complexity +
                ", growthCycle='" + growthCycle + '\'' +
                ", scarcityLevel='" + scarcityLevel + '\'' +
                ", salary='" + salary + '\'' +
                ", hint='" + hint + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy='" + createBy + '\'' +
                ", learning=" + learning +
                '}';
    }
}