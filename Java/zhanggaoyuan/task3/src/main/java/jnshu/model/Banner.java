package jnshu.model;

import java.util.List;

public class Banner {
    private Integer bannerId;

    private Long creatTime;

    private Long updateTime;

    private Boolean bannerStatus;

    private Long bannerPutawayTime;

    private String bannerRedactor;

    private Integer productionId;

    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
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

    public Boolean getBannerStatus() {
        return bannerStatus;
    }

    public void setBannerStatus(Boolean bannerStatus) {
        this.bannerStatus = bannerStatus;
    }

    public Long getBannerPutawayTime() {
        return bannerPutawayTime;
    }

    public void setBannerPutawayTime(Long bannerPutawayTime) {
        this.bannerPutawayTime = bannerPutawayTime;
    }

    public String getBannerRedactor() {
        return bannerRedactor;
    }

    public void setBannerRedactor(String bannerRedactor) {
        this.bannerRedactor = bannerRedactor == null ? null : bannerRedactor.trim();
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }
}