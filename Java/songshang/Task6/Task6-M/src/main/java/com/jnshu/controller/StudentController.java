package com.jnshu.controller;
import com.jnshu.Utils.XMemcachedUtil;
import com.jnshu.model.Student;
import com.jnshu.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class StudentController {
    @Resource
    private StudentService studentServiceImpl;
    @Resource
    private XMemcachedUtil xMemcachedUtil;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Login() {
        return "Login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String Register(HttpServletResponse response, HttpServletRequest request) throws Exception {
        return "welcome";
    }

    @RequestMapping(value = "/Cache", method = RequestMethod.GET)
    public String fullsCahe() {
        xMemcachedUtil.fullCache();
        return "welcome";
    }

    @RequestMapping(value = "/studentsJson", method = RequestMethod.GET)

    public List<Student> reStudents() {
        List<Student> studentList = studentServiceImpl.studentList();
        return studentList;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView reStudents2(ModelAndView mv) {
        List<Student> studentList = studentServiceImpl.studentList();
        mv.setViewName("students");
        mv.addObject("studentList", studentList);
        return mv;
    }
    //todo 完成压测报告
}
