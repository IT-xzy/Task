package com.jnshuboot.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 */
@Data
public class SysRoleUser implements Serializable {
    private Integer id;

    private Integer sysUserId;

    private Integer sysRoleId;

    private String sysUserName;

    private String sysRoleName;


}