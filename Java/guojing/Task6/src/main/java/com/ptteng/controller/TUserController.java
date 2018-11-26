package com.ptteng.controller;


import com.ptteng.entity.User;
import com.ptteng.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

//返回jsp

@Controller
public class TUserController {

    static Logger logger=Logger.getLogger(TProfessionController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/t/user",method = RequestMethod.GET)
    public String findById(Long id, Model model){
        User user=userService.findById(id);
        List<User> userList=new ArrayList<>();
        userList.add(user);
        model.addAttribute("user",userList);
        model.addAttribute("code",0);
        return "user";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(User user, Model model){
        try {
            Long id = userService.insertUser(user);
            System.out.println("插入数据返回主键为"+id);
            model.addAttribute("code",0);
        }
        catch (Exception e){
            model.addAttribute("code",-1);
        }
        return "user";
    }


    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(User user, Model model) {
        try {
            Boolean flag = userService.updateUser(user);
            logger.info("更新数据是否成功"+flag);
            model.addAttribute("code",0);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "profession";
    }


    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser(Long id, Model model) {
        try {
            Boolean flag = userService.deleteUser(id);
            logger.info("删除数据是否成功"+flag);
            model.addAttribute("code",0);
        } catch (Exception e) {
            model.addAttribute("code", -1);
        }
        return "profession";
    }








}
