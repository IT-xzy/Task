package com.controller;

import com.entity.User2;
import com.service.Impl.UserServiceImpl_t11;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
@Controller
public class UserController_t11 {
    @Resource
    private UserServiceImpl_t11 userServiceImpl_t11;
    @RequestMapping(value = {"/t11"}, method = RequestMethod.GET)
    public String save(Model model) {
        List<User2> user2 = userServiceImpl_t11.getAll2();
        model.addAttribute("user_t11",user2);
        model.addAttribute("size",user2.size());
        long time =System.currentTimeMillis();
        model.addAttribute("time",time);
        return "t11";
    }
}
