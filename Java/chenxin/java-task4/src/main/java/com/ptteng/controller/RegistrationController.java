package com.ptteng.controller;

import com.ptteng.model.User;
import com.ptteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationPage() throws Exception{
        return "register";
    }

    @RequestMapping(value= "/registerProcess",method = RequestMethod.POST)
    public String  registerProcess(User user) throws Exception {
        String result = null;
        boolean i = userService.register(user);
        System.out.println(user);
        System.out.println(i);
        if (i) {
            result = "registerSuccess";
        } else {
            result = "register";
        }
        return result;
    }
}
