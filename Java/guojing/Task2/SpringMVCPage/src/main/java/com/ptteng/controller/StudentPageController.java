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

import java.util.List;

@Controller
public class StudentPageController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CheckStudent checkStudent;

//定义一个第一页（也可以不用直接找到第一页即可）
    @RequestMapping(value="/page",method = RequestMethod.GET)
    public ModelAndView firstPage(  ModelAndView modelAndView){
        List<Student> students=checkStudent.findPageStudent(1);
        long allPage=checkStudent.findAllPage();
        modelAndView.addObject("allPage",allPage);
        modelAndView.addObject("students",students);
        modelAndView.addObject("page",1);
        modelAndView.setViewName("pageStudent");
        return modelAndView;
    }

//    跳转找到某个页的数据
    @RequestMapping(value="/pageStudent",method = RequestMethod.GET)
    public ModelAndView page(long page,ModelAndView modelAndView){
        System.out.println("最后一页"+page);  //测试最后一页数
        long allPage=checkStudent.findAllPage();
        if(page<1){page=1;}
        else{
            if(page>allPage){page=allPage;}
        }       //这个循环是在输入页数超出范围时，回到第一页或者是最后一页

       List<Student> students=checkStudent.findPageStudent(page);   //根据页数找到这页数据
       modelAndView.addObject("allPage",allPage);     //将所有页数加载到页面
       modelAndView.addObject("students",students);   //数据存入model加载到页面
       modelAndView.addObject("page",page);           //将页数加载到页面
       modelAndView.setViewName("pageStudent");                     //到页面
        return modelAndView;
    }
//  上一页数据
    @RequestMapping(value = "/lastPage/{page}",method = RequestMethod.GET)
    public ModelAndView lastPage(@PathVariable("page") long page,ModelAndView modelAndView){
        System.out.println(page);
        if(page==1){page=2;}  //防止第一页的上一页报错
        List<Student> students=checkStudent.findPageStudent(page-1);
        modelAndView.addObject("allPage",checkStudent.findAllPage());
        modelAndView.addObject("students",students);
        modelAndView.addObject("page",(page-1));
        modelAndView.setViewName("pageStudent");
        return modelAndView;
    }

//   下一页数据
    @RequestMapping(value = "/nextPage/{page}",method = RequestMethod.GET)
    public ModelAndView nextPage(@PathVariable("page") long page,ModelAndView modelAndView){
        System.out.println(page);
        if(page==checkStudent.findAllPage()){page=checkStudent.findAllPage()-1;}  //防止最后一页下一页报错
        List<Student> students=checkStudent.findPageStudent(page+1);
        modelAndView.addObject("allPage",checkStudent.findAllPage());
        modelAndView.addObject("students",students);
        modelAndView.addObject("page",(page+1));
        modelAndView.setViewName("pageStudent");
        return modelAndView;
    }


//  尾页
    @RequestMapping(value="/pageStudent/{allPage}",method = RequestMethod.GET)
    public ModelAndView pageOne(@PathVariable("allPage") long allPage,ModelAndView modelAndView){
        System.out.println("最后一页"+allPage);  //测试最后一页数
        List<Student> students=checkStudent.findPageStudent(allPage);   //根据页数找到这页数据
        modelAndView.addObject("allPage",allPage);     //将所有页数加载到页面
        modelAndView.addObject("students",students);   //数据存入model加载到页面
        modelAndView.addObject("page",allPage);           //将页数加载到页面
        modelAndView.setViewName("pageStudent");                     //到页面
        return modelAndView;
    }



}
