package com.iceneet.service.impl;

import com.iceneet.dao.UserMapper;
import com.iceneet.entity.User;
import com.iceneet.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userserviceimpl implements Userservice{

    @Autowired
    private UserMapper userMapper;

    public int insertSelective(User record){
        return userMapper.insertSelective(record);
    };

    public  int registerUser(User user){
        return userMapper.registerUser(user);
    }

    public User userMatch(User user) {
        return userMapper.userMatch(user);
    }

    public User selectByName(String name){
        return userMapper.selectByName(name);
    }
}
