package com.artist.pojo;


/**
 * 图片或者视频对应的实例
 */
public class ImageAndVideo {
    private int imgVideoId;
    private String imgVideName;
    private String type;
    private Integer productionId;
    private Long uploadTime;
    private Long updateTime;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public int getImgVideoId() {
        return imgVideoId;
    }

    public void setImgVideoId(int imgVideoId) {
        this.imgVideoId = imgVideoId;
    }

    public String getImgVideName() {
        return imgVideName;
    }

    public void setImgVideName(String imgVideName) {
        this.imgVideName = imgVideName;
    }

    public int getProductionId() {
        return productionId;
    }

    public void setProductionId(int productionId) {
        this.productionId = productionId;
    }

    public Long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Long uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ImageAndVideo{" +
                "imgVideoId=" + imgVideoId +
                ", imgVideName='" + imgVideName + '\'' +
                ", type='" + type + '\'' +
                ", productionId=" + productionId +
                ", uploadTime=" + uploadTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
