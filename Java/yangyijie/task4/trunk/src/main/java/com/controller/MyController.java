package com.controller;

import com.bean.GoodStudent;
import com.bean.Jobs;
import com.service.IgoodStudentService;
import com.service.IjobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/26 20:04
 */
@Controller
public class MyController {
    @Autowired
    IgoodStudentService goodStudentServiceImpl;
    @Autowired
    IjobsService jobsServiceImpl;
    @RequestMapping(value = "/jnshu",method = RequestMethod.GET)
    public String jnshu(ModelMap model) {
        List<GoodStudent> list = goodStudentServiceImpl.selectAll();
        System.out.println(list);
        model.addAttribute("list",list);
        model.addAttribute("count", goodStudentServiceImpl.count());
        model.addAttribute("countGood", goodStudentServiceImpl.countGood());
        return "jnshu";
    }
    
    
    @RequestMapping("/joblist")
    public String job(ModelMap model){
        List<Jobs> list = jobsServiceImpl.selectJobs();
        System.out.println(list);
        model.addAttribute("joblist",list);
        return "joblist";
    }
    
    
    @RequestMapping("/cooperation")
    public String cooperation() {
        return "cooperation";
    }
}