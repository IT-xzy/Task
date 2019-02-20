package com.controller;

import com.entity.User;
import com.service.UserService;
import com.util.JWT;
import com.util.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user) {
        logger.info(user);
//        输入的数据如果为空则注册失败
        if (user.getName() == null || user.getPassword() == null) {
            return "false";
        }
//       对姓名和密码分别进行加密，传入数据库,使用的是不同的加密算法，每次姓名加密后是一样的，密码每次加密后是不一样的
        user.setName(MD5Util.MD5(user.getName()));

        user.setPassword(MD5Util.generate(user.getPassword()));


        user.setUpdateAt(System.currentTimeMillis());
        user.setCreateAt(System.currentTimeMillis());
       if(userService.login(user.getName())!=null){
           return "false";
       }
        try {
            userService.register(user);
        } catch (Exception e) {
            return "false";
        }
        return "redirect:/student";
    }

}