package com.jnshu.service.impl;

import com.jnshu.dao.UserMapper;


import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    public UserMapper getESMapper() {
        return userDao;
    }

    public void setESMapper(UserMapper UserDao) {
        this.userDao = UserDao;
    }

    @Override
    public User findById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public String update(User addInfo) {
        if (userDao.updateByPrimaryKeySelective(addInfo) == 1) {
            return "更新成功";
        }
        return "更新失败";
    }

    @Override
    public User login(User user) {
        return userDao.selectByIdAndName(user);
    }


    @Override
    public String addInfo(User addInfo) {
        if (userDao.insertSelective(addInfo) == 1) {
            return "添加成功";
        }
        return "添加失败";
    }
}