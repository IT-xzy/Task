package com.fgh.Mybatis.service;

import com.fgh.Mybatis.model.User;

import java.util.List;

public interface UserService {
    public List<User> findUserBy(User user)throws Exception;
    public boolean insertUser(User user)throws Exception;
    public boolean delUser(int id)throws Exception;
    public boolean updateUser(User user)throws Exception;
    public List<User> findAll()throws Exception;
}
