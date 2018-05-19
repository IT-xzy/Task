package com.token.service.impl;

import com.token.dao.UserInfoMapper;
import com.token.model.UserInfo;
import com.token.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int add(UserInfo userInfo) {
        return userInfoMapper.add(userInfo);
    }

    @Override
    public UserInfo getById(long id) {
        return userInfoMapper.getById(id);
    }

    @Override
    public UserInfo getByName(String name) {
        return userInfoMapper.getByName(name);
    }

}
