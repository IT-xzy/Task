package com.jnshu.controller;

import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/1/16 - 9:58
 */
@Controller
public class JsonTest {
    @Autowired
    StudentService studentService;
    @ResponseBody
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public List<Student> selectAllStudent(){
        List<Student> students =  studentService.findAll();
        return students;
    }
}
