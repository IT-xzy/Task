package com.jnshuboot.dao;

import com.jnshuboot.pojo.SysPermissionRole;
import com.jnshuboot.pojo.example.SysPermissionRoleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysPermissionRoleMapper {
    long countByExample(SysPermissionRoleExample example);

    int deleteByExample(SysPermissionRoleExample example);

    int insert(SysPermissionRole record);

    int insertSelective(SysPermissionRole record);

    List<SysPermissionRole> selectByExample(SysPermissionRoleExample example);

    int updateByExampleSelective(@Param("record") SysPermissionRole record, @Param("example") SysPermissionRoleExample example);

    int updateByExample(@Param("record") SysPermissionRole record, @Param("example") SysPermissionRoleExample example);
}