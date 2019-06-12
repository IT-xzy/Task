package jnshu.model;

public class Works {
    private Long id;

    private String worksName;

    private String shortIntroduction;

    private String smallPhoto;

    private String videoLink;

    private String worksPhoto;

    private String worksIntroduction;

    private Long firstName;

    private Long secondName;

    private Long status;

    private Long updateAt;

    private Long createAt;

    private Long updateBy;

    private Long createBy;

    @Override
    public String toString() {
        return "Works{" +
                "id=" + id +
                ", worksName='" + worksName + '\'' +
                ", shortIntroduction='" + shortIntroduction + '\'' +
                ", smallPhoto='" + smallPhoto + '\'' +
                ", videoLink='" + videoLink + '\'' +
                ", worksPhoto='" + worksPhoto + '\'' +
                ", worksIntroduction='" + worksIntroduction + '\'' +
                ", firstName=" + firstName +
                ", secondName=" + secondName +
                ", status=" + status +
                ", updateAt=" + updateAt +
                ", createAt=" + createAt +
                ", updateBy=" + updateBy +
                ", createBy=" + createBy +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorksName() {
        return worksName;
    }

    public void setWorksName(String worksName) {
        this.worksName = worksName == null ? null : worksName.trim();
    }

    public String getShortIntroduction() {
        return shortIntroduction;
    }

    public void setShortIntroduction(String shortIntroduction) {
        this.shortIntroduction = shortIntroduction == null ? null : shortIntroduction.trim();
    }

    public String getSmallPhoto() {
        return smallPhoto;
    }

    public void setSmallPhoto(String smallPhoto) {
        this.smallPhoto = smallPhoto == null ? null : smallPhoto.trim();
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink == null ? null : videoLink.trim();
    }

    public String getWorksPhoto() {
        return worksPhoto;
    }

    public void setWorksPhoto(String worksPhoto) {
        this.worksPhoto = worksPhoto == null ? null : worksPhoto.trim();
    }

    public String getWorksIntroduction() {
        return worksIntroduction;
    }

    public void setWorksIntroduction(String worksIntroduction) {
        this.worksIntroduction = worksIntroduction == null ? null : worksIntroduction.trim();
    }

    public Long getFirstName() {
        return firstName;
    }

    public void setFirstName(Long firstName) {
        this.firstName = firstName;
    }

    public Long getSecondName() {
        return secondName;
    }

    public void setSecondName(Long secondName) {
        this.secondName = secondName;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
}