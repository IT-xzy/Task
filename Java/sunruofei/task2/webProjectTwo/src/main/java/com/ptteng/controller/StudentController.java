package com.ptteng.controller;

import com.ptteng.model.Result;
import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.omg.CORBA.Request;
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
    static Result result =new Result();
    static Map<String ,Object> map= new HashMap<>();
    @Autowired
    StudentService studentService;
    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public Result findAll(){
        List<Student> students =studentService.findAll();
        result.setCode(200);
        result.setMessage("成功");
        map.put("student",students);
        result.setData(map);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Result add(Student student){
        studentService.add(student);
        result.setCode(200);
        result.setMessage("成功");
    return result;
    }
    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.DELETE)
    public Result delete(int id){
        studentService.delete(id);
        result.setMessage("成功");
        result.setCode(200);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public Result update(Student student){
        studentService.update(student);
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable  int id){
      Student student =  studentService.findById(id);
        result.setCode(200);
        result.setMessage("成功");
        map.put("student",student);
        result.setData(map);
        return result;
    }

}
