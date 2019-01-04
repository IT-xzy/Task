package com.art.pojo;

public class First {
    private Integer id;

    private String name;

    private Boolean status;

    private Long createAt;

    private Long updateAt;

    private String updateBy;

    public First(Integer id, String name, Boolean status, Long createAt, Long updateAt, String updateBy) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public First() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("First{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", status=").append(status);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", updateBy='").append(updateBy).append('\'');
        sb.append('}');
        return sb.toString();
    }
}