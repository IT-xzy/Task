
package com.controller;

import com.entity.User;
import com.service.Impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    private Logger logger;
    @Resource
    private UserServiceImpl userService;

    public UserController() {
        this.logger = Logger.getLogger(UserController.class);
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println("主页");
        return "index";
    }

    @RequestMapping(value = {"/user/result"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String toadd() {
        return "add";
    }

    @RequestMapping(value = {"/user/result"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    public String insertUser(User user) {
        this.logger.info(user.toString());
        this.userService.insertUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = {"/user"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String selectUser(Model model, int id) {
        model.addAttribute("查询结果", this.userService.selectUser(id));
        return "cha";
    }

    @RequestMapping(value = {"/user/{id}"}, method = {org.springframework.web.bind.annotation.RequestMethod.DELETE})
    public String deleteUser(@PathVariable int id, Model model) {
        Boolean success = Boolean.valueOf(this.userService.deleteUser(id));
        return "redirect:/users";
    }

    @RequestMapping(value = {"/user"}, method = {org.springframework.web.bind.annotation.RequestMethod.PUT})
    public String updateUser(Model model, User user) {
        String emptyName = user.getName();
        if ((emptyName != null) && (emptyName.length() > 0)) {
            this.userService.selectUser(user.getId());
            Boolean success = Boolean.valueOf(this.userService.updateUser(user));
            return "redirect:/users";
        }
        return "redirect:/emptyname";
    }

    @RequestMapping(value = {"/emptyname"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String emp(Model model) {
        return "emptyname";
    }

    @RequestMapping(value = {"/users"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String getAllUser(User user, Model model) {
        List userList = this.userService.getAll();
        model.addAttribute("allUsers", userList);
        return "allUsers";
    }

    @RequestMapping(value = {"/json"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String json(User user, Model model, int id) {
        model.addAttribute("sel", this.userService.selectUser(id));
        return "json";
    }
}

