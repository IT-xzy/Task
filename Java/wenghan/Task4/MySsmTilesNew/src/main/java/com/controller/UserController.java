package com.controller;

import com.pojo.OccupationReunite;
import com.pojo.Student;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/T0",method = RequestMethod.GET)
    public String T0(Model model){
        //优秀的学生
        List<Student> list=userService.queryStudent("满意");
        //累计在学人数
        model.addAttribute("accumulativeLearning",userService.statisticsInLearning("在学"));
        //找到满意工作的人数
        model.addAttribute("accumulativeWork",userService.statisticaljobSatisfaction("满意"));
        //model封装优秀学员
        model.addAttribute("list",list);
        return "T0Layout";
    }

    @RequestMapping(value = "/T1",method = RequestMethod.GET)
    public String T1(Model model){
        //职业列表
        List<OccupationReunite> occupationReuniteList=userService.queryOccupationReunite("前端开发");

        //model封装职业
        model.addAttribute("list",occupationReuniteList);
        return "T1Layout";
    }

}
