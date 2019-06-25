package cn.wp.model;

public class Works {
    private Long id;

    private String name;

    private String introduction;

    private String thumbnail;

    private String videoLink;

    private String detailPicture;

    private String introductionWord;

    private Long collectionManageId;

    private Long createAt;

    private Long updateAt;

    private Long createBy;

    private Long updateBy;

    private Long state;

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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getvideoLink() {
        return videoLink;
    }

    public void setvideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getdetailPicture() {
        return detailPicture;
    }

    public void setdetailPicture(String detailPicture) {
        this.detailPicture = detailPicture;
    }

    public String getintroductionWord() {
        return introductionWord;
    }

    public void setintroductionWord(String introductionWord) {
        this.introductionWord = introductionWord;
    }

    public Long getcollectionManageId() {
        return collectionManageId;
    }

    public void setcollectionManageId(Long collectionManageId) {
        this.collectionManageId = collectionManageId;
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

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Works{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", videoLink='" + videoLink + '\'' +
                ", detailPicture='" + detailPicture + '\'' +
                ", introductionWord='" + introductionWord + '\'' +
                ", collectionManageId=" + collectionManageId +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", state=" + state +
                '}';
    }
}