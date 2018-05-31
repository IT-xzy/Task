package com.ptteng.service.Impl;

import com.ptteng.dao.UserMapperLogin;
import com.ptteng.entity.UserLogin;
import com.ptteng.service.UserServiceLogin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImplLogin implements UserServiceLogin {
    @Resource
    private UserMapperLogin userMapperLogin;

    @Override
    public UserLogin selectUserLogin(String name) {
        return userMapperLogin.selectUserLogin(name);
    }

    public void insertUserLogin(UserLogin user) {
        this.userMapperLogin.insertUserLogin(user);
    }
}
