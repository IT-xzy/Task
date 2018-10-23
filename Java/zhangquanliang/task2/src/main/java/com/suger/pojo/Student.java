package com.suger.pojo;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * 实体类，包括简单的参数校验
 * @author suger
 * @date 2018-10-02
 */
public class Student {
    private Long id;

    @NotNull(message = "请输入姓名")
    @Size(min = 2, max = 15, message = "长度在2-15之间")
    private String name;

    @NotEmpty(message = "请输入正确的qq")
    private String qq;
    @NotNull
    @Range(min = 1, max = 9999,message = "范围必须在1-9999")
    private int onlineId;

    private String profession;
    private String startTime;
    private String graduatedFrom;
    private String dailyLink;
    private String wish;
    private String counselor;
    private String way;
    private Long createAt;
    private Long updateAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getGraduatedFrom() {
        return graduatedFrom;
    }

    public void setGraduatedFrom(String graduatedFrom) {
        this.graduatedFrom = graduatedFrom;
    }

    public int getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(int onlineId) {
        this.onlineId = onlineId;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
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
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", qq='").append(qq).append('\'');
        sb.append(", profession='").append(profession).append('\'');
        sb.append(", startTime='").append(startTime).append('\'');
        sb.append(", graduatedFrom='").append(graduatedFrom).append('\'');
        sb.append(", onlineId=").append(onlineId);
        sb.append(", dailyLink='").append(dailyLink).append('\'');
        sb.append(", wish='").append(wish).append('\'');
        sb.append(", counselor='").append(counselor).append('\'');
        sb.append(", way='").append(way).append('\'');
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append('}');
        return sb.toString();
    }
}
