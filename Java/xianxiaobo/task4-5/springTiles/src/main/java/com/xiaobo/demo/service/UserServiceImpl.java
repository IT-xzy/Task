package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.UserMapper;
import com.xiaobo.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private User user;
    @Autowired
    private UserMapper userMapper;
    @Override
    public Boolean insert(User user){
        Long currentTime = new Long(new Date().getTime());
        user.setCreateAt(currentTime);
        user.setUpdateAt(currentTime);
        return userMapper.insert(user) == 1;
    }
    @Override
    public User getByUsername(User user){
        return userMapper.getByUsername(user);
    }
}
