//package com.controller;
//
//import com.POJO.Profession;
//import com.service.ProfessionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
///**
// * @author: 曹樾
// * @program: task5-module
// * @description: 职业页（前端后端等）控制器
// * @create: 2018/5/7 下午5:32
// */
//
//@Controller
//public class ProfessionController {
//    @Autowired
//    @Qualifier("ProfessionRMIServer")
//    private ProfessionService professionService;
//    @RequestMapping("/profession")
//    public String select(Model model) throws Exception {
//        List<Profession> Front = professionService.findFront();
//        List<Profession> After = professionService.findAfter();
//        List<Profession> OP = professionService.findOP();
//        List<Profession> PM = professionService.findPM();
//
//        model.addAttribute("afters",After);
//        model.addAttribute("fronts",Front);
//        model.addAttribute("ops",OP);
//        model.addAttribute("pms",PM);
//        return "second";
//    }
//}
//
