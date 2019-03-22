package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.UserDao;
import com.xiaobo.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getList(User user, Map<String,Object> pageData){
        return userDao.getList(user,pageData);
    }
    @Override
    public Boolean add(User user){
        return userDao.add(user);
    }
    @Override
    public Boolean update(User user){
        return userDao.update(user);
    }
    @Override
    public Boolean delete(User user){
        return userDao.delete(user);
    }
}
