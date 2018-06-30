package com.controller;

import com.POJO.Student;
import com.service.StudentService;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
@Controller
@Component("testAOP")
public class SpringController {
    Student student;
    @Autowired
    private StudentService stuServiceImpl;
    Logger log=Logger.getLogger("SpringController.class");

    @RequestMapping("/welcome")
    public String indexPage(Model model) {
        //职业展示

        model.addAttribute("goodstudent",stuServiceImpl.findGood());
        model.addAttribute("numberofstudent",stuServiceImpl.selectCount());
        model.addAttribute("numberofgraduate",stuServiceImpl.selectCountGraduate());
        model.addAttribute("images1",stuServiceImpl.findImgaes1());
        return "test1";
    }

    @RequestMapping("/profession")

    public String listAll(Model model) {
        model.addAttribute("joblist1",stuServiceImpl.findJobList1());
        model.addAttribute("numberofstudent1",stuServiceImpl.selectCount());
        return "test3";
    }
    //主页加入tiles
    @RequestMapping(path = "/welcome2")
    public String welcome(Model model) {
        model.addAttribute("goodstudent",stuServiceImpl.findGood());
        model.addAttribute("numberofstudent",stuServiceImpl.selectCount());
        model.addAttribute("numberofgraduate",stuServiceImpl.selectCountGraduate());
        model.addAttribute("images1",stuServiceImpl.findImgaes1());
        return "welcome2";
        //根据该逻辑名，找到tiles.xml中 对应的definition...获取最后的jsp
    }
    //职业页加入tiles
    @RequestMapping(path = "/jobs")
    public String jobs(Model model) {
        model.addAttribute("joblist1",stuServiceImpl.findJobList1());
        model.addAttribute("numberofstudent1",stuServiceImpl.selectCount());
        return "jobs";
        //根据该逻辑名，找到tiles.xml中 对应的definition...获取最后的jsp
    }
    //Tag标签处理时间转换
    @RequestMapping("/time")
    public String addTest(Model model) throws IOException {
        model.addAttribute("rs",stuServiceImpl.findUserById(24L));
        return "timedeal";
    }

}

