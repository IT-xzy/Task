package com.jnshu.pojo;

public class SecondWork {
    private Long id;

    private String name;

    private Long firstName;

    private Integer status;

    private Long createAt;

    private Long updateAt;

    private String updateBy;

    private String createBy;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFirstName() {
        return firstName;
    }

    public void setFirstName(long firstName) {
        this.firstName = firstName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "SecondWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName=" + firstName +
                ", status=" + status +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}