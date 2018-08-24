package com.service;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/23$ 15:57$
 **/
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    //    public UserDao getUserDao() {
//        return userDao;
//    }
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //增
    public long addUser(User user) {
        return userDao.addUser(user);
    }

    //删
    public boolean deleteUser(User user) {
        boolean b = userDao.deleteUser(user);
        return b;
    }

    //改
    public boolean updateUser(User user) {
        boolean b = userDao.updateUser(user);
        return b;
    }

    //查
    public User selectUser(User user) {
        return userDao.selectUser(user);
    }
}
