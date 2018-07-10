package com.yxpStu.service.serviceImp;

import com.yxpStu.dao.LoginDao;
import com.yxpStu.pojo.Login;
import com.yxpStu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService
{
    @Autowired
    private LoginDao loginDao;

    public int insertLogin(Login login)
    {
        return loginDao.insertLogin(login);
    }

    public Login selectLogin(Login login)
    {
        return loginDao.selectLogin(login);
    }

    public void updateLogin(Login login)
    {
         loginDao.updateLogin(login);
    }
}
