package hzw.controller;


import hzw.model.Cooperation;
import hzw.model.GreatStudent;
import hzw.model.HowToStudy;
import hzw.service.GreatStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    GreatStudentServiceImpl greatStudentServiceImpl;
    @RequestMapping("/index")
    public String select(Model model) throws Exception {
        List<GreatStudent> greatStudents = greatStudentServiceImpl.findUserByName();
        List<Cooperation> cooperation = greatStudentServiceImpl.findCooperation();
        List<HowToStudy> howToStudies = greatStudentServiceImpl.findStudy();

        model.addAttribute("lists",greatStudents);
        model.addAttribute("cooperation",cooperation);
        model.addAttribute("study",howToStudies);

        return "first";
    }

}
