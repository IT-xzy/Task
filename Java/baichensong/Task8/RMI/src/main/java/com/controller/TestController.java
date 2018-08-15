package com.controller;

import com.tools.CookieTool;
import com.tools.DESTool;
import com.tools.MD5Tool;
import com.tools.TokenTool;
import com.model.Login;
import com.model.Student;
import com.model.zhiwei;
import com.service.StudentService;
import org.ApplicationAll;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 * @author baich
 *  任务四 任务五
 */
@Controller
@RequestMapping("")
public class TestController {
/**
    //    @Autowired
    //    public StudentService service;

    //    ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext-client.xml");
    //    StudentService service = (StudentService) application.getBean("client");
*/
    ApplicationAll applicationAll = new ApplicationAll();
    private static Log logger = LogFactory.getLog(TestController.class);
 /*
    *----------注释掉  转换成了 json---
    //页面一
    //    @RequestMapping("/")
    //
    //    public ModelAndView home(){
    //        ModelAndView MAV = new ModelAndView();
    //        List<Student> by = service.findAll();
    //     logger.info( "能找到吗----"+ by);
    //        MAV.addObject("by",by);
    //        MAV.setViewName("home");
    //
    //    return MAV;
    //    }
*/
    @RequestMapping("/")

    @ResponseBody
    public Object home() {
        /* ----------结业人员 为 outstanding = 1----------------*/
        return applicationAll.service().findAll(1);
    }

    /*------页面二*/
    @RequestMapping("homeTwo")

    public ModelAndView homeTwo() {
        ModelAndView mav = new ModelAndView();
        List<zhiwei> zhiye = applicationAll.service().findAlls();
        int name = applicationAll.service().findName();
        mav.addObject("zhiye", zhiye);
        mav.addObject("name", name);
        mav.setViewName("homeTwo");
        return mav;
    }

    /**-------- 时间转换 拦截*/
    @RequestMapping("test")
    public ModelAndView test() {
        ModelAndView ma = new ModelAndView();
        List<zhiwei> bb = applicationAll.service().findAlls();
        ma.addObject("bb", bb);
        ma.setViewName("test");
        return ma;
    }

    /**--------前台提交 时间时 测试用的拦截*/
    @RequestMapping(value = "tijiao", method = RequestMethod.POST)
    public ModelAndView tijiao(zhiwei zhi) {
        ModelAndView mv = new ModelAndView();
        applicationAll.service().addlist(zhi);
        System.out.println(zhi);
        mv.setViewName("redirect:test");
        return mv;
    }

    /**--- 登陆拦截*/
    @RequestMapping("login")
    public String toLoginPage() {
        return "login";
    }

    /**------登陆成功 跳转页面-------  /相同---      加入 缓存机制*/
    @RequestMapping("u/userHome")
    public ModelAndView toUserHome(HttpServletRequest request) {
        ModelAndView MAV = new ModelAndView();
        List<Student> by = applicationAll.service().findAll(1);
        logger.info("能找到吗----" + by);
        MAV.addObject("by", by);
        MAV.setViewName("home");
        logger.info("username in forward userHome: " + request.getParameter("username"));
        return MAV;
    }

    /** 清除 Cookie*/
    @RequestMapping("exit")
    public String exitCookie(HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            logger.info("没有cookie==============");
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    cookie.setValue(null);
                    /* 立即销毁cookie */
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    logger.info("被删除的cookie名字为:" + cookie.getName());
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        return "redirect:/login";
    }


    //提交判断 判断登陆并生成cookie和登陆时间
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)

    public String doLogin(HttpServletRequest request, HttpServletResponse response) throws RemoteException {
        Login lg = applicationAll.service().login(request.getParameter("username"));
        logger.info("用户: " + request.getParameter("username"));
        logger.info("密码: " + request.getParameter("userpass"));

        try { /* 判断登陆       校验 数据库MD5 加盐的密码*/
            if (request.getParameter("username").equals(lg.getUsername()) && MD5Tool.verify(request.getParameter("userpass"), lg.getUserpass())) {
                request.getSession().setAttribute("username", lg.getUsername());

                /*---获取当前时间 并 转换为数字类型 bigint---*/
                Long a = System.currentTimeMillis()/ 1000;
                /*获取前端传来的用户名*/
                String str = request.getParameter("username");
                logger.info("能拿到用户名吗"+str);
                /* 把 当前时间由Long转 为String 用于DES加密*/
                String aa = String.valueOf(a);
                /*tools 加密*/
                String[] s = DESTool.tool(str, aa);
                /* tools 放入Token中*/
                String token = TokenTool.getToken(s[0], s[1]);
                /*如果登陆成功  Token放入cookie*/
                CookieTool.addCookie(response, "token", token, 100 * 60);
                logger.info("cookie生成成功");

                /*登陆时间的写入*/
                Login l = new Login();
                l.setUsername(request.getParameter("username"));
                l.setLandtime(a);
                applicationAll.service().findTime(l);
                logger.info("登陆时间写入成功");

                /* 重定向*/
                return "redirect:/u/userHome";
            } else {
                logger.info("没登录上");
                return "/login";
            }
        } catch (Exception e) {
            return "/login";
        }
    }


}
