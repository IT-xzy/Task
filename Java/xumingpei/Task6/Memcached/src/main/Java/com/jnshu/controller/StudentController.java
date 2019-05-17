package com.jnshu.controller;

import com.alibaba.fastjson.JSON;
import com.jnshu.pojo.Student;
import com.jnshu.pojo.tool.DesUtil;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 7:25
 */
@Controller
public class StudentController {
    private static Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getAll(HttpServletRequest request){
        List<Student> students =studentService.getAll();
        logger.info(students.toString());
        Cookie[] cookies= request.getCookies ();
        String token = null;
        ModelAndView mav =new ModelAndView("home");
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                switch (cookie.getName()) {
                    case "token":
                        token = cookie.getValue();
                        token = DesUtil.decrypt(token);
                }
            }
        }
        if(token != null) {
            String[] mw = token.split("\\|");
            String name = mw[1];
            logger.info("name1:" + mw[1]);
            mav.addObject("students",students);
            mav.addObject("name",name);
        }
        return mav;
    }


    //跳转页面
    @RequestMapping(value="/u/goInsert", method = RequestMethod.GET)
    public ModelAndView toInsert() {
        ModelAndView mav = new ModelAndView ("info/insert");
        return mav;
    }

    @RequestMapping(value="/u/student", method = RequestMethod.POST)
    public ModelAndView insert(Student student) {
        logger.info (student.toString());
        int rs=studentService.insert (student);
        logger.info ("新增结果："+rs);
        ModelAndView mav = new ModelAndView ("info/info");
        mav.addObject ("rs1", rs);
        return mav;
    }

    @RequestMapping(value="/u/goUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView toUpdate(@PathVariable long id) {
        Student student =studentService.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView ("info/update");
        mv.addObject ("student", student);
        return mv;
    }

    @RequestMapping(value="/u/student/{id}", method = RequestMethod.PUT)
    public ModelAndView update(Student student) {
        logger.info (student.toString());
        int rs=studentService.updateByPrimaryKey (student);
        logger.info ("更新结果："+rs);
        ModelAndView mv = new ModelAndView ("info/info");
        mv.addObject ("rs2", rs);
        return mv;
    }

    @RequestMapping(value="/u/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable long id) {
        boolean rs=studentService.deleteStudent (id);
        logger.info("删除结果："+rs);
        ModelAndView mv = new ModelAndView ("info/info");
        mv.addObject ("rs", rs);
        return mv;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ModelAndView list() {
        List<Student> student = studentService.getAll();
        ModelAndView mv = new ModelAndView ("info/list");
        mv.addObject ("student", student);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value="/allJson", method = RequestMethod.GET)
    public String listJson() {
        List<Student> student = studentService.getAll();
        Map mv = new HashMap();
        mv.put ("student", student);
        return JSON.toJSONString(mv);
    }


    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public ModelAndView byName(@RequestParam String name){
        logger.info("查询的名字"+name);
        List<Student> student = studentService.selectByName(name);
        ModelAndView mav = new ModelAndView("info/list");
        mav.addObject("student",student);
        return mav;
    }
}
