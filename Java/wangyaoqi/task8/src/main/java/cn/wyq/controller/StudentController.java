package cn.wyq.controller;

import cn.wyq.pojo.Student;
import cn.wyq.service.StudentService;
import cn.wyq.util.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    private Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;
    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/u/students",method = RequestMethod.GET)
    public ModelAndView listStudent(Page page){
        List<Student> students= studentService.list();
        int total = studentService.total();
        page.caculateLast(total);
        modelAndView.addObject("students",students);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("students");
        return modelAndView;
    }

    @RequestMapping(value = "/u/student",method = RequestMethod.POST)
    public ModelAndView addStudent(Student student){
        studentService.addStudent(student);
        modelAndView.setViewName("redirect:/u/students");
        return modelAndView;
    }

    @RequestMapping(value = "/u/student/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
        System.out.println("删除数据\n");
        modelAndView.setViewName("redirect:/u/students");
        return modelAndView;
    }

//    @ResponseBody
//    @RequestMapping(value = "/u/student/{id}",method = RequestMethod.POST)
//    public ModelAndView updateStudent(Student student){
//        studentService.updateStudent(student);
//        modelAndView.setViewName("redirect:/students");
//        return modelAndView;
//    }

//    @ResponseBody
//    @RequestMapping(value = "/u/student/{id}",method = RequestMethod.GET)
//    public ModelAndView showStudent(@PathVariable("id") int id){
//        Student student=studentService.getById(id);
//        modelAndView.addObject("student",student);
//        modelAndView.setViewName("editStudent");
//        return modelAndView;
//    }
}
