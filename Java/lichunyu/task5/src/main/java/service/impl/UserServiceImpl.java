package service.impl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUserById(int id) throws Exception {
        userMapper.deleteUserById(id);
    }

    @Override
    public User getUserById(int id) throws Exception {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUser(User user) throws Exception {
        return userMapper.getUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userMapper.updateUser(user);
    }
}
