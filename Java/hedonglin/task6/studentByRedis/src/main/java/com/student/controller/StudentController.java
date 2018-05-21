package com.student.controller;


import com.student.model.Student;
import com.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);


    @Resource
    private StudentService studentService;

    //    查询所有学生
    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public String getAll(Model model) {
        log.info("/student/list GET ");
//        List<Student> studentList = studentService.getAll();
//        List<Student> studentList=studentService.useMemcacheGetStudentList();
        List<Student> studentList = (List<Student>) studentService.useRedisGetStudentList();
        model.addAttribute("studentList", studentList);
        log.info("get student size is {}", studentList.size());
        return "list";
    }


    //    删除
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String delStudent(@PathVariable Long id) {
        log.info("/student/{id} DELETE  id is {}", id);
        studentService.deleteByPrimaryKey(id);
        log.info("deleted {} success", id);
        return "redirect:/student/list";
    }


    //    添加学员跳转页
    @RequestMapping(value = "/student/a", method = RequestMethod.GET)
    public String toAddStudent() {
        log.info("open /student/a GET");
        return "add";

    }

    //    添加学员
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(Student student) {
        student.setCreateAt(System.currentTimeMillis());
        if (student.getUpdateAt() == null) {
            student.setUpdateAt(System.currentTimeMillis());
        }
        studentService.insert(student);
        log.info("insert student information is {}", student);
        return "redirect:/student/list";
    }


    //    跳转到修改学员界面
    @RequestMapping(value = "/student/u/{id}", method = RequestMethod.GET)
    public String toUpdateStudent(@PathVariable Long id, Model model) {
        Student student = studentService.selectByPrimaryKey(id);
        model.addAttribute("student", student);
        return "update";
    }

    //    学员修改
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String updateStudent(@PathVariable Long id, Model model,
                                Long createAt, Long updateAt, String name, String sex,
                                String qq, String major, Long entryTime, String comeFrom) {
        Student student = new Student();
        log.info("/student/{id} the request parameters are id:{},createAt:{},updateAt:{},name:{}," +
                        "sex:{},qq:{},major:{},entryTime:{},comeFrom:{}", id, createAt, updateAt, name, sex, qq,
                major, entryTime, comeFrom);
        System.out.println(comeFrom);
        student.setId(id);
        student.setCreateAt(createAt);
        student.setUpdateAt(updateAt);
        student.setName(name);
        student.setSex(sex);
        student.setQq(qq);
        student.setMajor(major);
        student.setEntryTime(entryTime);
        student.setComeFrom(comeFrom);
        student.setUpdateAt(System.currentTimeMillis());
        int success = studentService.updateByPrimaryKey(student);
        log.info("update student success is {}", success);
        return "redirect:/student/list";
    }

    //    查询所有学生返回Json
    @RequestMapping(value = "/student/list/json", method = RequestMethod.GET)
    public String getAllByJson(Model model) {
        List<Student> studentList = (List<Student>) studentService.useRedisGetStudentList();
        model.addAttribute("studentList", studentList);
        return "jsonList";
    }


    @RequestMapping(value = "/student/json/{id}", method = RequestMethod.GET)
    public Object getStudentById(@PathVariable Long id,Model model) {
        Object student= studentService.useRedisGetStudent(id);
        model.addAttribute("student", student);
        return "student";

    }


    //学员修改界面
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public String updateStudent2(Long id,Model model) {
//        //先将原本的数据放入框内
//        Student student=studentService.selectByPrimaryKey(id);
//        model.addAttribute("student", student);
//
//        //修改该学生的相关信息
//        studentService.updateByPrimaryKey(student);
//    }
}




