package com.jnshu.entity;

import javax.persistence.*;

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer number;

    private Integer qq;

    @Column(name = "coach_name")
    private String coachName;

    @Column(name = "daily_link")
    private String dailyLink;

    @Column(name = "grade_colleage")
    private String gradeColleage;

    @Column(name = "create_at")
    private Long createAt;

    @Column(name = "update_at")
    private Long updateAt;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return qq
     */
    public Integer getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(Integer qq) {
        this.qq = qq;
    }

    /**
     * @return coach_name
     */
    public String getCoachName() {
        return coachName;
    }

    /**
     * @param coachName
     */
    public void setCoachName(String coachName) {
        this.coachName = coachName == null ? null : coachName.trim();
    }

    /**
     * @return daily_link
     */
    public String getDailyLink() {
        return dailyLink;
    }

    /**
     * @param dailyLink
     */
    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink == null ? null : dailyLink.trim();
    }

    /**
     * @return grade_colleage
     */
    public String getGradeColleage() {
        return gradeColleage;
    }

    /**
     * @param gradeColleage
     */
    public void setGradeColleage(String gradeColleage) {
        this.gradeColleage = gradeColleage == null ? null : gradeColleage.trim();
    }

    /**
     * @return create_at
     */
    public Long getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt
     */
    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    /**
     * @return update_at
     */
    public Long getUpdateAt() {
        return updateAt;
    }

    /**
     * @param updateAt
     */
    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}