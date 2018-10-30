package com.task5.service;

import com.task5.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    String login(User user)throws Exception;
    String register(User user,String SmsCheckCode,String EmailCheckCode)throws Exception;
    User findUserByPhoneNumber(String phoneNumber)throws Exception;
    User findUserByEmail(String email)throws Exception;
    //查询用户登录信息是否匹配
    User checkUser(@Param("userName")String userName, @Param("password")String password)throws Exception;
    //查询用户是否存在
    User findUserByName(String userName)throws Exception;
    //增加用户
    Integer addUser(User user)throws Exception;
    //更改用户
    Integer updateUser(User user)throws Exception;

    User findUserById(int id)throws Exception;
}
