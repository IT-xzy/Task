package com.model;/*
 * @ClassName:Profession
 * @Description:修真类型类
 * @Author qiao
 * @Date 2018/7/28 14:02
 **/

public class Profession {
    private int profId;
    private String profName;
    private String profIntro;
    private int profSill;
    private int profLevel;
    private String profCycle;
    private String profNeed;
    private String profTime1;
    private String profTime3;
    private String profTime5;
    private String profGroup;
    private String profLanguage;
    private int sum;

    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getProfIntro() {
        return profIntro;
    }

    public void setProfIntro(String profIntro) {
        this.profIntro = profIntro;
    }

    public int getProfSill() {
        return profSill;
    }

    public void setProfSill(int profSill) {
        this.profSill = profSill;
    }

    public int getProfLevel() {
        return profLevel;
    }

    public void setProfLevel(int profLevel) {
        this.profLevel = profLevel;
    }

    public String getProfCycle() {
        return profCycle;
    }

    public void setProfCycle(String profCycle) {
        this.profCycle = profCycle;
    }

    public String getProfNeed() {
        return profNeed;
    }

    public void setProfNeed(String profNeed) {
        this.profNeed = profNeed;
    }

    public String getProfTime1() {
        return profTime1;
    }

    public void setProfTime1(String profTime1) {
        this.profTime1 = profTime1;
    }

    public String getProfTime3() {
        return profTime3;
    }

    public void setProfTime3(String profTime3) {
        this.profTime3 = profTime3;
    }

    public String getProfTime5() {
        return profTime5;
    }

    public void setProfTime5(String profTime5) {
        this.profTime5 = profTime5;
    }

    public String getProfGroup() {
        return profGroup;
    }

    public void setProfGroup(String profGroup) {
        this.profGroup = profGroup;
    }

    public String getProfLanguage() {
        return profLanguage;
    }

    public void setProfLanguage(String profLanguage) {
        this.profLanguage = profLanguage;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "profId=" + profId +
                ", profName='" + profName + '\'' +
                ", profIntro='" + profIntro + '\'' +
                ", profSill=" + profSill +
                ", profLevel=" + profLevel +
                ", profCycle='" + profCycle + '\'' +
                ", profNeed='" + profNeed + '\'' +
                ", profTime1='" + profTime1 + '\'' +
                ", profTime3='" + profTime3 + '\'' +
                ", profTime5='" + profTime5 + '\'' +
                ", profGroup='" + profGroup + '\'' +
                ", profLanguage='" + profLanguage + '\'' +
                ", sum=" + sum +
                '}';
    }
}
