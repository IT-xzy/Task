package com.jnshutask.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 24569
 */
@Data
public class TaRole implements Serializable {
    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long modifyTime;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String description;


}