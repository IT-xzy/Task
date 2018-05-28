package com.jdbc.dao;


import com.jdbc.pojo.User;

import java.util.List;

public interface UserDao {

    public void insert(User user)throws Exception;

    public void delete(int i);

    public void update(User user);

    public User selectById(int i);

    public List<User> selectAll();
}
