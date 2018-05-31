package com.service.Impl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
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

    public List<User> getAll() {
        List<User> userList = userMapper.getAll();
        return userList;
    }
}
