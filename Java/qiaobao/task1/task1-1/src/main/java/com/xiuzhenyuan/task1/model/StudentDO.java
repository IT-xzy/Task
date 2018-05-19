package com.xiuzhenyuan.task1.model;


public class StudentDO {
    private int addId;
    private String name;
    private int qq;
    private String type;
    private long entorTime;
    private String graduateSchool;
    private int netId;
    private String dailyLink;
    private String wish;
    private String senior;
    private long createTime;
    private long updateTime;

    @Override
    public String toString() {
        return "StudentDO{" +
                "addId=" + addId +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", type='" + type + '\'' +
                ", entorTime=" + entorTime +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", netId=" + netId +
                ", dailyLink='" + dailyLink + '\'' +
                ", wish='" + wish + '\'' +
                ", senior='" + senior + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getEntorTime() {
        return entorTime;
    }

    public void setEntorTime(long entorTime) {
        this.entorTime = entorTime;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public int getNetId() {
        return netId;
    }

    public void setNetId(int netId) {
        this.netId = netId;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public StudentDO(String name, int qq, String type, long entorTime, String graduateSchool, int netId, String dailyLink, String wish, String senior, long createTime) {
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.entorTime = entorTime;
        this.graduateSchool = graduateSchool;
        this.netId = netId;
        this.dailyLink = dailyLink;
        this.wish = wish;
        this.senior = senior;
        this.createTime = createTime;
    }

    public StudentDO(int addId,String type,long updateTime) {
        this.addId = addId;
        this.type = type;
        this.updateTime=updateTime;
    }

    public StudentDO(String name, int netId) {
        this.name = name;
        this.netId = netId;
    }

    public StudentDO() {
    }
}
