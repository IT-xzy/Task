package com.service;

import com.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    Boolean register(User user);  //注册(插入数据)
    User login(User user, HttpServletResponse response); //登录(根据用户名和密码查询)
    void logout(HttpServletResponse response, HttpServletRequest request);//注销
    User findByName(String name);
    String findPasswordByName(String name);//查找注册时加密后的密码

}
