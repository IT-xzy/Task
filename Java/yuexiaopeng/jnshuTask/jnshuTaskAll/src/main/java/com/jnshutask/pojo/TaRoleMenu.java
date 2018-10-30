package com.jnshutask.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 24569
 */
@Data
public class TaRoleMenu implements Serializable {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单/按钮ID
     */
    private Long menuId;


}