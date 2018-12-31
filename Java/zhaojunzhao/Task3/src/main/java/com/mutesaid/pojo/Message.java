package com.mutesaid.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Message implements Serializable {
    /**
     * 留言序号
     */
    private Long id;

    private Long workId;

    private String workName;

    /**
     * 精选留言和普通留言
     */
    private Boolean status;

    /**
     * 留言游客昵称
     */
    private String visitorName;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 编辑人
     */
    private Long adminId;

    /**
     * 创建时间
     */
    private Long createAt;

    /**
     * 后台修改时间
     */
    private Long updateAt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Message other = (Message) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVisitorName() == null ? other.getVisitorName() == null : this.getVisitorName().equals(other.getVisitorName()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVisitorName() == null) ? 0 : getVisitorName().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", visitorName=").append(visitorName);
        sb.append(", content=").append(content);
        sb.append(", adminId=").append(adminId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}