package com.controller;

import com.entity.User;
import com.entity.User2;
import com.service.Impl.UserServiceImpl;
import com.service.Impl.UserServiceImpl_t11;
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
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(Model model) {
        List<User> user = userServiceImpl.getAll();
        model.addAttribute("user",user);
        model.addAttribute("size",user.size());
        long time =System.currentTimeMillis();
        model.addAttribute("time",time);
        return "index1";
    }


}
