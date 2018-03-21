package com.student.controller;


import com.aliyuncs.exceptions.ClientException;
import com.student.model.Register;
import com.student.model.Student;
import com.student.service.RegisterService;
import com.student.service.StudentService;
import com.student.util.CookieUtil;
import com.student.util.MD5Util;
import com.student.util.SingleSendMail;
import com.student.util.SmsDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Controller
public class BackendController {
    @Resource
    private StudentService studentService;
    @Resource
    private SmsDemo smsDemo;
    @Resource
    private RegisterService registerService;
    @Resource
    private SingleSendMail sendMail;

    private static final Logger log = LoggerFactory.getLogger(BackendController.class);

    //注册用户界面
    @RequestMapping(value = "/registered", method = RequestMethod.GET)
    public String registered() {
        return "regist";
    }

    //邮箱验证页面
    @RequestMapping(value = "/email/activation", method = RequestMethod.GET)
    public String emailActivation(String email, String name, HttpServletRequest request,HttpSession session) {
        log.info("emailCode:{},name:{}", email, name);
       String code= (String) session.getAttribute("emailCode");
        String account = (String) session.getAttribute("name");
        log.info("code is:{},name is:{}",code,account);
        Student student = studentService.selectByName(account);
        if (student.getName().equals(name) && code.equals(email)) {
            student.setActivated(1);
            studentService.updateByPrimaryKey(student);
            log.info("账号成功激活");
            return "redirect:/loginPage";

        } else {
            log.info("账号激活失败");
            return "failure";
        }

//        return "email";
    }

    //邮箱验证
    @RequestMapping(value = "/email/activation1", method = RequestMethod.GET)
    public String emailActivate() {
        return "nonactivated";

    }


    //注册用户
    @RequestMapping(value = "/registered/u", method = RequestMethod.POST)
    public String regist(String account, String password, String email, String cellphone,
                         String sex, String code, HttpServletResponse response, HttpSession session) {
        //生成盐
        String salt = UUID.randomUUID().toString();
        String passwordMixSalt = MD5Util.mixPasswordWithSalt(password, salt);

        //生成对象
        Student student = new Student();
        student.setSalt(salt);
        student.setCreateAt(System.currentTimeMillis());
        student.setUpdateAt(System.currentTimeMillis());
        student.setPassword(passwordMixSalt);
        student.setName(account);
        student.setEmail(email);
        student.setCellphone(cellphone);
        student.setActivated(2);
        Student exitStudent = studentService.selectByName(account);
        log.info("Student:{},exitStudent：{}", student, exitStudent);

//        查出该手机号最新发送的一条验证码
        Register register = registerService.selectFinalCodeByCellphone(cellphone);
        String finalCode = register.getCode();
        if (code.equals(finalCode) && exitStudent == null) {
            //放入数据库
            studentService.insert(student);
            //邮箱验证
            String emailCode = sendMail.getEmailCode();
            sendMail.sample(email, emailCode, account);
            session.setAttribute("emailCode",emailCode);
            session.setAttribute("name",account);
//            Cookie cookie1 = new Cookie("emailCode", emailCode);
//            Cookie cookie2 = new Cookie("name", account);
//            response.addCookie(cookie1);
//            response.addCookie(cookie2);
            log.info("注册成功,跳转到邮箱激活页面");
            return "redirect:/email/activation1";
        } else {
            return "false";
        }
    }


    //注册成功界面
    @RequestMapping("/registered/success")
    public String registeredSuccess() {
        return "success";
    }


    //    登陆界面
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() {
        log.info("登陆展示页");
        return "login";
    }


    //    登陆
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        RedirectAttributes model, String account, String password) throws Exception {
        Long id = studentService.selectIdByName(account);
        Student student = studentService.selectByPrimaryKey(id);
        String salt = student.getSalt();
        String mixSltPassword = MD5Util.mixPasswordWithSalt(password, salt);
        log.info("账号:{}，密码:{}", account, password);
        if (student.getName().equals(account) && student.getPassword().equals(mixSltPassword) && student.getActivated() == 1) {
            log.info("登陆成功");
            String token = studentService.getTokenByName(account);
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(30 * 60); // 设置为30分钟
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:talent/u";
        } else if (student.getActivated() == 2) {
            log.info("账号没有邮箱验证激活");
            return "redirect:loginPage";
        } else {
            log.info("登陆失败");
            model.addFlashAttribute("error", "密码错误");
            return "redirect:loginPage";
        }
    }


    //注销
    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                cookie.setValue(null);
                cookie.setMaxAge(0); //立即销毁cookie
                cookie.setPath("/");
                response.addCookie(cookie);
                break;
            }
        }
        return "redirect:loginPage";
    }


    @RequestMapping(value = "/fuck", method = RequestMethod.GET)
    public String fuckYou(ModelMap model, HttpServletRequest request) {
        Cookie name = CookieUtil.getCookieByName(request, "token");
        log.info("request:{},name:{}", request, name);

        try {
            String value = CookieUtil.getCookieValueByName(request, "token");
            log.info("request:{},name:{},value,{}", request, name, value);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "fuck";
    }


    //注册短信验证码
    @RequestMapping(value = "/phoneNumber", method = RequestMethod.GET)
    @ResponseBody
    public void smsVerification(String cellphone) {
//        获取该注册手机号在数据库中的个数
        Long cellphoneSize = registerService.selectCellphoneSize(cellphone);

//        List<Register> registerList = registerService.getAllRegister();
//        for (Register register:registerList)
        if (cellphoneSize < 3) {
            String code = SmsDemo.createRandomVcode();
            try {
                smsDemo.sendSms(cellphone, code);
            } catch (ClientException e) {
                e.printStackTrace();
            }
            log.info("注册手机号为：{}，验证码为：{}", cellphone, code);
            Register register = new Register();
            register.setCellphone(cellphone);
            register.setCode(code);
            registerService.insert(register);
        } else {
            log.info("每天只能发送3次验证码谢谢！");
        }

    }
}