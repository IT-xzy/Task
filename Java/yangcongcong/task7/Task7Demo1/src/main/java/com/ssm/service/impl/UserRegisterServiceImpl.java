package com.ssm.service.impl;

import com.ssm.dao.UserRegisterMapper;
import com.ssm.model.UserRegister;
import com.ssm.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    private UserRegisterMapper userRegisterMapper;

    @Override
    public int addUser(UserRegister userRegister) {
        return userRegisterMapper.addUser(userRegister);
    }

    @Override
    public UserRegister getById(Long id) {
        return userRegisterMapper.getById(id);
    }

    @Override
    public UserRegister getByName(String name) {
        return userRegisterMapper.getByName(name);
    }

    @Override
    public List<UserRegister> getAllRegister() {
        return userRegisterMapper.getAllRegister();
    }


}
