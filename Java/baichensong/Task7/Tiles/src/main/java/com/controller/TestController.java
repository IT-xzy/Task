package com.controller;

import com.DES.CookieUtil;
import com.DES.DESUtil;
import com.DES.MD5Util;
import com.DES.TokenUtil;
import com.model.Login;
import com.model.Student;
import com.model.zhiwei;
import com.service.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

//任务四 任务五
@Controller
@RequestMapping("")
public class TestController{
@Autowired
    public StudentService service;
    private static Log logger = LogFactory.getLog(TestController.class);
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

    @RequestMapping("/")
    @ResponseBody
    //结业人员 为 outstanding = 1
    public Object home(){
       return service.findAll(1);
    }

    //页面二
    @RequestMapping("homeTwo")

       public ModelAndView homeTwo(){
        ModelAndView mav = new ModelAndView();
        List<zhiwei> zhiye = service.findAlls();
        int name = service.findName();
        mav.addObject("zhiye",zhiye);
        mav.addObject("name",name);
        mav.setViewName("homeTwo");
        return mav;
    }
// 时间转换 拦截
    @RequestMapping("test")
    public ModelAndView test(){
        ModelAndView ma = new ModelAndView();
        List<zhiwei> bb = service.findAlls();
        ma.addObject("bb",bb);
        ma.setViewName("test");
        return ma;
    }
    //前台提交 时间时 测试用的拦截
    @RequestMapping(value = "tijiao",method= RequestMethod.POST)
    public ModelAndView tijiao(zhiwei zhi){
        ModelAndView mv = new ModelAndView();
        service.addlist(zhi);
        System.out.println(zhi);
        mv.setViewName("redirect:test");
        return mv;
    }

    // 登陆拦截
    @RequestMapping("login")
    public String toLoginPage() {
        return "login";
    }

    //登陆成功 跳转页面-------  /相同---      加入 缓存机制
    @RequestMapping("u/userHome")
    public ModelAndView toUserHome(HttpServletRequest request) {
        ModelAndView MAV = new ModelAndView();
        List<Student> by = service.findAll(1);
        logger.info( "能找到吗----"+ by);
        MAV.addObject("by",by);
        MAV.setViewName("home");
        logger.info("username in forward userHome: " + request.getParameter("username"));
        return  MAV;
    }

    // 清除 Cookie
    @RequestMapping("exit")
    public String exitCookie(HttpServletResponse response,HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            logger.info("没有cookie==============");
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
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
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)

    public String doLogin(HttpServletRequest request, HttpServletResponse response) {
      Login lg = service.login(request.getParameter("username"));
        logger.info("用户: " + request.getParameter("username"));
        logger.info("密码: " + request.getParameter("userpass"));

        try { // 判断登陆       校验 数据库MD5 加盐的密码
            if(request.getParameter("username").equals(lg.getUsername()) && MD5Util.verify(request.getParameter("userpass"), lg.getUserpass())) {
                request.getSession().setAttribute("username", lg.getUsername());

                //获取当前时间 并 转换为数字类型 bigint
                Long a = new Date().getTime()/1000;
                //获取前端传来的用户名
                String str  = request.getParameter("username");
                // 把 当前时间由Long转 为String 用于DES加密
                String aa = String.valueOf(a);
                //DES 加密
                String[] s =  DESUtil.tool(str,aa);
                // DES 放入Token中
                String token = TokenUtil.getToken(s[0],s[1]);
                //如果登陆成功  Token放入cookie
                CookieUtil.addCookie(response,"token",token,100*60);
                logger.info("cookie生成成功");

                //登陆时间的写入
                Login l = new Login();
                l.setUsername(request.getParameter("username"));
                l.setLandtime(a);
                service.findTime(l);
                logger.info("登陆时间写入成功");

                // 重定向
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
