package com.jnshu.czm.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.jnshu.czm.util.EmailUtil;
import com.jnshu.czm.util.EmailVerificationUntil;
import com.jnshu.czm.util.PhonoVerificationUntil;
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

import static com.jnshu.czm.util.SmsUtil.sendSms;

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
    public void ssmverify(HttpServletRequest request, HttpSession session) throws ClientException, InterruptedException {

        String telephone = request.getParameter("telephone");
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        long startTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(startTime);
        String time=formatter.format(date);

        if (PhonoVerificationUntil.phoneVerification(telephone)) {
            logger.info("\n手机号码格式正确");
            int count = 1;
            if (redisTemplate.opsForValue().get(time+telephone) != null) {
                count = (int) redisTemplate.opsForValue().get(time+telephone);
            }
            if (count < 5) {
                try {
                    SendSmsResponse response = sendSms(telephone, String.valueOf(code));
                    logger.info("\n短信接口返回的数据----------------");
                    logger.info("\nCode=" + response.getCode());
                    logger.info("\nMessage=" + response.getMessage());
                    logger.info("\nRequestId=" + response.getRequestId());
                    logger.info("\nBizId=" + response.getBizId());
                } catch (Exception e) {
                    logger.info("\n发送异常");
                }
            }
            redisTemplate.opsForValue().set("code" + telephone, String.valueOf(code), 5, TimeUnit.MINUTES);
            logger.info("\n缓存的电话验证码为：" + redisTemplate.opsForValue().get("code" + telephone));
            redisTemplate.opsForValue().set(time + telephone, ++count, 24, TimeUnit.HOURS);
        } else {
            logger.info("\n输入的号码异常");
        }
    }

        /**
         * 用户邮箱验证
         * register
         *
         * @return
         * @throws Exception
         */
    @RequestMapping(value = "/emailcode", method = RequestMethod.GET)
    public void emailverify(HttpServletRequest request) throws ClientException, InterruptedException {

        logger.info("\nGET /emailcode 进入发送邮箱验证码控制器");
        String email = request.getParameter("email");
        logger.info("\nemail:"+email);
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        long startTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(startTime);
        String time=formatter.format(date);


        if (EmailVerificationUntil.emailVerification(email)) {
            logger.info("\n邮箱号码格式正确");
            int count = 1;
            if (redisTemplate.opsForValue().get(time+email) != null) {
                count = (int) redisTemplate.opsForValue().get(time+email);
            }
            if (count < 5) {
                try {
                    EmailUtil emailDemo=new EmailUtil().sample(email,String.valueOf(code));
                } catch (Exception e) {
                    logger.info("\n发送异常");
                }
            }
            redisTemplate.opsForValue().set("code" + email, String.valueOf(code), 5, TimeUnit.MINUTES);
            logger.info("\n缓存的电话验证码为：" + redisTemplate.opsForValue().get("code" + email));
            redisTemplate.opsForValue().set(time+email,++count, 24, TimeUnit.HOURS);
        } else {
            logger.info("\n输入的号码异常");
        }
        }
    }



