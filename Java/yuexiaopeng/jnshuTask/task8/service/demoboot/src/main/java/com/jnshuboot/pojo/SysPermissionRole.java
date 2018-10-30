package com.jnshuboot.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 */
@Data
public class SysPermissionRole implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    private String description;


}