package controller;

import dao.StudentDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Course;
import pojo.Student;
import service.CourseServiceImpl;
import service.StudentServiceImpl;

import java.util.List;

@Controller
@RequestMapping("u")
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value = "/course")
    public ModelAndView cp(){
        ModelAndView modelAndView=new ModelAndView("coupage1");
        Course web =courseService.findCourse(1);
        Course java =courseService.findCourse(2);
        modelAndView.addObject("web",web);
        modelAndView.addObject("java",java);
        int webNum=0;
        int javaNum=0;
        webNum=studentService.countCourse("web");
         javaNum=studentService.countCourse("java");
        modelAndView.addObject("webNum",webNum);
        modelAndView.addObject("javaNum",javaNum);
        return modelAndView;
    }

}
