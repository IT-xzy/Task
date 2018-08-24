package com.jnshu.czm.service.impl;

import com.jnshu.czm.dao.UserDao;
import com.jnshu.czm.model.User;
import com.jnshu.czm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    //单条查询
    public User findUserById(int userId) {
        User user = userDao.findUserById(userId);
        return user;
    }


    //查询全部
    @Override
    public List<User> findAll() {
        List<User> user = userDao.findAll();
        return user;
    }

    //查询记录条数
    @Override
    public int selectCount(){
        return userDao.selectCount();
    }



}

