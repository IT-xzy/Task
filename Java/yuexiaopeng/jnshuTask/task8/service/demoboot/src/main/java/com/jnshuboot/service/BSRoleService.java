package com.jnshuboot.service;

import com.jnshuboot.pojo.SysPermissionRole;
import com.jnshuboot.pojo.SysRole;

import java.util.List;

public interface BSRoleService {

    List<SysPermissionRole> selectRole();

    SysPermissionRole selectByRoleId(Integer roleId);

    int insertRole(SysRole sysRole, SysPermissionRole sysPermissionRole);

    int deleteRole(Integer roleId);

    int updateRole(Integer roleId, SysPermissionRole sysPermissionRole);
}
