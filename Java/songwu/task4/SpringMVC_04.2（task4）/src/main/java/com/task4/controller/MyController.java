package com.task4.controller;


import com.task4.pojo.Profession;
import com.task4.pojo.User;
import com.task4.service.ProfessionService;
import com.task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping(value="/task4")
public class MyController {
@Autowired
    UserService userService;
@Autowired
    ProfessionService professionService;

    @RequestMapping(value = "/main")
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

    @RequestMapping(value = "/profession")
    public String pro(Model model) {
        model.addAttribute("web", professionService.findById("前端开发方向"));
        model.addAttribute("java", professionService.findById("后端开发方向"));
        model.addAttribute("qa", professionService.findById("测试方向"));
        model.addAttribute("pm", professionService.findById("产品方向"));
        model.addAttribute("ui", professionService.findById("UI方向"));
        return "profession";
    }



    @RequestMapping(value = "/recommend")
    public String rec() {
        return "recommend";
    }


}
