package com.lihoo.ssm.gai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lihoo.ssm.gai.model.Student;
import com.lihoo.ssm.gai.model.User;
import com.lihoo.ssm.gai.service.StudentService;
import com.lihoo.ssm.gai.service.UserService;
import com.lihoo.ssm.gai.util.Page;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lihoo
 * @Title: StudentController
 * @ProjectName spring_springMVC_mybatis_SMM_1
 * @Description: TODO
 * @date 2018/8/8-12:54
 */

@Controller
@RequestMapping("")
public class StudentController {
    private static Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    public ModelAndView findStudentList(Page page) throws Exception {
//        ModelAndView mav = new ModelAndView();
//        PageHelper.offsetPage(page.getStart(), 5);
//        List<Student> stu = studentService.findStudentList();
//        int total_page = (int) new PageInfo<>(stu).getTotal();
//        page.caculateLast(total_page);
//        //        放入转发参数
//        mav.addObject("stu", stu);
////        放入jsp路径
//        mav.setViewName("listStudent");
//        return mav;
//    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView listStudent() throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Student> stus = studentService.findStudentList();
        mav.addObject("stus", stus);
        mav.setViewName("jsonList");
        logger.debug("OJBK");
        return mav;
    }

//    @RequestMapping(value = "/student", method = RequestMethod.PUT)
//    public ModelAndView addStudent(Student student) throws Exception {
//        logger.debug("student.getUserName():" + student.getUsername());
//        studentService.addStudent(student);
//        ModelAndView mav = new ModelAndView("redirect:/student");
//        return mav;
//    }
//
//    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
//    public ModelAndView deleteStudent(Student student) throws Exception {
//        studentService.deleteStudent(student);
//        ModelAndView mav = new ModelAndView("redirect:/student");
//        return mav;
//    }
//
//    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
//    public ModelAndView editStudent(Student student) throws Exception {
//        Student stu = studentService.findStudentById(student.getId());
//        ModelAndView mav = new ModelAndView("editStudent");
//        mav.addObject("stu", stu);
//        return mav;
//    }
//
//    @RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
//    public ModelAndView updateStudent(Student student) throws Exception {
//        studentService.updateStudent(student);
//        ModelAndView mav = new ModelAndView("redirect:/student");
//        return mav;
//    }





}
