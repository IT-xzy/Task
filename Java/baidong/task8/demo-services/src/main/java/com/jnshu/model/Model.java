package com.jnshu.model;

import java.io.Serializable;

public class Model implements Serializable {
    private static final long serialVersionUID = 89756313569789218L;
    private Long id;

    private String name;

    private Long careteAt;

    private String createBy;

    private Long updateAt;

    private String updateBy;

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", careteAt=" + careteAt +
                ", createBy='" + createBy + '\'' +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }

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

    public Long getCareteAt() {
        return careteAt;
    }

    public void setCareteAt(Long careteAt) {
        this.careteAt = careteAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
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
}