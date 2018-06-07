package com.ptteng.controller;

import com.ptteng.client.MyRMIClient;
import com.ptteng.entity.UserT11;
import com.ptteng.service.UserService_t11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController_t11 {
    //@Autowired
    //private UserService_t11 userServiceImpl_t11;
    @Autowired
    private MyRMIClient myRMIClient;
    //UserService_t11 userServiceImpl_t11 = (UserService_t11) myRMIClient.object( "myRMIServer1-2", "myRMIServer2-2");

    @RequestMapping(value = "/u/t11", method = RequestMethod.GET)
    public String save(Model model) {
        List<UserT11> userT11 = ((UserService_t11) myRMIClient.object( "myRMIServer1-2", "myRMIServer2-2")).getAll2();
        model.addAttribute("user_t11", userT11);
        model.addAttribute("size", userT11.size());
        long time = System.currentTimeMillis();
        model.addAttribute("time", time);
        return "t11";
    }
}
