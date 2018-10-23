package com.jnshuboot.pojo;

import java.io.Serializable;

/**
 * @author
 */
public class Student implements Serializable {
    private Integer id;

    private String name;

    private Long createAt;

    private Long updateAt;

    private Integer qq;

    private String studyType;

    private Long joinTime;

    private String university;

    private String studyId;

    private String dailyLink;

    private String slogen;

    private String master;

    private static final long serialVersionUID = 1L;

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
        this.name = name;
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

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public Long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getSlogen() {
        return slogen;
    }

    public void setSlogen(String slogen) {
        this.slogen = slogen;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
                && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
                && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
                && (this.getStudyType() == null ? other.getStudyType() == null : this.getStudyType().equals(other.getStudyType()))
                && (this.getJoinTime() == null ? other.getJoinTime() == null : this.getJoinTime().equals(other.getJoinTime()))
                && (this.getUniversity() == null ? other.getUniversity() == null : this.getUniversity().equals(other.getUniversity()))
                && (this.getStudyId() == null ? other.getStudyId() == null : this.getStudyId().equals(other.getStudyId()))
                && (this.getDailyLink() == null ? other.getDailyLink() == null : this.getDailyLink().equals(other.getDailyLink()))
                && (this.getSlogen() == null ? other.getSlogen() == null : this.getSlogen().equals(other.getSlogen()))
                && (this.getMaster() == null ? other.getMaster() == null : this.getMaster().equals(other.getMaster()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getStudyType() == null) ? 0 : getStudyType().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        result = prime * result + ((getUniversity() == null) ? 0 : getUniversity().hashCode());
        result = prime * result + ((getStudyId() == null) ? 0 : getStudyId().hashCode());
        result = prime * result + ((getDailyLink() == null) ? 0 : getDailyLink().hashCode());
        result = prime * result + ((getSlogen() == null) ? 0 : getSlogen().hashCode());
        result = prime * result + ((getMaster() == null) ? 0 : getMaster().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", qq=").append(qq);
        sb.append(", studyType=").append(studyType);
        sb.append(", joinTime=").append(joinTime);
        sb.append(", university=").append(university);
        sb.append(", studyId=").append(studyId);
        sb.append(", dailyLink=").append(dailyLink);
        sb.append(", slogen=").append(slogen);
        sb.append(", master=").append(master);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}