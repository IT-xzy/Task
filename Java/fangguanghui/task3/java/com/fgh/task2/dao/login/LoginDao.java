package com.fgh.task2.dao.login;

import com.fgh.task2.model.LoginUser;

import java.util.List;

public interface LoginDao {
    Boolean insertLogin(LoginUser loginUser);
    Boolean updateLogin(LoginUser loginUser);
    Boolean delLogin(String name);
    LoginUser quaryByName(String name);
    Boolean quaryById(Long id);
    List<LoginUser> quaryLogin();

}
