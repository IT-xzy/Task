package task2.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import task2.pojo.Student;
import task2.service.StudentService;
import task2.util.Page;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping()
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/index")
    public String toLogin() {
        return ("index");
    }

    @RequestMapping("/jump")
    public ModelAndView jump() {
        ModelAndView mav = new ModelAndView("redirect:/index");
        return mav;
    }

    @RequestMapping("/students")
    public ModelAndView listUser(Page page) {
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(), 25);
        List<Student> students = studentService.list();
        int total = (int) new PageInfo<>(students).getTotal();
        //page.caculateLast(total);
        mav.addObject("students", students);
        mav.setViewName("students");
        return mav;
    }

    @RequestMapping("/student")
    public ModelAndView add(Student student) throws Exception {
        ModelAndView mav = new ModelAndView("/student");
        return mav;
    }
    //删除
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Integer id) throws Exception{

        studentService.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/students");
        return mav;

    }
    //改
    @RequestMapping(value = "/students/{id}",method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable("id") Integer id,Student student) throws Exception {
        student.setid(id);
        studentService.update(student);
        ModelAndView mav = new ModelAndView("redirect:/students");
        //mav.setViewName("listUser");
        return mav;
    }

    @RequestMapping(value = "/students/{id}",method = RequestMethod.POST)
    public ModelAndView adsd(@PathVariable("id") Integer id) throws Exception {
        Student student = studentService.findById(id);
        ModelAndView mav = new ModelAndView("id");
        mav.addObject("student",student);
        mav.setViewName("id");
        return mav;
    }
    //添加
    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public ModelAndView addd(Student student) throws Exception {
        studentService.add(student);
        ModelAndView mav =new ModelAndView("redirect:/students");
        //mav.setViewName("listUser");
        return mav;
    }
    //根据id查找
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ModelAndView Studentbyid(@RequestParam Integer id) {
        Student student = studentService.findById(id);
        ModelAndView mav = new ModelAndView("id");
        mav.addObject("student", student);
        mav.setViewName("id");
        return mav;
    }
    //根据姓名查找
    @RequestMapping(value = "/students/stu_name",method = RequestMethod.GET)
    public ModelAndView Studentbyname(@RequestParam("stu_name") String stu_name,Student student) throws Exception {
//        PageHelper.offsetPage(page.getStart(), 10);
        List<Student> students =studentService.findByName(stu_name);
//        int total = (int) new PageInfo<>(students).getTotal();

//        page.caculateLast(total);
        ModelAndView mav =new ModelAndView();
        mav.addObject("students",students);
//        mav.addObject("page", page);
        mav.setViewName("students");
        return mav;
    }
}



