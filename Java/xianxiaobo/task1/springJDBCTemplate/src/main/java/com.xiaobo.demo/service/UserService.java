package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.UserDao;
import com.xiaobo.demo.dto.User;

import java.util.List;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    public List<User> getAll(){
        return userDao.getAll();
    }
    public User getUserById(Integer id){
        return userDao.getUserById(id);
    }
    public Integer addUser(User user){
        return userDao.addUser(user);
    }
    public Boolean deleteUser(Integer id){
        return userDao.deleteUser(id);
    }
    public Boolean updateUser(User user){
        return userDao.updateUser(user);
    }
}
