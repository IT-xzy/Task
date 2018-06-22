package com.oto.serviceImp;

import com.oto.dao.userDao;
import com.oto.pojo.user;
import com.oto.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/9 上午9:53
 */

@Service
public class userServiceImp implements userService {
    @Autowired
    private userDao Mapper;
    private static final String SKEY = "12345678";
    private static final Charset CHARSET = Charset.forName("gb2312");
   
    @Override
    public boolean login(String username, String Password) {
        System.out.println("输入账号"+username+"输入密码"+Password);
        user u = Mapper.selectByName(username);
        if (u != null){
//            验证输入的是否与数据库相同
          if(u.getUsername().equals(username)&&u.getPassword().equals(Password))
                return true;
        }
        return false;
    }
    
    public void regist(user user){
        
        Mapper.addUser(user);
        
    }
    
}
