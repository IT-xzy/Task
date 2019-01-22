package com.ptteng.controller;

import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

//    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
//    public String findAll(Model model) {
//        List<Student> students = studentService.findAll();
//        model.addAttribute("students", students);
//        return "findAll";
//    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "add";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(Student student) {
        studentService.add(student);
        return "redirect:/page";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/page";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String findById(Model model ,int id) {
      Student student =  studentService.findById(id);
        model.addAttribute("student",student);
        return "update";
    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String update(Student student) {
        studentService.update(student);
        return "redirect:/page";
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String findPage(Model model, @RequestParam(value = "pageNow", defaultValue = "1") int pageNow) {
        List<Student> students = studentService.findData((pageNow - 1) * 10, 10);
        int allRow = studentService.findRow();
        int pageSize = 10;
        int prePage;
        if (pageNow - 1 > 0) {
            prePage = pageNow - 1;
        } else {
            prePage = pageNow;
        }
        int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
        int nextPage;
        if (pageNow < totalPage) {
            nextPage = pageNow + 1;
        } else {
            nextPage = pageNow;
        }
        model.addAttribute("pageNow", pageNow);
        model.addAttribute("prePage", prePage);
        model.addAttribute("students", students);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("totalPage", totalPage);
        return "findAll";
    }

}
