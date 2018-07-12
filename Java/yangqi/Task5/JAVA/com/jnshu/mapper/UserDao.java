package com.jnshu.mapper;

import com.jnshu.entity.User;

public interface UserDao {

    //登录 和 注册

    User findUserByname(String name);

    public void register(User user);

    User selectByid(long id);

    User selectByuser(String name, String password);

    void updateTimeByid(long id);
}
