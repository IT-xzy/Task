package com.jnshuboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class SeruityController {
    @RequestMapping("/denglu")
    public String denglu() {
        return "denglu";
    }

    //    @RequestMapping("/dengchu")
//    public String dengchu() {
//        return "dengchu";
//    }
    @RequestMapping("/s/admin")
    public String admin(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "haha";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            log.info("登录的admin用户为" + username);
        } else {
            username = principal.toString();
        }
        model.addAttribute("username", username);
        return "detail";
    }

    @RequestMapping("/s/user")
    public String user(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "haha";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        model.addAttribute("username", username);
        return "detail";
    }
}
