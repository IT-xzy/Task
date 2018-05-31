package com.oto.service;
        
        import com.oto.pojo.User;
        
        import java.util.List;

/**
 * @author: 刘军鹏
 * @program: demo
 * @description:
 * @create: 2018/5/22 下午1:05
 */

public interface UserService {
   
    User findUserById(int id) ;
    
    boolean deleteUser(Integer id) ;
    
    boolean updateUser(User user) ;
    
    int addUser(User user);
    
    List<User> findAll();
    
   
}
