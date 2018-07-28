package com.task4.controller;


import com.task4.pojo.Profession;
import com.task4.pojo.User;
import com.task4.service.ProfessionService;
import com.task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
//@RequestMapping(value="/task4")
public class MyController {
    @Autowired
    UserService userService;
    @Autowired
    ProfessionService professionService;


    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String main(Model model) {
        List<User> list=userService.selectAll();
        model.addAttribute("user", list);
        int number=0;
        int worker=0;
        List<Profession> list2=professionService.selectProfession();
        for (Profession l : list2) {
            number+= l.getNumber();
            worker+=l.getWorker();
        }
        model.addAttribute("number", number);
        model.addAttribute("worker", worker);

        return "main";
    }

    @RequestMapping(value = "/u/profession",method = RequestMethod.GET)
    public String pro(Model model) {
        List<Profession> list2 = professionService.selectProfession();
        model.addAttribute("professionList", list2);
        return "profession";
    }


    @RequestMapping(value = "/u/recommend",method = RequestMethod.GET)
    public String rec() {
        return "recommend";
    }


}
