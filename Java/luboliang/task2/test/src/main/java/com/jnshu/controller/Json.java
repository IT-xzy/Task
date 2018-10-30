package com.jnshu.controller;

import com.jnshu.model.Page;
import com.jnshu.model.Result;
import com.jnshu.model.Student;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory;
import java.util.List;

@Controller
public class Json {
    protected Logger log = Logger.getLogger(StudentController.class);
    @Autowired
    Page p;
    @Resource(name = "StudentService")
    private StudentService studentService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
        @ResponseBody
        public Result findAll(Result result) {
            List<Student> list = studentService.findAll();
            result.setCode(200);
            result.setMessage("OK");
            result.setData(list);
            log.info(list);
            return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result post(Result result, Student student) {
        result.setCode(200);
        result.setMessage("OK");
        log.info(studentService.addStudent(student));
        return result;
    }
    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    @ResponseBody
    public Result put(Student student,Result result){
        result.setCode(200);
        result.setMessage("OK");
        log.info(studentService.updateStudent(student));
        return result;
    }
    @RequestMapping(value = "/login", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete( long id, Result result){
        log.info(id+"==============================================");
        result.setCode(200);
        result.setMessage("OK");
        log.info(studentService.deleteStudent(id));
        return result;
    }

}
