package com.controller;


import com.util.Page;
import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    Logger logger = (Logger) LoggerFactory.getLogger(StudentController.class);


    @RequestMapping("/")
    public ModelAndView getall(Page page){
        page.caculateLast(studentService.getTotal());
        List<Student> cs = studentService.getStudentListByPage(page);

        ModelAndView mav = new ModelAndView();
        mav.addObject("massege",cs);
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String showaddstudent() {
        return "addstudent";
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String addstudent(Student student){
        studentService.insertStudent(student);
        logger.info("addstudent成功{}",student);
        return "redirect:/";
    }

    @RequestMapping(value = "/delstudent/{id}", method = RequestMethod.GET)
    public String delstudent(@PathVariable("id") int id){
        studentService.deleteStudentById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ModelAndView getstudent(@PathVariable int id)  {
        Student student = studentService.getStudentById(id);
        return new ModelAndView("showstudent","student",student);
    }


    @RequestMapping(value = "/updatestudent/{id}")
    public ModelAndView showstudent(@PathVariable int id) {
        Student student =  studentService.getStudentById(id);
        return new ModelAndView("updatestudent","student",student);
    }

    @RequestMapping(value = "/updatestudent",method = RequestMethod.POST)
    public String updatestudent(Student student){
        studentService.updateStudent(student);
        return "redirect:/";
    }
}



