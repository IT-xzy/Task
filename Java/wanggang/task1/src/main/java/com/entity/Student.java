package com.entity;

public class Student {
    private int id;
    private String name;
    private int qq;
    private String type;
    private String startDay;
    private String university;
    private int studyName;
    private String link;
    private String hope;
    private String tutorshipSenior;
    private String know;
    private long createAt;
    private long updateAt;

    public Student(){

    }

    public Student( String name, int qq, String type, String startDay, String university, int studyName, String link, String hope, String tutorshipSenior, String know) {
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.startDay = startDay;
        this.university = university;
        this.studyName = studyName;
        this.link = link;
        this.hope = hope;
        this.tutorshipSenior = tutorshipSenior;
        this.know = know;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getStudyName() {
        return studyName;
    }

    public void setStudyName(int studyName) {
        this.studyName = studyName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHope() {
        return hope;
    }

    public void setHope(String hope) {
        this.hope = hope;
    }

    public String getTutorshipSenior() {
        return tutorshipSenior;
    }

    public void setTutorshipSenior(String tutorshipSenior) {
        this.tutorshipSenior = tutorshipSenior;
    }

    public String getKnow() {
        return know;
    }

    public void setKnow(String know) {
        this.know = know;
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", QQ=" + qq +
                ", type='" + type + '\'' +
                ", startDay='" + startDay + '\'' +
                ", university='" + university + '\'' +
                ", studyName=" + studyName +
                ", link='" + link + '\'' +
                ", hope='" + hope + '\'' +
                ", tutorshipSenior='" + tutorshipSenior + '\'' +
                ", know='" + know + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
