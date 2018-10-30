package com.ptteng.controller;


import com.ptteng.entity.User;
import com.ptteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @Autowired
    private UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(ModelAndView modelAndView, String name, long password) {
        System.out.println("登录===" + name + password);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        System.out.println(user);
        User u = service.check(user);
        System.out.println(u);
        if (u == null) {
            modelAndView.addObject("code", -1);
        } else {
            modelAndView.addObject("code", 0);
        }
        modelAndView.setViewName("user");
        return modelAndView;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(User user, ModelAndView modelAndView) {
        System.out.println("开始注册");
        System.out.println("注册用户入参" + user);
        try {
            service.register(user);
            modelAndView.addObject("code", 0);
        } catch (Exception e) {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("user");
        return modelAndView;
    }


}
