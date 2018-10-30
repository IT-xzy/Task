package com.jnshu.Spring.daoSpring;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void add(){
        userDao.add();
    }
}
