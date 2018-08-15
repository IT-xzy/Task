package spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import spring.dao.UserDao;
import spring.demo.User;


import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer add(User user) {
        userDao.add(user);
        return user.getId();
    }
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User select(int id) {
        return userDao.select(id);
    }

    @Override
    public List<User> selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public List<User> query() {
        return userDao.query();
    }
}
