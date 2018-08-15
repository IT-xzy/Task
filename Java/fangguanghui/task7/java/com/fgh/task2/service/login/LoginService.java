package com.fgh.task2.service.login;

import com.fgh.task2.dao.LoginDao;
import com.fgh.task2.model.LoginUser;

import java.util.List;

public interface LoginService {
    Boolean insertLogin(LoginUser loginUser);
    Boolean updateLogin(LoginUser loginUser);
    Boolean updatePhoto(LoginUser loginUser);
    Boolean delLogin(String name);
    LoginUser quaryByName(String name);
    LoginUser quaryByCode(String code);
    LoginUser quaryById(int id);
    List<LoginUser> quaryLogin();
}
