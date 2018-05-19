package com.controller;

import com.DAO.StudentMapper;
import com.POJO.ChangeType;
import com.POJO.DateTypeChange1;
import com.POJO.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SpringController {
    Student student;
    @Autowired
    StudentMapper studentMapper;
    
    @RequestMapping("/user/student")
    public String gotosearch() throws IOException {
        return "search";
    }
    /*
     * 根据ID查询信息
     *
     * */
    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public String select( Integer ID, Model model) throws Exception {
        student = studentMapper.findUserById(ID);
        List<DateTypeChange1> list2=new ArrayList<DateTypeChange1>();
        list2.add(ChangeType.dateTypeChange1(student));
        model.addAttribute("lists",list2);
        return "list";
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/user/student/{ID}",method = RequestMethod.DELETE)
    public String delect(@PathVariable("ID") int ID, Model model) throws Exception {
        int a = studentMapper.deleteUser(ID);
        String message;
        if (a == 1) {
            message = "数据删除成功";
        } else {
            message = "数据删除失败";
        }
        model.addAttribute("message", message+ID);
        return "result";
    }
    /**
     * 修改用户
     */
    @RequestMapping(value = "/user/newstudent",method = RequestMethod.GET)
    public String selectOne( Integer ID, Model model) throws Exception {
        student = studentMapper.findUserById(ID);
        DateTypeChange1 newstu =  ChangeType.dateTypeChange1(student);
        model.addAttribute("student", newstu);
        return "change";
    }
    @RequestMapping(value = "/user/sturesult")
    public String update(DateTypeChange1 updatestudent,Model model) throws Exception {
        Student newstu1 = ChangeType.LongTypeChange(updatestudent);
        int s = studentMapper.updateUser(newstu1);
        String message;
        if (s == 1) {
            message = "数据修改成功";
        } else {
            message = "数据修改失败";
        }
        model.addAttribute("message", message);
        return "result";
    }
    /**
     * 根据姓名模糊查询
     */
    @RequestMapping(value = "/user/nameList",method = RequestMethod.GET)
    public String selectByName(String name, Model model) throws Exception {
        List<Student> studentlist = studentMapper.findUserByName(name);
        List<DateTypeChange1> list2=new ArrayList<DateTypeChange1>();
        for(Student student : studentlist){
            list2.add(ChangeType.dateTypeChange1(student));
        }
        model.addAttribute("lists",list2);
        return "list";
    }
    /**
     * 新增用户
     */
    @RequestMapping("/user/new")
    public String turntoinsert( ) throws IOException {
        return "insert";
    }
    @RequestMapping(value = "/user/result", method = RequestMethod.POST)
    public String insert(DateTypeChange1 newStudent,Model model) throws Exception {
        Student newstu1 = ChangeType.LongTypeChange(newStudent);
        int s = studentMapper.insertUser(newstu1);
        Integer a = newstu1.getID();
        String message;
        if (s == 1) {
            message = "数据添加成功";
        } else {
            message = "数据添加失败";
        }
        model.addAttribute("message",message);
        return "result";
    }
}
