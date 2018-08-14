package com.fgh.task2.service.loginService;

import com.fgh.task2.model.LoginUser;

import java.util.List;

public interface LoginService {
    Boolean insertLogin(LoginUser loginUser);
    Boolean updateLogin(LoginUser loginUser);
    Boolean delLogin(String name);
    LoginUser quaryByName(String name);
    Boolean quaryById(Long id);
    List<LoginUser> quaryLogin();
}
