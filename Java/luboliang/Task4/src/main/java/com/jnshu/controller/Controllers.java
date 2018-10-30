package com.jnshu.controller;


import com.jnshu.model.Profession;
import com.jnshu.model.Student;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Controllers {

   public static Logger logger=Logger.getLogger(Controllers.class);

    @Autowired
    StudentService studentService;
    @Autowired
    ProfessionService professionService;

    /**
     * 优秀学员
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String qw(Model model) {
        List<Student> list = studentService.all();
        model.addAttribute("list", list);
        int count = studentService.count();
        model.addAttribute("count", count);
        int number = studentService.number();
        model.addAttribute("number", number);
        return "home";
    }

    @RequestMapping(value = "/profession", method = RequestMethod.GET)
    public String profession(Model model) {
        List<Profession> list = professionService.all();
        List<Profession> list1=professionService.after();
        List<Profession>list2=professionService.ops();
        model.addAttribute("list", list);
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);

        logger.info("list1"+list1);
        logger.info("list1"+list2);
        logger.info("list1"+list);

        return "profession";
    }

@RequestMapping(value = "/partner",method = RequestMethod.GET)
    public String partner(){

        return "partne";
}
}
