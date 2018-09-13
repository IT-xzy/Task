package com.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.utils.ChinaPhone;
import com.utils.EMailUtil;
import com.utils.EMailVerifiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.utils.MsmUtil.sendSmsCode;

@Controller
public class Verification {
    private static Logger logger = LoggerFactory.getLogger(Verification.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户短信验证
     * register
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public void ssmverify(HttpServletRequest request) throws ClientException, InterruptedException {
        String phone = request.getParameter("phone");
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        long startTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(startTime);
        String time = formatter.format(date);

        if (ChinaPhone.isPhoneLegal(phone)) {
            logger.info("接收到的手机号码为：" + phone);
            logger.info("\n手机号码格式正确");
            int count = 1;
            logger.info("\ncount=" + count);
            if (redisTemplate.opsForValue().get(time + phone) != null) {
                logger.info("\n判断手机号码是否今天有被注册过");
                count = (int) redisTemplate.opsForValue().get(time + phone);
                logger.info("\ncount++=" + count);
            }
            if (count < 5) {
                try {
                    SendSmsResponse response = sendSmsCode(phone, String.valueOf(code));
                    logger.info("\n短信接口返回的数据----------------");
                    logger.info("\nCode=" + response.getCode());
                    logger.info("\nMessage=" + response.getMessage());
                    logger.info("\nRequestId=" + response.getRequestId());
                    logger.info("\nBizId=" + response.getBizId());
                } catch (Exception e) {
                    logger.info("\n发送异常");
                }
            }
            redisTemplate.opsForValue().set("phone" + phone, String.valueOf(code), 360, TimeUnit.MINUTES);
            logger.info("\n缓存的手机验证码为：" + redisTemplate.opsForValue().get("phone" + phone));
            redisTemplate.opsForValue().set(time + phone, ++count, 24, TimeUnit.HOURS);
        } else {
            logger.info("\n输入的号码异常");
        }
    }


    /**
     * @Description: 邮箱验证
     * @Author: Sometimes
     * @Date:
     */
    @RequestMapping(value = "/emailcode", method = RequestMethod.GET)
    public void emailverify(HttpServletRequest request) throws ClientException, InterruptedException {

        logger.info("\nGET /emailcode 进入发送邮箱验证码控制器");
        String email = request.getParameter("email");
        logger.info("\nemail:" + email);
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        long startTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(startTime);
        String time = formatter.format(date);

        if (EMailVerifiUtil.emailVerification(email)) {
            logger.info("\n邮箱格式正确");
            int count = 1;
            if (redisTemplate.opsForValue().get(time + email) != null) {
                count = (int) redisTemplate.opsForValue().get(time + email);
                logger.info(email + "该邮箱已经发送了" + count + "次\n\n");
            }
            if (count < 5) {
                try {
                    EMailUtil eMailUtil = new EMailUtil().sample(email, String.valueOf(code));
                } catch (Exception e) {
                    logger.info("\n邮箱发送异常");
                }
            }
            redisTemplate.opsForValue().set("email" + email, String.valueOf(code), 5, TimeUnit.MINUTES);
            logger.info("\n缓存的邮箱验证码为：" + redisTemplate.opsForValue().get("email" + email));
            redisTemplate.opsForValue().set(time + email, ++count, 24, TimeUnit.HOURS);
        } else {
            logger.info("\n输入的邮箱异常");
        }
    }
}


//
//package com.controller;
//import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
//import com.aliyuncs.exceptions.ClientException;
//import com.utils.ChinaPhone;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//import static com.utils.MsmUtil.sendSmsCode;
//
//@Controller
//public class Verification {
//    private static Logger logger = LoggerFactory.getLogger(Verification.class);
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    /**
//     * 用户短信验证
//     * register
//     *
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/code", method = RequestMethod.GET)
//    public void ssmverify(HttpServletRequest request, HttpSession session) throws ClientException, InterruptedException {
//
//        String phone = request.getParameter("phone");
//
//        int code = (int) ((Math.random() * 9 + 1) * 100000);
//        long startTime = System.currentTimeMillis();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
//        Date date = new Date(startTime);
//        String time=formatter.format(date);
//
//        if (ChinaPhone.isPhoneLegal(phone)) {
//            logger.info("\n手机号码格式正确");
//            int count = 1;
//            if (redisTemplate.opsForValue().get(time+phone) != null) {
//                count = (int) redisTemplate.opsForValue().get(time+phone);
//            }
//            if (count < 3) {
//                try {
//                    SendSmsResponse response = sendSmsCode(phone, String.valueOf(code));
//                    logger.info("\n短信接口返回的数据----------------");
//                    logger.info("\nCode=" + response.getCode());
//                    logger.info("\nMessage=" + response.getMessage());
//                    logger.info("\nRequestId=" + response.getRequestId());
//                    logger.info("\nBizId=" + response.getBizId());
//                } catch (Exception e) {
//                    logger.info("\n发送异常");
//                }
//            }
//            redisTemplate.opsForValue().set("code" + phone, String.valueOf(code), 360, TimeUnit.MINUTES);
//            logger.info("\n缓存的手机验证码为：" + redisTemplate.opsForValue().get("code" + phone));
//            redisTemplate.opsForValue().set(time + phone, ++count, 24, TimeUnit.HOURS);
//        } else {
//            logger.info("\n输入的号码异常");
//        }
//    }
//
//    }
//


