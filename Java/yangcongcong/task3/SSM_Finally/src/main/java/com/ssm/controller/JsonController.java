package com.ssm.controller;

import com.ssm.model.User;
import com.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        logger.info("the students are::{}", userList.toString());
        model.addAttribute("userList", userList);
        return "jsonDemo1";
    }

    @RequestMapping(value = "/json/students/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") Integer id, Model model) {
        logger.info("/json/students/{id} GET the student is {}", userService.getById(id));
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "jsonDemo2";
    }
}
