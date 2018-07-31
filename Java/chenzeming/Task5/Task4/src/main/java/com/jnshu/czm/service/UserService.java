package com.jnshu.czm.service;

import com.jnshu.czm.model.User;

import java.util.List;

public interface UserService {


    public User findUserById(int userId);

    public List<User> findAll();

    public int selectCount();


}

