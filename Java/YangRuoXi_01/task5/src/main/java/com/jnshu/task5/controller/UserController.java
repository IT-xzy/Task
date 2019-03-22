package com.jnshu.task5.controller;

import com.jnshu.task5.beans.User;
import com.jnshu.task5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *  测试json字符串用方法
     * @param model 数据放在model与中
     * @return 返回json.jsp页面
     */
    @RequestMapping(value = "/userJson",method = RequestMethod.GET)
    public String selectUser( Model model){

        List<User> userList = userService.selectAllUser();
//        user.setName("zzz");
//        user.setSalary(80);
//        user.setPosition("123");
//        user.setDescription("zzzzzz");
        model.addAttribute("userList",userList);
        return "json";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addUser() {
        return "";
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String updateUser(){
        return "";
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "";
    }


    /**
     *  从数据库中查询成绩排名前四的员工
     * @param model 放入model域中
     * @return 返回到home.jsp页面中;
     */
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String showUserBysalary(Model model){
        List<User> userList = userService.selectUserBysalaryDESC().subList(0,4);
        model.addAttribute("userList",userList);
      return "home";

    }



}
