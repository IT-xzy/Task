package com.ptteng.controller;

import com.ptteng.model.User;
import com.ptteng.service.UserService;
import com.ptteng.util.RedisUtil;
import com.ptteng.util.SerializableUtilForRedis;
import com.ptteng.util.thirdAPI.ShortMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping
public class ShortMessageController {
    @Autowired
    ShortMessageUtil shortMessageUtil;
    @Autowired
    RedisUtil redisUtil;

    private static Logger logger = Logger.getLogger(String.valueOf(ShortMessageController.class));

    @RequestMapping(value = "/shortMessage", method = RequestMethod.POST)
    public String t(User user, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String phone = user.getPhone();
        logger.info(phone);
        //调用短信接口发验证码
//        shortMessageUtil.t(phone);
        model.addAttribute("user", user);
        request.getSession().setAttribute("user", user);
        return "register2";
    }

    //验证码验证方法
    @RequestMapping(value = "/shortMessageCaptche", method = RequestMethod.POST)
    public String p(String image, String password, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user1 = (User) request.getSession().getAttribute("user");
        user1.setImage(image);
        user1.setPassword(password);
        System.out.println(user1);
        System.out.println(redisUtil.get(user1.getPhone()));
        System.out.println(user1.getImage());
        if (redisUtil.get(user1.getPhone()).equals(user1.getImage())) {
            //设置头像
            user1.setImage("img/照片2.png");
            request.getSession().setAttribute("user", user1);
            model.addAttribute("result", "true");
        } else {
            model.addAttribute("result", "false");
        }
        return "register3";
    }
}
