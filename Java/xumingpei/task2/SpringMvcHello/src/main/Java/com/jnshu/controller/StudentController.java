package com.jnshu.controller;

import com.jnshu.pojo.Page;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author pipiretrak
 * @date 2019/1/7 - 22:22
 */
@Controller
//@RequestMapping("")
public class StudentController {
    private static Logger logger = Logger.getLogger(String.valueOf(StudentController.class));
    //注入service层
    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public ModelAndView list(Page page){
        logger.info("查看全部");
        //分开指定视图与模型
        ModelAndView mav = new ModelAndView("ListStudent");
        List<Student> students = studentService.list(page);
        int total = studentService.total();
        page.caculateLast(total);
        //添加模型中的对象
        mav.addObject("students",students);
        return mav;
    }

    @RequestMapping(value = "/new/student",method = RequestMethod.GET)
    public String newStudent(Student student){
        return "AddStudent";
    }

    //新增
    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public String addStudent(Student student){
      logger.info("新增的参数为："+ student.toString());
      int rs= studentService.add(student);
      return "redirect:/students";
    }


    //删除
    @RequestMapping(value = "/student/{id}",method =RequestMethod.DELETE )
    public String deleteStudent(@PathVariable int id){
        logger.info("删除的id:"+id);
        int rs= studentService.delete(id);
        return "redirect:/students";
    }

    //跳转到editStudent
    @RequestMapping(value = "/students/{id}",method=RequestMethod.GET)
    public ModelAndView editStudent(@PathVariable int id){
        Student student = studentService.get(id);
        ModelAndView mav = new ModelAndView("EditStudent");
        mav.addObject("student",student);
        return mav;
    }

    //修改
    @RequestMapping(value = "/students/{id}",method=RequestMethod.PUT)
    public String updateStudent(Student student){
        logger.info("修改的参数："+student.toString());
        int rs = studentService.update(student);
        return "redirect:/students";
    }

    //模糊查询
    @RequestMapping(value = "/students/name",method = RequestMethod.GET)
    public ModelAndView byName(@RequestParam String name){
        logger.info("查询的名字"+name);
        List<Student> students = studentService.byName(name);
        ModelAndView mav = new ModelAndView("ListStudent");
        mav.addObject("students",students);
        return mav;
    }
}
