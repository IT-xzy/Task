package com.jnshu.czm.controller;

import com.jnshu.czm.model.User;
import com.jnshu.czm.service.UserService;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @Autowired
    private MemcachedClient memcachedClient;


    //  将url的映射请求映射到控制器里面
    @RequestMapping("")
    //    RequestMapping是一个用来处理请求地址映射的注解
    public String first() {
        return "first";
    }


    //添加用户
    @RequestMapping("/insert")
//    @ResponseBody
    public String insert() {
        return "insertInterface";
    }


    //        @RequestMapping("/INSERT")
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String insert(Model model, User user) {
        logger.info("User user" + user.getUserName());
        logger.info("POST /insert ");
        try {
            userService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("code", -1);
            model.addAttribute("message", "操作错误，请重试");
            return "erre";
        }
        model.addAttribute("user", user);
        return "insertResult";
    }



    //删除用户
    @RequestMapping(value="/category/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id)throws Exception {
        logger.info("DELETE / delete ");
        userService.deleteUserById(id);
        return "redirect:/main";
    }



    //更改用户
    @RequestMapping("/change/{id}")
    public String find(@PathVariable("id") Integer id,Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "updatePaper";
    }


    //    @RequestMapping("/UPDATE")
    @RequestMapping(value="/category",method = RequestMethod.PUT)
    public String update(Model model, User user) {

        logger.info("PUT /update ");
        System.out.println("user:"+user);
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("code", -1);
            model.addAttribute("message", "操作错误，请重试");
            return "erre";
        }
        return "redirect:/main";
    }


    //单条查询数据
//    private static final Logger logger = LoggerFactory.getLogger();
    @RequestMapping("/find")
    //    RequestMapping是一个用来处理请求地址映射的注解
    public String service() {
        return "findInterface";
    }


    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getUser(HttpServletRequest request, Model model) {
        logger.info("GET /findOne ");
        int userId = Integer.parseInt(request.getParameter("id"));
        model.addAttribute("user", userService.findUserById(userId));
        return "findResult";
    }

    //查询全部
    @RequestMapping("/all")
    public String findAll(Model model)throws Exception{
        List<User> userList = userService.findAll();
        logger.info("the students are::{}", userList.toString());
        model.addAttribute("userList", userList);
        return "findAll";
    }

    @RequestMapping("/main")
    public String main(@RequestParam(value = "currentPage", defaultValue = "1",/*@PathVariable*/ required = false) int currentPage, Model model) {
        model.addAttribute("pagemsg", userService.findByPage(currentPage));//回显分页数据
        return "test";

    }

    //json的使用
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String getAll(Model model)throws Exception{
        logger.info("GET /json ");
        List<User> userList = userService.findAll();
        logger.info("the students are::{}", userList.toString());
        model.addAttribute("userList", userList);
        return "json";
    }



    //缓存简单测试
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home() throws Exception{
//        logger.info("\n"+"测试");
//        memcachedClient.set("1123", 0, "2121");
//        logger.info("\n"+"缓存内容为"+memcachedClient.get("1123"));
//        return "test2";
//    }

}
