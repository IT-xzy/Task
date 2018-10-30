package com.lihoo.ssm.model;

import java.io.Serializable;

public class StudentProfession implements Serializable {
    private static final long serialVersionUID = 1081L;

    private Long id;

    private String job;

    private String jobInfo;

    private String salary1;

    private String salary2;

    private String salary3;

    private String hoverInfo;

    private Long createAt;

    private Long updateAt;

    public StudentProfession() {
    }

    public StudentProfession(Long id, String job, String jobInfo, String salary1, String salary2, String salary3, String hoverInfo, Long createAt, Long updateAt) {
        this.id = id;
        this.job = job;
        this.jobInfo = jobInfo;
        this.salary1 = salary1;
        this.salary2 = salary2;
        this.salary3 = salary3;
        this.hoverInfo = hoverInfo;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
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

    public String getHoverInfo() {
        return hoverInfo;
    }

    public void setHoverInfo(String hoverInfo) {
        this.hoverInfo = hoverInfo;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "StudentProfession{" +
                "id=" + id +
                ", job='" + job + '\'' +
                ", jobInfo='" + jobInfo + '\'' +
                ", salary1='" + salary1 + '\'' +
                ", salary2='" + salary2 + '\'' +
                ", salary3='" + salary3 + '\'' +
                ", hoverInfo='" + hoverInfo + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}