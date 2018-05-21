package cn.summerwaves.model;

public class Position {
    private String picture;
    private String positionName;
    private String introduction;
    private int type;
    private int barrier;
    private int difficulty;
    private String growthCycle;
    private String scarcity;
    private String experience1;
    private String experience2;
    private String experience3;
    private String salary1;
    private String salary2;
    private String salary3;
    private int studying;
    private String skill;
    private String detail;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBarrier() {
        return barrier;
    }

    public void setBarrier(int barrier) {
        this.barrier = barrier;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle;
    }

    public String getScarcity() {
        return scarcity;
    }

    public void setScarcity(String scarcity) {
        this.scarcity = scarcity;
    }

    public String getExperience1() {
        return experience1;
    }

    public void setExperience1(String experience1) {
        this.experience1 = experience1;
    }

    public String getExperience2() {
        return experience2;
    }

    public void setExperience2(String experience2) {
        this.experience2 = experience2;
    }

    public String getExperience3() {
        return experience3;
    }

    public void setExperience3(String experience3) {
        this.experience3 = experience3;
    }

    public String getSalary1() {
        return salary1;
    }

    public void setSalary1(String salary1) {
        this.salary1 = salary1;
    }

    public String getSalary2() {
        return salary2;
    }

    public void setSalary2(String salary2) {
        this.salary2 = salary2;
    }

    public String getSalary3() {
        return salary3;
    }

    public void setSalary3(String salary3) {
        this.salary3 = salary3;
    }

    public int getStudying() {
        return studying;
    }

    public void setStudying(int studying) {
        this.studying = studying;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Position() {
    }

    @Override
    public String toString() {
        return "Position{" +
                "picture='" + picture + '\'' +
                ", positionName='" + positionName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type=" + type +
                ", barrier=" + barrier +
                ", difficulty=" + difficulty +
                ", growthCycle='" + growthCycle + '\'' +
                ", scarcity='" + scarcity + '\'' +
                ", experience1='" + experience1 + '\'' +
                ", experience2='" + experience2 + '\'' +
                ", experience3='" + experience3 + '\'' +
                ", salary1='" + salary1 + '\'' +
                ", salary2='" + salary2 + '\'' +
                ", salary3='" + salary3 + '\'' +
                ", studying=" + studying +
                ", skill='" + skill + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Position(String picture, String positionName, String introduction, int type, int barrier, int difficulty, String growthCycle, String scarcity, String experience1, String experience2, String experience3, String salary1, String salary2, String salary3, int studying, String skill, String detail) {
        this.picture = picture;
        this.positionName = positionName;
        this.introduction = introduction;
        this.type = type;
        this.barrier = barrier;
        this.difficulty = difficulty;
        this.growthCycle = growthCycle;
        this.scarcity = scarcity;
        this.experience1 = experience1;
        this.experience2 = experience2;
        this.experience3 = experience3;
        this.salary1 = salary1;
        this.salary2 = salary2;
        this.salary3 = salary3;
        this.studying = studying;
        this.skill = skill;
        this.detail = detail;
    }


}
