package com.longhang.controller;

import com.longhang.model.Student;
import com.longhang.stuService.StuService;
import com.longhang.util.SelectUtli;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class StuController {
    Logger logger =Logger.getLogger("StuController.class");
     private StuService stu=SelectUtli.getStudentService();


    @RequestMapping ("/myTest")
    public String myTest(){
        return "test";
    }
    @RequestMapping("/totest")
    public String to(MultipartFile upPicture) throws IOException {
        InputStream inputStream = upPicture.getInputStream();
        return "上传成功";
    }

    /**
     *
     * 数据迁移工具
     *
     * */
    @RequestMapping ("/qianyi")
    public String qianyi(){
        return "qinayi";
    }




    /**
     * 跳转添加
     */
    @RequestMapping("/POST")
    public String toAddStu() {
        return "addStu";
    }
    /**
     * 跳转
     */
    @RequestMapping("/GET")
    public String toQueryStu() {
        return "message";
    }


    /**
     * 获取学生
     *
     * @param id
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/json/student",method =RequestMethod.GET)
    public String getStu1(@RequestParam Long id, Student student, Model model) {
//        if (stu.getStuById(id)!=null){
        logger.info("query id : "+id);
        Long start=System.currentTimeMillis();
        Student student1=stu.getStu(student);
        Long end=System.currentTimeMillis();
        logger.info("the db run time : "+(end-start));
        model.addAttribute("student",student1);
        logger.info("student massage : "+student.toString());
        return "stuJson";
//        else
//            return "error";
    }
    @RequestMapping(value = "/student/{id}",method =RequestMethod.GET)
    public String getStu(@PathVariable Long id, Model model) {
        logger.info("query id : "+id);
        model.addAttribute("student", stu.getStuById(id));
        return "message";
    }
    /**
     * 根据id删除
     *
     * @param id
     * @param
     * @param
     */
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public String deleteStu(@PathVariable Long id, Model model) {
        logger.info("delete id : "+ id);
        Long start=System.currentTimeMillis();
        stu.getDelete(id);
        Long end=System.currentTimeMillis();
        logger.info("the db run time : "+(end-start));
        return "redirect:/students";
    }
    /**
     * 查询所有
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/students")
    public String getAllStu(Model model)  {
        try{
            List<Student> students = stu.getGetAll();
        System.out.println("我来了"+students.toString());
        model.addAttribute("studentList", students);}
        catch(Exception e){
            StuService stu=SelectUtli.getStudentService();
            List<Student> students = stu.getGetAll();
            model.addAttribute("studentList", students);}
        return "all";
    }
    /**
     * 查询所有json
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/json/students")
    public String getAllStuOne(Model model)  {
            List<Student> students = stu.getGetAll();
        model.addAttribute("students", students);
        return "stuJson";
    }



}
