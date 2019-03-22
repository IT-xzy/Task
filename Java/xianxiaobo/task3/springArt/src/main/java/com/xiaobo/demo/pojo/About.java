package com.xiaobo.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class About {
    @ApiModelProperty(hidden = true)
    private Long id;

    private Integer status;
    @NotNull(message = "about_type不能为空")
    private Integer about_type;

    private String image;
    @NotBlank(message = "content不能为空")
    private String content;
    @ApiModelProperty(hidden = true)
    private Long create_at;
    @ApiModelProperty(hidden = true)
    private Long create_by;
    @ApiModelProperty(hidden = true)
    private Long update_at;
    @ApiModelProperty(hidden = true)
    private Long update_by;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAbout_type() {
        return about_type;
    }

    public void setAbout_type(Integer about_type) {
        this.about_type = about_type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
