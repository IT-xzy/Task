package com.zyq.controller;

import com.zyq.pojo.ExcellentStudent;
import com.zyq.pojo.Profession;
import com.zyq.service.ExcellentStudentService;
import com.zyq.service.ProfessionService;
import com.zyq.util.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class MyController {

    private static Logger logger = LogManager.getLogger(StudentController.class);

    @Autowired
    private ProfessionService professionService;
    @Autowired
    private ExcellentStudentService excellentStudentService;
    @Autowired
    private RedisUtil redisUtil;
//    跳转首页
    @RequestMapping(value = "/index")
    public String indexView(Model model) {
        logger.info("进入首页（展示优秀学员信息）。。。。。。。。。。。。。。。。。");
        model.addAttribute("item","indexBody");
        List<ExcellentStudent> list;
        if (redisUtil.get("ExcellentStudent")==null){
            logger.info("缓存中没有优秀学员信息，正要去数据库中查询");
            list = excellentStudentService.selectByOrder();
            redisUtil.set("ExcellentStudent",list);
        }else {
            logger.info("缓存中有优秀学员信息，直接读取了");
            list = (List<ExcellentStudent>) redisUtil.get("ExcellentStudent");
        }
        model.addAttribute("list",list);
        return "myView";
    }
//    跳转关于（about）页面
    @RequestMapping(value = "/about")
    public String aboutView(Model model, HttpSession session, HttpServletRequest request) {
        logger.info("进入关于页面。。。。。。。。。。。。。。。。。。。");
        model.addAttribute("item","aboutBody");
        return "myView";
    }
//    跳转职业页面
    @RequestMapping(value = "/profession")
    public String professionView(Model model) {
        logger.info("进入职业信息页面。。。。。。。。。。。。。。。。");
        List<Profession> list;
        if (redisUtil.get("profession")==null){
            logger.info("缓存中没有职业信息，马上到数据库中查询");
            list = professionService.selectAll();
            redisUtil.set("profession",list);
        }else {
            logger.info("缓存中有职业信息，正在获取");
            list = (List<Profession>) redisUtil.get("profession");
        }
        model.addAttribute("item","professionBody");
        model.addAttribute("list",list);
        return "myView";
    }
    @RequestMapping(value = "/login")
    public String Login(Model model){
        logger.info("进入登录页面。。。。。。。。。。。。。。。");
        model.addAttribute("item","loginBody");
        return "myView";
    }
    @RequestMapping(value = "/register")
    public String Register(Model model){
        logger.info("进入注册页面。。。。。。。。。。。。。。。。。。");
        model.addAttribute("item","registerBody");
        return "myView";
    }
}
