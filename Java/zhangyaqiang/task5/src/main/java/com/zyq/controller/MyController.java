package com.zyq.controller;

import com.zyq.pojo.ExcellentStudent;
import com.zyq.pojo.Profession;
import com.zyq.service.ExcellentStudentService;
import com.zyq.service.ProfessionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class MyController {

    private static Logger logger = LogManager.getLogger(StudentController.class);

    @Autowired
    ProfessionService professionService;
    @Autowired
    ExcellentStudentService excellentStudentService;
//    跳转首页
    @RequestMapping(value = "/index")
    public String indexView(Model model) {
        logger.info("进入首页（展示优秀学员信息）。。。。。。。。。。。。。。。。。");
        model.addAttribute("item","indexBody");
        List<ExcellentStudent> list = excellentStudentService.selectByOrder();
        model.addAttribute("list",list);
        return "myView";
    }
//    跳转关于（about）页面
    @RequestMapping(value = "/about")
    public String aboutView(Model model) {
        logger.info("进入关于页面。。。。。。。。。。。。。。。。。。。");
        model.addAttribute("item","aboutBody");
        return "myView";
    }
//    跳转职业页面
    @RequestMapping(value = "/profession")
    public String professionView(Model model) {
        logger.info("进入职业信息页面。。。。。。。。。。。。。。。。");
        List<Profession> list = professionService.selectAll();
        model.addAttribute("item","professionBody");
        model.addAttribute("list",list);
        return "myView";
    }
    @RequestMapping(value = "/login")
    public String Login(Model model){
        logger.info("进入登录页面。。。。。。。。。。。。。。。");
        model.addAttribute("item","loginBody");
        return "myView";
    }
    @RequestMapping(value = "/register")
    public String Register(Model model){
        logger.info("进入注册页面。。。。。。。。。。。。。。。。。。");
        model.addAttribute("item","registerBody");
        return "myView";
    }
}
