package com.jnshu.controller;

import com.jnshu.modle.*;
import com.jnshu.service.ServiceManage;
import com.jnshu.tools.DESUtil;
import com.jnshu.tools.MD5Util;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: SSM_Tiles
 * @description: Controller层
 * @author: Mr.xweiba
 * @create: 2018-05-11 00:04
 **/
@Controller
public class ControllerMain {
    @Autowired
    ServiceManage serviceManage;

    private static Logger logger = LoggerFactory.getLogger(ControllerMain.class);
    private StudentQV studentQV = new StudentQV();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(Model model) {
        // 获取学员统计信息
        StudentStatistics studentStatistics = serviceManage.countStudent();
        // 获取学员信息
        List<StundetCustom> studentList = serviceManage.findListStudent();
        logger.info(studentList.toString());
        logger.info(studentStatistics.toString());
        studentQV.setStudentStatistics(studentStatistics);
        studentQV.setStudentList(studentList);
        model.addAttribute("studentQV", studentQV);
        return "home";
    }

    @RequestMapping(value = "/u/profession", method = RequestMethod.GET)
    public String home(Model model) {
        // 获取职业信息
        List<Profession> professionList = serviceManage.findByListProfession();
        System.out.println(professionList.toString());
        studentQV.setProfession(professionList);
        model.addAttribute("studentQV", studentQV);
        return "profession";
    }

    // 跳转到登陆页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    // 账号密码验证
    @RequestMapping(value = "/login/validate", method = RequestMethod.POST)
    public void valiDate(UserAuth userAuth,
                         HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        logger.info("加密前登陆的信息: " + userAuth.toString());
        // 将密码通过md5加密
        String passwordMd5 = MD5Util.stringToMD5(userAuth.getAu_password());
        userAuth.setAu_password(passwordMd5);
        logger.info("登陆加密后的信息:" + userAuth.toString());
        logger.info("登陆验证: " + String.valueOf(serviceManage.userAuth(userAuth)));
        // 判断账号密码是否正确 正确设置session
        if(serviceManage.userAuth(userAuth)){
            logger.info("登陆成功");
            UserAuth userAuth1 = serviceManage.findUserAuthByName(userAuth.getAu_username());
            logger.info(userAuth1.toString());
            Long id = userAuth1.getId();
            // 使用系统当前时间生成唯一token, 格式为键值对
            String token = id + "=" + System.currentTimeMillis();
            // 加密jey 必须8位
            String key = "liuhuan1";

            // 加密
            byte[] bytes = DESUtil.encrypt(token,key);
            logger.info("加密后的token: " + DESUtil.toHexString(bytes).toUpperCase());
            logger.info("加密后的Base64 token: " + Base64.encodeBase64String(bytes));
            // 保存到 Cookie 中
            // 使用 Base64.encodeBase64String(bytes)) 报错 RFC6265 Cookie values may not contain control characters . 原因: import org.apache.commons.net.util.Base64 生成的Base64带换行符, 会导致报错 更换为 org.apache.commons.codec.binary.Base64;
            Cookie cookie = new Cookie("token", Base64.encodeBase64String(bytes));
            // Cookie cookie = new Cookie("tonken", key);
            // 设置 Cookie 过期时间 单位为秒
            cookie.setMaxAge(7000);
            // 设置 Cookie 有效路径
            cookie.setPath("/");

            logger.info("新生成的Cookie-效时间-值: " + cookie.getName() + "-->" + cookie.getMaxAge() + "-->" + cookie.getValue() + cookie.getPath());

            httpServletResponse.addCookie(cookie);
            // 注意 Cookie 跨域的问题!!!!!!!!!!! sendRedirect后跨域的Cookie是不会保存的
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/u/profession");
        }else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
        }
    }
}
