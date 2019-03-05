package com.jnshu.clroom.beans;

public class Painting {
    private Long paintingId;

    private String paintingName;

    private Boolean paintingStatus;

    private Long createTime;

    private Long updateTime;

    private Long editerId;

    private Long paintingsId;

    private String paintingIntroduction;

    private String paintingPicture;

    private String videoUrl;

    private String paintingDetailPicture;

    private String introductionArticle;

    public Painting(Long paintingId, String paintingName, Boolean paintingStatus, Long createTime, Long updateTime, Long editerId, Long paintingsId, String paintingIntroduction, String paintingPicture, String videoUrl, String paintingDetailPicture, String introductionArticle) {
        this.paintingId = paintingId;
        this.paintingName = paintingName;
        this.paintingStatus = paintingStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.editerId = editerId;
        this.paintingsId = paintingsId;
        this.paintingIntroduction = paintingIntroduction;
        this.paintingPicture = paintingPicture;
        this.videoUrl = videoUrl;
        this.paintingDetailPicture = paintingDetailPicture;
        this.introductionArticle = introductionArticle;
    }

    public Painting() {
        super();
    }

    public Long getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(Long paintingId) {
        this.paintingId = paintingId;
    }

    public String getPaintingName() {
        return paintingName;
    }

    public void setPaintingName(String paintingName) {
        this.paintingName = paintingName == null ? null : paintingName.trim();
    }

    public Boolean getPaintingStatus() {
        return paintingStatus;
    }

    public void setPaintingStatus(Boolean paintingStatus) {
        this.paintingStatus = paintingStatus;
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

    public Long getPaintingsId() {
        return paintingsId;
    }

    public void setPaintingsId(Long paintingsId) {
        this.paintingsId = paintingsId;
    }

    public String getPaintingIntroduction() {
        return paintingIntroduction;
    }

    public void setPaintingIntroduction(String paintingIntroduction) {
        this.paintingIntroduction = paintingIntroduction == null ? null : paintingIntroduction.trim();
    }

    public String getPaintingPicture() {
        return paintingPicture;
    }

    public void setPaintingPicture(String paintingPicture) {
        this.paintingPicture = paintingPicture == null ? null : paintingPicture.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getPaintingDetailPicture() {
        return paintingDetailPicture;
    }

    public void setPaintingDetailPicture(String paintingDetailPicture) {
        this.paintingDetailPicture = paintingDetailPicture == null ? null : paintingDetailPicture.trim();
    }

    public String getIntroductionArticle() {
        return introductionArticle;
    }

    public void setIntroductionArticle(String introductionArticle) {
        this.introductionArticle = introductionArticle == null ? null : introductionArticle.trim();
    }
}