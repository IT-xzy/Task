package com.jnshu.mybatis.dao;

import com.jnshu.mybatis.pojo.User1;

import java.util.List;

public interface UserDao1 {
    public List<User1> getUser(int id);
    public void deleteUser(int id);
    public void updateUser(User1 user1);
    public void insertUser(User1 user1);

}
