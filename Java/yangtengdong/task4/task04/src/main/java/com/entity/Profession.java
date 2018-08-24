package com.entity;
//职业表
public class Profession {
    private Integer id;
    private String vpt;       //职业类型
    private String obligation;//职责
    private String sill;      //门槛
    private String complexity;//难易程度
    private String growth;     //成长周期
    private String rareness;   //稀缺程度
    private String monney;     //薪资待遇
    private String online;     //在线人数
    private String tip;        //提示
    private String style;

    public Profession() {
    }

    public Profession(String vpt, String obligation, String sill,
                      String complexity, String growth, String rareness,
                      String monney, String online, String tip, String style) {
        this.vpt = vpt;
        this.obligation = obligation;
        this.sill = sill;
        this.complexity = complexity;
        this.growth = growth;
        this.rareness = rareness;
        this.monney = monney;
        this.online = online;
        this.tip = tip;
        this.style = style;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", vpt='" + vpt + '\'' +
                ", obligation='" + obligation + '\'' +
                ", sill='" + sill + '\'' +
                ", complexity='" + complexity + '\'' +
                ", growth='" + growth + '\'' +
                ", rareness='" + rareness + '\'' +
                ", monney='" + monney + '\'' +
                ", online='" + online + '\'' +
                ", tip='" + tip + '\'' +
                ", style='" + style + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVpt() {
        return vpt;
    }

    public void setVpt(String vpt) {
        this.vpt = vpt;
    }

    public String getObligation() {
        return obligation;
    }

    public void setObligation(String obligation) {
        this.obligation = obligation;
    }

    public String getSill() {
        return sill;
    }

    public void setSill(String sill) {
        this.sill = sill;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public String getRareness() {
        return rareness;
    }

    public void setRareness(String rareness) {
        this.rareness = rareness;
    }

    public String getMonney() {
        return monney;
    }

    public void setMonney(String monney) {
        this.monney = monney;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
