package cn.wp.model;

public class CollectionManage {
    private Long id;

    private String name;

    private Long state;

    private Long collectionClassId;

    private Long createAt;

    private Long updateAt;

    private Long createBy;

    private Long updateBy;

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
        this.name = name;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getcollectionClassId() {
        return collectionClassId;
    }

    public void setcollectionClassId(Long collectionClassId) {
        this.collectionClassId = collectionClassId;
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

    @Override
    public String toString() {
        return "CollectionManage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", collectionClassId=" + collectionClassId +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                '}';
    }
}