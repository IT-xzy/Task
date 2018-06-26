package com.jnshu.model;

import java.io.Serializable;

/**
 * @program: smsdemo
 * @description: 职业
 * @author: Mr.xweiba
 * @create: 2018-05-29 23:00
 **/

public class Profession implements Serializable{

    private static final long serialVersionUID = 1957179448349542224L;

    private Integer id;
    private String proName;
    private String proIntroduction;
    private Integer proCompany;
    private Integer proDifficulty;
    private Integer proThreshold;
    private Integer proSalary_min;
    private Integer proSalary_max;
    private Integer proCount;
    private Long create_by;
    private Long update_by;
    private Long create_at;
    private Long update_at;

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", proIntroduction='" + proIntroduction + '\'' +
                ", proCompany=" + proCompany +
                ", proDifficulty=" + proDifficulty +
                ", proThreshold=" + proThreshold +
                ", proSalary_min=" + proSalary_min +
                ", proSalary_max=" + proSalary_max +
                ", proCount=" + proCount +
                ", create_by=" + create_by +
                ", update_by=" + update_by +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProIntroduction() {
        return proIntroduction;
    }

    public void setProIntroduction(String proIntroduction) {
        this.proIntroduction = proIntroduction;
    }

    public Integer getProCompany() {
        return proCompany;
    }

    public void setProCompany(Integer proCompany) {
        this.proCompany = proCompany;
    }

    public Integer getProDifficulty() {
        return proDifficulty;
    }

    public void setProDifficulty(Integer proDifficulty) {
        this.proDifficulty = proDifficulty;
    }

    public Integer getProThreshold() {
        return proThreshold;
    }

    public void setProThreshold(Integer proThreshold) {
        this.proThreshold = proThreshold;
    }

    public Integer getProSalary_min() {
        return proSalary_min;
    }

    public void setProSalary_min(Integer proSalary_min) {
        this.proSalary_min = proSalary_min;
    }

    public Integer getProSalary_max() {
        return proSalary_max;
    }

    public void setProSalary_max(Integer proSalary_max) {
        this.proSalary_max = proSalary_max;
    }

    public Integer getProCount() {
        return proCount;
    }

    public void setProCount(Integer proCount) {
        this.proCount = proCount;
    }

    public Long getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Long create_by) {
        this.create_by = create_by;
    }

    public Long getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(Long update_by) {
        this.update_by = update_by;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }
}
