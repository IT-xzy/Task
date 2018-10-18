package com.jnshu.entity;

import javax.persistence.*;

public class Second {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 所属一级作品集id
     */
    @Column(name = "first_id")
    private Long firstId;

    /**
     * 所属一级作品集名称
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * 二级作品集名称
     */
    private String name;

    /**
     * 上下架状态
     */
    private Boolean status;

    @Column(name = "create_at")
    private Long createAt;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_at")
    private Long updateAt;

    @Column(name = "update_by")
    private String updateBy;

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
     * 获取所属一级作品集id
     *
     * @return first_id - 所属一级作品集id
     */
    public Long getFirstId() {
        return firstId;
    }

    /**
     * 设置所属一级作品集id
     *
     * @param firstId 所属一级作品集id
     */
    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }

    /**
     * 获取所属一级作品集名称
     *
     * @return first_name - 所属一级作品集名称
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置所属一级作品集名称
     *
     * @param firstName 所属一级作品集名称
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    /**
     * 获取二级作品集名称
     *
     * @return name - 二级作品集名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置二级作品集名称
     *
     * @param name 二级作品集名称
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
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
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

    /**
     * @return update_by
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}