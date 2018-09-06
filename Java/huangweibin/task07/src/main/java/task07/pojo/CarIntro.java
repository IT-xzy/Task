package task07.pojo;

public class CarIntro {
    private int id;

    private String occupation;

    private int difficult;

    private int scarcity;

    private String growth;

    private String briefintroducce;

    private int doorsill;

    private String picture;

    private String introduce;

    private String level01;

    private String level02;

    private String level03;

    private String level01_salary;

    private String level02_salary;

    private String level03_salary;

    private int learningnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public int getScarcity() {
        return scarcity;
    }

    public void setScarcity(int scarcity) {
        this.scarcity = scarcity;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public String getBriefintroducce() {
        return briefintroducce;
    }

    public void setBriefintroducce(String briefintroducce) {
        this.briefintroducce = briefintroducce;
    }

    public int getDoorsill() {
        return doorsill;
    }

    public void setDoorsill(int doorsill) {
        this.doorsill = doorsill;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLevel01() {
        return level01;
    }

    public void setLevel01(String level01) {
        this.level01 = level01;
    }

    public String getLevel02() {
        return level02;
    }

    public void setLevel02(String level02) {
        this.level02 = level02;
    }

    public String getLevel03() {
        return level03;
    }

    public void setLevel03(String level03) {
        this.level03 = level03;
    }

    public String getLevel01_salary() {
        return level01_salary;
    }

    public void setLevel01_salary(String level01_salary) {
        this.level01_salary = level01_salary;
    }

    public String getLevel02_salary() {
        return level02_salary;
    }

    public void setLevel02_salary(String level02_salary) {
        this.level02_salary = level02_salary;
    }

    public String getLevel03_salary() {
        return level03_salary;
    }

    public void setLevel03_salary(String level03_salary) {
        this.level03_salary = level03_salary;
    }

    public int getLearningnum() {
        return learningnum;
    }

    public void setLearningnum(int learningnum) {
        this.learningnum = learningnum;
    }

    @Override
    public String toString() {
        return "CarIntro{" +
                "id=" + id +
                ", occupation='" + occupation + '\'' +
                ", difficult=" + difficult +
                ", scarcity=" + scarcity +
                ", growth='" + growth + '\'' +
                ", briefintroducce='" + briefintroducce + '\'' +
                ", doorsill=" + doorsill +
                ", picture='" + picture + '\'' +
                ", introduce='" + introduce + '\'' +
                ", level01='" + level01 + '\'' +
                ", level02='" + level02 + '\'' +
                ", level03='" + level03 + '\'' +
                ", level01_salary='" + level01_salary + '\'' +
                ", level02_salary='" + level02_salary + '\'' +
                ", level03_salary='" + level03_salary + '\'' +
                ", learningnum=" + learningnum +
                '}';
    }
}
