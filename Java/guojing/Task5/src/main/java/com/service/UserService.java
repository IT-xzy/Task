package com.service;


import com.entity.User;

public interface UserService {
    Long register(User user);

    User login(String name);
}
