package com.jnshu.controller;

import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {


    UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String get(Model model) throws RemoteException, NotBoundException, MalformedURLException {


        int code = new Random().nextInt(2);
        if (code == 0) {
            try {
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:8088/userService");
            } catch (Exception e) {
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:8086/userService");
            }
        } else {
            try {
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:8086/userService");
            } catch (Exception e) {
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:8088/userService");
            }

        }

        try {
            List<User> list = userService.selectAll();
            System.out.println(list + "======");
            model.addAttribute("data", list);
            model.addAttribute("code", 200);

        } catch (Exception e) {
            model.addAttribute("code", 201);

        }
        return "jsp/all";
    }
}
