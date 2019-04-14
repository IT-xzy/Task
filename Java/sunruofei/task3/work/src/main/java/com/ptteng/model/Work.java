package com.ptteng.model;

public class Work {
    private Long id;

    private String name;

    private String introduction;

    private String smallPicture;

    private String videoLink;

    private String detailPicture;

    private String introductionWord;

    private Long createAt;

    private Long updateAt;

    private Long createBy;

    private Long updateBy;

    private Long secondCollectionId;

    private Long state;

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getSmallPicture() {
        return smallPicture;
    }

    public void setSmallPicture(String smallPicture) {
        this.smallPicture = smallPicture == null ? null : smallPicture.trim();
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink == null ? null : videoLink.trim();
    }

    public String getDetailPicture() {
        return detailPicture;
    }

    public void setDetailPicture(String detailPicture) {
        this.detailPicture = detailPicture == null ? null : detailPicture.trim();
    }

    public String getIntroductionWord() {
        return introductionWord;
    }

    public void setIntroductionWord(String introductionWord) {
        this.introductionWord = introductionWord == null ? null : introductionWord.trim();
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

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getSecondCollectionId() {
        return secondCollectionId;
    }

    public void setSecondCollectionId(Long secondCollectionId) {
        this.secondCollectionId = secondCollectionId;
    }

    @Override
    public String toString() {
        return "WorkService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", smallPicture='" + smallPicture + '\'' +
                ", videoLink='" + videoLink + '\'' +
                ", detailPicture='" + detailPicture + '\'' +
                ", introductionWord='" + introductionWord + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", secondCollectionId=" + secondCollectionId +
                '}';
    }
}