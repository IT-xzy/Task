package com.task.dao;

import com.task.entity.User;

public interface UserDao {
    User findByUsername(String username);
    User findByPhone(String phone);
    User findByEmail(String email);

//    多条件查询
    User findBySign(String username);

    //增加用户
    void addUser(User user);
}