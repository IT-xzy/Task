package com.xiaobo.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class Category {
    @ApiModelProperty(hidden = true)
    private Long id;

    @NotBlank(message = "category_name不能为空")
    private String category_name;

    @NotNull(message = "collection_id不能为空")
    private Long collection_id;

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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Long getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(Long collection_id) {
        this.collection_id = collection_id;
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
