package com.controller;

import com.entity.User;
import com.entity.User2;
import com.service.Impl.UserServiceImpl;
import com.service.Impl.UserServiceImpl_t11;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(Model model) {
        List<User> user = userService.getAll();
        List<User> limit = userService.limit();
        model.addAttribute("user", user);
        User u = user.get(0);
        model.addAttribute("studynum", u.getStudynum());
        model.addAttribute("jobnum", u.getJobnum());
        model.addAttribute("limit", limit);
        return "home";
    }
}
