package com.lihoo.ssm.controller;

import com.lihoo.ssm.model.StudentHome;
import com.lihoo.ssm.model.StudentProfession;
import com.lihoo.ssm.service.StudentHomeService;
import com.lihoo.ssm.service.StudentProfessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * #Title: IndexController
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/28-15:18
 */

@Controller
@RequestMapping("")
public class IndexController {

    private static Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    StudentHomeService studentHomeService;

    @Autowired
    StudentProfessionService studentProfessionService;

    @RequestMapping("/index")
    public String home(Model model) {
        List<StudentHome> selectGreatStudent = studentHomeService.selectGreatStudent();
        int countAll = studentHomeService.countAll();
        int workingCount = studentHomeService.workingCount();

//        String a = selectGreatStudent.toString();
//        logger.debug( "wow:"+a);

        model.addAttribute("selectGreatStudent", selectGreatStudent);

        model.addAttribute("countAll", countAll);
        model.addAttribute("workingCount", workingCount);

        return "home";
    }

    @RequestMapping("/profession")
    public String profession(Model model) {
        List<StudentProfession> selectAll = studentProfessionService.selectAll();
        int countAll = studentProfessionService.countAll();

        model.addAttribute("selectAll", selectAll);
        model.addAttribute("countAll", countAll);

        return "profession";
    }

    @RequestMapping("/recommend")
    public String recommend(Model model) {

        return "recommend";
    }
}
