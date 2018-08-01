package com.dao;

import com.model.User;


public interface UserDao {
    //增
    public long addUser(User user);
    //删
    public boolean deleteUser(User user);
    //改
    public boolean updateUser(User user);
    //查
    public User selectUser(User user);
}
