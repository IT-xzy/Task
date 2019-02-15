package com.ptteng.controller;


import com.ptteng.model.Company;
import com.ptteng.model.Student;
import com.ptteng.service.CompanyService;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/12  10:18
 * @Version 1.0
 **/

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String selectAll(Model model) {
        try {
            List<Student> students = studentService.selectBySalary();
            List<Company> companies = companyService.selectAll();
            int counts = studentService.selectCount();
            int countBySalary = studentService.selectCountBySalary();
            model.addAttribute("countBySalary",countBySalary);
            model.addAttribute("counts",counts);
            model.addAttribute("students", students);
            model.addAttribute("companies", companies);
            model.addAttribute("code", 1);
            return "home";
        } catch (Exception e) {
            model.addAttribute("code", -1);
            return "home";
        }
    }


}



