package com.fgh.task2.service;


import com.fgh.task2.dao.UserDao;
import com.fgh.task2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "userService")
public class UserServiceImpl  {

    @Autowired
    private UserDao userDao;

    public  List<User> findUserBy(User user)throws Exception{
        return userDao.findUserBy(user);
    }

    public User findUserById (int id)throws Exception{
        return userDao.findUserById(id);
    }
    public Integer insertUser(User user)throws Exception{
        return userDao.insertUser(user);
    }
    public Boolean delUser(int id)throws Exception{
        return userDao.delUser(id);
    }
    public Boolean updateUser(User user)throws Exception{
        return  userDao.updateUser(user);
    }

    public List<User> findAll()throws Exception{
//        try{
//            int a=10/0;
//        }catch (ArithmeticException ae){
//            System.out.println("算数异常已被处理");
//        }
//        String s = null;
//        //substring 截取字符串 下标0-2
//        System.out.println(s.substring(0,3));
        return userDao.findAll();
    }


}
