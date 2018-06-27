package com.task.service;

import com.task.entity.User;

//Service层接口
public interface UserService {

    //检验用户登录
    User checkLogin(String username, String password);


    User checkLogin(String username);

    int checkLogin(User user);

    //检测用户是否存在
    User checkExist(String username);
    //增加新用户
    void addUser(User user);

    int checkPhone(String phone);

    int checkEmail(String email);

    int checkUsername(String username);
}