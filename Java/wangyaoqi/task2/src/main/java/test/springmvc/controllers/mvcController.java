package test.springmvc.controllers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.springmvc.pojo.Student;
import test.springmvc.service.StudentService;
import test.springmvc.util.Page;

import java.util.List;
import org.apache.log4j.Logger;


@Controller
@RequestMapping("/mvc")
public class mvcController{
    @Autowired
    StudentService studentService;
    ModelAndView modelAndView = new ModelAndView();
    public StudentService getStudentService(){
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    private static Logger logger = Logger.getLogger(mvcController.class);
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ModelAndView listStudent(Page page){
        PageHelper.offsetPage(page.getStart(),5);
        List<Student> students= studentService.list();
        int total = (int) new PageInfo<>(students).getTotal();
        page.caculateLast(total);
        modelAndView.addObject("students",students);
        modelAndView.setViewName("listStudent");
        logger.info("list正常");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public ModelAndView addStudent(Student student){
        studentService.addStudent(student);
        modelAndView.setViewName("redirect:/mvc/student");
        logger.info("添加正常");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
        modelAndView.setViewName("redirect:/mvc/student");
        logger.info("删除正常");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public ModelAndView updateStudent(Student student){
        studentService.updateStudent(student);
        modelAndView.setViewName("redirect:/mvc/student");
        logger.info("更新正常");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public ModelAndView showStudent(@PathVariable("id") int id){
        Student s=studentService.getById(id);
        modelAndView.addObject("s",s);
        logger.info("查询正常");
        return modelAndView;
    }
}
