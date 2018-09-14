package com.zyq.service.Impl;

import com.zyq.mapper.UserMapper;
import com.zyq.pojo.User;
import com.zyq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void insert(User user) {
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        userMapper.insert(user);
    }

    @Override
    public User selectByUserName(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public Integer selectIdById(Integer id) {
        return userMapper.selectIdById(id);
    }

    @Override
    public String selectPwdByUserName(String username) {
        return userMapper.selectPwdByUserName(username);
    }
}
