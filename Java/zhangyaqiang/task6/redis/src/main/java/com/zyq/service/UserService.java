package com.zyq.service;

import com.zyq.pojo.User;

public interface UserService {
    void insert(User user);

    User selectByUserName(String username);

    Integer selectIdById(Integer id);

    String selectPwdByUserName(String username);
}
