package com.ptteng.service;


import com.ptteng.dao.mapping.UserMapper;
import com.ptteng.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User getUser(int id) {
        User user = userMapper.getUser(id);
        return user;
    }

    public void save(User user) {
        userMapper.save(user);
    }

    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public boolean deleteUser(int id) {
        return userMapper.deleteUser(id);

    }
}
