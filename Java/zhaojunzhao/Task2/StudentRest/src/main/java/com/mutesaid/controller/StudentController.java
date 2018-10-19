package com.mutesaid.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mutesaid.pojo.Student;
import com.mutesaid.pojo.StudentAttr;
import com.mutesaid.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "page/{page}", method = RequestMethod.GET)
    public ModelAndView getStudent(@PathVariable("page") String pageStr) {
        PageHelper.startPage(Integer.parseInt(pageStr), 3);
        List<Student> stuList = studentService.getStudent();
        PageInfo<Student> pageInfo = new PageInfo<Student>(stuList);
        ModelAndView mav = new ModelAndView("stuList");
        mav.addObject("pageInfo",pageInfo);
        return mav;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(Long.parseLong(id));
        ModelAndView mav = new ModelAndView("success");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addStudent(@Validated Student student,
                                   BindingResult error) throws Exception {
        ModelAndView mav = new ModelAndView();
        if (error.hasErrors()) {
            String message = error.getFieldError().getDefaultMessage();
            throw new Exception(message);
        }
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ModelAndView updatePage(@PathVariable("id") String id, StudentAttr stuAttr) {
        studentService.updateStudent(Long.parseLong(id),
                stuAttr.getKey(),stuAttr.getValue());
        ModelAndView mav = new ModelAndView("success");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView signUpPage() {
        ModelAndView mav = new ModelAndView("signup");
        return mav;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public ModelAndView updatePage(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("update");
        mav.addObject("id",id);
        return mav;
    }
}
