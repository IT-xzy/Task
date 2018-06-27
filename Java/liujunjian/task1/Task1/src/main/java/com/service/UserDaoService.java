package com.service;

import com.dao.UserDao;
import com.pojo.User;

import java.util.Iterator;
import java.util.List;

public class UserDaoService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findUserById(int id) throws Exception {
        User user= userDao.findUserById(id);
        System.out.println(user);
        return  user;
    }

    public List<User> findUserByName(String name) throws Exception {
        List<User> list = userDao.findUserByName(name);
        Iterator<User> user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
        return list;
    }

    public List<User> findUserByNumber(String number) throws Exception {
        List<User> list = userDao.findUserByNumber(number);
        Iterator<User> user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
        return list;
    }

    public List<User> findUsers() throws Exception {
        List<User> list = userDao.findUsers();
        Iterator<User> user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
        return list;
    }

    public void insertUser(User user) throws Exception {
        userDao.insertUser(user);
        System.out.println("插入成功！id=" + user.getId());
    }

    public void deleteUser(int id) throws Exception {
        userDao.deleteUser(id);
        System.out.println("true！成功删除");
    }

    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
        System.out.println("true！更新成功");
    }

}
