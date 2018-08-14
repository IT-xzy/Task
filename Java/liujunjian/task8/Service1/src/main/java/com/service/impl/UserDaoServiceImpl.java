package com.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.dao.UserDao;
import com.exception.MyException;
import com.pojo.User;
import com.service.UserDaoService;
import com.tools.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class UserDaoServiceImpl implements UserDaoService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate<String, User> redisTemplate;
    @Autowired
    private MD5Util md5Util;
    @Autowired
    private ShortMessageUtil shortMessageUtil;
    @Autowired
    private MailUtil mailUtil;
    private Logger logger = Logger.getLogger(UserDaoServiceImpl.class.getName());

    private User getFromRedis(String username) {
        return redisTemplate.opsForValue().get(username);
    }

    private void putIntoRedis(String name, User user) {
        redisTemplate.opsForValue().set(name, user);
    }

    @Override
    //登录验证
    public boolean login(User user) throws MyException, NoSuchAlgorithmException {
        User user1 = userDao.findUserByName(user.getUsername());
        if (user1 == null) {
            throw new MyException("没有此用户");
        }
        return md5Util.checkPassword(user.getPassword(), user1.getPassword());
    }

    @Override
    //注册
    public boolean register(User user) throws MyException, NoSuchAlgorithmException {
        if (user.getUsername().trim().length() <= 0) {
            throw new MyException("用户名不符合要求");
        }
        if (user.getPassword().trim().length() < 6) {
            throw new MyException("密码不符合要求");
        }
        if (userDao.findUserByName(user.getUsername()) != null) {
            throw new MyException("此用户已被注册");
        }
        //对密码进行加密
        user.setPassword(md5Util.generatePassword(user.getPassword()));
        //返回注册结果
        return userDao.insertUser(user);
    }

    @Override
    //获取指定用户名的用户
    public User getUser(String username) throws MyException {
        User user = getFromRedis(username);
        if (user != null) {
            logger.info("从redis获取用户信息：" + username);
            return user;
        }
        user = userDao.findUserByName(username);
        if (user != null) {
            //把去掉密码后放入缓存
            user.setPassword(null);
            putIntoRedis(user.getUsername(), user);
            logger.info("用户信息放入redis：" + username);
        }
        //返回查询结果
        return user;
    }

    @Override
    //更新用户信息
    public boolean update(User user) throws MyException {
        //删掉缓存里的信息
        redisTemplate.delete(user.getUsername());
        logger.info("从redis删除信息：" + user.getUsername());
        //返回更新结果
        return userDao.updateUser(user);
    }

    @Override
    //发送手机验证码
    public String sendPhoneCheckCode(String phoneNumber) throws ClientException {
        return shortMessageUtil.sendShortMessage(phoneNumber);
    }

    @Override
    //发送邮箱验证码
    public String sendMailCheckCode(String mailAddress) throws IOException {
        return mailUtil.sendMail(mailAddress);
    }

}
