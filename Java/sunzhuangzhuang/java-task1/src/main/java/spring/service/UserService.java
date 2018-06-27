package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.dao.UserDao;
import spring.demo.User;

import java.util.List;

@Component
public class UserService implements IUserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Integer add(User user) {
        userDao.add(user);
        return user.getId();
    }
    public void delete(int id) {
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> select(User user) {
        return userDao.select(user);
    }

    public List<User> query() {
        return userDao.query();
    }
}
