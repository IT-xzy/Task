package com.ptteng.controller;

import com.ptteng.entity.UserT11;
import com.ptteng.service.Impl.UserServiceImpl_t11;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
@Controller
public class UserController_t11 {
    @Resource
    private UserServiceImpl_t11 userServiceImpl_t11;
    @RequestMapping(value = "/u/t11", method = RequestMethod.GET)
    public String save(Model model) {
        List<UserT11> userT11 = userServiceImpl_t11.getAll2();
        model.addAttribute("user_t11", userT11);
        model.addAttribute("size", userT11.size());
        long time =System.currentTimeMillis();
        model.addAttribute("time",time);
        return "t11";
    }
}
