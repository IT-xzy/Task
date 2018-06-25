package com.task.service;

import com.task.entity.User;

//Service层接口
public interface UserService {

    //检验用户登录
    User checkLogin(String username, String password);
    User checkLogin(String username);
}