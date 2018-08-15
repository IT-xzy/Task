package yxp.service;

import yxp.pojo.Login;

public interface LoginService
{
    int registerLogin(Login login);

    Login selectLogin(String loginAccount);

    int updateLogin(Login login);

    int updatePassword(Login login);
}
