package com.pojo;

public class Student {
    private int id;
    private String name;
    private int oid;
    private String company;
    private String position;
    private String personalProfile;
    private String headPortrait;
    private String learningState;
    private String jobSatisfaction;
    private long create_at;
    private long update_at;

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", oid=" + oid + ", company='" + company + '\'' + ", position='" + position + '\'' + ", personalProfile='" + personalProfile + '\'' + ", headPortrait='" + headPortrait + '\'' + ", learningState='" + learningState + '\'' + ", jobSatisfaction='" + jobSatisfaction + '\'' + ", create_at=" + create_at + ", update_at=" + update_at + '}';
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

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getLearningState() {
        return learningState;
    }

    public void setLearningState(String learningState) {
        this.learningState = learningState;
    }

    public String getJobSatisfaction() {
        return jobSatisfaction;
    }

    public void setJobSatisfaction(String jobSatisfaction) {
        this.jobSatisfaction = jobSatisfaction;
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
}
