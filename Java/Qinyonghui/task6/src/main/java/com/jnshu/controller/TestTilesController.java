package com.jnshu.controller;

import com.jnshu.entity.Student4;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.Student4Service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestTilesController {
    Logger logger = LogManager.getLogger(ThirdPageController.class.getName());
    @Autowired
    ProfessionService professionService;
    @Qualifier("NoCache")
    Student4Service student4Service;
    @RequestMapping(value = "/tiles",method = RequestMethod.GET)
    public ModelAndView testTiles(ModelAndView modelAndView)
    {
        Student4 student4 = new Student4();
        student4.setState(false);
        List<Student4> student4List = student4Service.getOrderByKeyWords(student4);
        long onlinCount = student4Service.SelectCountByState(true);
        long graduateCount = student4Service.SelectCountByState(false);
        modelAndView.addObject("onlinCount",onlinCount);
        modelAndView.addObject("graduateCount",graduateCount);
        modelAndView.addObject("student4List",student4List);
        modelAndView.setViewName("myView1");
        return modelAndView;
    }
}
