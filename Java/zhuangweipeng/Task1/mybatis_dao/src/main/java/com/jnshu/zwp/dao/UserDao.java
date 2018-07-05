package com.jnshu.zwp.dao;

import com.jnshu.zwp.domain.User;

import java.util.List;

public interface UserDao {
    public User findUserById(int id) throws Exception ;
    public List<User> findAllUsers() throws Exception;
    public void insertUser(User user) throws Exception;
    public void deleteUserById(int id) throws Exception;
    public void updateUserEmp(User user) throws Exception;
}
