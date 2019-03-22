package com.xiaobo.demo.service;


import com.xiaobo.demo.dao.LoginDao;
import com.xiaobo.demo.pojo.Login;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public List<Login> getAll(){
        return loginDao.getAll();
    }
    @Override
    public Login getIdByUsername(String username){
        return loginDao.getIdByUsername(username);
    }
    @Override
    public Integer checkUsernameExist(String username){
        return loginDao.checkUsernameExist(username);
    }
    @Override
    public Integer postUser(Login login){
        return loginDao.postUser(login);
    }
    @Override
    public String getPasswordByUsername(String username){
        return loginDao.getPasswordByUsername(username);
    }
}
