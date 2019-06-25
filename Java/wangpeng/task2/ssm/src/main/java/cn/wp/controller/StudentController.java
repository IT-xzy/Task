/**
 * Author: 老王
 * Date: 2019/4/26 16:09
 */
package cn.wp.controller;

import cn.wp.model.Student;
import cn.wp.service.StudentService;
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
    private StudentService studentService;

    /**
     * 增
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "add";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(Student student) {
        studentService.add(student);
        return "redirect:/table";
    }

    /**
     * 删
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/table";
    }

    /**
     * 改
     */
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String findById(Model model, int id) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "update";
    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String update(Student student) {
        studentService.update(student);
        return "redirect:/table";
    }

    /**
     * 查、分页
     */
    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public String selectPage(Model model, @RequestParam(value = "number", defaultValue = "1") int pageNow) {
        List<Student> students = studentService.selectProductsPage((pageNow - 1) * 10, 10);
        int allRow = studentService.selectCount();
        int prePage;
        if (pageNow - 1 > 0) {
            prePage = pageNow - 1;
        } else {
            prePage = pageNow;
        }
        int pageSize = 10;
        int totalPages = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
        int nextPage;
        if (pageNow < totalPages) {
            nextPage = pageNow + 1;
        } else {
            nextPage = pageNow;
        }
        model.addAttribute("number", pageNow);
        model.addAttribute("prePage", prePage);
        model.addAttribute("students", students);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("totalPages", totalPages);
        return "findAll";
    }

//    /**
//     * 查
//     */
//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    public String getAll(Model model) {
//        List<Student> students = studentService.findAll();
//        model.addAttribute("students", students);
//        return "findAll";
//    }
}
