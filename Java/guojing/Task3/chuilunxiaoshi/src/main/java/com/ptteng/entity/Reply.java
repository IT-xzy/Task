package com.ptteng.entity;


public class Reply {
    private Long id;
    private String message;
    private Long bbdId;
    private Long createAt;
    private Long updateAt;
    private Long createBy;
    private Long updateBy;;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", bbdId=" + bbdId +
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getBbdId() {
        return bbdId;
    }

    public void setBbdId(Long bbdId) {
        this.bbdId = bbdId;
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
