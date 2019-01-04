package jnshu.model;

public class People {
    private Integer peopleId;

    private Long creatTime;

    private Long updateTime;

    private String peopleName;

    private String peopleImage;

    private String peopleDetail;

    private String peopleProductionIntro;

    private String peopleContactWay;

    private Boolean ifArtist;

    private Boolean ifWorker;

    private Boolean peoplePutaway;

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName == null ? null : peopleName.trim();
    }

    public String getPeopleImage() {
        return peopleImage;
    }

    public void setPeopleImage(String peopleImage) {
        this.peopleImage = peopleImage == null ? null : peopleImage.trim();
    }

    public String getPeopleDetail() {
        return peopleDetail;
    }

    public void setPeopleDetail(String peopleDetail) {
        this.peopleDetail = peopleDetail == null ? null : peopleDetail.trim();
    }

    public String getPeopleProductionIntro() {
        return peopleProductionIntro;
    }

    public void setPeopleProductionIntro(String peopleProductionIntro) {
        this.peopleProductionIntro = peopleProductionIntro == null ? null : peopleProductionIntro.trim();
    }

    public String getPeopleContactWay() {
        return peopleContactWay;
    }

    public void setPeopleContactWay(String peopleContactWay) {
        this.peopleContactWay = peopleContactWay == null ? null : peopleContactWay.trim();
    }

    public Boolean getIfArtist() {
        return ifArtist;
    }

    public void setIfArtist(Boolean ifArtist) {
        this.ifArtist = ifArtist;
    }

    public Boolean getIfWorker() {
        return ifWorker;
    }

    public void setIfWorker(Boolean ifWorker) {
        this.ifWorker = ifWorker;
    }

    public Boolean getPeoplePutaway() {
        return peoplePutaway;
    }

    public void setPeoplePutaway(Boolean peoplePutaway) {
        this.peoplePutaway = peoplePutaway;
    }
}