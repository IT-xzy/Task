package com.jnshu.task4.service.impl;

import com.jnshu.task4.beans.User;
import com.jnshu.task4.mapper.UserMapper;
import com.jnshu.task4.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = userMapper.selectAllUser();
        return userList;
    }

    @Override
    public User selectUserById(Integer id) {
        User user = userMapper.selectUserById(id);
        return user;
    }

    @Override
    public int updateUserById(Integer id, User user) {
        int flag = userMapper.updateUserById(id, user);
        return flag;
    }

    @Override
    public int delectUserById(Integer id) {
        int flag = userMapper.delectUserById(id);
        return flag;
    }

    @Override
    public List<User> selectUserBysalaryDESC() {
       List<User> userList = userMapper.selectUserBySalaryDESC();
        return userList;
    }
}
