package com.task4.service;

import com.task4.mapper.UserMapper;
import com.task4.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
   private UserMapper userMapper;

    public UserServiceImpl() {
        super();
    }

    @Override
    public List<User> selectAll() {
        List<User> list = userMapper.selectAll();
        return list;
    }




}
