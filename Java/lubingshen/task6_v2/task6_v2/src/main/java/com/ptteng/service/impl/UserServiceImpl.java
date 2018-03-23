package com.ptteng.service.impl;

import com.ptteng.pojo.model.User;
import com.ptteng.dao.UserDao;
import com.ptteng.pojo.exception.StudentException;
import com.ptteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Integer count() {
        return 0;
    }

    @Override
    public Long register(User user) throws Exception {
        Boolean success = false;
        user.setCreateAt(System.currentTimeMillis());
        try {
            success = userDao.insertUser(user);
        } catch (DuplicateKeyException e) {
            //处理插入时重复学号引发的异常
            throw new StudentException("注册失败！该用户名已存在！");
        }
        if(!success)
            throw new StudentException("未知原因，注册失败！");
        return user.getId();
    }

    @Override
    public boolean delete(Long primeKey) throws Exception {
        return userDao.deleteUser(primeKey);
    }

    @Override
    public User findByPrimeKey(Long primeKey) throws Exception {
        return userDao.findById(primeKey);
    }

    @Override
    public User query(String name) throws Exception {
        return userDao.findByName(name);
    }

    @Override
    public boolean modify(User user) throws Exception {
        return userDao.modifyLoginTime(user);
    }

}
