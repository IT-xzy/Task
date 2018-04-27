package com.ptteng.service;


import com.ptteng.dao.mapping.UserMapper;
import com.ptteng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectUser(int id) {
        User user = userMapper.selectUser(id);
        return user;
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public boolean deleteUser(int id) {
        return userMapper.deleteUser(id);
    }
}
