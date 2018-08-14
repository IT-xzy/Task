package com.fgh.task2.model;

public class Pro {
    private Integer id;
    private String proClass;
    private String proName;
    private String introduce;
    private String hint;
    private Integer sill;
    private Integer complexity;
    private Integer demand;
    private Integer growth;
    private String working_years;
    private String wage_min;
    private String wage_max;
    private String proCount;
    private Long create_at;
    private Long update_at;
    private String create_by;
    private String update_by;


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
    public String getProClass() {
        return proClass;
    }

    public void setProClass(String proClass) {
        this.proClass = proClass;
    }
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Integer getSill() {
        return sill;
    }

    public void setSill(Integer sill) {
        this.sill = sill;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public Integer getDemand() {
        return demand;
    }

    public void setDemand(Integer demand) {
        this.demand = demand;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public String getWorking_years() {
        return working_years;
    }

    public void setWorking_years(String working_years) {
        this.working_years = working_years;
    }

    public String getWage_min() {
        return wage_min;
    }

    public void setWage_min(String wage_min) {
        this.wage_min = wage_min;
    }

    public String getWage_max() {
        return wage_max;
    }

    public void setWage_max(String wage_max) {
        this.wage_max = wage_max;
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

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getProCount() {
        return proCount;
    }

    public void setProCount(String proCount) {
        this.proCount = proCount;
    }
}
