package com.task.controller;

/**
 * 不需要登陆就可以进入的页面在此控制器跳转
 */

import com.task.service.ProfessionService;
import com.task.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProfessionService professionService;

    private Logger logger = Logger.getLogger(PublicController.class);

    /**
     * 携带主页需要的数据跳转至主页
     * @return Model中存放从数据库中取出来的数据，view中存放跳转的页面
     * @throws Exception
     */
    @RequestMapping(value = "/homepage")
    public ModelAndView listPage1() throws Exception {
        ModelAndView mav = new ModelAndView();
        //将总学生数查出来放进total中
        mav.addObject("total", studentService.listCount());
        //将在学学生数查出来放进studyCount中
        mav.addObject("studyCount", studentService.listIsStudy());
        //将优秀学员分别查出来放进student中
        mav.addObject("student1", studentService.justListById(3));
        mav.addObject("student2", studentService.justListById(7));
        mav.addObject("student3", studentService.justListById(5));
        mav.addObject("student4", studentService.justListById(6));
        mav.setViewName("page01");
        return mav;
    }



/**
 * 因为此页面没有动态数据，所以直接跳转即可
 */
    @RequestMapping(value = "/recommend")
    public String listPage3() throws Exception {
        return "page03";
    }






}
