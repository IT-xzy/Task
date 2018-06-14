package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

    @Override
    //添加一个用户
    public boolean addUser(User user) {
        return userMapper.insertUser(user) != 0;
    }

    //减少一个用户
    @Override
    public boolean cutUserById(long id) {
        return userMapper.deleteUserById(id) != 0;
    }

    @Override
    //修改一个用户
    public boolean reviseUserById(User user) {
        return userMapper.updateUserById(user) != 0;
    }

    @Override
    //查询一个用户
    public User queryUserById(long id) {
        return userMapper.selectUserById(id);
    }

    //查询所有用户
    @Override
    public List<User> queryUser() {
        return userMapper.selectUser();
    }
}
