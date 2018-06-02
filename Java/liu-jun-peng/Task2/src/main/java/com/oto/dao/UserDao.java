package com.oto.dao;

import com.oto.pojo.User;

import java.util.List;

/**
 * @author: 刘军鹏
 * @program: demo
 * @description:
 * @create: 2018/5/22 下午12:47
 */

public interface UserDao {
    User findUserById(int id) ;
    
//    List<User> findUserByName(String name) ;
    
//    void insertUsers(List<User>users);
    
    boolean deleteUser(Integer id) ;
    
    boolean updateUser(User user) ;
    
    List<User> findAll();
    
    int addUser(User user);
    
    List<User> getUserByPage(int startRow,int pageSize) ;
}
