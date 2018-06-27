package com.task.dao;

import com.task.models.User;

public interface UserDao {
    Boolean addUser(User user);//增
    Boolean updateUser(User user); //改
    Boolean deleteUser(int id);//删
    User getUserByName(String username);//查
    Boolean updateLoginTime(User user);//更新登录时间
}
