package com.controller;

import com.service.CompanyService;
import com.service.ProfessionService;
import com.service.StudentsService;
import com.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/jnshu")
public class Controller01 {
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private StudentsService studentsService;

    @RequestMapping("/main")
    public String main(Model model){
        model.addAttribute("allStudents",studentsService.countAll());//历史总人数
        model.addAttribute("onlineStudents",studentsService.count(1));//在线学习人数
        model.addAttribute("jobStudents",studentsService.count(2));//找到工作人数
        model.addAttribute("goodStudents",studentsService.listGood());//在状态2中随即抽取4个
        return "main";
    }

    @RequestMapping("/profession")
    public String profession(Model model){
        model.addAttribute("前端",professionService.findByStyle("前端"));
        model.addAttribute("后端",professionService.findByStyle("后端"));
        model.addAttribute("移动端",professionService.findByStyle("移动端"));
        model.addAttribute("全站",professionService.findByStyle("全站"));
        model.addAttribute("运维",professionService.findByStyle("运维"));
        return "profession";
    }
    @RequestMapping("/recommend")
    public String recommend(Model model){
        model.addAttribute("company",companyService.findAll());
        return "recommend";
    }

    @RequestMapping("/date")
    public String tag(Model model){
        Long time = System.currentTimeMillis();
        Date date = new Date(time);
        String strTime = DateUtil.dateToYMDHMS(date);
        model.addAttribute("time1",time);
        model.addAttribute("time2",date);
        model.addAttribute("time4",DateUtil.dateToYMD(date));
        model.addAttribute("time5",DateUtil.dateToYMDHMS(date));
        model.addAttribute("time6",DateUtil.dateToYMDhms(date));
        model.addAttribute("time8",DateUtil.YMDToDate(strTime));
        model.addAttribute("time9",DateUtil.YMDHMSToDate(strTime));
        return "date";
    }


}
