package com.fgh.task2.controller;



import com.fgh.task2.Utils.cache.RedisUtils;
import com.fgh.task2.Utils.code.CookieUtil;
import com.fgh.task2.Utils.code.Md5Salt;

import com.fgh.task2.Utils.code.TokenUtil;
import com.fgh.task2.model.LoginUser;
import com.fgh.task2.model.Pro;
import com.fgh.task2.model.Stu;
import com.fgh.task2.service.login.LoginService;
import com.fgh.task2.service.ProService;
import com.fgh.task2.service.StuService;
import com.fgh.task2.tool.ChinaPhone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller

public class LoginController {
    private static Logger logger = LogManager.getLogger(LoginController.class.getName());

    @Autowired
    StuService stuService;
    @Autowired
    ProService proService;
    @Autowired
    LoginService loginService;
    @Autowired
    RedisUtils redisUtils;

    @RequestMapping(path = "/u/home", method = RequestMethod.GET)
    public ModelAndView homeMethod() throws Exception {
        ModelAndView mav = new ModelAndView();
        Integer num = stuService.findWorking();
        Integer allCount = stuService.allCount();
        List <Stu> stus = stuService.findOutstanding();
        mav.addObject("outstanding", stus);
        mav.addObject("working", num);
        mav.addObject("study", allCount);
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping(path = "/profession", method = RequestMethod.GET)
    public ModelAndView proMethod() throws Exception {
        ModelAndView mav = new ModelAndView();
        List <Pro> pros = proService.getListPro();
        mav.addObject("pro", pros);
        mav.setViewName("profession");
        return mav;
    }


    @RequestMapping(path = "/toMsg_register")
    public String registerPage() {
        return "MsgRegister";
    }

    @RequestMapping(path = "/index")
    public String indexPage() {
        return "index";
    }

    /**
     * 注册
     *
     * @param loginUser
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/msg_register", method = RequestMethod.POST)
    public String  registerUser(LoginUser loginUser, Model model,
                                HttpServletRequest request) throws Exception {
        //获取账号与手机验证码
        String name = request.getParameter("name");
        String code = request.getParameter("RandCode");

        //用户名是否存在
        if (loginService.quaryByName(name) != null) {
            logger.debug("用户名已存在，无法注册");
//            String userExist = "用户名已存在";
            model.addAttribute("userExist","用户名已存在");
            return "MsgRegister";
        }

        //用户名格式判断
        if (!ChinaPhone.isPhoneLegal(name)){
            logger.debug("用户名格式不符！");
            model.addAttribute("illegal","用户名不合法");
            return "MsgRegister";
        }

        //验证码处理
        String phoneCode = (String) redisUtils.getkey(name);
        logger.info("phoneCode: "+phoneCode);
        if (phoneCode.equals(code)) {
            String Md5pass = Md5Salt.getEncryptPwd(loginUser.getPassword());
            logger.debug("注册加密后：" + Md5pass);
            loginUser.setMD5Pass(Md5pass);
            Boolean inser = loginService.insertLogin(loginUser);
            logger.debug(inser);
            return "redirect:index";
        }else{
            logger.debug("验证码错误！");
            model.addAttribute("errorCode","验证码错误");
            return "MsgRegister";
        }
    }


    /**
     * 登录
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/index", method = RequestMethod.POST)
    public String index(HttpServletRequest request, RedirectAttributes attributes,
                        HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");
        String passd = request.getParameter("password");
        //cookie 存在时间
        String s_saveTime = request.getParameter("saveTime");
        logger.debug("name：" + name + " password：" + passd);
        logger.debug("s_saveTime:" + s_saveTime);
        //JSP中密码MD5加密
        if (!ChinaPhone.isPhoneLegal(name)) {
            logger.debug("用户名无效，登录失败");
            return "index";
        } else if (loginService.quaryByName(name) != null) {
            //取出DB中Md5
            LoginUser loginUser = loginService.quaryByName(name);
            logger.debug("name: " + loginUser);
            int userid = loginUser.getId();
            logger.debug("id: " + userid);
            String DBMd5Pass = loginUser.getMD5Pass();
            logger.debug("DB中MD5" + DBMd5Pass);
            //验证密码
            Boolean result = Md5Salt.validPassword(passd, DBMd5Pass);
            if (result) {
                logger.debug("登录成功");
                long time = System.currentTimeMillis();
                //生成的token已经DES加密
                String tokenValue = TokenUtil.generateToken(userid, time);
                logger.debug("token: " + tokenValue);
                //将token放入
                int saveTime = Integer.parseInt(s_saveTime);
//                int seconds = saveTime * 24 * 60 * 60;
                Cookie token = CookieUtil.addCookie("token", tokenValue,
                        saveTime, response, request);
                logger.debug("token：" + token);
//                attributes.addFlashAttribute("id",userid);
                return "redirect:/users/";
            }

        } else
            logger.debug("用户名或密码不存在");
        return "index";
    }


    @RequestMapping(path = "/logout")
    public String Logout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.delCookie(response, "token", request);
        return "redirect:/users";
    }
}




