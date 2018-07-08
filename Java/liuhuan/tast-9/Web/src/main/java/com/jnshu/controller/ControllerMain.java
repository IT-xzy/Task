package com.jnshu.controller;

import com.jnshu.model.*;
import com.jnshu.service.*;
import com.jnshu.tools.*;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * @program: smsdemo
 * @description: 非权限页面
 * @author: Mr.xweiba
 * @create: 2018-05-29 20:54
 **/
@Controller
public class ControllerMain {
    private static Logger logger = LoggerFactory.getLogger(ControllerMain.class);
    // 项目路径
    private static String projectpath = null;

    @Qualifier("serverDao")
    @Autowired
    private ServiceDao serviceDao;

    @Qualifier("serverCachedMem")
    @Autowired
    private ServiceCache serviceCache;

    @Qualifier("serverSMSRLian")
    @Autowired
    private ServiceSMS serviceSMS;

    @Qualifier("serverQiNiuYunOSS")
    @Autowired
    private ServiceOSS serviceOSS;

    @Qualifier("calculatorRMIServer")
    @Autowired
    private CalculatorInterface calculatorInterface;

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    @ResponseBody
    public String calculator(){
        double test = calculatorInterface.sub(3,5);
        return String.valueOf(test);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, StudentQV studentQV) throws Exception {
        StudentCustom studentCustom = new StudentCustom();
        studentCustom.setIsSuper(1);
        studentQV.setStudentCustom(studentCustom);
        model.addAttribute("studentCount", serviceDao.countStudent());
        model.addAttribute("countWorkStundet", serviceDao.countWorkStundet());
        model.addAttribute("superStudent", serviceDao.findListStudent(studentQV));
        return "home";
    }

    @RequestMapping(value = "/profession", method = RequestMethod.GET)
    public String profession(Model model) throws Exception {
        List<Profession> professionList = serviceDao.findByListProfession();
        model.addAttribute("professionList", professionList);
        return "profession";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validate(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, UserAuth userAuth, String code) throws Exception {
        // 获取项目路径
        this.projectpath = httpServletRequest.getContextPath();
        logger.debug("code: " + code);
        // 判断短信 code 线上测试才注释的
        /*if(serviceCache.getKey(code + httpServletRequest.getSession().getId())==null){
            logger.debug("code 验证失败");
            return "redirect:/admin/login";
        }*/
        String passWordMd5 = MD5Util.stringToMD5(userAuth.getAu_password());
        userAuth.setAu_password(passWordMd5);
        Integer userId = serviceDao.userAuth(userAuth);
        logger.debug("userId" + userId);
        if (userId != null) {
            logger.debug("验证通过");
            // token
            String token = userId + "=" + System.currentTimeMillis();
            // key
            String key = "liuhuan1";

            byte[] bytes = DESUtil.encrypt(token, key);
            Cookie cookie = new Cookie("token", Base64.encodeBase64String(bytes));
            cookie.setMaxAge(60 * 60 * 24 * 7);

            logger.debug(projectpath);
            // 上线以后cookie的生效范围为/, 但tomcat运行是带项目名的. 所以直接写/是有问题的. 这里取得项目路径再设置, 该token只再本项目生效
            cookie.setPath(projectpath);

            logger.debug("登陆时token Cookie路径: " + cookie.getPath());
            // 将用户信息保存在Cookie中
            Cookie cookie1 = new Cookie("username", URLEncoder.encode(userAuth.getAu_username(), "UTF-8"));
            cookie1.setMaxAge(60 * 60 * 24 * 7);
            cookie1.setPath(projectpath);
            httpServletResponse.addCookie(cookie);
            httpServletResponse.addCookie(cookie1);

            // 将Session保存到缓存中
            serviceCache.setDefault(httpServletRequest.getSession().getId(), "session_id");
            return "redirect:/admin/students";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        /*Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if(c.getName().equals("token")){
                    c.setMaxAge(0);
                    c.setPath(httpServletRequest.getContextPath());
                    logger.debug("退出时token Cookie路径: " + c.getPath());
                    httpServletResponse.addCookie(c);
                }
            }
        }*/

        // logger.debug("全局项目路径: " + projectpath);
        // // 新建一个Cookie覆盖掉原来的Token 省去查找Cookie的开销
        Cookie cleanCookie = new Cookie("token", null);
        cleanCookie.setPath(projectpath);
        cleanCookie.setMaxAge(0);
        httpServletResponse.addCookie(cleanCookie);

        // 删除Session 缓存
        serviceCache.delete(httpServletRequest.getSession().getId());
        // 删除session
        httpServletRequest.getSession().invalidate();
        return "redirect:/";
    }

    // 短信验证
    @RequestMapping(value = "/SMS", method = RequestMethod.POST)
    @ResponseBody
    public Boolean SMS(String telePhone, HttpServletRequest httpServletRequest){
        boolean flag = false;
        // 判断是否在60秒内发送过短信
        if(serviceCache.getKey(telePhone)==null){
            String Session = httpServletRequest.getSession().getId();
            flag = serviceSMS.sendSMS(telePhone, Session);
            if (flag){
                // 短信发送成功设置60秒缓存
                serviceCache.setDate(telePhone, "ver", new Date(1000*60));
            }
        }
        return flag;
    }

    // 效验 效验邮箱不需要登陆验证
    @RequestMapping(value = "/verifyMail/{verifyCode}", method = RequestMethod.GET)
    public String verifyCode(@PathVariable(value = "verifyCode") String verifyCode, Model model){
        StudentCustom studentCustom = (StudentCustom) serviceCache.getKey(verifyCode);
        if (studentCustom != null ){
            logger.debug("studentCustom 邮箱验证:" + studentCustom.toString());
            // 该验证码请求只要被接收到就失效
            serviceCache.delete(verifyCode);
            // 改变邮箱状态
            studentCustom.setStuMailState(1);
            try {
                // 存入数据库 判断是否存入成功
                if(serviceDao.updateEmail(studentCustom)){
                    model.addAttribute("message", "验证成功");
                    return "message";
                }
            } catch (Exception e) {
                model.addAttribute("message", "写入数据库失败");
                e.printStackTrace();
            }
        }
        model.addAttribute("message", "验证码无效");
        return "message";
    }

    // OSS文件迁移
    @RequestMapping(value = "/fileRemoval", method = RequestMethod.GET)
    @ResponseBody
    public Boolean test(){
        return serviceOSS.fileRemoval("image", "http://p9kpdscob.bkt.clouddn.com/");
    }
}