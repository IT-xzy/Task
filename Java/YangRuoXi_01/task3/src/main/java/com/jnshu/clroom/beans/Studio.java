package com.jnshu.clroom.beans;

public class Studio {
    private Long id;

    private String studioName;

    private Boolean studioStatus;

    private Long createTime;

    private Long updateTime;

    private Long editerId;

    private Integer studioType;

    private String studioPicture;

    private String studioIntroduction;

    public Studio(Long id, String studioName, Boolean studioStatus, Long createTime, Long updateTime, Long editerId, Integer studioType, String studioPicture, String studioIntroduction) {
        this.id = id;
        this.studioName = studioName;
        this.studioStatus = studioStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.editerId = editerId;
        this.studioType = studioType;
        this.studioPicture = studioPicture;
        this.studioIntroduction = studioIntroduction;
    }

    public Studio() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName == null ? null : studioName.trim();
    }

    public Boolean getStudioStatus() {
        return studioStatus;
    }

    public void setStudioStatus(Boolean studioStatus) {
        this.studioStatus = studioStatus;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getEditerId() {
        return editerId;
    }

    public void setEditerId(Long editerId) {
        this.editerId = editerId;
    }

    public Integer getStudioType() {
        return studioType;
    }

    public void setStudioType(Integer studioType) {
        this.studioType = studioType;
    }

    public String getStudioPicture() {
        return studioPicture;
    }

    public void setStudioPicture(String studioPicture) {
        this.studioPicture = studioPicture == null ? null : studioPicture.trim();
    }

    public String getStudioIntroduction() {
        return studioIntroduction;
    }

    public void setStudioIntroduction(String studioIntroduction) {
        this.studioIntroduction = studioIntroduction == null ? null : studioIntroduction.trim();
    }
}