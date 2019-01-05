package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.UserMapper;
import com.xiaobo.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private User user;
    @Autowired
    private UserMapper userMapper;
    @Override
    public Boolean insert(User user){
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        return userMapper.insert(user) == 1;
    }
    @Override
    public User getByUsername(User user){
        return userMapper.selectByUsername(user);
    }
    @Override
    public Boolean updateByPrimaryKeySelective(User user){
     return userMapper.updateByPrimaryKeySelective(user) == 1;
    }
    @Override
    public User getUser(User user){

        return userMapper.getUser(user);
    }
    @Override
    public User getUserWithoutPassword(User user){
        return userMapper.getUserWithoutPassword(user);
    }
}
