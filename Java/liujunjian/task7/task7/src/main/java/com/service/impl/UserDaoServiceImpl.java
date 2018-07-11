package com.service.impl;

import com.dao.UserDao;
import com.exception.MyException;
import com.pojo.User;
import com.service.UserDaoService;
import com.tools.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;

public class UserDaoServiceImpl implements UserDaoService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MD5Util md5Util;

    @Override
    public boolean login(User user) throws MyException, NoSuchAlgorithmException {
        User user1 = userDao.findUserByName(user.getUsername());
        if (user1 == null) {
            throw new MyException("没有此用户");
        }
        return md5Util.checkPassword(user.getPassword(), user1.getPassword());
    }

    @Override
    public boolean register(User user) throws MyException, NoSuchAlgorithmException {
        if (user.getUsername().trim().length() <= 0) {
            throw new MyException("用户名不符合要求");
        }
        if (user.getPassword().trim().length() < 6) {
            throw new MyException("密码不符合要求");
        }
        if (userDao.findUserByName(user.getUsername()) != null) {
            throw new MyException("此用户已被注册");
        }
        //对密码进行加密
        user.setPassword(md5Util.generatePassword(user.getPassword()));
        //返回注册结果
        return userDao.insertUser(user);
    }

    @Override
    public User getUser(String username) throws MyException {
        //返回查询结果
        return userDao.findUserByName(username);
    }

    @Override
    public boolean update(User user) throws MyException {
        //返回更新结果
        return userDao.updateUser(user);
    }

}
