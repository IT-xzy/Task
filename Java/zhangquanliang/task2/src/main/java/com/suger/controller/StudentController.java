package com.suger.controller;

import com.suger.pojo.Page;
import com.suger.pojo.Student;
import com.suger.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author suger
 * @date 2018-10-02
 */
@Controller(value = "studentController")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView listStudent(Page page)  throws Exception {
        int total = studentService.total();
        page.calculateLast(total);
        List<Student> students = studentService.findAll(page);

        ModelAndView mav = new ModelAndView();
        if(students==null){
            logger.info("查询失败----");
        }else{
            logger.info("查询成功----");
        }

        //相当于request的setAttribute方法,在jsp页面中通过students取数据
        mav.addObject("students", students);
        //指定视图
        mav.setViewName("studentList");
        return mav;
    }

    // 根据姓名查询，支持模糊查询，以jsong格式返回
    @RequestMapping(value = "/student/name/", method = RequestMethod.GET)
    public ModelAndView getStudent(@RequestParam String name) throws Exception {

        List<Student> students = studentService.getStudentByName(name);
        ModelAndView mav = new ModelAndView();
        mav.addObject("students", students);
        mav.setViewName("studentJson");
        return mav;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable Long id) {
        boolean deleteTag = studentService.deleteStudent(id);
        logger.warn("删除结果："+deleteTag);
        ModelAndView mav = new ModelAndView("redirect:/student");
        return mav;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ModelAndView editStudent(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        Student student1 = studentService.getStudentById(id);
        mav.addObject("s", student1);
        mav.setViewName("updateStudent");
        return mav;
    }


    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String saveStudent(Student student,  Model model) {

            // 通过model 回显验证信息到jsp页面
            model.addAttribute("student", student);
            // 参数错误，刷新提交页面
            logger.info("跳转 新增页面");
            return "savestudent";

    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public ModelAndView updateStudent(Student student) {
        if(student.getId()==null){
            logger.info("id不存在，添加信息");
            studentService.addStudent(student);
        }else {
            logger.info("id已经存在，更新信息");
            studentService.updateStudent(student);
        }
        ModelAndView mav = new ModelAndView("redirect:/student");
        return mav;
    }
}
