package com.fgh.task2.service.login;

import com.fgh.task2.dao.LoginDao;
import com.fgh.task2.model.LoginUser;
import com.fgh.task2.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    public Boolean insertLogin(LoginUser loginUser){
        return loginDao.insertLogin(loginUser);
    }

    public Boolean updateLogin(LoginUser loginUser){
        return loginDao.updateLogin(loginUser);
    }

    public Boolean updatePhoto(LoginUser loginUser){
        return loginDao.updatePhoto(loginUser);
    }

    public Boolean delLogin(String name){
        return loginDao.delLogin(name);
    }

    public LoginUser quaryByName(String name){
        return loginDao.quaryByName(name);
    }

    public LoginUser quaryByCode(String code){
        return loginDao.quaryByCode(code);
    }

    public LoginUser quaryById(int id){
        return loginDao.quaryById(id);
    }

    public List<LoginUser> quaryLogin(){
        return loginDao.quaryLogin();
    }

}
