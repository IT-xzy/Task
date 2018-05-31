package com.task.controller;

import com.task.service.ProfessionService;
import com.task.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/u")//此controller都带前缀/u，进入之前会被拦截器拦截
public class PrivateController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProfessionService professionService;

    private Logger logger = Logger.getLogger(PublicController.class);

    /**
     * 携带动态数据跳转至职业页面
     * @return Model中存放各职业信息，view中存放跳转的页面
     * @throws Exception
     */
    @RequestMapping(value = "/profession")
    public ModelAndView listPage2() throws Exception {
        ModelAndView mav = new ModelAndView();
        //将各个职业查出来放在mav中
        mav.addObject("ios", professionService.justListByName("ios"));
        mav.addObject("android", professionService.justListByName("android"));
        mav.addObject("java", professionService.justListByName("java"));
        mav.addObject("web", professionService.justListByName("web"));
        mav.addObject("pm", professionService.justListByName("pm"));
        mav.addObject("qa", professionService.justListByName("qa"));
        mav.addObject("ui", professionService.justListByName("ui"));
        mav.addObject("css", professionService.justListByName("css"));
        mav.addObject("js", professionService.justListByName("js"));
        mav.addObject("python", professionService.justListByName("python"));
        //将个职业在学人数查出来放在mav中
        mav.addObject("iosCount", studentService.listIsStuByPro("ios"));
        mav.addObject("androidCount", studentService.listIsStuByPro("android"));
        mav.addObject("javaCount", studentService.listIsStuByPro("java"));
        mav.addObject("webCount", studentService.listIsStuByPro("web"));
        mav.addObject("pmCount", studentService.listIsStuByPro("pm"));
        mav.addObject("qaCount", studentService.listIsStuByPro("qa"));
        mav.addObject("uiCount", studentService.listIsStuByPro("ui"));
        mav.addObject("cssCount", studentService.listIsStuByPro("css"));
        mav.addObject("jsCount", studentService.listIsStuByPro("js"));
        mav.addObject("pythonCount", studentService.listIsStuByPro("python"));
        mav.setViewName("page02");
        return mav;
    }
}
