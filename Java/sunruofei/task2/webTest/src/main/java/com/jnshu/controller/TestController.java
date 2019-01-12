//package com.jnshu.controller;
//
//
//import com.jnshu.dao.StudentDao;
//import com.jnshu.model.Student;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class TestController {
//    @Autowired
//    StudentDao studentDao;
//
//    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
//    public String getAll(Model model) {
//        List<Student> students = studentDao.findAll();
//        model.addAttribute("students", students);
//        return "findAll";
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public String addStudent() {
//        return "add";
//    }
//
//    @RequestMapping(value = "/student", method = RequestMethod.POST)
//    public String insertStudent(Student student) {
//        studentDao.add(student);
//        return "redirect:/student/list";
//    }
//    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
//    public String deleteStudent(@PathVariable int id){
//        studentDao.delete(id);
//        return "redirect:/student/list";
//    }
//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    public String findById(Model model , int id){
//      Student student =  studentDao.findById(id);
//        model.addAttribute("student",student);
//        return "update";
//    }
//    @RequestMapping(value = "/student",method = RequestMethod.PUT)
//    public String updateStudent (Student student){
//        studentDao.update(student);
//        return "redirect:/student/list";
//    }
//    @RequestMapping(value = "/listtable",method = RequestMethod.GET)
//    public String selectPage (Model model , @RequestParam(value = "pageNow",defaultValue = "1")int pageNow){
//        List<Student> students = studentDao.selectProductsPage((pageNow-1)*10,10);
//        int allRow = studentDao.selectRow();
//        int prePage;
//        if (pageNow - 1 > 0) {
//            prePage = pageNow - 1;
//        } else {
//            prePage = pageNow;
//        }
//        int pageSize = 10;
//        int totalPages = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
//        int nextPage;
//        if ( pageNow <totalPages) {
//            nextPage = pageNow+1;
//        } else {
//            nextPage = pageNow ;
//        }
//        model.addAttribute("pageNow", pageNow);
//        model.addAttribute("prePage", prePage);
//        model.addAttribute("students", students);
//        model.addAttribute("nextPage", nextPage);
//        model.addAttribute("totalPages", totalPages);
//        return "findAll";
//
//    }
//@RequestMapping("/select")
//    public String selectAll(Model model){
//        List<Student> students = studentDao.findAll();
//        model.addAttribute("code","200");
//        model.addAttribute("message","传递成功");
//        model.addAttribute("students",students);
//        return "json";
//}
//}
