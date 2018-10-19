package com.jnshu.entity;

import javax.persistence.*;

public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 轮播图跳转链接
     */
    private String url;

    /**
     * 配图链接
     */
    private String img;

    /**
     * 状态，0：草稿，1：发布
     */
    private Boolean state;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 类型，什么类型再看看需求
     */
    private Boolean type;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_at")
    private Long createAt;

    /**
     * 编辑者
     */
    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_at")
    private Long updateAt;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取轮播图跳转链接
     *
     * @return url - 轮播图跳转链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置轮播图跳转链接
     *
     * @param url 轮播图跳转链接
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取配图链接
     *
     * @return img - 配图链接
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置配图链接
     *
     * @param img 配图链接
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 获取状态，0：草稿，1：发布
     *
     * @return state - 状态，0：草稿，1：发布
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置状态，0：草稿，1：发布
     *
     * @param state 状态，0：草稿，1：发布
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Long getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * 获取类型，什么类型再看看需求
     *
     * @return type - 类型，什么类型再看看需求
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置类型，什么类型再看看需求
     *
     * @param type 类型，什么类型再看看需求
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * @return create_at
     */
    public Long getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt
     */
    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    /**
     * 获取编辑者
     *
     * @return update_by - 编辑者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置编辑者
     *
     * @param updateBy 编辑者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * @return update_at
     */
    public Long getUpdateAt() {
        return updateAt;
    }

    /**
     * @param updateAt
     */
    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}