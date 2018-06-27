
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
        logger = Logger.getLogger(UserController.class);
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index() {
        System.out.println("主页");
        return "index";
    }

    @RequestMapping(value = {"/user/result"}, method = RequestMethod.GET)
    public String toadd() {
        return "add";
    }

    @RequestMapping(value = {"/user/result"}, method = {RequestMethod.POST})
    public String insertUser(User user) {
        userService.insertUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = {"/user"}, method = {RequestMethod.GET})
    public String selectUser(Model model, int id) {
        model.addAttribute("查询结果", userService.selectUser(id));
        return "cha";
    }

    @RequestMapping(value = {"/user/{id}"}, method = {RequestMethod.DELETE})
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = {"/user"}, method = {RequestMethod.PUT})
    public String updateUser(Model model, User user) {
        String emptyName = user.getName();
        if ((emptyName != null) && (emptyName.length() > 0)) {
            userService.selectUser(user.getId());
            userService.updateUser(user);

            return "redirect:/users";
        }
        model.addAttribute("sel", "姓名不能为空");
        return "redirect:/emptyname";
    }

    @RequestMapping(value = {"/emptyname"}, method = {RequestMethod.GET})
    public String emp() {
        return "emptyname";
    }

    @RequestMapping(value = {"/users"}, method = {RequestMethod.GET})
    public String getAllUser(Model model) {
        List userList = userService.getAll();
        model.addAttribute("allUsers", userList);
        return "allUsers";
    }

    @RequestMapping(value = {"/json"}, method = {RequestMethod.GET})
    public String json(Model model, int id) {
        model.addAttribute("sel", userService.selectUser(id));
        return "json";
    }
}

