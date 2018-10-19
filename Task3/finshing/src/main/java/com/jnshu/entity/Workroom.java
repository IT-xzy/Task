package com.jnshu.entity;

import javax.persistence.*;

public class Workroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 工作室名称
     */
    private String name;

    /**
     * 简介类型，0：艺术家简介，1：工作室简介，2：成员简介
     */
    private Boolean type;

    /**
     * 上下架状态0：下架，1：上架
     */
    private Boolean status;

    /**
     * 正文，富文本编辑
     */
    private String context;

    /**
     * img1，img2，img3三张图片
     */
    private String img1;

    private String img2;

    private String img3;

    /**
     * 工作室被谁创建
     */
    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_at")
    private Long createAt;

    /**
     * 工作室被谁更新
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
     * 获取工作室名称
     *
     * @return name - 工作室名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置工作室名称
     *
     * @param name 工作室名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取简介类型，0：艺术家简介，1：工作室简介，2：成员简介
     *
     * @return type - 简介类型，0：艺术家简介，1：工作室简介，2：成员简介
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置简介类型，0：艺术家简介，1：工作室简介，2：成员简介
     *
     * @param type 简介类型，0：艺术家简介，1：工作室简介，2：成员简介
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取上下架状态0：下架，1：上架
     *
     * @return status - 上下架状态0：下架，1：上架
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置上下架状态0：下架，1：上架
     *
     * @param status 上下架状态0：下架，1：上架
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取正文，富文本编辑
     *
     * @return context - 正文，富文本编辑
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置正文，富文本编辑
     *
     * @param context 正文，富文本编辑
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * 获取img1，img2，img3三张图片
     *
     * @return img1 - img1，img2，img3三张图片
     */
    public String getImg1() {
        return img1;
    }

    /**
     * 设置img1，img2，img3三张图片
     *
     * @param img1 img1，img2，img3三张图片
     */
    public void setImg1(String img1) {
        this.img1 = img1 == null ? null : img1.trim();
    }

    /**
     * @return img2
     */
    public String getImg2() {
        return img2;
    }

    /**
     * @param img2
     */
    public void setImg2(String img2) {
        this.img2 = img2 == null ? null : img2.trim();
    }

    /**
     * @return img3
     */
    public String getImg3() {
        return img3;
    }

    /**
     * @param img3
     */
    public void setImg3(String img3) {
        this.img3 = img3 == null ? null : img3.trim();
    }

    /**
     * 获取工作室被谁创建
     *
     * @return create_by - 工作室被谁创建
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置工作室被谁创建
     *
     * @param createBy 工作室被谁创建
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
     * 获取工作室被谁更新
     *
     * @return update_by - 工作室被谁更新
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置工作室被谁更新
     *
     * @param updateBy 工作室被谁更新
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