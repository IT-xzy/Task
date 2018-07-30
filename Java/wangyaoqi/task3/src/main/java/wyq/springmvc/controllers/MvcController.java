package wyq.springmvc.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wyq.springmvc.pojo.Student;
import wyq.springmvc.service.StudentService;
import wyq.springmvc.util.Page;

import java.util.List;
import org.apache.log4j.Logger;


@Controller
@RequestMapping("/mvc")
public class MvcController {
    @Autowired
    StudentService studentService;
    ModelAndView modelAndView = new ModelAndView();

    private static Logger logger = Logger.getLogger(MvcController.class);
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public ModelAndView listStudent(Page page){
        List<Student> students= studentService.list(page);
        int total = studentService.total();
        page.caculateLast(total);
        modelAndView.addObject("students",students);
        modelAndView.setViewName("listStudent");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public ModelAndView addStudent(Student student){
        studentService.addStudent(student);
        modelAndView.setViewName("redirect:/mvc/students");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
        modelAndView.setViewName("redirect:/mvc/students");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/student/{id}",method = RequestMethod.POST)
    public ModelAndView updateStudent(Student student){
        studentService.updateStudent(student);
        modelAndView.setViewName("redirect:/mvc/students");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public ModelAndView showStudent(@PathVariable("id") int id){
        Student s=studentService.getById(id);
        modelAndView.addObject("student",s);
        modelAndView.setViewName("editStudent");
        return modelAndView;
    }
}
