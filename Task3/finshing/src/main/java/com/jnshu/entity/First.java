package com.jnshu.entity;

import javax.persistence.*;

public class First {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 一级作品集名称
     */
    private String name;

    /**
     * 上下架状态
     */
    private Boolean status;

    /**
     * 排序规则
     */
    private Boolean sort;

    /**
     * 被谁创建
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
     * 获取一级作品集名称
     *
     * @return name - 一级作品集名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置一级作品集名称
     *
     * @param name 一级作品集名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取上下架状态
     *
     * @return status - 上下架状态
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置上下架状态
     *
     * @param status 上下架状态
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取排序规则
     *
     * @return sort - 排序规则
     */
    public Boolean getSort() {
        return sort;
    }

    /**
     * 设置排序规则
     *
     * @param sort 排序规则
     */
    public void setSort(Boolean sort) {
        this.sort = sort;
    }

    /**
     * 获取被谁创建
     *
     * @return create_by - 被谁创建
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置被谁创建
     *
     * @param createBy 被谁创建
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