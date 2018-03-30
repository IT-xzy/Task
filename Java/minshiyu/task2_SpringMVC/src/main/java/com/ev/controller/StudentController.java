package com.ev.controller;


import com.ev.bean.Student;
import com.ev.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/student")//窄化路径
public class StudentController {

    private static final Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    //分页显示所有学员
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, Model model) throws Exception {
        model.addAttribute("student", studentService.findByPage(currentPage));//回显分页数据
        return "list";
    }

    //编辑新增学生
    @RequestMapping(value = "/newone", method = RequestMethod.GET)
    public String addAStudent(){
        return "newone";
    }

    //提交新增学员数据
    @RequestMapping(value = "/newone", method = RequestMethod.POST)
    public String doAdd(Student student) throws Exception{
        student.setCreateAt(System.currentTimeMillis());
        studentService.addAStudent(student);
        return "redirect:list";
    }

    //删除学生
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Long id) throws Exception {
        studentService.deleteAStudent(id);
//        logger.info("Delete successfully, whose id is " + id + ".");
        return "redirect:delete";
    }

    //确认删除
    @RequestMapping(value="/delete" , method = RequestMethod.GET)
    public String delete(){
        return "delete";
    }

    //由id查找学员
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStudentById(@PathVariable Long id, Model model) throws Exception {
        Student studentById = studentService.findStudentById(id);
        System.out.println(studentById);
        model.addAttribute("studentById", studentById);
        return "id";
    }

    //由姓名模糊查找
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getStudentByName(@RequestParam String name, Model model) throws Exception {
        List<Student> studentByName = studentService.findStudentByName(name);
        model.addAttribute("studentByName", studentByName);
        return "name";
    }

    //由学号查找
    @RequestMapping(value = "/number", method = RequestMethod.GET)
    public String getStudentByNumber(@RequestParam String number, Model model) throws Exception {
        List<Student> studentByNumber = studentService.findStudentByNumber(number);
        model.addAttribute("studentByNumber", studentByNumber);
        return "number";
    }

    //
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String reNewStudent(@PathVariable Long id, Student student) throws Exception {
        student.setId(id);
        studentService.updateInformation(student);
        return "redirect:list";
    }

    //
//    @RequestMapping(value = "/edit", method =RequestMethod.GET)
//    public String isUpdated(@RequestParam Student student ,Model model){
//        Long id = student.getId();
//        model.addAttribute("id", id );
//        return "edit";
//    }

}
