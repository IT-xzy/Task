package com.jnshu.taskone.serviceImpl;


import com.jnshu.taskone.dao.UserDao;
import com.jnshu.taskone.model.User;
import com.jnshu.taskone.service.UserService;
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
    public List<User> findUserMore(User user) throws Exception {
        return userDao.findUserMore(user);
    }

    @Override
    public int insertUser(User user) throws Exception{
        return userDao.insertUser(user);
    }
    @Override
    public boolean updateUser(User user) throws Exception{
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(int i) throws Exception {
        return userDao.deleteUser(i);
    }
    @Override
    public void forlist(List<User> user){
        for (int i = 0; i < user.size(); i++) {
            System.out.println(user.get(i).toString());
        }
    }
}
