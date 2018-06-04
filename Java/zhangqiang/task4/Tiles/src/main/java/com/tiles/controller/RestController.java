package com.tiles.controller;

import com.tiles.model.Profession;
import com.tiles.service.ProfessionServiceImpl;
import org.springframework.stereotype.Controller;
import com.tiles.model.Page;
import com.tiles.model.Student;
import com.tiles.util.RandomStudent;
import com.tiles.service.StudentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RestController {

    private static Logger logger = Logger.getLogger(RestController.class);
    private RandomStudent randomStudent = new RandomStudent();
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
    StudentServiceImpl studentService = (StudentServiceImpl) applicationContext.getBean("studentService");
    ProfessionServiceImpl professionService = (ProfessionServiceImpl) applicationContext.getBean("professionService");

    @RequestMapping("/home")
    public String tiles(Model model){
        Page<Student> pages = studentService.findByPage(2,4);
        model.addAttribute("students",pages.getPages());
        return "home";
    }

    @RequestMapping("/profession")
    public String tilestest(Model model){
        List<Profession> pros = professionService.findAll();
        logger.info(pros);
        model.addAttribute("pros",pros);
        return "profession";
    }


}
