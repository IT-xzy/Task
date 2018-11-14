package jnshu.model;

public class Studio {
    private Integer studioId;

    private Long creatTime;

    private Long updateTime;

    private String studioName;

    private String studioDetail;

    private String studioContactWay;

    private Boolean studioPutaway;

    public Boolean getStudioPutaway() {
        return studioPutaway;
    }

    public void setStudioPutaway(Boolean studioPutaway) {
        this.studioPutaway = studioPutaway;
    }

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
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

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName == null ? null : studioName.trim();
    }

    public String getStudioDetail() {
        return studioDetail;
    }

    public void setStudioDetail(String studioDetail) {
        this.studioDetail = studioDetail == null ? null : studioDetail.trim();
    }

    public String getStudioContactWay() {
        return studioContactWay;
    }

    public void setStudioContactWay(String studioContactWay) {
        this.studioContactWay = studioContactWay == null ? null : studioContactWay.trim();
    }
}