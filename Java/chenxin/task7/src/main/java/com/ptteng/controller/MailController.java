package com.ptteng.controller;

import com.ptteng.model.User;
import com.ptteng.util.RedisUtil;
import com.ptteng.util.thirdAPI.MailCaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Controller
public class MailController {

    @Autowired
    MailCaptchaUtil mailCaptchaUtil;

    @Autowired
    RedisUtil redisUtil;

    private static Logger logger = Logger.getLogger(String.valueOf(MailController.class));
    /**
     * 调用邮箱验证码
     */
    @RequestMapping(value = "/emailMessage",method = RequestMethod.POST)
    public String send(User user, HttpServletRequest request, HttpServletResponse response){
        String email = user.getEmail();
        logger.info(email);
        //调用邮箱接口
        mailCaptchaUtil.sample(email);
        request.getSession().setAttribute("user", user);
        return "emailRegister2";
    }
    /**
     * 验证验证码方法
     * @param image 用来存放邮箱验证码
     * @param password
     */
    @RequestMapping(value = "/emailCaptche",method = RequestMethod.POST)
    public String v(String image, String password, Model model, HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        user.setImage(image);
        user.setPassword(password);

        System.out.println(user.getImage());
        System.out.println(redisUtil.get(user.getEmail()));
        //对比缓存
        if (redisUtil.get(user.getEmail()).equals(user.getImage())){
            user.setImage("img/照片2.png");
            request.getSession().setAttribute("user", user);
            model.addAttribute("result", "true");
        }else {
            model.addAttribute("result", "false");
        }
        return "emailRegister3";
    }
}
