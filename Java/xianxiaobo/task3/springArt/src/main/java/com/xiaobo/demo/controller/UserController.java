package com.xiaobo.demo.controller;

import com.xiaobo.demo.pojo.Login;
import com.xiaobo.demo.pojo.Response;
import com.xiaobo.demo.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/a")
public class UserController {
    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    Login login;
    @Autowired
    Response response;
    //获取所有用户
    @RequestMapping(value = "/u/user", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllUser(){
        List<Login> loginList = loginService.getAll();
        ModelAndView modelAndView = new ModelAndView("userList");
        Response response = new Response();
        modelAndView.addObject("response",response);
        modelAndView.addObject("data",loginList);
        return modelAndView;
    }
}
