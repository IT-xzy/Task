package com.jnshu.service;

import com.jnshu.entity.User;

import java.util.List;

public interface YserService {
    User queryId(int i) throws Exception;

    List<User> queryName(String user) throws Exception;

    boolean addUser(User user) throws Exception;

    boolean updateUser(User user) throws Exception;

    boolean deleteUser(int i) throws Exception;

    boolean updateId(int id, User user) throws Exception;

    List<User> queryUser(User user) throws Exception;


}
