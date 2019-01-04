package jnshu.controller;

import com.alibaba.fastjson.JSON;
import jnshu.model.ExcellentStudent;
import jnshu.model.Profession;
import jnshu.model.RestUser;
import jnshu.tool.MD5;
import jnshu.tool.RMI.RMIClient;
import jnshu.tool.RegisterUtis;
import jnshu.tool.TokenUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerRegister {
    private static Logger logger = Logger.getLogger (ControllerRegister.class);//引入日志配置

    long timeStamp = System.currentTimeMillis ();





    //查询优秀学员,返回JSON数据
    @ResponseBody
    @RequestMapping(value = "/homeJSON", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String homeJSON(HttpServletRequest request) {
        RMIClient rmiClient = RMIClient.server ();
        List<ExcellentStudent> rs = rmiClient.getStudentService ().selectStudent ();
        logger.info (JSON.toJSONString (rs));
        Cookie[] cookies = request.getCookies ();
        logger.info ("cookies的值为：" + JSON.toJSONString (cookies));
        //获取登录状态
        String sds = RegisterUtis.status (cookies);
        logger.info ("status的值为：" + sds);
        Map ma = new HashMap ();
        ma.put ("student", rs);
        ma.put ("status", sds);
        return JSON.toJSONString (ma);
    }


    //查询优秀学员
    @RequestMapping(value = "/home", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public ModelAndView home(HttpServletRequest request) {
        RMIClient rmiClient = RMIClient.server ();
        List<ExcellentStudent> rs = rmiClient.getStudentService ().selectStudent ();
        logger.info (JSON.toJSONString (rs));
        Cookie[] cookies = request.getCookies ();
        logger.info ("cookies的值为：" + JSON.toJSONString (cookies));
        //获取登录状态
        String sds = RegisterUtis.status (cookies);
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
        RMIClient rmiClient = RMIClient.server ();
        List<Profession> rs = rmiClient.getProfessionService ().selectProfession ();
        logger.info (JSON.toJSONString (rs));
        Cookie[] cookies = request.getCookies ();
        String sds = RegisterUtis.status (cookies);//获取登录状态
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

    //    注册学员信息
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public ModelAndView Login(RestUser restUser) {
        RMIClient rmiClient = RMIClient.server ();

        restUser.setCreatTime (timeStamp);
        restUser.setUpdateTime (timeStamp);
        logger.info (JSON.toJSONString (restUser));
//        给密码加密
        String salt = MD5.salt ();//生成盐
        String pwd = MD5.encoder (restUser.getPwd (), salt);//得到加密后的密码
        restUser.setPwd (pwd);
        restUser.setSalt (salt);
        logger.info (JSON.toJSONString (restUser));

        int rt = rmiClient.getStudentService ().insertUser (restUser);//把数据存入数据库
        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("/info/register01");
        mv.addObject ("rs", rt);
        return mv;
    }

    //    跳转到登录
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    //    登录    HttpServletRequest request, HttpServletResponse response
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public ModelAndView Login(RestUser restUser, HttpServletRequest request, HttpServletResponse response) {
        RMIClient rmiClient = RMIClient.server ();

        logger.info (JSON.toJSONString (restUser));
        Boolean bl = rmiClient.getStudentService ().exists (restUser.getName (), restUser.getPwd ());//判断是否存在该角色，密码是否正确
        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("home");
//      登录失败返回首页
        if (!bl) {
            return mv;
        }

        Map map=RegisterUtis.takMD5 (rmiClient,restUser );
        response.addCookie ((Cookie) map.get ("cookie"));
        response.addCookie ((Cookie)map.get ("cookie1"));
        mv.addObject ("status", restUser.getName ());
        return mv;
    }

    //    退出登录
    @RequestMapping(value = "/logout ", method = RequestMethod.GET)
    public String Logout(HttpServletRequest request, HttpServletResponse response) {
//        request.getSession ().setAttribute ("status", null);

        Cookie cookie = new Cookie ("token", null);
        cookie.setMaxAge (0);
        Cookie cookie1 = new Cookie ("status", null);
        cookie1.setMaxAge (0);
        response.addCookie (cookie);
        response.addCookie (cookie1);
        return "home";
    }


    @RequestMapping(value = "/u/list ", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        RMIClient rmiClient = RMIClient.server ();
        Cookie[] cookies = request.getCookies ();
        logger.info ("cookies的值为：" + JSON.toJSONString (cookies));
        //获取登录状态
        String sds = RegisterUtis.status (cookies);
        logger.info ("status的值为：" + sds);

        List ls = rmiClient.getStudentService ().selectInfo ();
        logger.info (JSON.toJSONString (ls));
        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("Info");
        mv.addObject ("students", ls);
        mv.addObject ("status", sds);
        return mv;
    }

}
