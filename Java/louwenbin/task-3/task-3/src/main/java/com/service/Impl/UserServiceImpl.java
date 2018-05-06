
package com.service.Impl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectUser(int id) {
        User user = this.userMapper.selectUser(id);
        return user;
    }

    public void insertUser(User user) {
        this.userMapper.insertUser(user);
    }

    public boolean updateUser(User user) {
        return this.userMapper.updateUser(user);
    }

    public boolean deleteUser(int id) {
        return this.userMapper.deleteUser(id);
    }

    public List<User> getAll() {
        List userList = this.userMapper.getAll();
        return userList;
    }
}

