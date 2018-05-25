package com.how2java.pojo;

public class Student {
    private int id;
    private int location;
    private int level;
    private int lesson;

    private String name;
    private long qq;

    private String job;
    private long startTime;

    private String university;

    private int number;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
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

    private String link;


    private String target;
    private String brother;
    private String source;

    private long createAt;
    private long updateAt;


    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }



    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public Student(int id,int location){
        this.id=id;
        this.location=location;
    }

    public Student(int id, int location, int level, int lesson, String name, long qq, String job,
                   long startTime, String university, int number, String link, String target, String brother,
                   String source, long createAt, long updateAt){
        this.id=id;
        this.location=location;
        this.level=level;
        this.lesson=lesson;
        this.name=name;
        this.qq=qq;
        this.job=job;
        this.startTime=startTime;
        this.university=university;
        this.number=number;
        this.link=link;
        this.target=target;
        this.brother=brother;
        this.source=source;
        this.createAt=createAt;
        this.updateAt=updateAt;
    }

    public Student(){

    }



    @Override
    public String toString() {
        return this.getId()+"\n"
                +this.getLocation()+"\n"
                +this.getLevel()+"\n"
                +this.getLesson()+"\n"
                +this.getName()+"\n"
                +this.getQq()+"\n"
                +this.getJob()+"\n"
                +this.getStartTime()+"\n"
                +this.getUniversity()+"\n"
                +this.getNumber()+"\n"
                +this.getLink()+"\n"
                +this.getTarget()+"\n"
                +this.getBrother()+"\n"
                +this.getSource()+"\n"
                +this.getCreateAt()+"\n"
                +this.getUpdateAt();
    }

}
