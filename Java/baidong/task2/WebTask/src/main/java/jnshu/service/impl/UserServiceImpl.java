package jnshu.service.impl;

import jnshu.dao.UserDao;
import jnshu.model.User;
import jnshu.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public int add(User user){
        return userDao.add(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> selectPage(int start, int pageSize) {
        return userDao.selectPage(start,pageSize);
    }

    @Override
    public int selectCount() {
        return userDao.selectCount();
    }
@Override
    public int delete(int id){
        return userDao.delete(id);
    }
}
