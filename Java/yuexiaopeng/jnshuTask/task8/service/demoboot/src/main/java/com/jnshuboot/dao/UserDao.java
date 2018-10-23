package com.jnshuboot.dao;

import com.jnshuboot.pojo.SysUser;

public interface UserDao {
    public SysUser findByUserName(String username);
}
