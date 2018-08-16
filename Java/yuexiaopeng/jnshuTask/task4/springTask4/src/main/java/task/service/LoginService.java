package task.service;

import org.springframework.stereotype.Service;
import task.pojo.Login;

public interface LoginService
{
    int insertLogin(Login login);

    Login selectLogin(Login login);

    int updateLogin(Login login);
}
