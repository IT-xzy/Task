package cn.wyq.controller;

import cn.wyq.pojo.Student;
import cn.wyq.service.StudentService;
import cn.wyq.util.Page;
import cn.wyq.util.RmiServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
//    @Autowired
//    StudentService studentService;

    StudentService studentService = (StudentService) new RmiServiceProxy().getStudentService();
    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/u/students",method = RequestMethod.GET)
    public ModelAndView listStudent(Page page){
        System.out.println("listStudent请求");
        List<Student> students= studentService.list(page);
        int total = studentService.total();
        page.caculateLast(total);
        System.out.println("listStudent获取数据");
        modelAndView.addObject("students",students);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("students");
        return modelAndView;
    }
}
