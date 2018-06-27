package com.ev.controller;


import com.ev.model.Student;
import com.ev.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(value = "/student")//窄化路径
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    //分页显示所有学员
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, Model model) throws Exception {
        model.addAttribute("student", studentService.findByPage(currentPage));//回显分页数据
        logger.info("List of records.");
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
        Long beforeInsert =System.currentTimeMillis();
        studentService.addAStudent(student);
        Long afterInsert =System.currentTimeMillis();
        logger.info("It costs "+(afterInsert-beforeInsert)+" ms to insert student which id is "+student.getId()+".");
        return "redirect:update";
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String isUpdated(){
        return "update";
    }

    //删除学生
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Long id) throws Exception {
        Long beforeDelete =System.currentTimeMillis();
        studentService.deleteAStudent(id);
        Long afterDelete = System.currentTimeMillis();
        logger.info("It costs "+(afterDelete-beforeDelete)+"ms to delete student whose id is " + id + ".");
        return "redirect:delete";
    }

    //确认删除
    @RequestMapping(value="/delete" , method = RequestMethod.GET)
    public String idDeleted(){
        return "delete";
    }

    //由id查找学员
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStudentById(@PathVariable Long id, Model model) throws Exception {
        Long before =System.currentTimeMillis();
        Student studentById = studentService.findStudentById(id);
        Long after =System.currentTimeMillis();
        logger.info("It costs "+(after-before)+" ms to find student which id is "+id+" .");
        model.addAttribute("studentById", studentById);
        return "id";
    }

    //由姓名模糊查找
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getStudentByName(@RequestParam String name, Model model) throws Exception {
        Long before =System.currentTimeMillis();
        List<Student> studentByName = studentService.findStudentByName(name);
        Long after =System.currentTimeMillis();
        logger.info("It costs "+(after-before)+" ms to find student(s) whose name is(are) familiar with "+name+" .");
        model.addAttribute("studentByName", studentByName);
        return "name";
    }

    //由学号查找
    @RequestMapping(value = "/number", method = RequestMethod.GET)
    public String getStudentByNumber(@RequestParam String number, Model model) throws Exception {
        Long before =System.currentTimeMillis();
        List<Student> studentByNumber = studentService.findStudentByNumber(number);
        Long after =System.currentTimeMillis();
        logger.info("It costs "+(after-before)+" ms to find student(s) whose number is(are) familiar with "+number+" .");
        model.addAttribute("studentByNumber", studentByNumber);
        return "number";
    }

    //
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String reNewStudent(@PathVariable Long id, Student student) throws Exception {
        Long before =System.currentTimeMillis();
        student.setId(id);
        studentService.updateStudent(student);
        Long after =System.currentTimeMillis();
        logger.info("It costs "+(after-before)+" ms to update student whose id is "+id+". ");
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
