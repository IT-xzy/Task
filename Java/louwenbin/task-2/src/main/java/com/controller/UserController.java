package com.controller;

import com.entity.User;
import com.service.Impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);

    @Resource
    private UserServiceImpl userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
            return "index";
    }

    @RequestMapping(value = "/user/result", method = RequestMethod.GET)
    public String toadd() {
        return "add";
    }

    @RequestMapping(value = "/user/result", method = RequestMethod.POST)
    public String insertUser(User user) {
        logger.info(user.toString());
        userService.insertUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String selectUser(Model model, int id) {
        model.addAttribute("查询结果", userService.selectUser(id));
        return "cha";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id, Model model) {
        logger.info("/del/{} POST");
        Boolean success = userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(Model model, User user) {
        logger.info("INFO的信息");
        String emptyName=user.getName();
        if(emptyName!=null&&emptyName.length()>0){
            userService.selectUser(user.getId());
            Boolean success = userService.updateUser(user);
            return "redirect:/users";
        }else {
            return "redirect:/emptyname";
        }
    }
    @RequestMapping(value = "/emptyname",method =RequestMethod.GET)
        public String emp(Model model){
        return "emptyname";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUser(User user, Model model) {
            List<User> userList=userService.getAll();
            model.addAttribute("allUsers", userList);
            return "allUsers";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String json(User user, Model model,int id) {
        model.addAttribute("sel", userService.selectUser(id));
        return "json";
    }
}
