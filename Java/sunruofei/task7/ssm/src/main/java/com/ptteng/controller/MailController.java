package com.ptteng.controller;

import com.ptteng.model.User;
import com.ptteng.service.MailService;
import com.ptteng.service.UserService;
import com.ptteng.utils.MailUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Random;
import java.util.TimeZone;

/**
 * @ClassName MailController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/11  19:06
 * @Version 1.0
 **/
@Controller
public class MailController {
    @Autowired
    MailService mailService;
    @Autowired
    MailUtil mailUtil;
    @Autowired
    UserService userService;
    Logger logger = Logger.getLogger(MailController.class);

    @RequestMapping(value = "/p/gain", method = RequestMethod.GET)
    public String getMessage() {
        return "one/mail";
    }

    public String randomMessage() {
        Random random = new Random();
        String message = String.valueOf(1000 + random.nextInt(8999));
        logger.info("验证码是多少?++++++++++" + message);
        return message;
    }


    @RequestMapping(value = "/getMail", method = RequestMethod.POST)
    public String getMessage(String mail) throws IOException {
        logger.info("邮箱是多少啊?=====" + mail);
        //获取随机数,作为验证码存在数据库里,然后发送
        String message = randomMessage();
        int state = mailService.insertCodeMail(mail, message, System.currentTimeMillis());
        logger.info("插入与否======" + state);
        mailUtil.send_common(mail, message);
        return "one/registerMail";
    }

    @RequestMapping(value = "/registerByMail", method = RequestMethod.POST)
    public String register(HttpServletRequest request) {
        //获取参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        String code = request.getParameter("code");
        String phone= request.getParameter("phone");
        //参数判空
        if (!ObjectUtils.isEmpty(name)
                && !ObjectUtils.isEmpty(password)
                && !ObjectUtils.isEmpty(mail)
                && !ObjectUtils.isEmpty(code)) {
            //用户名是否存在
            User userName = userService.selectByName(name);
            logger.info("用户名是========" + userName);
            if (ObjectUtils.isEmpty(userName)) {
                //用户名不存在,可注册
                //查找mail表中是否有发送的邮件和验证码
                User user = userService.selectCodeMail(code, mail);
                logger.info("code and mail" + user);
                if (ObjectUtils.isEmpty(user)) {
                    logger.info("请重新获取验证码");
                    return "one/mail";
                } else {
                    //注册
                    logger.info("邮箱与验证码匹配");
                    int state = userService.insertMail(name, password, mail, phone);
                    logger.info("插入成功与否" + state);
                    return "one/home";
                }
            } else {
                logger.info("用户名已经存在");
                return "one/registerMail";
            }
        } else {
            logger.info("数据为空");
            return "one/registerMail";
        }
    }



}
