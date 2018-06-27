package hzw.controller;

import hzw.model.Student;
import hzw.service.StudentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ModelController {
    @Autowired
    StudentSerivce studentSerivce;
    private Logger logger = Logger.getLogger("ModelController.class");

    @RequestMapping(value = "/student1",method = RequestMethod.GET)
    public String listStudent(Model model){
        logger.info("全体查询");
        List<Student> list = studentSerivce.getAll();
        model.addAttribute("cs",list);
        return "listStudent2";
    }

    @RequestMapping(value = "/student1",method = RequestMethod.PUT)
    public String addStudent(Student student){
        studentSerivce.addStu(student);
        return "redirect:/student1";
    }

    @RequestMapping(value = "/student1/{stuId}",method = RequestMethod.DELETE)
    public String delelteStudent(@PathVariable("stuId")long stuId){
        studentSerivce.deleteStu(stuId);
        return "redirect:/student1";
    }

    @RequestMapping(value = "/student1/{stuId}",method = RequestMethod.POST)
    public String updateStudent(Student student){
        studentSerivce.updateStu(student);
        return "redirect:/student1";
    }

    @RequestMapping(value = "/student1/ins/{stuId}",method = RequestMethod.GET)
    public String getId(@PathVariable("stuId")long stuId,Model model){
        Student student = studentSerivce.getId(stuId);
        model.addAttribute("c",student);
        return "updateStudent2";
    }
}
