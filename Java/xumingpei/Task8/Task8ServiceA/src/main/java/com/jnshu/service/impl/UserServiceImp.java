package com.jnshu.service.impl;

import com.jnshu.dao.UserMapper;
import com.jnshu.pojo.User;
import com.jnshu.service.UserService;
import com.jnshu.tool.MailUtil;
import com.jnshu.tool.SMS;
import com.jnshu.tool.UuidUtil;
import com.jnshu.tool.redis.Redis;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/4/3 - 2:12
 */
@Service
public class UserServiceImp implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImp.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    SMS sms;

    @Autowired
    Redis redis;

    @Autowired
    MailUtil mailUtil;

    final long expireTime = 60 * 5;

    @Override
    public int insert(User record) {
        int x = userMapper.insert(record);
        logger.info("插入的是："+record);
        return x;
    }

    @Override
    public User selectById(Long id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public List<User> selectByName(String name) {
        List<User> user = userMapper.selectByName(name);
        logger.info(user.toString());
        return user;
    }

    @Override
    public List<User> selectByNameAndPassword(String name, String password) {
        List<User> user = userMapper.selectByNameAndPassword(name,password);
        logger.info(user.toString());
        return user;
    }

    /**
     * 发送短信验证码，每1分钟之后可以重复发送，每次有效期为10分钟，每天最多发送5次
     * @param phone 手机号
     * @return  0：发送成功 1：其他 2:发送过于频繁 3：超过每天最大次数
     */
    @Override
    public int sendPhone(String phone,String msgCode) {
        //默认发送时间为0
        long time = 0;
        //发送次数，默认为0
        int next = 0;
        //判断发送时间间隔是否在1分钟之内
        if (redis.get("time"+phone) !=null){
            time = (long) redis.get("time"+phone);
            long nowTime =System.currentTimeMillis();
            if ((nowTime - time)<1000*60){
                return 2;
            }
        }

        //判断24小时之内发送次数是否小于等于最大次数
        if (redis.get("next"+phone) !=null){
            next = (int) redis.get("next"+phone);
            logger.info("手机号码发送验证码次数："+next);
            if (next>=5){
                return 3;
            }
        }

        String msgStatus = null;
        //调用容联发送短信验证码
        try {
            msgStatus =sms.sendMessage(phone,msgCode);
            logger.info("容联短信发送为："+msgStatus);
        }catch (Exception e){
            logger.info("容联发送手机信息失败");
            e.printStackTrace();
        }
        //判断发送结果是否成功，将验证码、当前时间以及发送次数放入缓存
        if (msgStatus !=null && msgStatus.equals("000000") ){

            redis.add("time"+phone,System.currentTimeMillis(),60);
            redis.add("msgCode"+phone,msgCode,expireTime);
            redis.add("next"+phone,++next,60*60*24);
            logger.info("手机号码发送验证码次数："+redis.get("next"+phone));
            return 0;
        }
        return 1;
    }

    /**
     * 检验手机验证码是否一致
     * @param phone
     * @param code
     * @return 0:验证成功 1:验证失败
     */
    @Override
    public int checkPhoneCode(String phone, String code) {
        String redisPhoneCode =(String) redis.get("msgCode"+phone);
        logger.info("redis中短信验证码："+redisPhoneCode);
        logger.info("输入的验证码："+code);
        //比对缓存中验证码与用户输入验证码
        if (redisPhoneCode != null && code.equals(redisPhoneCode)){
            return 0;
        }else {
            return 1;
        }

    }


    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    @Override
    public int sendEmail(String email, String msgCode) {
        String msgStatus = null;


        logger.info("email："+email+"msgCode："+msgCode);
        if ( email == null  ){
            logger.info("邮箱不能为空");
            return 1;
        }else try {
            // 由于每天次数的限制，暂时采用假的，测试其他逻辑有没有问题,基本测试完成，再换成真的
//            msgStatus = DataUtils.getMsgStatus();
            msgCode = "222222";
            msgStatus =mailUtil.send_common(email,msgCode);
//                msgStatus = "true";

            logger.info("msgStatus:"+msgStatus);
        } catch (Exception e) {
            logger.info("sendCloud发送邮件注册信息失败");
            e.printStackTrace();
        }
        if (msgStatus!=null && "200".equals(msgStatus)) {
            redis.add("msgCode"+email, msgCode);
            logger.info("邮箱验证码的缓存"+redis.add("msgCode"+email, msgCode)+redis.get("msgCode"+email));
            return 0;
        }else{
            logger.info("邮箱验证码的缓存无");
            return 1;

        }
    }

    @Override
    public int cheakEmail(String email, String code) {
        logger.info(" msgCode is："+code);
        String redisEmailCode = (String) redis.get("msgCode"+email);
        logger.info("redis中邮箱验证码："+redisEmailCode);
        if ((redisEmailCode !=null ) && (code.equals(redisEmailCode))){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public User selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

}
