package com.jnshu.modle;

/**
 * @program: SSM_Tiles
 * @description: 职业实体类
 * @author: Mr.xweiba
 * @create: 2018-05-10 23:45
 **/

public class Profession {
    private Long id;
    private String proName;
    private String proIntroduction;
    private String proCompany;
    private byte proDifficulty;
    private byte proThreshold;
    private Integer proSalary_min;
    private Integer proSalary_max;
    private Long proCount;
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
                ", proCompany='" + proCompany + '\'' +
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

    public Long getProCount() {
        return proCount;
    }

    public void setProCount(Long proCount) {
        this.proCount = proCount;
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

    public String getProIntroduction() {
        return proIntroduction;
    }

    public void setProIntroduction(String proIntroduction) {
        this.proIntroduction = proIntroduction;
    }

    public String getProCompany() {
        return proCompany;
    }

    public void setProCompany(String proCompany) {
        this.proCompany = proCompany;
    }

    public byte getProDifficulty() {
        return proDifficulty;
    }

    public void setProDifficulty(byte proDifficulty) {
        this.proDifficulty = proDifficulty;
    }

    public byte getProThreshold() {
        return proThreshold;
    }

    public void setProThreshold(byte proThreshold) {
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
