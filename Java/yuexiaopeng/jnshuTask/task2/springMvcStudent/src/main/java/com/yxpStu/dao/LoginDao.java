package com.yxpStu.dao;
import com.yxpStu.pojo.Login;
public interface LoginDao
{
    int insertLogin(Login login);

    Login selectLogin(Login login);

    void updateLogin(Login login);
}
