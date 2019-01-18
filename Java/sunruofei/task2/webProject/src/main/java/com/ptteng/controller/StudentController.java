package com.ptteng.controller;

import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    static Logger logger = Logger.getLogger(StudentController.class);
    static Map<String,Object> map = new HashMap<>();
    @Autowired
    StudentService studentService;
    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public Map findAll() {
        List<Student> students = studentService.findAll();
        map.put("code",200);
        map.put("message","成功");
        map.put("student",students);
       logger.info(map);
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Map addStudent(Student student){
        logger.info(student);
    studentService.add(student);
    map.put("code",200);
    map.put("message","成功");
    return map;
    }
    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.DELETE)
    public Map delete(int id){
        studentService.delete(id);
        map.put("code",200);
        map.put("message","成功");
    return map;
    }
    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public Map update(Student student){
        studentService.update(student);
        map.put("code",200);
        map.put("message","成功");
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/student/{id}",method =RequestMethod.GET )
    public Map findById (@PathVariable int id){
      Student student =  studentService.findById(id);
        map.put("code",200);
        map.put("message","成功");
        map.put("student",student);

        return map;

    }



}

