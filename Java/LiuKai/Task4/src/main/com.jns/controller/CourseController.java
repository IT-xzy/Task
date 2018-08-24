package controller;

import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Course;
import pojo.Student;
import service.CourseServiceImpl;
import service.StudentServiceImpl;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping("/course")
    public ModelAndView header(){
        ModelAndView modelAndView=new ModelAndView("coupage1");
        Course web =courseService.findCourse(1);
        Course java =courseService.findCourse(2);
        modelAndView.addObject("web",web);
        modelAndView.addObject("java",java);

        int webNum=studentService.countCourse("web");
        int javaNum=studentService.countCourse("java");
        modelAndView.addObject("webNum",webNum);
        modelAndView.addObject("javaNum",javaNum);
        return modelAndView;
    }

    @RequestMapping("/a")
    public ModelAndView a(){
        ModelAndView modelAndView=new ModelAndView("occupation");

        return modelAndView;
    }


}
