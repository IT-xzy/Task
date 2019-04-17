package com.jnshu.service.impl;

import com.jnshu.dao.UserMapper;
import com.jnshu.pojo.User;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/4/3 - 2:12
 */
@Service
public class UserServiceImp implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImp.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User record) {
        int x = userMapper.insert(record);
        logger.info(record);
        return x;
    }

    @Override
    public User selectById(Long id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public List<User> selectByName(String name) {
        List<User> user = userMapper.selectByName(name);
        logger.info(user.toString());
        return user;
    }

    @Override
    public List<User> selectByNameAndPassword(String name, String password) {
        List<User> user = userMapper.selectByNameAndPassword(name,password);
        logger.info(user.toString());
        return user;
    }
}
