package com.ptteng.controller;


import com.ptteng.CheckStudent;
import com.ptteng.Student;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CheckStudent checkStudent;


    //跳转到删除页面，根据路径传入两个参数，id和page
    @RequestMapping(value = "/student/down/{id}/{page}", method = RequestMethod.GET)
    public String beforeDelete(@PathVariable("id") long id,@PathVariable("page") long page,Model model) {
        System.out.println("第一次id====="+id);
        System.out.println(page);
        Student student = studentService.fingById(id);
        model.addAttribute("student",student);
        model.addAttribute("page",page);
        return "delete";
    }

    @RequestMapping(value = "/student/{id}/{page}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") long id,@PathVariable("page") long page,ModelAndView modelAndView){
        System.out.println(page);
        System.out.println("第2次id====="+id);
        studentService.deleteStudent(id);
//        List<Student> students=studentService.findAll();
//        model.addAttribute("students",students);
        long allPage=checkStudent.findAllPage();
        modelAndView.addObject("page",page);
        modelAndView.addObject("students",checkStudent.findPageStudent(page));
        modelAndView.addObject("allPage",checkStudent.findAllPage());
        modelAndView.setViewName("pageStudent");
        return modelAndView;
    }


    @RequestMapping(value="/student/up/{id}/{page}",method = RequestMethod.GET)
    public String beforeUpdate(@PathVariable("id") long id,@PathVariable("page") long page,Model model){
        System.out.println("修改位置"+id);
        Student student=studentService.fingById(id);
        model.addAttribute("student",student);
        model.addAttribute("page",page);
        return "update";
    }

    //修改数据后回到当前页
    @RequestMapping(value="/student/{page}",method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable("page") long page, Student student, ModelAndView modelAndView){
        System.out.println("修改哒"+student);
        studentService.updateStudent(student);
      modelAndView.addObject("page",page);
      modelAndView.addObject("students",checkStudent.findPageStudent(page));
      modelAndView.addObject("allPage",checkStudent.findAllPage());
      modelAndView.setViewName("pageStudent");
      return modelAndView;
    }

    @RequestMapping(value = "/student/add",method = RequestMethod.GET)
    public String beforeInsert(Student student, Model model){
        model.addAttribute("student",student);
        return "insert";
    }

//    插入数据然后跳转到最后一页
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public ModelAndView insert(Student student, ModelAndView modelAndView){
        System.out.println(student);
        student.setUpdateAt(System.
                currentTimeMillis());
        student.setCreateAt(System.currentTimeMillis());
        studentService.insertStudent(student);
//        List<Student> students=studentService.findAll();
//        model.addAttribute("students",students);
        long allPage=checkStudent.findAllPage();
        modelAndView.addObject("page",checkStudent.findAllPage());
        modelAndView.addObject("students",checkStudent.findPageStudent(allPage));
        modelAndView.addObject("allPage",checkStudent.findAllPage());
        modelAndView.setViewName("pageStudent");
        return modelAndView;
    }






}
