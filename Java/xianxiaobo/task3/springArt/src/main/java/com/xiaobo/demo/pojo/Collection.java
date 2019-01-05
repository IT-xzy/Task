package com.xiaobo.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class Collection {
    @ApiModelProperty(hidden = true)
    private Long id;

    @NotBlank(message = "collection_name不能为空")
    private String collection_name;

    private Integer status;
    @ApiModelProperty(hidden = true)
    private Long update_at;
    @ApiModelProperty(hidden = true)
    private Long update_by;
    @ApiModelProperty(hidden = true)
    private Long create_at;
    @ApiModelProperty(hidden = true)
    private Long create_by;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollection_name() {
        return collection_name;
    }

    public void setCollection_name(String collection_name) {
        this.collection_name = collection_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public Long getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(Long update_by) {
        this.update_by = update_by;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Long create_by) {
        this.create_by = create_by;
    }
}
