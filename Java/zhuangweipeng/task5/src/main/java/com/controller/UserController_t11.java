package com.controller;

import com.entity.User2;
import com.service.Impl.UserServiceImpl_t11;
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
    @RequestMapping(value = {"/u/career"}, method = RequestMethod.GET)
    public String save(Model model) {
        //取出职业介绍数据
        List<User2> user2 = userServiceImpl_t11.getAll2();
        model.addAttribute("user_t11",user2);
        //算出user_t11表中数据量大小，循环输出数据
        model.addAttribute("size",user2.size());
        //System.out.println(user2);
        //System.out.println(user2.size());
        return "career";
    }
}





