package com.jnshu.server.controller;

import com.google.gson.Gson;
import com.jnshu.server.po.Students;
import com.jnshu.server.service.BeanService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by lxk on 2017/3/27
 */
@Controller
//@RequestMapping 是 Spring Web 应用程序中最常被用到的注解之一。
// 这个注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。
//@RequestMapping用在类上，这时该路径就是这个类中所有的方法的父路径了；
// 用在方法上，前端调用该方法的路径就是父路径+方法上的子路径。
//@ResponseBody
@RequestMapping("students")
public class StudentController {
    private static Logger logger = Logger.getLogger (StudentController.class);
    @Resource(name = "beanService")
    private BeanService beanService;
    long timeStamp = System.currentTimeMillis ();  //获取当前时间戳
    //    定义操作失败返回给客户的信息
    public ModelAndView error(int i){
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ("message/error");
        mav.addObject ("error", i);
        return mav;
    }
    //    定义操作成功返回给客户的信息
    public ModelAndView succeed(int i){
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ("message/succeed");
        mav.addObject ("message", i);
        return mav;
    }

    //    更新学员信息
    @RequestMapping( method = RequestMethod.PUT)
    public ModelAndView update(Students students) {
        if (students!=null){
            try {
                students.setUpdateAt (timeStamp);
                boolean rs = beanService.update (students);
                logger.info (rs);
                if (rs){
                  return   succeed (13);
                }
                else {
                  return   error (1);
                }
            }catch ( Exception e ){
                logger.error (e.getMessage ());
                return error (1);
            }
        }else {
            return error (23);
        }}

    //插入学员信息
    @RequestMapping( method = RequestMethod.POST)
    public ModelAndView insert( Students students) {
        if (students!=null) {
            try {
                students.setUpdateAt (timeStamp);
                students.setCreateAt (timeStamp);
                beanService.insertStudents (students);
              return   this.succeed (11);

            } catch ( Exception e ) {
                logger.error (e.getMessage ());
                return   error (1);
            }
        } else {
            return   error (21);
        }
    }

    //删除学员信息
    @ResponseBody
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") long id) {
        if (id>0){
            try {
                logger.info (id);
                boolean rs= beanService.deleteStudents (id);
                logger.info (rs);
                ModelAndView mav = new ModelAndView ();
                mav.setViewName ("delete");
                mav.addObject ("rt", rs);
                return mav;
            }catch ( Exception e ){
                logger.error (e.getMessage ());
                return   error (1);
            }
        }
        else {
            logger.error (id);
            return error (0);
        }
    }


    //通过名字查询学员信息
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findItemsByName(String name)  {
        try {
            ModelAndView mav = new ModelAndView ();
            Students students = new Students ();
            students.setStudentName (name);
            List st = beanService.selectIf (students);
            mav.setViewName ("select");
            mav.addObject ("students", st);
            logger.info (st);
            return mav;
            }catch ( Exception e ){
                logger.error (e.getMessage ());
                return error (1);
            }
    }
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home(String name) throws Exception {
//        System.out.println ("home con start...");
//        return "index";
//    }


}

