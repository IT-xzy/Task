package com.suger.controller;

import com.suger.pojo.Page;
import com.suger.pojo.Student;
import com.suger.service.RMIService;
import com.suger.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/29 18:19
 */

@Controller
public class StudentController {

    private static Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private RMIService rmiServcice;
    private StudentService  studentService;


    // 分页查询全表
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView listStudent(Page page)  throws Exception {

        studentService = rmiServcice.getStudentService();

        int total = studentService.total();
        page.calculateLast(total);
        List<Student> students = studentService.findAll(page);

        ModelAndView mav = new ModelAndView();
        if(students==null || students.isEmpty()){
            logger.info("查询失败，用户列表为空");
        }else{
            logger.info("查询成功----");
        }

        mav.addObject("students", students);
        //指定视图
        mav.setViewName("listStudent");
        return mav;
    }
    @RequestMapping(value = "/student/", method = RequestMethod.GET)
    public ModelAndView getStudent(@RequestParam(value = "name",required = false) String name){

        studentService = rmiServcice.getStudentService();

        logger.info("name:"+name);
        List<Student> students = studentService.getStudentByName(name);

        ModelAndView mav = new ModelAndView();
        if(students==null || students.isEmpty()){
            logger.info("查询失败,学生列表为空");
        }else{
            logger.info("查询成功----");
        }
        mav.addObject("students", students);
        //指定视图
        mav.setViewName("getStudent");
        return mav;
    }


    // 删除
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)

    public String deleteStudent(@PathVariable Long id,Model model) {

        logger.info("删除记录的id:"+id);
        // 标识删除，默认删除失败
        boolean deleteTag = false;

        studentService = rmiServcice.getStudentService();

        deleteTag = studentService.deleteStudent(id);
        logger.warn("删除结果："+deleteTag);
        return "redirect:/student";
    }

    // 根据id 查询
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String editStudent(@PathVariable Long id, Model model) {

        studentService = rmiServcice.getStudentService();

        Student student = studentService.getStudentById(id);
        model.addAttribute("s", student);
        return "updateStudent";
    }


    // 更新
    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public ModelAndView updateStudent(Student student) {

        studentService = rmiServcice.getStudentService();

        ModelAndView mav  = new ModelAndView();
        if(student.getId()==null){
            logger.info("id不存在，添加信息");
        }else {
            logger.info("id已经存在，更新信息");
            boolean tag = studentService.updateStudent(student);
            if(tag){
                mav.addObject("message","更新成功");
            }else{
                mav.addObject("message","更新失败");
            }
        }
        mav.setViewName("redirect:/student");
        return mav;
    }
}
