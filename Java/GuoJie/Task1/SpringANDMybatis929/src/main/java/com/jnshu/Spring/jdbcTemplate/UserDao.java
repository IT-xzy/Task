package com.jnshu.Spring.jdbcTemplate;

import com.jnshu.Spring.User;

public interface UserDao {
    public User findById(int id);
}
