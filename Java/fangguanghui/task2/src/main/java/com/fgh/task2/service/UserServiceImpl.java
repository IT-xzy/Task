package com.fgh.task2.service;




import com.fgh.task2.dao.UserDao;
import com.fgh.task2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public  List<User> findUserBy(User user)throws Exception{
        return userDao.findUserBy(user);
    }

    public User findUserById (int id)throws Exception{
        return userDao.findUserById(id);
    }
    public Boolean insertUser(User user)throws Exception{
        return userDao.insertUser(user);
    }
    public Boolean delUser(int id)throws Exception{
        return userDao.delUser(id);
    }
    public Boolean updateUser(User user)throws Exception{
        return  userDao.updateUser(user);
    }

    public List<User> findAll()throws Exception{
        return userDao.findAll();
    }
}
