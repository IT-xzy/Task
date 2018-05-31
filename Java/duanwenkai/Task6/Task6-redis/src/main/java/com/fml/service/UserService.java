package com.fml.service;

import com.fml.pojo.User;

import java.util.List;

public interface UserService {

    boolean add(User user);

    boolean deleteById(long id);

    boolean update(User user);

    User getById(long id);

    User getByName(String name);

    User getByEmail(String email);

    List<User> getListByName(String name);

    long getTotalCount();
}
