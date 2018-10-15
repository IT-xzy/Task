package com.ptteng.entity;

public class Banner {

    private Long id;
    private String coverUrl;
    private Integer status;
    private String turnUrl;
    private String introduction;
    private Long createAt;
    private Long updateAt;
    private Long createBy;
    private Long updateBy;

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", coverUrl='" + coverUrl + '\'' +
                ", status=" + status +
                ", turnUrl='" + turnUrl + '\'' +
                ", introduction='" + introduction + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTurnUrl() {
        return turnUrl;
    }

    public void setTurnUrl(String turnUrl) {
        this.turnUrl = turnUrl;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
}
