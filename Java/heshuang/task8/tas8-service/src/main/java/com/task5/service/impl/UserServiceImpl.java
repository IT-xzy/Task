package com.task5.service.impl;

import com.task5.mapper.UserDao;
import com.task5.pojo.User;
import com.task5.service.UserService;
import com.task5.until.MD5;
import com.task5.until.RedisUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    @Autowired
    private MD5 md5;
    @Autowired
    RedisUntil redisUntil;


    @Override
    public String login(User user) throws Exception {

        //登录判断
        User user1 = userDao.findUserByName(user.getUserName());
        if (user1 == null){
            return "此用户不存在！";
        }
        String salt = user1.getSalt();
        String key = md5.md5encryption(user.getPassword()+salt);
        if (key ==null){
            return "密码错误，请重试";
        }
        user.setPassword(key);


        if (userDao.checkUser(user.getUserName(),user.getPassword())!=null){
            return "true";
        } else{
        return "用户名和密码不匹配";
        }
    }

    public String check(User user,String SmsCheckCode,String EmailCheckCode)throws Exception{
        if (userDao.findUserByName(user.getUserName())!=null){
            return "此用户已被注册";
        }
        if (user.getUserName().trim().length()<1){
            return "用户名必须大于1位";
        }
        if (user.getPassword().trim().length()<3){
            return "密码必须大于3位";
        }

//        String SmsCheckCode = RequestContextHolderUtil.getRequest().getParameter("SmsCheckCode");


        System.out.println("前端手机验证码:" + SmsCheckCode);

        /** 获取redis中存放的手机短信验证码 */
        String code = (String) redisUntil.get("code");

        System.out.println("缓存手机验证码:" + code);

//        String EmailCheckCode = RequestContextHolderUtil.getRequest().getParameter("EmailCheckCode");
        System.out.println("前端邮箱验证码:" + EmailCheckCode);

        /** 获取redis中存放的邮箱验证码 */
        String emailCode = (String) redisUntil.get("emailCode");

        System.out.println("缓存邮箱验证码:" + emailCode);

        if (SmsCheckCode!=null){
                if (code.equals(SmsCheckCode)){
                    return "true";
                }
            else
                return "验证码输入错误";
        }
        if (EmailCheckCode!=null){
                if ( EmailCheckCode.equals(emailCode)){
                    return "true";
            }
            else
                return "验证码输入错误";
        }
        return "此用户已被注册";
    }

    @Override
    public String register(User user,String SmsCheckCode,String EmailCheckCode) throws Exception {
        String message = check(user,SmsCheckCode,EmailCheckCode);
        if (message.equals("true")){
            System.out.println("用户名：" + user.getUserName());
            System.out.println("密码："+ user.getPassword());
            String[] key = md5.encryption(user.getPassword());
            if (key[0] == null) {
                return "系统出错，请重试";
            }
            user.setPassword(key[0]);
            user.setSalt(key[1]);
            user.setCreateAt(System.currentTimeMillis());
            user.setUpdateAt(System.currentTimeMillis());
            //注册该用户
            if (userDao.addUser(user) > 0) {
                return "true";
            } else {
                return "注册失败，请稍后尝试";
            }
        } else {
            return message;
        }

    }

    @Override
    public User findUserByPhoneNumber(String phoneNumber) throws Exception {
        return userDao.findUserByPhoneNumber(phoneNumber);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        return userDao.findUserByEmail(email);
    }

    @Override
    public Integer updateUser(User user) throws Exception {
        return userDao.updateUser(user);//只是本地上传使用的
    }

    @Override
    public User checkUser(String userName, String password) throws Exception {
        return userDao.checkUser(userName,password);
    }

    @Override
    public User findUserByName(String userName) throws Exception {
        return userDao.findUserByName(userName);
    }

    @Override
    public Integer addUser(User user) throws Exception {
        return userDao.addUser(user);
    }

    @Override
    public User findUserById(int id) throws Exception {
        return userDao.findUserById(id);
    }

}

