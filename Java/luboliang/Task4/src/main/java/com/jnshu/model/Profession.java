package com.jnshu.model;

public class Profession {
    private long id;
    private String name;
    private String overview;
    private long salary1;
    private long salary2;
    private long salary3;
    private long threshold;//门槛
    private long complexity;//难易程度
    private String growth_cycle;//成长周期
    private String direction;//所属方向
    private long need;//公司需求
    private long create_at;
    private long update_at;
    private String hint;
    private String tc;
    private long number;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public long getSalary1() {
        return salary1;
    }

    public void setSalary1(long salary1) {
        this.salary1 = salary1;
    }

    public long getSalary2() {
        return salary2;
    }

    public void setSalary2(long salary2) {
        this.salary2 = salary2;
    }

    public long getSalary3() {
        return salary3;
    }

    public void setSalary3(long salary3) {
        this.salary3 = salary3;
    }

    public long getThreshold() {
        return threshold;
    }

    public void setThreshold(long threshold) {
        this.threshold = threshold;
    }

    public long getComplexity() {
        return complexity;
    }

    public void setComplexity(long complexity) {
        this.complexity = complexity;
    }

    public String getGrowth_cycle() {
        return growth_cycle;
    }

    public void setGrowth_cycle(String growth_cycle) {
        this.growth_cycle = growth_cycle;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public long getNeed() {
        return need;
    }

    public void setNeed(long need) {
        this.need = need;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", salary1=" + salary1 +
                ", salary2=" + salary2 +
                ", salary3=" + salary3 +
                ", threshold=" + threshold +
                ", complexity=" + complexity +
                ", growth_cycle='" + growth_cycle + '\'' +
                ", direction='" + direction + '\'' +
                ", need=" + need +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", hint='" + hint + '\'' +
                ", tc='" + tc + '\'' +
                ", number=" + number +
                '}';
    }
}
