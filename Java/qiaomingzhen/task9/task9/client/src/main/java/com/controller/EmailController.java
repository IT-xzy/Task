package com.controller;
/*
 * @ClassName:EmailController
 * @Description:邮箱绑定
 * @Author qiao
 * @Date 2018/8/25 20:19
 **/

import com.model.People;
import com.rmi.Server;
import com.service.UserService;
import com.service.thirdParty.EmailService;
import com.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Controller

public class EmailController {
    private static Logger logger = Logger.getLogger("EmailController.class");
    @Autowired
    Server server;
    private UserService userService;

    private EmailService emailService;

    /**
     * @param modelAndView, request, result]
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName getEmail
     * @Description 邮箱绑定，发送邮件
     * @date 2018/8/25 19:42
     */
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ModelAndView getEmail(ModelAndView modelAndView, HttpServletRequest request, Result result, People people) {
        userService=server.getUserService();
        emailService=server.getEmailService();
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String emailType = "emailBind";
        String randCode = String.valueOf(100000 + new Random().nextInt(899999));

        logger.info("getEmail:email" + email + "name" + name);

        //发送邮件
        if (emailService.sentEmail(request, randCode, emailType)) {
            //保存验证码到数据库
            people.setName(name);
            people.setEmail(randCode);
            userService.updatePeople(people);
            logger.info("success");
            result.setCode(0);
            result.setMsg("邮件发送成功，请前往验证");
            modelAndView.addObject("email", email);
        } else {
            logger.info("fail");
            result.setCode(-105);
            result.setMsg("邮件发送失败，请重试");
        }
        modelAndView.addObject("result", result);
        modelAndView.setViewName("email");
        return modelAndView;
    }

    /**
     * @param modelAndView, request, result, people]
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName checkEmail
     * @Description 绑定邮箱验证，更新数据库
     * @date 2018/8/25 19:42
     */
    @RequestMapping(value = "/emailBind", method = RequestMethod.GET)
    public ModelAndView checkEmail(ModelAndView modelAndView, HttpServletRequest request, Result result, People people) throws UnsupportedEncodingException {

        emailService=server.getEmailService();
        logger.info("checkEmail:参数：" + people.toString());
        String email = request.getParameter("email");
        String randCode = request.getParameter("randCode");
        String name = request.getParameter("name");
        logger.info(email + "-----" + randCode + "---------" + name);
        //查询数据库，验证码对比
        if (emailService.checkEmail(randCode, name)) {
            logger.info("success");
            //更新数据库
            people.setEmail(email);
            people.setUpdateTime(System.currentTimeMillis());
            userService.updatePeople(people);
            result.setMsg("验证成功");
            modelAndView.setViewName("forward:u/showPeople1");
            return modelAndView;
        }
        logger.info("fail");
        result.setMsg("验证失败");
        modelAndView.setViewName("redirect:skipEmail");
        return modelAndView;
    }

    /**
     * @param modelAndView
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName skipEmail
     * @Description 邮箱跳转页
     * @date 2018/8/25 14:48
     */
    @RequestMapping(value = "/skipEmail")
    public ModelAndView skipEmail(ModelAndView modelAndView) {
        modelAndView.addObject("item", "email");
        modelAndView.setViewName("task7");
        return modelAndView;
    }

}
