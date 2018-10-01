package com.jnshu.ssm.controller;


import com.jnshu.ssm.entities.User;
import com.jnshu.ssm.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class StuController {


    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userList(User user, Model model) throws Exception {
        List<User> user1 = userService.getAllUser();
        model.addAttribute("itemsList", user1);
        return "CRUD/home";
    }

    //增

    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/test;charset=utf-8")
    public String addUser(User user) throws Exception {
        userService.saveUser(user);
        return "redirect:/rest/user/";
    }

    //删

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) throws Exception {
        System.out.println(id);
        return userService.deleteUser(id);
    }


    //改

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST, produces = "application/test;charset=utf-8")
    public String updateUser(@PathVariable int id, User user) throws Exception {
        userService.updateUser(id,user);
        return "redirect:/rest/user/";
    }

    //根据ID得到用户数据

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String queryId(@PathVariable int id, Model model) throws Exception {
        User user = userService.getUserById(id);
        model.addAttribute("itemsList", user);
        return "CRUD/Update";
    }

//根据条件查询

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView queryName(User user) throws Exception {
        List<User> user1 =userService.getUserMore(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", user1);
        modelAndView.setViewName("CRUD/home");
        return modelAndView;
    }
}
