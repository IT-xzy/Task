package com.java.service.impl;

import com.java.dao.UserDao;
import com.java.pojo.User;
import com.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author suger
 * @date 2018-09-17
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;
    @Override
    public Long insert(User user) {
        userDao.insert(user);
        return user.getUserId();
    }

    @Override
    public Boolean update(User user) {

        Boolean flag = false;
        int i = userDao.update(user);
        if(i!=0){
            flag = true ;
        }
        return flag;
    }

    @Override
    public Boolean delete(Long userId) {

        Boolean flag = false;
        int i = userDao.delete(userId);
        if(i!=0){
            flag = true ;
        }
        return flag;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public List<User> getUserByonlineId(int onlineId) {
        return userDao.getUserByonlineId(onlineId);
    }
}
