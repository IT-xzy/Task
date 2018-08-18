package com.iceneet.Entity;

public class signup {
    private long id;
    private String name;
    private int qq;
    private String learnType;
    private String timeToLearn;
    private String graduatedSchool;
    private String onlineNum;
    private String dariyList;
    private String wish;
    private String helperShixiong;
    private String wayToKnow;
    private long createAt;
    private long updateAt;
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

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getLearnType() {
        return learnType;
    }

    public void setLearnType(String learnType) {
        this.learnType = learnType;
    }

    public String getTimeToLearn() {
        return timeToLearn;
    }

    public void setTimeToLearn(String timeToLearn) {
        this.timeToLearn = timeToLearn;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(String onlineNum) {
        this.onlineNum = onlineNum;
    }

    public String getDariyList() {
        return dariyList;
    }

    public void setDariyList(String dariyList) {
        this.dariyList = dariyList;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getHelperShixiong() {
        return helperShixiong;
    }

    public void setHelperShixiong(String helperShixiong) {
        this.helperShixiong = helperShixiong;
    }

    public String getWayToKnow() {
        return wayToKnow;
    }

    public void setWayToKnow(String wayToKnow) {
        this.wayToKnow = wayToKnow;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }


    @Override
    public String toString() {
        return "signup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", learnType='" + learnType + '\'' +
                ", timeToLearn='" + timeToLearn + '\'' +
                ", graduatedSchool='" + graduatedSchool + '\'' +
                ", onlineNum='" + onlineNum + '\'' +
                ", dariyList='" + dariyList + '\'' +
                ", wish='" + wish + '\'' +
                ", helperShixiong='" + helperShixiong + '\'' +
                ", wayToKnow='" + wayToKnow + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
