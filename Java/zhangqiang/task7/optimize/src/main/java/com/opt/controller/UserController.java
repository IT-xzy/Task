package com.opt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opt.model.Page;
import com.opt.model.Student;
import com.opt.model.User;
import com.opt.service.impl.ProfessionServiceImpl;
import com.opt.service.impl.StudentServiceImpl;
import com.opt.service.impl.UserServiceImpl;
import com.opt.util.JWTUtil;
import com.opt.util.PhoneFormatCheckUtils;
import com.opt.util.RandomStudent;
import com.opt.util.Sha256Util;
import com.opt.util.thirdparty.SendMailForOSS;
import com.opt.util.thirdparty.SendSMSForRongLian;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {

    private static Logger logger = Logger.getLogger(OptController.class);
    private RandomStudent randomStudent = new RandomStudent();
    private String message = "似乎遇到点问题...";
    private final String TOKENKEY = "zhangqiang";

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
    StudentServiceImpl studentService = (StudentServiceImpl) applicationContext.getBean("studentService");
    UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");


    //登录跳转
    @RequestMapping("/u/login")
    public String tologin(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        return "login";
    }

    //登录
    @RequestMapping(value = "/u/login",method = POST)
    public String login(Model model,User user,HttpServletRequest request, HttpServletResponse response,HttpSession session){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        logger.info("\n登录信息："+user.toString());

        JWTUtil jwtUtil = new JWTUtil(TOKENKEY);
        Sha256Util shaUtil = new Sha256Util();

        if (user!=null){

            User userInfo = userService.findByName(user.getName());

            if (userInfo!=null){
                String shapwd = user.getPwd();
                String salt = userInfo.getSalt();

                if (shaUtil.getSha256(shapwd+salt).equals(userInfo.getPwd())){

                    try {

                        String token = jwtUtil.createToken(user.getName(),7*24*60);//一周
                        Cookie cookie = new Cookie("token",token);
                        cookie.setMaxAge(7*24*60*60);
                        response.addCookie(cookie);

                        String name = user.getName();
                        session.setAttribute("username",name);
                        session.setMaxInactiveInterval(30 * 60);//30分钟

                        message = "登录成功";

                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.info("登录出错");
                    }
                    return "home";
                }else {
                    message = "密码错误或用户名无效！请重新输入！";
                }
            }else {
                message = "用户名错误，找不到此用户！";
            }
        }else {
            message = "无此用户，请重新输入";
        }

        model.addAttribute("message",message);
        return "login";
    }

    //登出
    @RequestMapping(value = "/u/e")
    public String exlogin(Model model, User user, HttpServletRequest request, HttpServletResponse response){
        logger.info("\nDLETE");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        JWTUtil jwtUtil = new JWTUtil(TOKENKEY);
        try {
//            String newToken = jwtUtil.createToken("exit",7*24*60);
            String newToken = jwtUtil.createToken("exit",1);
            Cookie cookie = new Cookie("token",newToken);
            //Cookie cookie = new Cookie("token",null);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.invalidate();

        Page<Student> pages = studentService.findByPage(2,4);
        model.addAttribute("students",pages.getPages());
        return "home";
    }

    //注册跳转
    @RequestMapping("/u/reg")
    public String goReg(){
        return "reg";
    }

    //注册
    @RequestMapping(value = "/u/reg",method = POST)
    public String reg(Model model,HttpServletRequest request){

        logger.info("\n注册 ");


        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPwd(request.getParameter("pwd"));


        //判断手机号是否为数字 转换为long添加 user.phone
        if (request.getParameter("phone") != null && !request.getParameter("phone").equals("") ){

            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");

            if (pattern.matcher(request.getParameter("phone")).matches()){
                logger.info(request.getParameter("phone") + " >>>输入手机号是数字");
                user.setPhone(Long.parseLong(request.getParameter("phone")));
                user.setEmail("");
            }else {
                logger.info(request.getParameter("phone") + " >>>输入手机号不是数字");
                message="手机号输入错误,请输入正确的手机号";
                model.addAttribute("status",2);
                model.addAttribute("message",message);
                return "reg";
            }

        }

        //设置email
        if ( request.getParameter("email") != null){
            user.setEmail(request.getParameter("email"));
            user.setPhone(0);
        }else {
            user.setEmail("");
        }

        logger.info("\nuser：" + user.toString());

        if (user.getName().equals("") && user.getPwd().equals("")){
            logger.info("输入信息不全");
            message="请输入必填项";
            model.addAttribute("status",2);
            model.addAttribute("message",message);
            return "reg";
        }

        HttpSession session = request.getSession();

        //手机为0 使用邮箱注册
        if(user.getPhone()==0){
            if (user.getEmail().equals("")){
                message="注册必须使用邮箱或者手机二选一，请填入手机或者邮箱！";
                model.addAttribute("status",2);
                model.addAttribute("message",message);
                return "reg";
            }
            String mailCodeBack = request.getParameter("code_emil");
            String mailCode = String.valueOf(session.getAttribute("mailCode"));

            if(user.getEmail().equals("") && mailCodeBack.equals("")){
                message="请输入邮箱和验证码";
                model.addAttribute("status",2);
                model.addAttribute("message",message);
                return "reg";
            }else {

                logger.info("mailCodeBack:"+mailCodeBack+"mailCode"+mailCode);
                if(!mailCodeBack.equals(mailCode)){
                    logger.info("邮箱验证码不匹配");
                    message="邮箱验证码不匹配";
                    model.addAttribute("status",2);
                    model.addAttribute("message",message);
                    return "reg";
                }
            }

        }

//        String isok = (String) request.getParameter("codeIsOk");
//        logger.info("是否验证"+isok);
//        if (!isok.equals("true")){
//            message = "请先验证手机！";
//            model.addAttribute("status",2);
//            model.addAttribute("message",message);
//            return "reg";
//        }

        //邮箱为空 使用手机注册
        if( user.getEmail().equals("")){
            if (user.getPhone()==0){
                message="注册必须使用邮箱或者手机二选一！";
                model.addAttribute("status",2);
                model.addAttribute("message",message);
                return "reg";
            }
            String smsCodeBack = request.getParameter("code_sms");
            String smsCode = String.valueOf(session.getAttribute("smsCode"));

            if(user.getPhone()==0 && smsCodeBack.equals("")){
                message="请输入手机号和验证码";
                model.addAttribute("status",2);
                model.addAttribute("message",message);
                return "reg";
            }else {
                logger.info("smsCodeBack:"+smsCodeBack+"smsCode"+smsCode);
                if(!smsCodeBack.equals(smsCode)){
                    logger.info("手机验证码不匹配");
                    message="手机验证码不匹配";
                    model.addAttribute("status",2);
                    model.addAttribute("message",message);
                    return "reg";
                }
            }

        }

        long date = System.currentTimeMillis();
        long sendTime = (long) session.getAttribute("sendTime");
        long Exp = sendTime-date;
        long ExpMin = Long.parseLong( String.valueOf(session.getAttribute("ExpMin")));

        if(Exp/(1000 * 60)>ExpMin){
            logger.info(Exp/(1000 * 60)>ExpMin);
            logger.info("验证码已超时");
            message="验证码已超时";
            model.addAttribute("status",2);
            model.addAttribute("message",message);
            return "reg";
        }

        Sha256Util sha256Util = new Sha256Util();
        String name = user.getName();
        String pwd = user.getPwd();
        User user1 = userService.findByName(name);

        logger.info("\n注册 查询到表内信息："+user1);

        logger.info(user1);
        if(user1!=null){
            message = "已有用户名！请重输！";
        }else {
            logger.info("\n未查詢到信息，開始注冊");
            String salt = sha256Util.getSalt();
            user.setSalt(salt);
            String pwda = sha256Util.getSha256(pwd+salt);
            user.setPwd(pwda);
            userService.insertOne(user);
            message = "注册成功，请登录";
            logger.info("注册成功");
            model.addAttribute("status",1);
            model.addAttribute("message",message);
            return "login";
        }
        model.addAttribute("message",message);
        return "reg";
    }

    //    验证手机号 发送验证码
    @ResponseBody
    @RequestMapping(value = "/u/smsCode",method = GET)
    public Map SendSMSCode(@RequestParam("mobile")String phone, HttpServletResponse response, HttpServletRequest request){

        Map<String,Object> map = new HashMap();
        map.put("key1","value1");

        logger.info("\n注册手机号：" + phone);
//        int tel = Integer.parseInt(phone);

//        验证是否为空 是否为手机号
        if(phone!=null && PhoneFormatCheckUtils.isChinaPhoneLegal(phone)){
            long iphone = Long.parseLong(phone);
            //是否已被注册
            if (userService.findByPhone(iphone)!=null){
                logger.info("手机验证失败，已被注册");
                map.put("status",2);
                map.put("message","此手机已注册，请登录或者更换注册手机号");
                return map;
            }else {
                logger.info("手机验证成功，开始发送验证码");
                //失效时间
                String min = "3";
                //验证码
                int codeNum = (int)((Math.random()*3+1)*999);

                map.put("smsCode",codeNum);

                //"验证码"，"分钟数"
                String[] smsInfo = new String[]{String.valueOf(codeNum),min};

                //发送验证码
                HashMap<String, Object> result = SendSMSForRongLian.sendTemplateSMS(phone,"1",smsInfo);

                //验证
                if ("000000".equals(result.get("statusCode"))){

                    HttpSession session = request.getSession();

                    session.setAttribute("smsCode",codeNum);

                    //发送短信时间
                    long sendTime =System.currentTimeMillis();
                    session.setAttribute("sendTime",sendTime);
                    session.setAttribute("ExpMin",min);

                    /*定时任务 超时3分钟删除
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            session.removeAttribute("smsCode");
                            timer.cancel();
                        }
                    },Integer.parseInt(min)*60*1000);
                    */

                    map.put("statusMsg",result.get("statusMsg"));
                    map.put("statusCode",result.get("statusCode"));

                    logger.info("发送验证码:"+codeNum);
                    map.put("status",1);
                    map.put("message","验证码已发送，有效时间"+min+"分钟");

                }else {
                    map.put("status",2);
                    map.put("message","验证码发送失败，"+result.get("statusMsg"));
                    logger.info("发送错误，错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
                }

            }

        }else {
            map.put("status",2);
            map.put("message","空号或非手机号");
        }
        return map;
    }

    //手机验证码验证 已取消逻辑 放入注册
    /*@ResponseBody
    @RequestMapping(value = "/s/smsisok")
    public Map codeIsOK(HttpSession session,HttpServletRequest request,HashMap map){
        String smsCode = request.getParameter("smsIsCode");
        String smsSend = (String) session.getAttribute("smsCode");
        logger.info(smsCode+":"+smsSend);
        if (smsCode.equals(smsSend)){
            map.put("status",1);
            map.put("message","手机验证成功");
        }else {
            map.put("status",2);
            map.put("message","验证码错误");
        }
        return map;
    }*/


    //    验证邮箱 发送验证码
    @ResponseBody
    @RequestMapping(value = "/u/emailCode",method = GET)
    public Map SendEmailCode(@RequestParam("email")String email,HttpServletRequest request){
        Map map = new HashMap();
        logger.info("\n注册邮箱：" + email);

        if (email.equals("")){
            map.put("status",2);
            map.put("message","请输入邮箱！");
            logger.info("\n请输入邮箱！");
            return map;
        }

        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern p = Pattern.compile(RULE_EMAIL);
        Matcher m = p.matcher(email);

        if (!m.matches()){
            map.put("status",2);
            map.put("message","请输入正确的邮箱！");
            logger.info("\n请输入正确的邮箱！");
            return map;
        }
        logger.info(userService.findByEmail(email));

        if (userService.findByEmail(email)!=null){

            map.put("status",2);
            map.put("message","此邮箱已注册，请使用邮箱登录或者更换邮箱");
            logger.info("\n此邮箱已注册，请使用邮箱登录或者更换邮箱");
            return map;
        }else {
            logger.info("邮箱验证成功，发送验证码");

            //失效时间
            String min = "3";
            //验证码
            int codeNum = (int)((Math.random()*3+1)*999);

            map.put("mailCode",codeNum);

            //"验证码"，"分钟数"
            String[] smsInfo = new String[]{String.valueOf(codeNum),min};

            String html = "验证码："+codeNum;

            //发送邮件
            JSON o = SendMailForOSS.send_common(email,"注册验证",html);

            JSONObject result = (JSONObject) o;

//            logger.info(request.toString());
//            logger.info("error"+request.getParameter("error"));

            if (request.getParameter("error")==null){

                HttpSession session = request.getSession();

                session.setAttribute("mailCode",codeNum);

                //发送短信时间
                long sendTime =System.currentTimeMillis();
                session.setAttribute("sendTime",sendTime);
                session.setAttribute("ExpMin",min);

                map.put("statusMsg",result.get("message"));
                logger.info("发送验证码:"+codeNum);
                map.put("status",1);
                map.put("message","验证码已发送，有效时间"+min+"分钟");

            }else {

                map.put("statusMsg",result.get("message"));

                map.put("status",2);
                map.put("message","验证码发送失败，错误信息："+result.get("message"));
            }

        }
        return map;
    }



}
