package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Student;
import spring.service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

//    @RequestMapping(value ="home", method = RequestMethod.GET)
//    public ModelAndView getAll() {
//        ModelAndView mav = new ModelAndView("index");
//        int a = studentService.getAll();
//        int b = studentService.getOffer();
//        List<Student> list = studentService.getGood();
//        mav.addObject("all",a);
//        mav.addObject("offer",b);
//        mav.addObject("list",list);
//        return mav;
//    }
    @RequestMapping("test")
    public ModelAndView testView(){
        ModelAndView mav = new ModelAndView("myView");
        int a = studentService.getAll();
        int b = studentService.getOffer();
        List<Student> list = studentService.getGood();
        mav.addObject("all",a);
        mav.addObject("offer",b);
        mav.addObject("list",list);
        return mav;
    }
}
