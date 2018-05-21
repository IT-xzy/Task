package com.ptteng.service;

import com.ptteng.entity.UserLogin;

public interface UserServiceLogin {
    UserLogin selectUserLogin(String name);
    public void insertUserLogin(UserLogin user);
}
