package com.task.service.Impl;

import com.task.dao.UserDao;
import com.task.models.User;
import com.task.service.UserService;
import com.task.utils.EncryptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    private Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Override
    //因为从controller中传过来的user中只有username和password，所以需要在service中添加salt和hashKey
    public int justAdd(User user) throws Exception {
        String salt= EncryptionUtil.getNextSalt();
        user.setSalt(salt);
        String str=user.getPassword()+salt;
        String hashKey=EncryptionUtil.getSHA256Str(str);
        user.setHashKey(hashKey);
       userDao.addUser(user);
       return user.getId();
    }

    @Override
    public Boolean justUpdate(User user) throws Exception {
        String salt= EncryptionUtil.getNextSalt();
        user.setSalt(salt);
        String str=user.getPassword()+salt;
        String hashKey=EncryptionUtil.getSHA256Str(str);
        user.setHashKey(hashKey);
        return userDao.updateUser(user);
    }

    @Override
    public Boolean justDelete(int id) throws Exception {
        return userDao.deleteUser(id);
    }

    @Override
    public User listByName(String username) throws Exception {
        User user=userDao.getUserByName(username);
        return user;
    }

    @Override
    public Boolean updateLoginTime(User user) {
        return userDao.updateLoginTime(user);
    }
}
