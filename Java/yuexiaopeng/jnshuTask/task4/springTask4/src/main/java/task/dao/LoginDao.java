package task.dao;

import task.pojo.Login;

public interface LoginDao
{
    int insertLogin(Login login);

    Login selectLogin(Login login);

    int updateLogin(Login login);
}
