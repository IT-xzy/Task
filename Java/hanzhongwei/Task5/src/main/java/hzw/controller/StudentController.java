package hzw.controller;

import hzw.model.Student;
import hzw.service.StudentService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
    private Logger logger = Logger.getLogger(String.valueOf(StudentController.class));

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String findStudent(Model model) throws IOException {
        List<Student> stu = studentService.findStudent();
        model.addAttribute("stu",stu);
        return "student";
    }

}
