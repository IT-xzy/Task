package com.hgc.dao;

import com.hgc.pojo.User;

public interface UserDao {
    public User findById(int id);
    public void insertUser(User user);
}
