package com.jnshu.service.impl;


import com.jnshu.dao.UserDao;
import com.jnshu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> findUserAll() throws Exception {
        return userDao.findUserAll();
    }

    @Override
    public List<User> findUserByCondition(String s) throws Exception {
        return userDao.findUserByCondition(s);
    }


    @Override
    public User findUserById(int i) throws Exception {
        return userDao.findUserById(i);
    }




    @Override
    public int insertUser(User user) throws Exception {
        System.out.println(user.toString());
        return userDao.insertUser(user);
    }

    @Override
    public boolean deleteUser(long l) throws Exception {
        return userDao.deleteUser(l);
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        return userDao.updateUser(user);
    }

    @Override
    public void forList(List<User> user) {
        for (int i = 0; i < user.size(); i++) {
            System.out.println(user.get(i).toString());
        }
    }
}