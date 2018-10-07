package com.jnshu.jdbctemplate.dao;

import com.jnshu.jdbctemplate.pojo.User;

import java.util.List;

public interface UserDao {
    public int insert(User user);
    public boolean delect(User user);
    public int updata(User user);
    public List<User> getAll();

}
