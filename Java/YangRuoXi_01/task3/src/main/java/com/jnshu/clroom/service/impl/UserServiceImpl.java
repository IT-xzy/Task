package com.jnshu.clroom.service.impl;

import com.jnshu.clroom.beans.User;
import com.jnshu.clroom.mapper.UserMapper;
import com.jnshu.clroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean upadteUserById(Integer userId,String userName,String password,String userRole) {
        return userMapper.updateUserById(userId,userName,password,userRole);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUser(id);
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = userMapper.selectAllUser();
        return userList;
    }

    @Override
    public Boolean delectUserById(Integer userId) {

        return userMapper.delectUserById(userId);
    }
}
