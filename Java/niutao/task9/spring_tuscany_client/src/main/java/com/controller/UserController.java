package com.controller;
import com.model.Student;
import com.util.*;
import com.validator.Register;
import com.validator.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    Student student;

    public static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);
    //主页
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(Model model, HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
        boolean islogin = TokenUtil.VerifyToken(httpServletRequest);
        logger.info("用户是否登陆:"+islogin);
        if(islogin){
            logger.info("islogin true");
            model.addAttribute("islogin",true);
            model.addAttribute("message", "已登陆");
        }else {
            model.addAttribute("islogin",false);
            model.addAttribute("message", "请先登陆后再访问网站");
            logger.info("islogin false");
        }
        return "hello";
    }

//    @RequestMapping(value = "/u",method = RequestMethod.GET)
//    public String uhello(Model model) {
//        model.addAttribute("islogin",true);
//        return "hello";
//    }

    @RequestMapping("/u/logout")
    public String ulogout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        Cookie cookie = CookieUtil.getCookieByName(httpServletRequest,"logtime");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
        return "redirect:/";
    }

    //用户信息查看。
    @RequestMapping(value = "/u/home",method = RequestMethod.GET)
    public String uhomeget(HttpServletRequest request, Model model){
        int id =Integer.parseInt(CookieUtil.getId(request));
        Student student = RMI.getService().selectByPrimaryKey(id);
        model.addAttribute("student", student);
        model.addAttribute("url",RMI.getService().geturl()+student.getHeadPicture());
        return "userhome";
    }
    //用户信息更改。
    @RequestMapping(value = "/u/home",method = RequestMethod.POST)
    public String uhomepost( HttpServletRequest request,RedirectAttributes redirectAttributes, @Validated({Update.class}) Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError fieldError:errors){
                redirectAttributes.addFlashAttribute("ERR_"+ fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "redirect:/u/home";
        }
        //TODO 这里不安全，如果用户改了cookie中的id，他就可以修改其他用户信息了。
        //根据cookie中的id，获取用户。
        int id =Integer.parseInt(CookieUtil.getId(request));
        Date day = new Date();
        student.setUpdateTime(day);
        student.setId(id);
        RMI.getService().updateByPrimaryKeySelective(student);
        return "redirect:/";
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerget(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerpost(@Validated({Register.class}) Student student, BindingResult bindingResult, HttpServletRequest request)  {
        //数据校验
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError fieldError:errors){
                request.setAttribute("ERR_"+ fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "register";
        }else {
            logger.debug("注册数据校验成功");
            student.setPassWord(MD5.getMD5(student.getPassWord()));
            Date day = new Date();
            student.setCreateTime(day);
            student.setUpdateTime(day);
            //生成随机4位数的email_code
            //插入数据库。
            String randomCode = RandomNumAndChar.getRandom(5);
            student.setEmailCode(randomCode);
            RMI.getService().insert(student);
            //发送激活邮件给用户
            try {
                RMI.getService().sendEmail(student.getEmail(), student.getUserName(), randomCode);
            } catch (Throwable throwable) {
                logger.error("发送邮件错误");
            }
            return "login";
        }
    }

    //用户名 ajax验证
    @RequestMapping(value = "/existsname",method = RequestMethod.GET)
    public ModelAndView existsname(String name){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        Student student = new Student();
        student = RMI.getService().selectByuserName(name);
        if(student==null){
            mav.addObject("用户名","不存在");
        }else{
            mav.addObject("用户名","存在");
        }
        return mav;
    }


    //使用cookie
    //private String code = null;
    //ajax发验证码给手机
    @RequestMapping("/getcode")
    public ModelAndView getcode(HttpServletResponse httpServletResponse){

        //产生一个随机4位整数,并转为字符串
        double four = Math.random()*9000+1000;
        int intfour = (int) four;
        String stringfour = String.valueOf(intfour);
        //存入cookie
        Cookie cookie = new Cookie("phoneverify",stringfour);
        cookie.setMaxAge(3*60);  //3分钟有效期
        httpServletResponse.addCookie(cookie);
        //存入code，验证用
        //code = stringfour;
        ModelAndView mav = new ModelAndView();
        logger.info("发送手机验证码start");
        //发送短信给手机
        try {
            RMI.getService().sendSMS(stringfour);
        }catch (Exception e){
            logger.error("发送手机验证码失败");
        }
        logger.info("手机验证码发送成功");
        return mav;
    }

    //ajax 手机验证码对比
    @RequestMapping("/verifycode")
    public ModelAndView verifycode(String facecode,HttpServletRequest httpServletRequest) {
        String phoneverify = CookieUtil.getValueByName(httpServletRequest,"phoneverify");
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        //用户填写数据与发送数据对比
        if (facecode.equals("")) {
            mav.addObject("验证码", "不能为空");
        } else {
            if (facecode.equals(phoneverify)) {
                mav.addObject("验证码", "正确");
            } else {
                mav.addObject("验证码", "不正确");
                }
        }
        return mav;
    }

    //登陆
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView logget(String userName,String email_code) {
        ModelAndView mav = new ModelAndView();
        //url中有参数，从邮件过来的链接
        if(userName!=null && email_code != null) {
            //按照用户名查询用户，并对比email_code是否相同。
            Student student = RMI.getService().selectByuserName(userName);
            logger.debug("要激活的账号信息" + student);
            //数据库校验，并改变账号状态。
            if (student.getEmailCode().equals(email_code)) {
                    //如果ok，email_statues改为1，用户可以正常登陆。
                    student.setAcountStatus(1);
                    logger.debug("激活的账号信息" + student);
                    RMI.getService().updateByPrimaryKeySelective(student);
                    mav.addObject("message", "激活成功！可以登陆");
                } else {
                    logger.info("emailcode验证失败");
                    //TODO 激活链接应该有时效。
                    mav.addObject("message", "激活码已过期");
                }
        //url无参数
        }else
            mav.setViewName("login");
            return mav;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String logpost(
                        HttpServletResponse response,
                        @RequestParam("userName") String u,
                        @RequestParam("passWord") String pw,
                        Model model){
            student = RMI.getService().selectByuserName(u);
            logger.debug("用户登陆POST" + student);
            //使用md5加密，然后和数据库中存储的内容对比。
            String md5password = MD5.getMD5(pw);
            //判断账号是否激活
            if (student.getAcountStatus().equals(1)) {
                logger.debug("登陆账号已激活");
                //账号已激活
                if (u.equals(student.getUserName()) && md5password.equals(student.getPassWord())) {
                    //得到系统当前时间，赋值给cookie
                    Date day = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String logtime = sdf.format(day);
                    String id = String.valueOf(student.getId());
                    //使用id+logtime生成tokeng
                    String token = RMI.getService().ProduceToken(id, logtime);
                    //创建cookie
                    Cookie idCookie = new Cookie("id", id);
                    Cookie logTimeCookie = new Cookie("logtime", logtime);
                    logTimeCookie.setPath("/");
                    Cookie tokenCookie = new Cookie("token", token);
                    response.addCookie(idCookie);
                    response.addCookie(logTimeCookie);
                    response.addCookie(tokenCookie);
                    model.addAttribute("message", "已登陆");

                    //超级管理员特权
                    if(u.equals("admin")){
                        return "redirect:/u/select";
                    }
                } else {
                    //账号密码有错误
                    model.addAttribute("message", "账号密码有错误");
                    return "login";
                }
                //账号未激活
            } else {
                logger.debug("登陆账号未激活");
                model.addAttribute("message", "账号未激活，请查看验证邮件");
                //TODO 点击去激活，再次发送激活邮件。
                return "login";
            }
            return "redirect:/";
    }

    //使用title布局的页面，没有填数据。
    @RequestMapping(value = "/home10",method = RequestMethod.GET)
    public String show10() {
        return "home10";
    }
    @RequestMapping(value = "/home11",method = RequestMethod.GET)
    public String show11() {
        return "home11";
    }
}




