package com.task5.service.impl;

import com.task5.mapper.UserDao;
import com.task5.pojo.User;
import com.task5.service.UserService;
import com.task5.until.AliyunOSSClientUntil;
import com.task5.until.MD5;
import com.task5.until.MemcachedUtils;
import com.task5.until.RequestContextHolderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    @Autowired
    private MD5 md5;

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

    public String check(User user)throws Exception{
        if (userDao.findUserByName(user.getUserName())!=null){
            return "此用户已被注册";
        }
        if (user.getUserName().trim().length()<1){
            return "用户名必须大于1位";
        }
        if (user.getPassword().trim().length()<3){
            return "密码必须大于3位";
        }

        String SmsCheckCode = RequestContextHolderUtil.getRequest().getParameter("SmsCheckCode");
        /** 获取memcached中存放的手机短信验证码 */
        String code = (String) MemcachedUtils.get("code");

        String EmailCheckCode = RequestContextHolderUtil.getRequest().getParameter("EmailCheckCode");
        /** 获取memcached中存放的邮箱验证码 */
        String emailCode = (String) MemcachedUtils.get("emailCode");
        System.out.println("姓名:"+user.getUserName());

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
    public String register(User user) throws Exception {
        String message = check(user);
        if (message.equals("true")){
            System.out.println("密码："+user.getPassword());
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

    }

