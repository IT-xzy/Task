package com.majorjoe.web.controller;

import com.mojorjoe.web.exception.StudentException;
import com.mojorjoe.web.pojo.PageBean;
import com.mojorjoe.web.pojo.Student;
import com.mojorjoe.web.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    private Logger logger = Logger.getLogger(StudentController.class);
    Student student = new Student();


    /**
     * 接口文档：
     * 采用restful风格接口；url定位资源；http定义操作。页面提交请求隐藏参数_method ；web.xml设置过滤器接收参数
     * 前后台数据传输均约定以json格式
     * accept  ： json
     * contextType:    application/json
     * controller层不直接返回实体类，由jsonTaglib进行排版
     */

//    查询：  http://localhost:8080/{id}/info
    @RequestMapping(value = "{id}/info", method = GET)
    public ModelAndView selectStudent(@PathVariable("id") long id) throws Exception {
        ModelAndView mv = new ModelAndView();
        student = studentService.selectStudent(id);
        if (student == null) {
            logger.info("id查询空值" + id);
            throw new StudentException("你所查询的信息不存在");
        } else {
            logger.info("id查询："+id);
            mv.addObject("student", student);
            mv.setViewName("json1");
            return mv;
        }
    }

    //    模糊查询：http://localhost:8080/{name}/info
    @RequestMapping(value = "name/info", method = GET)
    public ModelAndView selectByName(@RequestParam("name") String name) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Student> students = studentService.selectByName(name);
        if (students == null) {
            logger.info("name查询空值" + name);
            throw new StudentException("你所查询的信息不存在");
        } else {
            logger.info("name模糊查询："+name);
            mv.addObject("students", students);
            mv.setViewName("json2");
            return mv;
        }
    }

    //    删除：DELETE  http://localhost:8080/{id}/info
    @RequestMapping(value = "{id}/info", method = DELETE)
    public String deleteStudent(@PathVariable("id") long id) throws Exception {

        if (studentService.deleteStudent(id)) {
            logger.info("删除数据id=" + id);
        } else {
            logger.info("删除数据不存在id=" + id);
            throw new StudentException("删除数据不存在");
        }
        return "redirect:/1/infolist";
    }

    //    修改：PUT  http://localhost:8080/{id}/info
    @RequestMapping(value = "{id}/info", method = PUT)
    public String updateStudent(@PathVariable("id") long id, @RequestBody(required = false) Student student) throws Exception {

        student.setId(id);

        if (studentService.updateStudent(student)) {
            logger.info("更新数据id=" + id);
        } else {
            logger.info("更新数据不存在id=" + id);
            throw new StudentException("更新数据不存在");
        }
        String redirect ="redirect:/"+id+"/info";
        return redirect;
    }

    //    增加：POST http://localhost:8080/info
    @RequestMapping(value = "/info", method = POST)
    public String updateStudent( @RequestBody(required = false) Student student) throws Exception {

        String redirect ="redirect:/"+studentService.saveStudent(student)+"/info";
        return redirect;
    }



    //    分页   http://localhost:8080/{pageNum}/infolist
    @RequestMapping(value = "{pageNum}/infolist", method = GET)
    public ModelAndView pageListStudent(@PathVariable("pageNum" ) long pageNum) throws Exception {
        ModelAndView mv = new ModelAndView();
        PageBean pageBean = studentService.pageListStudent(pageNum,5);
        mv.addObject("pageBean",pageBean);
        mv.setViewName("json3");
        return mv;
    }
}



