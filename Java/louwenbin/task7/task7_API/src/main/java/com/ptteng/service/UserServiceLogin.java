package com.ptteng.service;

import com.ptteng.entity.UserLogin;

public interface UserServiceLogin {
    UserLogin selectUserLogin(String name);
    public void insertUserLogin(UserLogin user);
    void insertUserLoginPhoneCode(UserLogin user);
    void insertUserLoginEmailCode(UserLogin user);
    void updateUserLoginImage(UserLogin user);
    UserLogin selectUserLoginById(int id);
}
