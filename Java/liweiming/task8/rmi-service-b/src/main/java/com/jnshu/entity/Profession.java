package com.jnshu.entity;

import java.io.Serializable;

public class Profession implements Serializable{

    private static final long serialVersionUID = -3773526432987334440L;
    private Long id;
    private String proName;
    private String proIntro;
    private String proFirm;
    private String proThreshold;
    private String diffLevel;
    private Integer proSalary;
    private Integer proCycle;
    private String createBy;
    private String updateBy;
    private Long createAt;
    private Long updateAt;
    private Integer proCount;

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", proIntro='" + proIntro + '\'' +
                ", proFirm='" + proFirm + '\'' +
                ", proThreshold='" + proThreshold + '\'' +
                ", diffLevel='" + diffLevel + '\'' +
                ", proSalary=" + proSalary +
                ", proCycle=" + proCycle +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", count=" + proCount +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProIntro() {
        return proIntro;
    }

    public void setProIntro(String proIntro) {
        this.proIntro = proIntro;
    }

    public String getProFirm() {
        return proFirm;
    }

    public void setProFirm(String proFirm) {
        this.proFirm = proFirm;
    }

    public String getProThreshold() {
        return proThreshold;
    }

    public void setProThreshold(String proThreshold) {
        this.proThreshold = proThreshold;
    }

    public String getDiffLevel() {
        return diffLevel;
    }

    public void setDiffLevel(String diffLevel) {
        this.diffLevel = diffLevel;
    }

    public Integer getProSalary() {
        return proSalary;
    }

    public void setProSalary(Integer proSalary) {
        this.proSalary = proSalary;
    }

    public Integer getProCycle() {
        return proCycle;
    }

    public void setProCycle(Integer proCycle) {
        this.proCycle = proCycle;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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

    public Integer getProCount() {
        return proCount;
    }

    public void setProCount(Integer proCount) {
        this.proCount = proCount;
    }
}
