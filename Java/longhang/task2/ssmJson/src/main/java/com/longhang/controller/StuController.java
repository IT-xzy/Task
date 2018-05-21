package com.longhang.controller;


import com.longhang.stuModel.Student;
import com.longhang.stuService.StuService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StuController  {
    // private static Logger logger = Logger.getLogger(StuController.class);
    org.slf4j.Logger logger = LoggerFactory.getLogger(StuController.class);
    @Resource
    private StuService stu;
    //private StudentDao s;
    /**
     * 首页
     */
    @RequestMapping("")
    public String go() {
        return "index";
    }
    /**
     * 跳转到添加用户界面
     */
    @RequestMapping("/POST")
    public String toAddStu() {
        return "addStu";
    }
    /**
     * 跳转到查询用户界面
     */
    @RequestMapping("/GET")
    public String toQueryStu() {
        return "message";
    }
    /**
     * 跳转到编辑用户界面
     */
    @RequestMapping("/toStudent/{id}")
    public String toUpdateStu(Model model,@PathVariable Long id) {
        model.addAttribute("student", stu.getStuById(id));
        logger.info("students {}"+stu.getStuById(id));
        logger.info("id:\t"+id);
        return "editStu";
    }
    /**
     * 添加用户并重定向
     */
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String addStu( Model model,Student student) {
              logger.info("student: \t"+student.toString());
        if (student != null) {
            stu.getInsert(student);
            logger.info("1");
        }
        return "redirect:/studentInfo";
    }
    /**
     * 修改用户并重定向
     * @param
     * @return
     */
    @RequestMapping(value = "/student",method =RequestMethod.PUT)
    public String updateStu( Long id, Student student) {
        logger.info("id:"+id);
        logger.info("student.toString():"+student.toString());
        if (stu.getUpdate(student)) {
            stu.getStuById(student.getId());
            return "redirect:/studentInfo";
        }
        else
            return "json";
    }
    /**
     * 查询单个用户
     *
     * @param id
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/json/student",method =RequestMethod.GET)
    public String getStu1(@RequestParam Long id, Student student,Model model) {
//        if (stu.getStuById(id)!=null){
            logger.info("Processing trade with id: {}  ", id);
            model.addAttribute("student", stu.getStu(student));
            logger.info("Processing trade with :"+student.toString());
            return "json";
//        else
//            return "error";
    }
    @RequestMapping(value = "/student/{id}",method =RequestMethod.GET)
    public String getStu(@PathVariable Long id, Model model) {
//        if (stu.getStuById(id)!=null){
        logger.info("Processing trade with id: {}  ", id);
        model.addAttribute("student", stu.getStuById(id));
        return "message";
//        else
//            return "error";
    }
    /**
     * 根据id删除用户
     *
     * @param id
     * @param
     * @param
     */
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public String deleteStu(@PathVariable Long id, Model model) {
        logger.info("Processing trade with id: {}  ", id);
        model.addAttribute("student", stu.getDelete(id));
        return "redirect:/studentInfo";
    }
    /**
     * 查询所有用户
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/studentInfo")
    public String getAllStu(Model model) {
        List<Student> students = stu.getGetAll();
        model.addAttribute("studentList", students);
        return "all";
    }
    /**
     * 查询所有用户
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/students")
    public String getAllStuOne(Model model) {
        List<Student> students = stu.getGetAll();
        model.addAttribute("students", students);
        return "stuJson";
    }
}