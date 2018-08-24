package com.jnshu.czm.controller;


import com.jnshu.czm.model.User;
import com.jnshu.czm.service.UserService;
import com.jnshu.czm.util.SwitchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService getUserService(){
        return SwitchService.getUserService();
    }

//    private UserService userService=SwitchService.getUserService();

    //  将url的映射请求映射到控制器里面
    @RequestMapping("")
    //    RequestMapping是一个用来处理请求地址映射的注解
    public String first() {
            getUserService().test();
        return "first";
    }


    //添加用户
    @RequestMapping("/insert")
    public String insert() {
        return "insertInterface";
    }


    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String insert(Model model, User user) {
        logger.info("User user" + user.getUserName());

            getUserService().insertUser(user);

//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("code", -1);
//            model.addAttribute("message", "操作错误，请重试");
//            return "erre";
//        }
        model.addAttribute("user", user);
        return "insertResult";
    }



    //删除用户
    @RequestMapping(value="/category/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id) {
        getUserService().deleteUserById(id);
        return "redirect:/main";
    }



    //更改用户
    @RequestMapping("/change/{id}")
    public String find(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", getUserService().findUserById(id));
        return "updatePaper";
    }



    @RequestMapping(value="/category",method = RequestMethod.PUT)
    public String update(Model model, User user) {

        System.out.println("user:"+user);
        try {
            getUserService().updateUser(user);
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
        int userId = Integer.parseInt(request.getParameter("id"));
             model.addAttribute("user", getUserService().findUserById(userId));
        return "findResult";
    }

    //查询全部
    @RequestMapping("/all")
    public String findAll(Model model)throws Exception{
        List<User> userList = getUserService().findAll();
        logger.info("the students are::{}", userList.toString());
        model.addAttribute("userList", userList);
        return "findAll";
    }

    @RequestMapping("/main")
    public String main(@RequestParam(value = "currentPage", defaultValue = "1",/*@PathVariable*/ required = false) int currentPage, Model model) {

            model.addAttribute("pagemsg", getUserService().findByPage(currentPage));//回显分页数据

        return "test";
    }

    //json的使用
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<User> userList = getUserService().findAll();
        logger.info("the students are::{}", userList.toString());
        model.addAttribute("userList", userList);
        return "json";
    }


}
