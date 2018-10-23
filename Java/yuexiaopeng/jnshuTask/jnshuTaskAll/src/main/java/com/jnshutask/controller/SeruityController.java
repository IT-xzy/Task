package com.jnshutask.controller;

import com.jnshutask.controller.ControllerUtil.UserNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class SeruityController {
    @RequestMapping("/denglu")
    public String denglu() {
        return "denglu";
    }

    @RequestMapping("/bsHome")
    public String bsHome() {
        return "bsHome";
    }

    @RequestMapping("/s/admin")
    public String admin(Model model) {
        String username=new UserNameUtil().getUsername();
        model.addAttribute("username", username);
        return "detail";
    }

    @RequestMapping("/s/user")
    public String user(Model model) {
        String username=new UserNameUtil().getUsername();
        model.addAttribute("username", username);
        return "detail";
    }
}
