package com.zyq.controller;

import com.zyq.pojo.ExcellentStudent;
import com.zyq.pojo.Profession;
import com.zyq.service.ExcellentStudentService;
import com.zyq.service.ProfessionService;
import com.zyq.util.MemcacheUtils;
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
        List<ExcellentStudent> list = (List<ExcellentStudent>) MemcacheUtils.get("excellentStudentList");
        if (list.size()==0){
            logger.info("缓存中没有优秀学员信息的缓存");
            list = excellentStudentService.selectByOrder();
            MemcacheUtils.set("excellentStudentList",list);
        }
        model.addAttribute("list",list);
        return "myView";
    }

    //    跳转首页2
    @RequestMapping(value = "/index2")
    public String indexView2(Model model) {
        logger.info("进入首页（展示优秀学员信息,模拟缓存穿透）。。。。。。。。。。。。。。。。。");
        model.addAttribute("item","indexBody");
        List<ExcellentStudent> list = (List<ExcellentStudent>) MemcacheUtils.get("excellentStudentList2");
        if (list.size()==0){
            logger.info("缓存中没有优秀学员信息的缓存,要查找数据库");
            list = excellentStudentService.selectByOrder2();
            MemcacheUtils.set("excellentStudentList2",list);
        }
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
        List<Profession> list;
        if (MemcacheUtils.get("Profession")==null){
            logger.info("没有职业信息的缓存，正要去数据库中查找");
            list = professionService.selectAll();
            MemcacheUtils.set("Profession",list);
        }else {
            logger.info("有职业信息的缓存");
            list = (List<Profession>) MemcacheUtils.get("Profession");
        }
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
