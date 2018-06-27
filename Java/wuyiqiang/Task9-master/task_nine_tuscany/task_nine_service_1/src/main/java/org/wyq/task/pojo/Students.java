package org.wyq.task.pojo;

import java.io.Serializable;

public class Students implements Serializable {
    private Integer id;

    private String name;

    private String picture;

    private String profession;

    private Integer status;

    private String job;

    private String workIntroduction;

    private Integer evaluate;

    private Long creatAt;

    private Long upeateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getWorkIntroduction() {
        return workIntroduction;
    }

    public void setWorkIntroduction(String workIntroduction) {
        this.workIntroduction = workIntroduction == null ? null : workIntroduction.trim();
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }

    public Long getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Long creatAt) {
        this.creatAt = creatAt;
    }

    public Long getUpeateAt() {
        return upeateAt;
    }

    public void setUpeateAt(Long upeateAt) {
        this.upeateAt = upeateAt;
    }
}