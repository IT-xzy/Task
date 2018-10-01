package com.task6.service;

import com.task6.pojo.User;

import java.util.List;

public interface UserService {
    //    查询所有数据
    List<User> selectAll();



    //    动态修改
    boolean updateUser(User user);
}
