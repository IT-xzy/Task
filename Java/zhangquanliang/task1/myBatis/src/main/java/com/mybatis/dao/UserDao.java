package com.mybatis.dao;

import com.mybatis.pojo.User;

import java.util.List;

/**
 * created by suger on 2018/9/26
 */
public interface UserDao {
    long insert(User user);
    int update(User user);
    int delete(Long userId);
    List<User> getUsers();
    List<User> getUserByName(String userName);
    List<User> getUserByonlineId(int onlineId);
}
