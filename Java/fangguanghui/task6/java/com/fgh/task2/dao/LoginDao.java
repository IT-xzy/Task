package com.fgh.task2.dao;

import com.fgh.task2.model.LoginUser;

import java.util.List;

public interface LoginDao {
    Boolean insertLogin(LoginUser loginUser);
    Boolean updateLogin(LoginUser loginUser);
    Boolean updatePhoto(LoginUser loginUser);
    Boolean delLogin(String name);
    LoginUser quaryByName(String name);
    LoginUser quaryById(int id);
    LoginUser quaryByCode(String code);
    List<LoginUser> quaryLogin();

}
