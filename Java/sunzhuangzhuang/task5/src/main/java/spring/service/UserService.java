package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.UserDao;
import spring.model.User;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User query(User user){
        return userDao.query(user);
    }
    public void add(User user){
        userDao.add(user);
    }
    public void reLogin(User user){
        userDao.reLogin(user);
    }
    public Long getName(String name){
        return userDao.getName(name);
    }
    public Boolean selectByName(String name){
        return userDao.selectByName(name);
    }
}
