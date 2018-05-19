package com.ssm.controller;

import com.ssm.model.User;
import com.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Enzo Cotter on 18/4/4.
 */
@Controller
public class JsonController {
    private final Logger logger = LoggerFactory.getLogger(JsonController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/json/students", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<User> userList = userService.getAll();
        logger.info("TEH STUDENTS SIZE {}", userList.size());
        model.addAttribute("userList", userList);
        return "jsonDemo1";
    }

    @RequestMapping(value = "/json/nmstudents", method = RequestMethod.GET)
    public String getAllNoMemcached(Model model) {
        List<User> userList = userService.getAllNoMemcached();
        logger.info("TEH STUDENTS SIZE {}", userList.size());
        model.addAttribute("userList", userList);
        return "jsonDemo1";
    }

    @RequestMapping(value = "/json/body1",method = RequestMethod.GET)
    @ResponseBody
    public User bodyTest() {
        User obj = userService.getById(998);
        return obj;
    }

    @RequestMapping(value = "/json/body3",method = RequestMethod.GET)
    @ResponseBody
    public List<User> bodyTest3() {
        List<User> list = userService.getAllNoMemcached();
        return list;
    }
}
