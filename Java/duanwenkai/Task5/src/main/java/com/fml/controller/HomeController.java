package com.fml.controller;

import com.fml.pojo.Student;
import com.fml.service.StudentService;
import com.fml.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "home")
    public String homeView(Model model){
        int workCount = studentService.getWorkCount();
        int totalCount = studentService.getTotalCount();
        model.addAttribute("workCount",workCount);
        System.out.println(workCount);
        model.addAttribute("totalCount",totalCount);

        /**优秀学员*/
        List<Student> studentList = studentService.getByStatus(4);
        List<Student> list = new ArrayList<>(4);
        for (int i = 0; i < 4; i++){
            list.add(studentList.get(i));
        }
        model.addAttribute("list",list);
        return "home";
    }
}
