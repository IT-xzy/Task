package com.iceneet.entity;

public class Job {
    private Integer id;

    private String type;

    private String time;

    private Integer needcompany;

    private String descrition;

    private Integer learnnum;

    private String warning;

    private Integer skill;

    private Integer diffcut;

    private String pic;

    private Long createAt;

    private Long updateAt;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getNeedcompany() {
        return needcompany;
    }

    public void setNeedcompany(Integer needcompany) {
        this.needcompany = needcompany;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition == null ? null : descrition.trim();
    }

    public Integer getLearnnum() {
        return learnnum;
    }

    public void setLearnnum(Integer learnnum) {
        this.learnnum = learnnum;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning == null ? null : warning.trim();
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public Integer getDiffcut() {
        return diffcut;
    }

    public void setDiffcut(Integer diffcut) {
        this.diffcut = diffcut;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}