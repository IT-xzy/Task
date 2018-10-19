package com.jnshu.annotation.dao;

import com.jnshu.annotation.pojo.User;

import java.util.List;
public interface UserDao {
    int insert(User user);
    boolean delect(User user);
    int updata(User user);
    List<User> getAll();
}
