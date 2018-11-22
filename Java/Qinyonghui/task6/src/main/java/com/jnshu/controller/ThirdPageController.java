package com.jnshu.controller;

import com.jnshu.entity.Profession;
import com.jnshu.entity.Student4;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.Student4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ThirdPageController {
    @Autowired
    ProfessionService professionService;
    @Qualifier("NoCache")
    @Autowired
    Student4Service student4Service;
    @RequestMapping(value = "task-91",method = RequestMethod.GET)
    public ModelAndView firstPage(ModelAndView modelAndView)
    {
        Student4 student4 = new Student4();
        student4.setState(false);
        List<Student4> student4List = student4Service.getOrderByKeyWords(student4);
        long onlinCount = student4Service.SelectCountByState(true);
        long graduateCount = student4Service.SelectCountByState(false);
        modelAndView.addObject("onlinCount",onlinCount);
        modelAndView.addObject("graduateCount",graduateCount);
        modelAndView.addObject("student4List",student4List);
        modelAndView.addObject("bodyname","task-91");
        modelAndView.setViewName("myView1");
        return modelAndView;
    }
    @RequestMapping(value = "task-92",method = RequestMethod.GET)
    public ModelAndView secondPage(ModelAndView modelAndView)
    {
        //modelAndView.addObject(, );
        modelAndView.addObject("bodyname","task-92");
        modelAndView.setViewName("myView1");
        return modelAndView;
    }
    ///task4/u/
    @RequestMapping(value = "/u/task-93", method = RequestMethod.GET)
    public ModelAndView thirdPage(ModelAndView modelAndView){
            List<Profession> professionList;
            long count=0;
            //Student4 student4 = new Student4();
            professionList = professionService.getOneByPrimaryKey(10);
           /* student4.setPosition("前端工程师");
            student4.setState(true);*/
            count = student4Service.CountSelective("前端工程师",false);
            modelAndView.addObject("count",count);
            modelAndView.addObject("professionList",professionList);
            modelAndView.addObject("bodyname","task-93");
            modelAndView.setViewName("myView1");
            return modelAndView;
    }
}

