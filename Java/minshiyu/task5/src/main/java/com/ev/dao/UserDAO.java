package com.ev.dao;

import com.ev.entity.User;

import java.sql.SQLException;

public interface UserDAO {

    //姓名查找
    User selectByName(String name) throws SQLException;

    //email查找
    User selectByEmail(String email) throws SQLException;

    //手机号码查找
    User selectByPhoneNumber(String number) throws SQLException;

    //ID查找
    User selectById(Long id) throws SQLException;

    //增加用户
    Long addUser(User user) throws SQLException;

}

