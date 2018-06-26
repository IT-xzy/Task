package com.service;

import com.dao.UserDao;
import com.pojo.Administrator;
import com.pojo.User;

import java.util.List;

public class UserDaoService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findUserById(int id) throws Exception {
        User user = userDao.findUserById(id);
        return user;
    }

    public List<User> findUserByName(String name) throws Exception {
        List<User> list = userDao.findUserByName(name);
        return list;
    }

    public List<User> findUserByNumber(String number) throws Exception {
        List<User> list = userDao.findUserByNumber(number);
        return list;
    }

    public List<User> findUsers() throws Exception {
        List<User> list = userDao.findUsers();
        return list;
    }

    public int insertUser(User user) {
        try {
            if (userDao.insertUser(user) > 0)
                return user.getId();
            else return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public boolean deleteUser(int id) {
        try {
            return userDao.deleteUser(id);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateUser(User user) {
        try {
            return userDao.updateUser(user);
        } catch (Exception e) {
            return false;
        }
    }

    public Administrator findAdministrator(String username, String password) throws Exception {
        return userDao.findAdministrator(username, password);
    }

    public List<User> findUsersByPage(int start,int perPageUsers)throws Exception{
        List<User> list=userDao.findUsersByPage(start,perPageUsers);
        return list;
    }
}
