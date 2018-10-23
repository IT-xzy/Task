package yxpTask6.service;

import yxpTask6.pojo.Login;

public interface LoginService
{
    int registerLogin(Login login);

    Login selectLogin(String loginAccount);

    int updateLogin(Login login);

    int updateSecAccount(Login login);

    int updatePassword(Login login);
}
