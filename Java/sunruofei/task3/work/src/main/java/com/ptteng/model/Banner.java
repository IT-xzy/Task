package com.ptteng.model;

public class Banner {
    private Long id;

    private String picture;

    private Long updateBy;

    private String url;

    private int state;

    private Long createAt;

    private Long updateAt;

    private Long createBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", updateBy=" + updateBy +
                ", url='" + url + '\'' +
                ", state=" + state +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                '}';
    }
}