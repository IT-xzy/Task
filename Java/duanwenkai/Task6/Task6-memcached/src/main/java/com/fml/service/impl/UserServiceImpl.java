package com.fml.service.impl;

import com.fml.mapper.UserMapper;
import com.fml.pojo.User;
import com.fml.service.UserService;
import com.fml.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean add(User user) {
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());

        //表示通用唯一标识符(UUID)的类。UUID表示一个128位的值
        UUID uuid = UUID.randomUUID();
        user.setSalt(uuid.toString().substring(10));


        LOGGER.error("盐" + user.getSalt());
        LOGGER.error("密码" + MD5Util.getMd5withSalt(user.getPassword(),user.getSalt()));

        //进行MD5加密,将加密后的密文作为密码
        user.setPassword(MD5Util.getMd5withSalt(user.getPassword(),user.getSalt()));
        return userMapper.add(user);

    }

    @Override
    public boolean deleteById(long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User getById(long id) {
        return userMapper.getById(id);
    }

    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }

    @Override
    public User getByEmail(String email) {
        return userMapper.getByEmail(email);
    }

    @Override
    public List<User> getListByName(String name) {
        return userMapper.getListByName(name);
    }

    @Override
    public long getTotalCount() {
        return 0;
    }
}
