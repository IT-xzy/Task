package com.ssm.service.impl;

import com.ssm.dao.UserEmailRegMapper;
import com.ssm.model.UserEmailReg;
import com.ssm.service.UserEmailRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserEmailRegServiceImpl implements UserEmailRegService {
    @Autowired
    private UserEmailRegMapper userEmailRegMapper;

    @Override
    public int addUserEmail(UserEmailReg userEmailReg) {
        return userEmailRegMapper.addUserEmail(userEmailReg);
    }

    @Override
    public UserEmailReg getById(Long id) {
        return userEmailRegMapper.getById(id);
    }

    @Override
    public UserEmailReg getByName(String e_name) {
        return userEmailRegMapper.getByName(e_name);
    }

    @Override
    public List<UserEmailReg> getAllEmailReg() {
        return userEmailRegMapper.getAllEmailReg();
    }
}
