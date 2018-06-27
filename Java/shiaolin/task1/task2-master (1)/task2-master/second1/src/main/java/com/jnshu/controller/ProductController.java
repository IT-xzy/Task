package com.jnshu.controller;

import com.jnshu.serviceImpl.ServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;

import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    StudentService studentService;

    //显示所有学生数据
    @RequestMapping(value = "/stus", method = RequestMethod.GET)
    public String StuList(Model model) {
        List<Student> student = studentService.allStudent();
        model.addAttribute(student);
        return "homePage";
    }

    //根据姓名查找
    @RequestMapping(value = "/stu", method = RequestMethod.GET)
    public String StuSelect(String name, Model model) {
        //把姓名注入到student里;
        Student stu = studentService.queryName(name);
        System.out.println(stu.toString());
        model.addAttribute(stu);
        return "select";
    }

    //修改或添加学生信息
    @RequestMapping(value = "/editStu", method = RequestMethod.GET)
    public String editStu( int id, Model model) throws Exception {
        //设置要修改的数据ID
        Student student = studentService.queryUser(id);
        model.addAttribute("student", student);
        return "/edit";
    }
    ////添加
    //跳转到添加的页面
    @RequestMapping("/addStu")
    public String addStu1(Model model) {
        Student student = new Student();
        student.setId(0);
        model.addAttribute("student", student);
        return "/edit";
    }

    @RequestMapping(value = "/stu",method = RequestMethod.POST)
    public String editItemSubmit(@ModelAttribute("student")Student student) throws Exception {
        System.out.println(student);
        if (student.getId() == 0) {
            studentService.addUser(student);
        } else {
            studentService.updataUser(student);
        }
        return "redirect:/stus";

    }

    //删除学生
    @RequestMapping(value = "/stus",method = RequestMethod.DELETE)
    public String deleteStu(@RequestParam int id) {
        studentService.deleteUser(id);
        return "redirect:/stus";
    }

//}
    //保存信息
//    @RequestMapping("/stuSave")
//    public String saveStu(@ModelAttribute("student") Student student) {
//        System.out.println(student);
//        studentService.addUser(student);
//        return "redirect:/stus";
//    }
}
