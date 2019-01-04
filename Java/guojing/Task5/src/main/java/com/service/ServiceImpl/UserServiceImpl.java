package com.service.ServiceImpl;


import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Long register(User user) {
        return userDao.register(user);
    }

    @Override
    public User login(String name) {
       return userDao.login(name);

    }


}
