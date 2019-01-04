package com.ptteng.controller;

import com.ptteng.entity.User;
import com.ptteng.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//返回json格式的数据

@Controller
public class JsonUserController {

    @Autowired
    private UserService userService;

    static Logger logger = Logger.getLogger(JsonUserController.class);

    @RequestMapping(value = "/json/user", method = RequestMethod.GET)
    @ResponseBody
    public User login(Long id) {
        logger.info("id====" + id);
        User user = userService.findById(id);
        logger.info("user====" + user);
        return user;
    }
}
