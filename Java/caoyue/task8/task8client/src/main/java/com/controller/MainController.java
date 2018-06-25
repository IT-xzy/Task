package com.controller;

import com.POJO.Cooperation;
import com.POJO.GreatStudent;
import com.POJO.HowToStudy;
import com.service.OtherPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 首页控制器
 * @create: 2018/5/7 下午5:31
 */

@Controller
public class MainController {
//    @Autowired
//    @Qualifier("OtherPageRMIServer")
//    private OtherPageService otherPageService;
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    OtherPageService otherPageService =  applicationContext.getBean("OtherPageRMIServer",OtherPageService.class);
    
    @RequestMapping("/index")
    public String select(Model model) throws Exception {
        List<GreatStudent> greatStudents = otherPageService.findStudentByName();
        List<Cooperation> cooperation = otherPageService.findCooperation();
        List<HowToStudy> howToStudies = otherPageService.findStudy();
        model.addAttribute("lists", greatStudents);
        model.addAttribute("cooperation", cooperation);
        model.addAttribute("study", howToStudies);
        
        return "first";
    }
}
