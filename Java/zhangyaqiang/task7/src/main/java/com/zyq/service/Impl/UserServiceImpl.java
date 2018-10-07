package com.zyq.service.Impl;

import com.zyq.controller.StudentController;
import com.zyq.mapper.UserMapper;
import com.zyq.pojo.User;
import com.zyq.service.UserService;
import com.zyq.util.EmailRegisterUtil;
import com.zyq.util.RandomNumUtil;
import com.zyq.util.RedisUtil;
//import com.zyq.util.TelRegisterUtil;
import com.zyq.util.TelRegisterUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    private static Logger logger = LogManager.getLogger(StudentController.class);

    @Override
    public void insert(User user) {
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        userMapper.insert(user);
    }

    @Override
    public User selectByUserName(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User selectByTel(String telephone) {
        return userMapper.selectByTel(telephone);
    }

    @Override
    public User selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public Integer selectIdById(Integer id) {
        return userMapper.selectIdById(id);
    }

    @Override
    public String selectPwdByUserName(String username) {
        return userMapper.selectPwdByUserName(username);
    }

//    验证手机号是否存在
    @Override
    public String selectPwdByTelephone(String telephone) {
        return userMapper.selectPwdByTelephone(telephone);
    }

    //    验证邮箱是否存在
    @Override
    public String selectPwdByEmail(String email) {
        return userMapper.selectPwdByEmail(email);
    }

    @Override
    public void updateByUsername(String username,User user) {
        if (user.getName()==null||user.getName().length()<=0){
            User user2 = userMapper.selectByUsername(username);
            user.setName(user2.getName());
        }
        if (user.getHeadPhoto()==null||user.getHeadPhoto().length()<=0){
            User user3 = userMapper.selectByUsername(username);
            user.setHeadPhoto(user3.getHeadPhoto());
        }
        userMapper.updateByUsername(username,user.getHeadPhoto(),user.getName());
    }

    //    发送手机验证码
    @Override
    public String SendTelMsg(String telephone) {
        //上次发送时间，默认为0
        long time=0;
        //发送次数，默认为0
        int num = 0;
        //判断发送时间间隔是否在1分钟之内
        if (null!=redisUtil.get("time"+telephone)){
            time = (long) redisUtil.get("time"+telephone);
            long curTime = System.currentTimeMillis();
            if ((curTime-time)<1000*60){
                return "2";
            }
        }
        //判断24小时之内发送次数是否小于等于3
        if (null!=redisUtil.get("num"+telephone)){
            num = (int) redisUtil.get("num"+telephone);
            logger.info("获得："+redisUtil.get("num"+telephone));
            logger.info("获得："+num);
            if (num>=3){
                return "3";
            }
        }
        //生成随机四位验证码
        String msgCode = RandomNumUtil.registerMessage();
        String msgStatus = null;
        //调用容联发送验证码，并捕获异常，返回发送结果
        try {
            msgStatus = TelRegisterUtil.sendTemplateSMS(telephone,msgCode);
        } catch (Exception e) {
            logger.info("容联发送手机注册信息失败");
            e.printStackTrace();
        }
        //判断发送结果是否成功，成功则将验证码、当前时间以及发送次数放入缓存
        if (msgStatus!=null && "true".equals(msgStatus)) {
            redisUtil.set("time"+telephone,System.currentTimeMillis(),60);
            redisUtil.set("msgCode"+telephone,msgCode,60);
            redisUtil.set("num"+telephone,++num,60*60*24);
            logger.info("设置："+redisUtil.get("num"+telephone));
            return "0";
        }
        return "1";
    }
//    发送邮箱验证码

    @Override
    public String SendEmailMsg(String email) {
        String msgCode = RandomNumUtil.registerMessage();
        String msgStatus = null;
        try {
            msgStatus = EmailRegisterUtil.send_common(email,msgCode);
        } catch (Exception e) {
            logger.info("sendCloud发送邮件注册信息失败");
            e.printStackTrace();
        }
        if (msgStatus!=null && "true".equals(msgStatus)) {
            redisUtil.set("email:" + email, msgCode, 60);
            return "0";
        }
        return "1";
    }
//    验证手机验证码是否正确

    @Override
    public String verifyTelMsg(String telephone, String message) {
        //从缓存中取出验证码进行比对
            if ((null!=redisUtil.get("msgCode"+telephone))&&(message.equals(redisUtil.get("msgCode"+telephone)))){
            redisUtil.del("msgCode"+telephone);
            return "0";
        }
        return "1";
    }
//    验证邮箱验证码是否正确

    @Override
    public String verifyEmailMsg(String email, String message) {
        logger.info(redisUtil.get("email:"+email));
        if ((redisUtil.get("email:"+email)!=null)&&(message.equals(redisUtil.get("email:"+email)))){
            redisUtil.del("email:"+email);
            return "0";
        }
        return "1";
    }
}
