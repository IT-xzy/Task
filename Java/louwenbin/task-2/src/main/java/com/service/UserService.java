package com.service;

import com.entity.User;

import java.util.List;


public interface UserService {
    User selectUser(int id);

    void insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);

    List<User> getAll();
}
