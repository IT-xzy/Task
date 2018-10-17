package com.ptteng.service;

import com.ptteng.dao.UserDao;
import com.ptteng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public User check(User user) {
        return userDao.check(user);
    }

    public long register(User user) {
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        return userDao.register(user);
    }
}
