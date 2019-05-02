package cn.wp.controller;

import cn.wp.model.Student;
import cn.wp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName: StudentsController
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/2 9:38
 * @Version: 1.0
 */
@Controller
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/select")
    public String selectAll(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("code", "200");
        model.addAttribute("message", "传递成功");
        model.addAttribute("students", students);
        return "json";
    }

}
