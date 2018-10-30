package com.jnshu.controller;

import com.jnshu.model.Login;
import com.jnshu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
   private LoginService loginService;

    @RequestMapping(value = "/login/list", method = RequestMethod.GET)
    public String getLogin(Model model) {
        System.out.println(123);
        List<Login> list = loginService.findAllLogin();
        System.out.println(list);
        model.addAttribute("code", 200);
        model.addAttribute("data", list);
        return "login";
    }

    @RequestMapping(value = "/login/list", method = RequestMethod.POST)
    public String postLogin(Model model, Login login) {
        login.setCreate_at(System.currentTimeMillis());
        login.setUpdate_at(System.currentTimeMillis());
        long a = loginService.addLogin(login);
        if (a > 0) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        System.out.println(login);
        return "work";
    }

    @RequestMapping(value = "/login/list", method = RequestMethod.PUT)
    public String putLogin(Model model, Login login) {
        login.setUpdate_at(System.currentTimeMillis());
        if (loginService.updateLogin(login)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";
    }

    @RequestMapping(value = "/login/list/{id}", method = RequestMethod.GET)
    public String findLogin(@PathVariable("id") long id, Model model) {
        Login a = loginService.findByLogin(id);
        if (a != null) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }

    @RequestMapping(value = "/login/list/{id}", method = RequestMethod.DELETE)
    public String deleteLogin(@PathVariable("id") long id, Model model) {
        if (loginService.deleteLogin(id)) {
            model.addAttribute("code", 200);
        } else {
            model.addAttribute("code", -200);
        }
        return "work";

    }

}
