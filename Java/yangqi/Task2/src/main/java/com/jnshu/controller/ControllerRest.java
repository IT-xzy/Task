package com.jnshu.controller;

import com.jnshu.entity.User;
import com.jnshu.service.YserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class ControllerRest {
    //日志
    private static Logger logger = Logger.getLogger(ControllerRest.class);

    @Autowired
    private YserService yserService;


    //查
    //显示所有
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String userList(User user, Model model) throws Exception {
        List<User> user1 = yserService.queryUser(user);
        model.addAttribute("itemsList", user1);
        return "CRUD/home";
    }
    //增加

    @RequestMapping(value = "a", method = RequestMethod.PUT, produces = "application/test;charset=utf-8")//在服务器上创建一个资源
    public String addUser(User user) throws Exception {
        System.out.println(user);
        yserService.addUser(user);
        return "redirect:/rest/user/";
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) throws Exception {
        System.out.println(id);
        return yserService.deleteUser(id);
    }

    //根据姓名查找
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView queryName(String name) throws Exception {
        System.out.println("yang");
        List<User> user1 = yserService.queryName(name);
        System.out.println(user1.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", user1);
        modelAndView.setViewName("CRUD/home");
        return modelAndView;
    }

    //改
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = "application/test;charset=utf-8")
//put 更新服务器上的一个资源
    public String updateUser(@PathVariable int id, User user) throws Exception {
        System.out.println(user.toString());
        yserService.updateId(id, user);
        return "redirect:/rest/user/";
    }

    //根据ID跳转页面
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)// 从服务器上获取一个指定资源或一个集合
    public String queryId(@PathVariable int id, Model model) throws Exception {
        User user = yserService.queryId(id);
        model.addAttribute("itemsList", user);
        return "CRUD/Update";
    }


}
