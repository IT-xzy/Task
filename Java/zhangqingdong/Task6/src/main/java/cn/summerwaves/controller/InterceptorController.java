package cn.summerwaves.controller;

import cn.summerwaves.model.Student;
import cn.summerwaves.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
public class InterceptorController  {

    @Resource
    private IStudentService studentService;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toWelcome() {
        return "welcome";
    }

    
    @RequestMapping(value = "/jspcache", method = RequestMethod.GET)
    public ModelAndView toTPS() {
        ModelAndView mv = new ModelAndView("jspcache");
        mv.addObject("studentList", studentService.selectThreeStudent());
        return mv;
    }

    @RequestMapping(value = "/jspnocache", method = RequestMethod.GET)
    public ModelAndView toNoCacheTPS() {
        ModelAndView mv = new ModelAndView("jspnocache");
        mv.addObject("studentList", studentService.selectThreeStudentFromDB());
        return mv;
    }

    @RequestMapping(value = "/jsoncache", method = RequestMethod.GET,headers="Accept=application/json")
    public ModelAndView toJsoncache(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("jsoncache");
        mv.addObject("head", request.getHeader("Accept"));
        mv.addObject("students",studentService.selectThreeStudent());
        return mv;
    }

    @RequestMapping(value = "/jsonnocache", method = RequestMethod.GET,headers="Accept=application/json")
    public ModelAndView toJson(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("jsonnocache");
        mv.addObject("head", request.getHeader("Accept"));
        mv.addObject("students",studentService.selectThreeStudentFromDB());
        return mv;
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView toCreateStudent() {
        return new ModelAndView("createStudent");
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute Student student) throws IOException {
        studentService.insertStudent(student);
        return new ModelAndView("welcome");
    }
}
