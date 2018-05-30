package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.model.User;
import com.ssm.service.UserService;
import com.ssm.utils.RMIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Enzo Cotter on 18/4/2.
 */
@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    /**跳转到添加页面
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String toAdd(Model model) {
        return "addUser";
    }

    /**
     * 添加用户
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(User user) {
        logger.info("/users POST the user's parameters are {}" + user.toString());
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());

        try {
            userService = RMIUtils.selectService();
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }

        userService.addUser(user);
        return "redirect:/users";
    }
    /**
     * 删除用户
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id, User user) {
        logger.info("/users/{id} DELETE the incoming ID is:{}",user.getId());

        try {
            userService = RMIUtils.selectService();
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }

        userService.deleteUser(id);
        return "redirect:/users";
    }

    //todo 修改用户
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(User user) {
        logger.info("/users PUT the user's parameters are " +user.toString());
        user.setUpdate_at(System.currentTimeMillis());

        try {
            userService = RMIUtils.selectService();
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }

        userService.updateUser(user);
        return "redirect:/users";
    }
    /**
     * 查询单个用户并跳转到编辑页面
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") Integer id, Model model) {
        logger.info("/users/{id} GET the information of select one ID is:{}",id);

        try {
            userService = RMIUtils.selectService();
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }

        User user=userService.getById(id);
        model.addAttribute("user",user);
        return "editUser";
    }
    /**查询所有用户
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUser(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model) {
        PageHelper.startPage(pn, 5);

        try {
            userService = RMIUtils.selectService();
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }

        List<User> userList=userService.getAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        model.addAttribute("pageInfo", pageInfo);
        return "allUsers";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }
}
