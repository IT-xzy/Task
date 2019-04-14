package com.ptteng.service.impl;

import com.ptteng.dao.UserMapper;
import com.ptteng.entity.User;
import com.ptteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/15  15:49
 * @Version 1.0
 **/

@Service
public class UserServiceImp implements UserService{
@Autowired
    UserMapper userMapper;

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public List<User> selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public List<User> selectByCondition(String name, String password) {
        return userMapper.selectByCondition(name,password);
    }

}
