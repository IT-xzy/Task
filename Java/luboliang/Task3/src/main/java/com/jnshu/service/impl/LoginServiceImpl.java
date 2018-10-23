package com.jnshu.service.impl;

import com.jnshu.mapper.LoginDao;
import com.jnshu.model.Login;
import com.jnshu.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;

    @Override
    public long addLogin(Login login) {
        return loginDao.addLogin(login);
    }

    @Override
    public boolean deleteLogin(long id) {
        return loginDao.deleteLogin(id);
    }

    @Override
    public boolean updateLogin(Login login) {
        return loginDao.updateLogin(login);
    }

    @Override
    public Login findByLogin(long id) {
        return loginDao.findByLogin(id);
    }

    @Override
    public List<Login> findAllLogin() {
        return loginDao.findAllLogin();
    }
}
