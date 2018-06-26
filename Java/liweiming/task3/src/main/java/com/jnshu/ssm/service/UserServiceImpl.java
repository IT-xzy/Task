package com.jnshu.ssm.service;


import com.jnshu.ssm.entities.User;
import com.jnshu.ssm.mapping.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> getAllUser() throws Exception {
        return userDAO.getAllUser();
    }

    @Override
    public User getUserById(int id)throws Exception{
        return  userDAO.getUserById(id);
    }

    @Override
    public List<User> getUserMore(User user) throws Exception {
        return userDAO.getUserMore(user);
    }

    @Override
//    保存用户
    public boolean saveUser(User user) throws Exception {
        return userDAO.addUser(user);
    }

    @Override
    public boolean deleteUser(int id) throws Exception {
        return userDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(int id,User user) throws Exception {
        return userDAO.updateUser(user);
    }

}