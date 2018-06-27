package com.fml.controller;

import com.fml.pojo.Student;
import com.fml.service.StudentService;
import com.fml.utils.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/10 14:11
 * @version: [1.0]
 */

@Controller
@RequestMapping("s")
public class StudentController {
    private static final Logger logger = Logger.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;

    /**进入报名页面*/
    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }

    /**学员报名信息提交*/
    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public String add(Student student){
        final long createTime = System.currentTimeMillis();
        student.setCreateTime(createTime);
        student.setUpdateTime(System.currentTimeMillis());

        int result = studentService.add(student);
        if (result == 1){
            return "success";//若想直接返回学员列表,就重定向到list方法。redirect:studentList
        }
        return "error";
    }

    /**分页查询所有学员*/
    @RequestMapping(value = "/students")
    public String studentList(@RequestParam(value = "currPage", defaultValue = "1", required = false) int currPage,Model model){
        Page<Student> lists = studentService.selectAll(currPage);
        model.addAttribute("lists",lists);
        return "students";
    }

    /**根据ID查看学员报名信息详细页面*/
    @RequestMapping(value = "/students/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable("id") int id,Model model){
        Student student = studentService.selectById(id);
        model.addAttribute("stu",student);
        return "detail";
    }

    /**根据学员姓名查找*/
    @RequestMapping(value = "/students/name",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String findByName(@RequestParam("name") String name, Model model){
        List<Student> students = studentService.selectByName(name);
        model.addAttribute("students",students);
        return "stuName";
    }

    /**根据ID删除学员*/
    @RequestMapping(value = "/students/{id}",method = RequestMethod.DELETE)
    public String studentDelete(@PathVariable("id") int id){
        int result =  studentService.delete(id);
        if (result != 1){
            return "error";
        }
        return "success";
    }

    /**进入更新信息页面*/
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String studentUpdate(@PathVariable("id") int id,Model model){
        Student student = studentService.selectById(id);
        model.addAttribute("student",student);
        return "update";
    }

    /**更新学员报名信息*/
    @RequestMapping(value = "/students/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable("id") int id, Student student){
        student.setUpdateTime(System.currentTimeMillis());
        student.setId(id);
        int result = studentService.update(student);

        long CreateTime = System.currentTimeMillis();
        student.setCreateTime(CreateTime);
        if (result == 1){
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String json(ModelMap modelMap) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("234");
        list.add("567");
        modelMap.addAttribute("list", list);
        return "json";
    }
}