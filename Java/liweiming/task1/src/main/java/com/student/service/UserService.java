package com.student.service;

import com.student.model.User;
import com.student.mapping.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserDao userDao;

    public List<User> getAllUser() throws Exception {
        return userDao.getAllUser();
    }

    public List<User> getUserMore(User user) throws Exception {
        return userDao.getUserMore(user);
    }

    public int addUser(User user) throws Exception {
        return userDao.addUser(user);
    }

    public boolean deleteUser(int id) throws Exception {
        return userDao.deleteUser(id);
    }
    public boolean updateUser(User user) throws Exception {
        return userDao.updateUser(user);
    }
    public void forlist(List<User> users){
        for (int i=0; i < users.size();i++){
            System.out.println(users.get(i).toString());
        }
    }
}
/*
*/