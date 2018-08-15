package yxp.dao;

import yxp.pojo.Login;

public interface LoginDao
{
    int insertLogin(Login login);

    Login selectLogin(String loginAccount);

    int updateLogin(Login login);

    int updatePassword(Login login);
}
