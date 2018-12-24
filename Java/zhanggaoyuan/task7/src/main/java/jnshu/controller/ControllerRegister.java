package jnshu.controller;

import com.alibaba.fastjson.JSON;
import jnshu.model.Profession;
import jnshu.model.RestUser;
import jnshu.model.Student;
import jnshu.service.ProfessionService;
import jnshu.service.StudentService;
import jnshu.tool.GetStatus;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerRegister {
    private static Logger logger = Logger.getLogger (ControllerRegister.class);//引入日志配置
    @Resource
    StudentService studentService;
    @Resource
    ProfessionService professionService;

    long timeStamp = System.currentTimeMillis ();


    //查询优秀学员,返回JSON数据
    @ResponseBody
    @RequestMapping(value = "/homeJSON", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String homeJSON(HttpServletRequest request) {
        List rs = studentService.selectStudent ();
        logger.info (JSON.toJSONString (rs));
        Cookie[] cookies = request.getCookies ();
        logger.info ("cookies的值为：" + JSON.toJSONString (cookies));
        //获取登录状态
        String sds = GetStatus.status (cookies);
        logger.info ("status的值为：" + sds);
        Map ma = new HashMap ();
        ma.put ("student", rs);
        ma.put ("status", sds);
        return JSON.toJSONString (ma);
    }

    //查询优秀学员
    @RequestMapping(value = "/home", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public ModelAndView home(HttpServletRequest request) {
        logger.info ("进入操作");
        List<Student> rs = studentService.selectStudent ();
        logger.info (JSON.toJSONString (rs));
        Cookie[] cookies = request.getCookies ();
        logger.info ("cookies的值为：" + JSON.toJSONString (cookies));

        //获取登录状态
        String sds = GetStatus.status (cookies);
        logger.info ("status的值为：" + sds);

        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("home");
        mv.addObject ("students", rs);
        mv.addObject ("status", sds);
        return mv;
    }

    //    查询职业信息
    @RequestMapping(value = "/u/home11", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public ModelAndView home11(HttpServletRequest request) {
        List<Profession> rs = professionService.selectProfession ();
        logger.info (JSON.toJSONString (rs));
        Cookie[] cookies = request.getCookies ();
        String sds = GetStatus.status (cookies);//获取登录状态
        logger.info ("status的值为：" + sds);
        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("home11");
        mv.addObject ("professions", rs);
        mv.addObject ("status", sds);
        return mv;
    }

    //    跳转到注册页面
    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }

    //    跳转到登录
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    //    登录
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public ModelAndView Login(RestUser restUser, HttpServletResponse response) {
        logger.info (JSON.toJSONString (restUser));
        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("home");
        Boolean bl = studentService.exists (restUser.getName (), restUser.getPwd ());//判断是否存在该角色，密码是否正确
        if (!bl) {
            return mv;
        }// 登录失败返回首页

        Map map = studentService.login (restUser);
        response.addCookie ((Cookie) map.get ("cookie"));
        response.addCookie ((Cookie) map.get ("cookie1"));
        mv.addObject ("status", restUser.getName ());
        return mv;
    }

    //    退出登录
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String Logout(HttpServletResponse response) {
        Cookie cookie = new Cookie ("token", null);
        cookie.setMaxAge (0);
        Cookie cookie1 = new Cookie ("status", null);
        cookie1.setMaxAge (0);
        response.addCookie (cookie);
        response.addCookie (cookie1);
        return "home";
    }

    @RequestMapping(value = "/u/list", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies ();
        logger.info ("cookies的值为：" + JSON.toJSONString (cookies));
        //获取登录状态
        String sds = GetStatus.status (cookies);
        logger.info ("status的值为：" + sds);
        List ls = studentService.selectInfo ();
        logger.info (JSON.toJSONString (ls));
        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("Info");
        mv.addObject ("students", ls);
        mv.addObject ("status", sds);
        return mv;
    }


}
