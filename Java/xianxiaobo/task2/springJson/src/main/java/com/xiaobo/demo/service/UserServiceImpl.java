package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.UserDao;
import com.xiaobo.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAll(){
        List<User> userList = userDao.getAll();
        return userList;
    }
    @Override
    public User getUserById(Integer id){
        return userDao.getUserById(id);
    }
    @Override
    public Integer addUser(User user){
        return userDao.addUser(user);
    }
    @Override
    public Boolean updateUser(User user){
        return userDao.updateUser(user);
    }
    @Override
    public Boolean deleteUser(Integer id){
        return userDao.deleteUser(id);
    }
    @Override
    public Integer batchDeleteUser(List list){
        return userDao.batchDeleteUser(list);
    }
}
