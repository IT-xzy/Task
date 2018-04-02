package com.fml.controller;

import com.fml.pojo.Student;
import com.fml.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping()
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    //private static final Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/home")
    public String homeView(Model model){
        int workCount = studentService.getWorkCount();
        int totalCount = studentService.getTotalCount();
        model.addAttribute("workCount",workCount);
        model.addAttribute("totalCount",totalCount);

        /*优秀学员*/
        List<Student> studentList = studentService.getByStatus(4);
        LOGGER.info("开始读取优秀学员信息！");
        List<Student> list = new ArrayList<>(4);
        for (int i = 0; i < 4; i++){
            list.add(studentList.get(i));
        }
        LOGGER.info("信息读取结束！");
        model.addAttribute("list",list);
        return "home";
    }
}
