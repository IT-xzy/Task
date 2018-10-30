package com.jnshutask.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 24569
 */
@Data
public class TaMenu implements Serializable {
    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long modifyTime;

    /**
     * 菜单/按钮ID
     */
    private Long menuId;

    /**
     * 上级菜单ID
     */
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    private String menuName;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 权限名称标识
     */
    private String perms;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    private String type;

    /**
     * 排序
     */
    private Long orderNum;


}