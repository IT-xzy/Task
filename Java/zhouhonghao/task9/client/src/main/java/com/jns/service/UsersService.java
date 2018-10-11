package com.jns.service;

import com.jns.entity.Users;

import java.util.List;

public interface UsersService {
    //定义方法，以便controller层的使用

    //添加用户
    void add(Users users);
    //修改用户信息
    void update(Users users);
    //获取所有用户信息
    List<Users> list();
    //根据用户phone，查找该用户
    Users getByPhone(String phone);
    //根据用户name，查找该用户
    void  updateOther(Users users);
    Users getByName(String name);
    //验证用户登录信息是否正确
    Users checkLogin(String phone ,String password);
}
