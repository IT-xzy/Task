package com.jnshu.task7.service.impl;

import com.jnshu.task7.beans.Login;
import com.jnshu.task7.mapper.LoginMapper;
import com.jnshu.task7.service.LoginService;
import com.jnshu.task7.utils.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
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
    public Login selectLoginById(Long id) {
        Login login = loginMapper.selectLoginById(id);
        return login;
    }

    @Override
    public Boolean checkLogin(Long id, String pwd) {
        Login login = loginMapper.selectLoginById(id);
        String md5 = login.getPwd();
            if (Md5Util.digest(md5).equals(Md5Util.digest(pwd))){
            return true;
        }
        return false;
    }

    @Override
    public Long selectPwdByNameOrPhoneOrEmail(String value) {
        Login login = loginMapper.selectPwdByNameOrPhoneOrEmail(value);

        return login.getId();
    }

    @Override
    public Login selectLoginByEmail(String email) {
        Login login = loginMapper.selectLoginByEmail(email);
        return login;
    }


}
