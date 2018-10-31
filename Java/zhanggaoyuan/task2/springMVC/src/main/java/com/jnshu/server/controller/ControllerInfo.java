package com.jnshu.server.controller;

import com.jnshu.server.po.Students;
import com.jnshu.server.service.BeanService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lxk on 2017/3/27
 */
@Controller
//@RequestMapping 是 Spring Web 应用程序中最常被用到的注解之一。
// 这个注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。
//@RequestMapping用在类上，这时该路径就是这个类中所有的方法的父路径了；
// 用在方法上，前端调用该方法的路径就是父路径+方法上的子路径。
//@ResponseBody
@RequestMapping("info")
public class ControllerInfo {
    private static Logger logger = Logger.getLogger (ControllerInfo.class);
    @Resource(name = "beanService")
    private BeanService beanService;
    long timeStamp = System.currentTimeMillis ();  //获取当前时间戳


    //    跳转到查询结果页面
    @RequestMapping(value = "/paging")
    public ModelAndView paging() {
        List<Students> re = beanService.selectAll ();
        ModelAndView mav=new ModelAndView ();
        mav.setViewName ("info/PagingInfo");
        mav.addObject ("students", re);
        return mav;
    }
//    跳转到更新操作页面
    @RequestMapping(value = "/infoUpdate/{id}",method = RequestMethod.GET)
    public ModelAndView toUpdate(@PathVariable long id) {
        logger.info (id);
        Students student=beanService.selectStudents (id);
        logger.info (student);
        ModelAndView mav=new ModelAndView ();
        mav.setViewName ("update000");
        mav.addObject ("student", student);
        return mav;
    }
//    跳转到新增操作页面
    @RequestMapping(value = "/infoInsert" )
    public ModelAndView toInsert() {
    return new ModelAndView ("insert000");
    }
//    跳转到查询操作页面
    @RequestMapping(value = "/infoSelect")
    public ModelAndView jump4() {
        return new ModelAndView ("select000");
    }
}

