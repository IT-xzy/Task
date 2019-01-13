package com.suger.service.impl;

import com.suger.dao.UserDao;
import com.suger.pojo.Page;
import com.suger.pojo.Student;
import com.suger.pojo.User;
import com.suger.util.DataUtils;
import com.suger.util.RedisUtils;
import com.suger.util.SMS;
import com.suger.util.SendCloud;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suger.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author suger
 * @date 2018/11/19 16:12
 * 用户service的实现类
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;
    @Autowired
    RedisUtils redisUtils;

    // 设置验证码过期时间
    final long expireTime = 60 * 10;

    @Autowired
    SMS sms;


    /**
     * 发送短信验证码，每1分钟之后可以重复发送，每次有效期为10分钟，每天最多发送5次
     * @param phone 手机号
     * @return  0：发送成功 2:发送过于频繁 3：超过每天最大次数 1：其他
     */
    @Override
    public int sendPhone(String phone,String msgCode) {

        // 默认发送时间为0
        long time=0;
        //发送次数，默认为0
        int next = 0;
        //判断发送时间间隔是否在1分钟之内
        if (null!=redisUtils.get("time"+phone)){
            time = (long) redisUtils.get("time"+phone);
            long curTime = System.currentTimeMillis();
            if ((curTime-time)<1000*60){
                return 2;
            }
        }
        //判断24小时之内发送次数是否小于等于最大次数
        if (null!=redisUtils.get("next"+phone)){
            next = (int) redisUtils.get("next"+phone);
            logger.info("手机号发送验证码次数：{}",next);
            if (next>=5){
                return 3;
            }
        }

        String msgStatus = null;

        //调用容联发送验证码
        try {
            msgStatus = sms.sendMessage(phone,msgCode);
            logger.info("容联短信发送：{}",msgStatus);

            // 为测试需要，先不调用容联,使用随机工具类去模拟
            //msgStatus = DataUtils.getMsgStatus();
        } catch (Exception e) {
            logger.info("发送手机注册信息失败");
            e.printStackTrace();
        }
        //判断发送结果是否成功，将验证码、当前时间以及发送次数放入缓存
        // 由于测试手机号有限，目前移除 判断成功与否-------&& "true".equals(msgStatus)， 全部放入缓存中，

        if (msgStatus!=null ) {
            redisUtils.set("time"+phone,System.currentTimeMillis(),60);
            redisUtils.set("msgCode"+phone,msgCode,expireTime);
            redisUtils.set("next"+phone,++next,60*60*24);
            logger.info("手机号发送验证码次数：{}",redisUtils.get("next"+phone));
            return 0;
        }
       return 1;
    }

    /**
     * 发送邮箱验证码
     * @param email
     * @return 0：发送成功 1：发送失败
     */
    @Override
    public int sendEmai(String email,String msgCode) {

        String msgStatus = null;
        try {
            // 由于每天次数的限制，暂时采用假的，测试其他逻辑有没有问题,基本测试完成，再换成真的
            //msgStatus = DataUtils.getMsgStatus();
            msgStatus = SendCloud.sendCommon(email,msgCode);

            logger.info("msgStatus:"+msgStatus);
        } catch (Exception e) {
            logger.info("sendCloud发送邮件注册信息失败");
            e.printStackTrace();
        }
        if (msgStatus!=null && "true".equals(msgStatus)) {
            redisUtils.set("msgCode"+email, msgCode, expireTime);
            return 0;
        }else{
            return 1;
        }
    }


    /**
     * 检验验证码
     * @param phone 手机号
     * @param code
     * @return  0:验证成功 1:验证失败
     */
    @Override
    public int checkPhoneCode(String phone, String code) {
        String redisPhoneCode = (String) redisUtils.get("msgCode"+phone);
        logger.info("redis中手机验证码：{}",redisPhoneCode);
        logger.info("输入的验证码code:{}",code);
        //从缓存中取出验证码进行比对
        if ((null!=redisPhoneCode)&&(code.equals(redisPhoneCode))){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public int checkEmailCode(String email, String code) {
        Object redisEmailCode = redisUtils.get("msgCode"+email);
        logger.info("redis中邮箱验证码：{}",redisEmailCode);
        if ((redisEmailCode!=null)&&(code.equals(redisEmailCode))){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
    @Override
    public User getUserByphone(String phone) {
        return userDao.getUserPhone(phone);
    }


    @Override
    public User getUserByEmail(String email){
        return  userDao.getUserEmail(email);
    }


    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public Long insertUser(User user) {
        long time = System.currentTimeMillis();
        user.setImg("http://img-note.oss-cn-hangzhou.aliyuncs.com/user/img/784d6e49018f49b4adca3c213fab0a0d1546272753635.jpg");
        user.setCreateAt(time);
        user.setUpdateAt(time);
        userDao.insertUser(user);
        Long id = user.getId();
        if(id != null){
            logger.info("新增成功，缓存失效");
            redisUtils.delete("users");
        }
        logger.info("插入Id：{}", id);
        return id;
    }


    /**
     * 更新用户信息
     *
     * @param user
     * @return true-----更新成功，false------更新失败
     */
    @Override
    public Boolean updateUser(User user) {
        boolean flag = false;
        int i = userDao.updateUser(user);
        logger.info("更新id:{}", user.getId());
        logger.info("更新的信息:"+user);

        if (i != 0) {
            logger.info("更新成功，缓存失效");
            redisUtils.delete("users");
            flag = true;
        }
        return flag;
    }

    /**
     * 删除用户信息
     *
     * @param id 用户id
     * @return true-----删除成功，false------更新失败
     */
    @Override
    public Boolean deleteUser(Long id) {
        boolean flag = false;
        logger.info("删除id为：{}的用户", id);
        int i = userDao.deleteUser(id);
        if (i != 0) {
            logger.info("删除成功，缓存失效");
            redisUtils.delete("users");
            flag = true;
        }
        return flag;
    }

    /**
     * 分页查询
     *
     * @param page 分页工具类
     * @return
     */
    @Override
    public List<User> findAll(Page page) {
        logger.info("进入分页查询：当前页开始记录："+page.getStart());
        List<User> users;
        if(redisUtils.get("users"+page.getStart())==null){
            logger.info("缓存不存在数据，准备设置缓存");
            users = userDao.findAll();
            redisUtils.set("users"+page.getStart(),users);
        }else {
            logger.info("缓存已经存在,准备读取缓存数据");
            users = (List<User>) redisUtils.get("users"+page.getStart());
        }
        return users;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        logger.info("---------正在进行查全表------------------");
        List<User> users;
        if(redisUtils.get("users")==null){
            logger.info("缓存不存在数据，准备设置缓存");
            users = userDao.findAll();
            redisUtils.set("users",users);
        }else {
            logger.info("缓存已经存在,准备读取缓存数据");
            users = (List<User>) redisUtils.get("users");
        }
        return users;
    }

    /**
     * 查询记录总数
     *
     * @return 记录总数
     */
    @Override
    public int total() {
        return userDao.total();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return 具体的用户信息
     */
    @Override
    public User getUserById(Long id) {
        User user = userDao.getUserById(id);
        logger.info("根据id：{}------查询学生：{}", id, user);
        return user;
    }

    /**
     * 根据姓名和id查询，如果条件全为空，则实现查全表
     *
     * @param name
     * @return
     */
    @Override
    public List<User> getUser(String name) {
        if(name==null){
            logger.info("输入姓名为空，正在进行分页查询");
        }
        logger.info("根据姓名模糊查询");
        return userDao.getUser(name);

    }

}
