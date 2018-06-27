package com.controller;


import com.model.Student;
import com.model.zhiwei;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class TestController{
@Autowired
    private StudentService service;
//页面一
    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView MAV = new ModelAndView();
        List<Student> by = service.findAll();
        MAV.addObject("by",by);
        MAV.setViewName("home");

    return MAV;
    }
    //页面二
    @RequestMapping("homeTwo")
    public ModelAndView homeTwo(){
        ModelAndView mav = new ModelAndView();
        List<zhiwei> zhiye = service.findAlls();
        int name = service.findName();
        mav.addObject("zhiye",zhiye);
        mav.addObject("name",name);
        mav.setViewName("homeTwo");
        return mav;
    }

    @RequestMapping("test")
    public ModelAndView test(){
        ModelAndView ma = new ModelAndView();
        List<zhiwei> bb = service.findAlls();
        ma.addObject("bb",bb);
        ma.setViewName("test");
        return ma;
    }
    @RequestMapping(value = "tijiao",method= RequestMethod.POST)
    public ModelAndView tijiao(zhiwei zhi){
        ModelAndView mv = new ModelAndView();
        service.addlist(zhi);
        System.out.println(zhi);
        mv.setViewName("redirect:test");
        return mv;

    }
}
