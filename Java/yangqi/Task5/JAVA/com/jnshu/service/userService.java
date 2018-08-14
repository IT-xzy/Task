package com.jnshu.service;

import com.jnshu.entity.User;

public interface userService {

    void regist(User user);

    User findUserByname(String name);

    User selectByuser(String name, String password);

    void updateTimeByid(long id);

    User selectByid(long id);

}
