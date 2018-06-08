package com.task.controller;

import com.task.service.ProfessionService;
import com.task.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProfessionService professionService;
    private Logger logger=Logger.getLogger(TaskController.class);

    @RequestMapping(value="/homepage")
    public ModelAndView listPage1()throws Exception{
        ModelAndView mav=new ModelAndView();
        //将总学生数查出来放进total中
       mav.addObject("total",studentService.listCount());
       //将在学学生数查出来放进studyCount中
        mav.addObject("studyCount",studentService.listIsStudy());
        //将优秀学员分别查出来放进student中
        mav.addObject("student1",studentService.justListById(3));
        mav.addObject("student2",studentService.justListById(4));
        mav.addObject("student3",studentService.justListById(5));
        mav.addObject("student4",studentService.justListById(6));
        mav.setViewName("page01");
        return mav;
    }

    @RequestMapping(value="/profession")
    public ModelAndView listPage2()throws Exception{
        ModelAndView mav=new ModelAndView();
        //将各个职业查出来放在mav中
        mav.addObject("ios",professionService.justListByName("ios"));
        mav.addObject("android",professionService.justListByName("android"));
        mav.addObject("java",professionService.justListByName("java"));
        mav.addObject("web",professionService.justListByName("web"));
        mav.addObject("pm",professionService.justListByName("pm"));
        mav.addObject("qa",professionService.justListByName("qa"));
        mav.addObject("ui",professionService.justListByName("ui"));
        mav.addObject("css",professionService.justListByName("css"));
        mav.addObject("js",professionService.justListByName("js"));
        mav.addObject("python",professionService.justListByName("python"));
        //将个职业在学人数查出来放在mav中
        mav.addObject("iosCount",studentService.listIsStuByPro("ios"));
        mav.addObject("androidCount",studentService.listIsStuByPro("android"));
        mav.addObject("javaCount",studentService.listIsStuByPro("java"));
        mav.addObject("webCount",studentService.listIsStuByPro("web"));
        mav.addObject("pmCount",studentService.listIsStuByPro("pm"));
        mav.addObject("qaCount",studentService.listIsStuByPro("qa"));
        mav.addObject("uiCount",studentService.listIsStuByPro("ui"));
        mav.addObject("cssCount",studentService.listIsStuByPro("css"));
        mav.addObject("jsCount",studentService.listIsStuByPro("js"));
        mav.addObject("pythonCount",studentService.listIsStuByPro("python"));
        mav.setViewName("page02");
        return mav;
    }

//    @RequestMapping(value="/recommend")
//    public ModelAndView listPage3()throws Exception{
//        ModelAndView mav=new ModelAndView();
//
//        mav.setViewName("page3");
//        return mav;
//    }
      @RequestMapping(value="/recommend")
    public String listPage3()throws Exception{
        return "page03";
    }

}
