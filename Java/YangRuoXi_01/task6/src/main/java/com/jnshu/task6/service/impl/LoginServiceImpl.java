package com.jnshu.task6.service.impl;

import com.jnshu.task6.beans.Login;
import com.jnshu.task6.mapper.LoginMapper;
import com.jnshu.task6.service.LoginService;
import com.jnshu.task6.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public int addlogin(Login login) {

        return loginMapper.insertLogin(login);
    }

    @Override
    public boolean addLoginAndPwd(Login login) {

       return loginMapper.insertLoginNameAndPwd(login);

    }

    @Override
    public Login selectLoginByName(String loginName) {
    Login login =  loginMapper.selectLoginByName(loginName);
    return login;

    }

    @Override
    public Login selectLoginById(Integer id) {
        Login login = loginMapper.selectLoginById(id);
        return login;
    }

    @Override
    public Boolean checkLogin(Integer id, String pwd) {
        Login login = loginMapper.selectLoginById(id);
        String md5 = login.getPwd();
            if (Md5Util.digest(md5).equals(Md5Util.digest(pwd))){
            return true;
        }
        return false;
    }


}
