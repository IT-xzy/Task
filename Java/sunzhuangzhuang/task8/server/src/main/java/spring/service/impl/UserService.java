package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.UserDao;
import spring.model.User;
import spring.service.IuserService;

@Service
public class UserService implements IuserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User query(User user){
        return userDao.query(user);
    }

    @Override
    public void add(User user){
        userDao.add(user);
    }

    @Override
    public void reLogin(User user){
        userDao.reLogin(user);
    }

    @Override
    public Long getName(String name){
        return userDao.getName(name);
    }

    @Override
    public Boolean selectByName(String name){
        return userDao.selectByName(name);
    }

    @Override
    public void gerServer() {
        System.out.println("检查宕机");
    }
}
