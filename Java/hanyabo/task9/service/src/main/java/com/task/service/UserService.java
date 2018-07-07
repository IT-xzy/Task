package com.task.service;

import com.task.entity.User;
import org.oasisopen.sca.annotation.Remotable;

//Service层接口
@Remotable
public interface UserService {

    //检验用户登录
    User checkLogin(String username, String password);


    User checkLoginByUsername(String username);

    int checkLoginByUser(User user);

    //检测用户是否存在
    User checkExist(String username);
    //增加新用户
    void addUser(User user);

    int checkPhone(String phone);

    int checkEmail(String email);

    int checkUsername(String username);
}