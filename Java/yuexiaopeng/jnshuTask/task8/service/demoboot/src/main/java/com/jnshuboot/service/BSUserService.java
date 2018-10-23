package com.jnshuboot.service;


import com.jnshuboot.pojo.SysRoleUser;
import com.jnshuboot.pojo.SysUser;

import java.util.List;

public interface BSUserService {
    List<SysRoleUser> selectUsers();

    SysRoleUser selectByUserId(Integer userId);

    int insertUser(SysUser sysUser, SysRoleUser sysRoleUser);

    int deleteUser(Integer userId);

    int updateUser(Integer userId, SysRoleUser sysRoleUser);
}
