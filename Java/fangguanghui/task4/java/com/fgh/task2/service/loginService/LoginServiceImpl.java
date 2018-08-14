package com.fgh.task2.service.loginService;

import com.fgh.task2.dao.login.LoginDao;
import com.fgh.task2.model.LoginUser;
import com.fgh.task2.service.loginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    public Boolean insertLogin(LoginUser loginUser){
        return loginDao.insertLogin(loginUser);
    }

    public Boolean updateLogin(LoginUser loginUser){
        return loginDao.updateLogin(loginUser);
    }

    public Boolean delLogin(String name){
        return loginDao.delLogin(name);
    }
    public LoginUser quaryByName(String name){
        return loginDao.quaryByName(name);
    }
    public Boolean quaryById(Long id){
        return loginDao.quaryById(id);
    }

    public List<LoginUser> quaryLogin(){
        return loginDao.quaryLogin();
    }

}
