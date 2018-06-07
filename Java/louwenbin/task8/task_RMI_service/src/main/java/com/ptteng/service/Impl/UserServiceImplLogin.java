package com.ptteng.service.Impl;

import com.ptteng.dao.UserMapperLogin;
import com.ptteng.entity.UserLogin;
import com.ptteng.service.UserServiceLogin;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplLogin implements UserServiceLogin {
    @Autowired
    private UserMapperLogin userMapperLogin;
    private static Logger logger= Logger.getLogger(UserServiceImplLogin.class);

    @Override
    public UserLogin selectUserLogin(String name) {
        logger.info("查询登录账号");
        return userMapperLogin.selectUserLogin(name);
    }

    public void insertUserLogin(UserLogin user) {
        logger.info("将账号密码存入数据库");
        userMapperLogin.insertUserLogin(user);
    }

    public void insertUserLoginPhoneCode(UserLogin user) {
        logger.info("存入手机验证码");
        userMapperLogin.insertUserLoginPhoneCode(user);
    }

    public void insertUserLoginEmailCode(UserLogin user) {
        logger.info("也没用");

        userMapperLogin.insertUserLoginEmailCode(user);
    }

    public void insertUserLoginEmailCodeTemporary(UserLogin user) {
        logger.info("没用的");

        userMapperLogin.insertUserLoginEmailCodeTemporary(user);
    }

    @Override
    public UserLogin selectUserLoginEmailCode(String email) {
        logger.info("没用没用");
        UserLogin user = null;
        userMapperLogin.selectUserLoginEmailCode(email);
        return user;
    }

    @Override
    public void updateUserLoginImage(UserLogin user) {
        logger.info("查询登录账号");

        userMapperLogin.updateUserLoginImage(user);
    }

    @Override
    public UserLogin selectUserLoginById(int id) {
        logger.info("根据ID查询 -.-");
        return userMapperLogin.selectUserLoginById(id);
    }
}
