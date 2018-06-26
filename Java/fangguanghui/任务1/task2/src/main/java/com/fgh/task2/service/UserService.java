package com.fgh.task2.service;

import com.fgh.task2.model.User;

import java.util.List;

public interface UserService {
     List<User> findUserBy(User user)throws Exception;
     Boolean insertUser(User user)throws Exception;
     Boolean delUser(int id)throws Exception;
     Boolean updateUser(User user)throws Exception;
     List<User> findAll()throws Exception;
     User findUserById(int id)throws Exception;
}
