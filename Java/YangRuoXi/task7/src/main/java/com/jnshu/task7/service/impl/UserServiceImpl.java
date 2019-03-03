package com.jnshu.task7.service.impl;

import com.jnshu.task7.beans.User;
import com.jnshu.task7.mapper.UserMapper;
import com.jnshu.task7.service.UserService;
import com.jnshu.task7.utils.RedisClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
    public List selectUserBysalaryDESC() {

        List<User> userListCache = (List<User>) RedisClientUtil.getList("userListCache");
        if (userListCache != null && userListCache.size() != 0){
            return userListCache;
        }
        List<User> userList = userMapper.selectUserBySalaryDESC();
        RedisClientUtil.setList("userListCache",userList);
        return userList;
    }
}
