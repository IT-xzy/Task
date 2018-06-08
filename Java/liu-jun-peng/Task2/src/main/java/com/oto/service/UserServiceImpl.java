package com.oto.service;

import com.oto.dao.UserDao;
import com.oto.pojo.User;
import com.oto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 刘军鹏
 * @program: demo
 * @description:
 * @create: 2018/5/23 上午9:14
 */
@Service
public class UserServiceImpl implements UserService {
   
   @Autowired
   private UserDao userDao;
  
    @Override
    public User findUserById(int id) {
       
        User user= userDao.findUserById(id);
      
        return user;
        
    }
    
    @Override
    public  boolean deleteUser(Integer id) {
        
        return userDao.deleteUser(id);
        
    }
    
    @Override
    public boolean updateUser(User user) {
        
        return userDao.updateUser(user);
    }
    
    @Override
    public int addUser(User user) {
       
      if(userDao.addUser(user)>0){
          
          return user.getId();
          
      } else {return -1;}
       
        
    }
    
    @Override
    public List<User> findAll() {
        
        List<User> allUser = userDao.findAll();
        
        return allUser;
        
    }
    
    public List<User> getByLimit(int startRow, int pageSize){
        
        return userDao.getUserByPage(startRow,pageSize);
    }
}
