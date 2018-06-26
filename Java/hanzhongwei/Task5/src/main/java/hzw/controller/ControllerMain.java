package hzw.controller;

import hzw.model.*;
import hzw.service.ServiceManage;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.slf4j.Logger;

@Controller
public class ControllerMain {
    @Autowired
    ServiceManage serviceManage;

    private static Logger logger = LoggerFactory.getLogger(ControllerMain.class);
    private StudentQV studentQV = new StudentQV();

    @RequestMapping("/home")
    public String index(Model model) {
        StudentStatistics studentStatistics = serviceManage.countStudent();
        List<StundetCustom> studentList = serviceManage.findListStudent();
        logger.info(studentList.toString());
        logger.info(studentStatistics.toString());
        studentQV.setStudentStatistics(studentStatistics);
        studentQV.setStudentList(studentList);
        model.addAttribute("studentQV", studentQV);
        return "home";
    }

    @RequestMapping("/profession")
    public String home(Model model) {
        List<Profession1> professionList = serviceManage.findByListProfession();
        System.out.println(professionList.toString());
        studentQV.setProfession(professionList);
        model.addAttribute("studentQV", studentQV);
        return "profession";
    }
}
