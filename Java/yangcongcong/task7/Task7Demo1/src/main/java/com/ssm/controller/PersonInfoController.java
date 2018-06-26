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

@Controller
public class PersonInfoController {
    private final Logger logger = LoggerFactory.getLogger(PersonInfoController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/u/users/{id}", method = RequestMethod.POST)
    public String display(Model model, @PathVariable("id")Integer id) {
        logger.info("/u/users/{id}  POST user information:" + userService.getById(id));
        User user = userService.getById(id);
        model.addAttribute("u", user);
        return "details";
    }
}
