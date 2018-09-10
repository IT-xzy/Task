package com.dao;

import com.entity.User;

public interface UserDao {
    Long register(User record);  //注册(插入数据)
    User login(User user);     //登录(根据用户名和密码查询)
    User findByName(String name);
    Long update(Long id);    //修改用户信息
    User findById(Long id);
    String findPasswordByName(String name);//查找注册时加密后的密码
}
