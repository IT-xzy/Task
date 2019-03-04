package com.jnshu.clroom.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
@Getter
@Setter
public class Banner {
    private Long bannerId;

    private String bannerPicture;

    private String editerId;

    private String url;

    private Boolean bannerStatus;

    private Long createTime = System.currentTimeMillis();

    private Long updateTime;

    private String picture;

//    public Banner(Long bannerId, String bannerPicture, String editerId, String url, Boolean bannerStatus, Long createTime, Long updateTime, String picture) {
//        this.bannerId = bannerId;
//        this.bannerPicture = bannerPicture;
//        this.editerId = editerId;
//        this.url = url;
//        this.bannerStatus = bannerStatus;
//        this.createTime = createTime;
//        this.updateTime = updateTime;
//        this.picture = picture;
//    }
//
//    public Banner() {
//        super();
//    }
//
//    public Long getBannerId() {
//        return bannerId;
//    }
//
//    public void setBannerId(Long bannerId) {
//        this.bannerId = bannerId;
//    }
//
//    public String getBannerPicture() {
//        return bannerPicture;
//    }
//
//    public void setBannerPicture(String bannerPicture) {
//        this.bannerPicture = bannerPicture == null ? null : bannerPicture.trim();
//    }
//
//    public String getEditerId() {
//        return editerId;
//    }
//
//    public void setEditerId(String editerId) {
//        this.editerId = editerId == null ? null : editerId.trim();
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url == null ? null : url.trim();
//    }
//
//    public Boolean getBannerStatus() {
//        return bannerStatus;
//    }
//
//    public void setBannerStatus(Boolean bannerStatus) {
//        this.bannerStatus = bannerStatus;
//    }
//
//    public Long getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Long createTime) {
//        this.createTime = createTime;
//    }
//
//    public Long getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Long updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public String getPicture() {
//        return picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture == null ? null : picture.trim();
//    }
}