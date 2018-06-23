package com.task.service.impl;

import com.task.dao.UserDao;
import com.task.entity.User;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User checkLogin(String username, String password) {

        User user = userDao.findByUsername(username);
        if(user != null && user.getPassword().equals(password)){

            return user;
        }
        return null;
    }


    public User checkLogin(String username) {

        User user = userDao.findByUsername(username);
        if(user != null){
            return user;
        }
        return null;
    }
}
