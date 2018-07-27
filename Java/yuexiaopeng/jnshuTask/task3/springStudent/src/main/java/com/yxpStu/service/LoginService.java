package com.yxpStu.service;

import com.yxpStu.pojo.Login;


public interface LoginService
{
    int insertLogin(Login login);

    Login selectLogin(Login login);

    void updateLogin(Login login);
}
