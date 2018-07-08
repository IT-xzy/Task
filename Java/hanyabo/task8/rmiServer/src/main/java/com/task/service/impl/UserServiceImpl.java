package com.task.service.impl;

import com.task.dao.UserDao;
import com.task.entity.User;
import com.task.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public User checkLogin(String username, String password) {

        logger.info("username:"+username);
        logger.info("password:"+password);

        User user = userDao.findByPhone(username);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }else{
            user = userDao.findByEmail(username);
            if(user != null && user.getPassword().equals(password)) {
                return user;
            }else{
                user = userDao.findByUsername(username);
                if(user != null && user.getPassword().equals(password)) {
                    return user;
                }
            }

        }

        return null;
    }


    public User checkLogin(String username) {

        logger.info("username:"+username);
        User user = userDao.findByUsername(username);
        if(user != null){
            return user;
        }
        return null;
    }

    /*

        0:正常
        1.邮箱被占用
        2.用户名被占用
        3.手机号被占用
        4.异常

     */
    public int checkLogin(User user){
        logger.info("user:"+user);

        //手机号/邮箱 必须有
        String str = user.getPhone();
        User userResult = null;


        if(null == str){//手机号为空

            str = user.getEmail();
            if(null == str){//邮箱为空
                return 4;//手机号邮箱都为空 异常
            }
            else{//邮箱不为空
                userResult = userDao.findByEmail(str);
                if(null == userResult){//邮箱不存在

                    str = user.getUsername();

                    userResult = userDao.findByUsername(str);
                    if(null == userResult){//用户名不存在
                        return 0;
                    }else{//用户名被占用
                        return 2;
                    }

                }else{//邮箱被占用
                    return 1;
                }
            }
        }else {//手机号不为空
            userResult = userDao.findByPhone(str);
            if(null == userResult){//手机号不存在
                str = user.getUsername();
                userResult = userDao.findByUsername(str);
                if(null == userResult){//用户名不存在
                    return 0;
                }else{//用户名被占用
                    return 2;
                }

            }else{//手机号被占用
                return 3;
            }
        }
    }

    @Override
    public User checkExist(String username) {

        logger.info("username:"+username);
        return userDao.findBySign(username);
    }

    @Override
    public void addUser(User user) {
        logger.info("user:"+user);
        userDao.addUser(user);
    }

    @Override
    public int checkPhone(String phone) {
        logger.info("phone:"+phone);
        User userResult = userDao.findByPhone(phone);

        if(null == userResult){

            return 0;//没有该手机号 可以注册

        }else{

            return 3;//手机号已存在

        }
    }

    @Override
    public int checkEmail(String email) {
        logger.info("email:"+email);
        User userResult = userDao.findByEmail(email);

        if(null == userResult){

            return 0;//没有该邮箱 可以注册

        }else{

            return 1;//邮箱已存在

        }
    }

    @Override
    public int checkUsername(String username) {
        logger.info("username:"+username);
        User userResult = userDao.findByUsername(username);

        if(null == userResult){

            return 0;//没有该用户名 可以注册

        }else{

            return 2;//用户名已存在

        }
    }
}
