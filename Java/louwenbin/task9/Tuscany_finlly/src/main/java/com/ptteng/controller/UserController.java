package com.ptteng.controller;

import com.ptteng.client.MyClient;
import com.ptteng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@Controller
public class UserController {
    @Resource
    private MyClient myClient;
    @RequestMapping("/")
    public String Create(Model model) throws RemoteException, NotBoundException, MalformedURLException {
        model.addAttribute("返回",myClient.getUserService().getAll());
        return "create";
    }

    @RequestMapping("/save")
    public String Save(@ModelAttribute("form") User user, Model model) {
        // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
        model.addAttribute("user", user);
        return "detail";
    }
}
