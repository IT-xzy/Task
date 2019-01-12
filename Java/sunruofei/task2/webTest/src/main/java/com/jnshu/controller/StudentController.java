//package com.jnshu.controller;
//
//import com.jnshu.dao.StudentDao;
//
//import com.jnshu.model.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.HttpMediaTypeException;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
////Controller注解的作用是把这个类作为一个bean放入Spring容器里
//public class StudentController {
//    //将studentDao的bean取出来
//    @Autowired
//    StudentDao studentDao;
//
//    //为控制器指定可以处理的URL
//    @RequestMapping(value = "/user")
//// model是为了给页面发数据，让他展示
//    public String findAll(Model model) {
////直接用一个集合，去接我查出来的数据
//        List<Student> ListAllStudent = studentDao.findAll();
//        System.out.println(ListAllStudent);
//// 调用Model接口里的addAttribute方法往前台传数据，把我查出来的数据作为参数去传
//        model.addAttribute("students", ListAllStudent);
//// 把所有的东西带到页面里去
//        return "findAll";
//    }
//
//    @RequestMapping("/addStudent")
//    public String addStudent() {
//        return "add";
//    }
//
//    @RequestMapping("/adduser")
//    public String insertStudent(Student student) {
//        studentDao.add(student);
////redirect 是重定向
//        return "redirect:/user";
//    }
//
//    @RequestMapping("/deleteuser")
//    public String delete(int id) {
//        studentDao.delete(id);
//        return "redirect:/user";
//    }
//
//    // 修改数据要先得到要修改数据的ID
//    @RequestMapping("/getId")
//    public String getStudent(Model model, int id) {
////        使用实体类的对象student去接查到的id
//        Student student = studentDao.findById(id);
////   将拥有id的student显示在页面上
//        model.addAttribute("q", student);
////        将id带到update.jsp里,去执行那一行的修改
//        return "update";
//    }
//
//    @RequestMapping("updateuser")
//    public String update(Student student) {
//        if (studentDao.update(student)) {
//            return "redirect:user";
//        }
//        return "/error";
//    }
//
//    //    @RequestMapping("/listdata")
//////    number代表前端的第几页
////    public String selectPage(Model model, @RequestParam(value = "number",defaultValue = "1") int pageNow) {
//////假设number为5，第四十条到第五十条数据作为参数，去数据库里获取第四十条到第五十条
////        List<Student> students = studentDao.selectProductsPage((pageNow - 1) * 10, 10);
//////将得到的所有行的传给dog
////        int allCount = studentDao.selectCount();
//////将number和dog作为参数给page
////        Page page = new Page(pageNow, allCount);
//////        然后把page传给页面，在页面上显示它的属性
////        model.addAttribute("page", page);
////        model.addAttribute("students", students);
////        model.addAttribute("number",pageNow);
//////        将数据返回给页面
////        return "findAll";
////    }
//    @RequestMapping("/listdata")
//    public String selectPage(Model model, @RequestParam(value = "pageNow", defaultValue = "1") int pageNow) {
//        List<Student> students = studentDao.selectProductsPage((pageNow - 1) * 10, 10);
//        int allRow = studentDao.selectCount();
//
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
//}
