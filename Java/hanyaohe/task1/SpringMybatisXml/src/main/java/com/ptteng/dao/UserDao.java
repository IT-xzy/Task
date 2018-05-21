package com.ptteng.dao;

import com.ptteng.model.User;

import java.util.List;

public interface UserDao {
    //public User getUser(User user);
    public List<User> getUser(User user);
    public void addUser(User user);
     public void updateUser(User user);
     public void deleteUser(int UserId);
}
