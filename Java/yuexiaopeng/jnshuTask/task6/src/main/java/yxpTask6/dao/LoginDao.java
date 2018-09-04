package yxpTask6.dao;

import yxpTask6.pojo.Login;

public interface LoginDao
{
    int insertLogin(Login login);

    Login selectLogin(String loginAccount);

    int updateLogin(Login login);

    int updatePassword(Login login);
}
