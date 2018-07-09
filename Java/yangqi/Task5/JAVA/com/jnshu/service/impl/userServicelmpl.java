package com.jnshu.service.impl;

import com.jnshu.entity.User;
import com.jnshu.mapper.UserDao;
import com.jnshu.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServicelmpl implements userService {
    @Autowired
    private UserDao userDao;

    //注册

    @Override
    public void regist(User user){
        userDao.register(user);
    }

    //查询账户名密码

    @Override
    public User selectByuser(String name, String password){
        return userDao.selectByuser(name,password);
    }

    //查询姓名

    @Override
    public User findUserByname(String name){
        return userDao.findUserByname(name);
    }


    @Override
    public User selectByid(long id) {
        return userDao.selectByid(id);
    }

    @Override
    public void updateTimeByid(long id){
        userDao.updateTimeByid(id);
    }



}
