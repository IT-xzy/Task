package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User validateUser(String username, String password) {
        return userDao.validateUser(username, password);
    }

    public void updateTimeBtId(long id) {
        userDao.updateTimeById(id);
    }

    public User selectUserById(long id) {
        return userDao.selectById(id);
    }
}
