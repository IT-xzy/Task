package com.ptteng.model;

public class SecondCollection {
    private Long id;

    private String name;

    private Long state;

    private Long createAt;

    private Long updateAt;

    private Long createBy;

    private Long updateBy;

    private Long firstCollectionId;

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
        this.name = name == null ? null : name.trim();
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
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

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getFirstCollectionId() {
        return firstCollectionId;
    }

    public void setFirstCollectionId(Long firstCollectionId) {
        this.firstCollectionId = firstCollectionId;
    }

    @Override
    public String toString() {
        return "SecondCollection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", firstCollectionId=" + firstCollectionId +
                '}';
    }
}