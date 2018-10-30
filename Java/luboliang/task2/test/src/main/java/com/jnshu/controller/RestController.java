package com.jnshu.controller;

import com.jnshu.model.Page;
import com.jnshu.model.Student;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
//@RequestMapping("/")
public class RestController {
    Student student = new Student();

    Page page = new Page();
    protected Logger log = Logger.getLogger(StudentController.class);
    @Autowired
    Page p;
    @Resource(name = "StudentService")
    private StudentService studentService;

    @RequestMapping(value = "/jsons", method = RequestMethod.GET)
    public String js(Model model) {
        //传两个数组，
        student.setId(1);
        student.setName("你是谁");
        student.setQq(12312313);

        page.setCurrentPage(1);
        page.setPrefPage(2);
        page.setNextPage(1);

        model.addAttribute("date", student);
        model.addAttribute("page", page);
//        model.addAttribute("messages/message.properties", 200);
        model.addAttribute("code", 200);

        return "json";
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public String jso(Model model) {
        log.info("=========================");
        model.addAttribute("code",200);
        log.info(model);
        return "json1";
    }
    @RequestMapping(value = "/json",method = RequestMethod.PUT)
    public String json(Model model){
        log.info("=========================");
        model.addAttribute("code",200);
//        model.addAttribute("messages/message.properties","你好");
        log.info(model);
        log.info(model);

        return "json1";
    }
    @RequestMapping(value = "/json",method = RequestMethod.DELETE)
    public String json1(Model model){
        log.info("=========================");
        studentService.deleteStudent(107);
        model.addAttribute("code",200);
//        model.addAttribute("messages/message.properties","你好");
        log.info(model);
        return "json1";
    }
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ModelAndView findAll() {
//        将查找全部方法的值赋给list
        List<Student> list = studentService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("students", list);
        mv.addObject("code",200);
//        mv.addObject("messages/message.properties","你好");
        mv.setViewName("show");
        return mv;
    }
}
