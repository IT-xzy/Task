package com.controller;

import com.pojo.Student;
import com.service.IFStudentService;
import com.service.IMStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class StudentController {
    @Resource
    private IFStudentService ifStudentService;
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public ModelAndView queryAllStudent(){
        ModelAndView modelAndView=new ModelAndView();
        List<Student> studentList=ifStudentService.findStudent();
        modelAndView.addObject("students",studentList);
        modelAndView.setViewName("student");
        return modelAndView;
    }

    //这个方法是用来添加的。
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public ModelAndView addStudent(Student student){
        ModelAndView modelAndView=new ModelAndView();
        ifStudentService.inputStudent(student);
        student.setCreate_at(System.currentTimeMillis());
        modelAndView.setViewName("redirect:/students");
        return  modelAndView;
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public ModelAndView findStudentById(@PathVariable("id")long id,
     @RequestParam(value = "name",required = false) String name,
     @RequestParam(value="age",required = false) String age                                   ) {
        ModelAndView modelAndView = new ModelAndView();
        Student student=ifStudentService.findStudentById(id);
        modelAndView.addObject("object",student);
        if(name==null && age==null ) {
            //编辑的方法体
            modelAndView.setViewName("edit");
        } else {
           //查询视图的方法体
            if (age==null){
                //查询方法体：json页面
                modelAndView.setViewName("query");
            }else {
                //查询方法体: jsp页面
                modelAndView.setViewName("query1");
            }
        }
        return  modelAndView;
    }

    //更新一个用户student
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public ModelAndView update(Student student ){
        ModelAndView modelAndView = new ModelAndView();
        ifStudentService.replayStudent(student);
        student.setUpdate_at(System.currentTimeMillis());
        modelAndView.setViewName("redirect:/students");
        return  modelAndView;
        }

    //删除一个用户
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView delect(@PathVariable("id")long id){
        ModelAndView modelAndView=new ModelAndView();
        ifStudentService.outputStudentById(id);
        modelAndView.setViewName("redirect:/students");
        return modelAndView;
    }
}
