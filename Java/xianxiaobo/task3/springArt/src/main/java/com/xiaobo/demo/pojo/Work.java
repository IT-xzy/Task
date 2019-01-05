package com.xiaobo.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class Work {
    @ApiModelProperty(hidden = true)
    private Long id;
    @NotBlank(message = "work_name不能为空")
    private String work_name;

    private Integer status;

    private String introduction;

    private String image_mini;

    private String video;

    private String article;

    private String image;
    @NotNull(message = "category_id不能为空")
    private Long category_id;
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

    public String getWork_name() {
        return work_name;
    }

    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImage_mini() {
        return image_mini;
    }

    public void setImage_mini(String image_mini) {
        this.image_mini = image_mini;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
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
