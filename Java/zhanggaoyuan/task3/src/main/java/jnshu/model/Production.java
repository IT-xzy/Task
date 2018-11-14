package jnshu.model;

public class Production {
    private Integer productionId;

    private String productionName;

    private Long creatTime;

    private Long updateTime;

    private Boolean productionPutaway;

    private Long productionPutawayTime;

    private Integer submenuId;

    public Integer getSubmenuId() {
        return submenuId;
    }

    public void setSubmenuId(Integer submenuId) {
        this.submenuId = submenuId;
    }

    private String artistName;

    private String productionFinishTime;

    private String productionSynopsis;

    private String productionDetail;

    private String productionExperience;

    private String imageLinks;

    private String videoLink;

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName == null ? null : productionName.trim();
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

    public Boolean getProductionPutaway() {
        return productionPutaway;
    }

    public void setProductionPutaway(Boolean productionPutaway) {
        this.productionPutaway = productionPutaway;
    }

    public Long getProductionPutawayTime() {
        return productionPutawayTime;
    }

    public void setProductionPutawayTime(Long productionPutawayTime) {
        this.productionPutawayTime = productionPutawayTime;
    }


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName == null ? null : artistName.trim();
    }

    public String getProductionFinishTime() {
        return productionFinishTime;
    }

    public void setProductionFinishTime(String productionFinishTime) {
        this.productionFinishTime = productionFinishTime == null ? null : productionFinishTime.trim();
    }

    public String getProductionSynopsis() {
        return productionSynopsis;
    }

    public void setProductionSynopsis(String productionSynopsis) {
        this.productionSynopsis = productionSynopsis == null ? null : productionSynopsis.trim();
    }

    public String getProductionDetail() {
        return productionDetail;
    }

    public void setProductionDetail(String productionDetail) {
        this.productionDetail = productionDetail == null ? null : productionDetail.trim();
    }

    public String getProductionExperience() {
        return productionExperience;
    }

    public void setProductionExperience(String productionExperience) {
        this.productionExperience = productionExperience == null ? null : productionExperience.trim();
    }

    public String getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(String imageLinks) {
        this.imageLinks = imageLinks == null ? null : imageLinks.trim();
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink == null ? null : videoLink.trim();
    }
}