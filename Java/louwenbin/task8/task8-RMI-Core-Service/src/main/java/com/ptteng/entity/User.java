package com.ptteng.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 839626135820616848L;
    private int id;
    private int studynum;
    private int jobnum;
    private String consultant;
    private String introduction;
    private String imges;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", studynum=" + studynum +
                ", jobnum=" + jobnum +
                ", consultant='" + consultant + '\'' +
                ", introduction='" + introduction + '\'' +
                ", imges='" + imges + '\'' +
                '}';
    }

    public String getImges() {
        return imges;
    }

    public void setImges(String imges) {
        this.imges = imges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudynum() {
        return studynum;
    }

    public void setStudynum(int studynum) {
        this.studynum = studynum;
    }

    public int getJobnum() {
        return jobnum;
    }

    public void setJobnum(int jobnum) {
        this.jobnum = jobnum;
    }

    public String getConsultant() {
        return consultant;
    }

    public void setConsultant(String consultant) {
        this.consultant = consultant;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
