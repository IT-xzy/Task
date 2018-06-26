package com.task.dao;

import com.task.entity.User;

public interface UserDao {
    User findByUsername(String username);
}