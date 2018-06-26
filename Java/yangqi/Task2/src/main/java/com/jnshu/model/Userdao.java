package com.jnshu.model;

import com.jnshu.entity.User;

import java.util.List;

public interface Userdao {
    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int i);

    List<User> findUserByName(String user);

    User findUserById(int id);

    List<User> findUser(User user);
}
