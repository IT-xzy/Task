package com.jnshu.service.impl;

import com.jnshu.mapper.AuthDao;
import com.jnshu.mapper.UserDao;
import com.jnshu.model.Auth;
import com.jnshu.model.User;
import com.jnshu.model.UserCustom;
import com.jnshu.model.UserQV;
import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    AuthDao authDao;

    @Override
    public List<UserCustom> findUserMore(UserQV userQV) throws Exception {
        return userDao.findUserMore(userQV);
    }

    @Override
    public UserCustom findUserById(Integer id) throws Exception {
        return userDao.findUserById(id);
    }

    @Override
    public int insertUser(User user) throws Exception {
        //插入成功后返回的值存入了user的id中
        userDao.insertUser(user);
        //所以返回user的id值
        return user.getId();
    }

    @Override
    public boolean updateUser(UserCustom userCustom, Integer id) throws Exception {
        userCustom.setId(id);
        return userDao.updateUser(userCustom);
    }

    @Override
    public boolean deleteUser(Integer i) throws Exception {
        return userDao.deleteUser(i);
    }

    @Override
    public boolean findAuth(Auth auth) throws Exception{
        return authDao.findAuth(auth);
    }
}
