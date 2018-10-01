package com.service;

import com.model.Page;
import com.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    boolean deleteById(User user);
    User selectById(User user);
    int total();
    List<User> selectAll(Page page);

    boolean deleteByName(User user);
    int updateTypeByName(User user);
    User selectByName(User user);
}
