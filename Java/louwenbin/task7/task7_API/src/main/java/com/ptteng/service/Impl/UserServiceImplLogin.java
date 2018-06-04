package com.ptteng.service.Impl;

import com.ptteng.dao.UserMapperLogin;
import com.ptteng.entity.UserLogin;
import com.ptteng.service.UserServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

@Service
public class UserServiceImplLogin implements UserServiceLogin {
    @Resource
    private UserMapperLogin userMapperLogin;

    public UserLogin selectUserLogin(String name) {
        return userMapperLogin.selectUserLogin(name);
    }

    public void insertUserLogin(UserLogin user) {
        userMapperLogin.insertUserLogin(user);
    }

    public void insertUserLoginPhoneCode(UserLogin user) {
        userMapperLogin.insertUserLoginPhoneCode(user);
    }

    public void insertUserLoginEmailCode(UserLogin user) {
        userMapperLogin.insertUserLoginEmailCode(user);
    }

    public void updateUserLoginImage(UserLogin user) {
        userMapperLogin.updateUserLoginImage(user);
    }

    public UserLogin selectUserLoginById(int id) {
        return  userMapperLogin.selectUserLoginById(id);

    }
}
