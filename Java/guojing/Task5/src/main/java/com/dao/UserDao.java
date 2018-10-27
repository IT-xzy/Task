package com.dao;


import com.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    Long register(User user);
    User login(String name);
}
