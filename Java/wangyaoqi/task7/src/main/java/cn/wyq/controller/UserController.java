package cn.wyq.controller;

import cn.wyq.pojo.User;
import cn.wyq.service.UserService;
import cn.wyq.util.JwtHelper;
import cn.wyq.util.MD5Util;
import cn.wyq.util.SMSUtil;
import cn.wyq.util.SendCloudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    ModelAndView modelAndView = new ModelAndView();
    SMSUtil smsUtil = new SMSUtil();

    @ResponseBody
    @RequestMapping(value = "/user/code/phone",method = RequestMethod.POST,produces = "text/xml;charset=UTF-8")
    public String phoneCode(String telephone){
        Object obj = redisTemplate.opsForValue().get("phonecode");

        if(obj == null){
            String number = String.valueOf(smsUtil.sendMessage(telephone));
            redisTemplate.opsForValue().set("phonecode",number);
            redisTemplate.expire("phonecode",60*5,TimeUnit.SECONDS);
            return "验证码已发送，请在5分钟内输入";
        }

        return "请勿频繁发送";
    }

    @ResponseBody
    @RequestMapping(value = "/user/code/email",method = RequestMethod.POST,produces = "text/xml;charset=UTF-8")
    public String emailCode(String email){
        System.out.println(email);
        Object obj = redisTemplate.opsForValue().get("emailcode");

        if(obj == null){
            try {
                String number = String.valueOf(SendCloudUtil.send_common(email));
                redisTemplate.opsForValue().set("emailcode",number);
                redisTemplate.expire("emailcode",60*5,TimeUnit.SECONDS);
            }catch (IOException e){
                e.printStackTrace();
            }
            return "验证码已发送，请在5分钟内输入";
        }

        return "请勿频繁发送";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String user(){
//        modelAndView.setViewName("user");
        return "user";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView getRegister(){
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register/phone",method = RequestMethod.POST)
    public ModelAndView registerPhone(HttpServletRequest request, HttpServletResponse response, String userName,
                                 String password,String telephone,String code) {

        if(userName == null | password == null | telephone==null){
            modelAndView.addObject("msg","注册信息不能为空");
            return modelAndView;
        }

        if(code == null){
            modelAndView.addObject("msg","请输入验证码");
            return modelAndView;
        }

        User findUn = userService.findUserName(userName);
        User findPhone = userService.findPhone(telephone);
        User findUnAndPhone = userService.findUserNameAndPhone(userName,telephone);

        if(findUnAndPhone != null) {
            if (findUn != null) {
                modelAndView.addObject("msg", "用户名已存在");
                return modelAndView;
            }

            if (findPhone != null) {
                modelAndView.addObject("msg", "手机已被注册");
                return modelAndView;
            }

            modelAndView.addObject("msg","手机和账号未绑定");
            return modelAndView;
        }

        String salt = MD5Util.addSalt();
        String pw = MD5Util.genetate(password,salt);

        if(telephone != null) {
            Object obj = redisTemplate.opsForValue().get("phonecode");
            if(obj == null){
                modelAndView.addObject("msg","验证码错误");
                return modelAndView;
            }

            if(obj.toString().equals(code)){
                User user = new User();
                user.setUserName(userName);
                user.setPassword(pw);
                user.setSalt(salt);
                user.setTelephone(telephone);
                userService.register(user);

                modelAndView.addObject("msg","注册成功");
                modelAndView.setViewName("redirect:/user");
                return modelAndView;
            }

            modelAndView.addObject("msg","验证码错误");
            return modelAndView;
        }

        modelAndView.addObject("msg","注册信息不能为空");
        return modelAndView;
    }

    @RequestMapping(value = "/register/email",method = RequestMethod.POST)
    public ModelAndView registerEmail(HttpServletRequest request, HttpServletResponse response, String userName,
                           String password,String email,String code) {

        if(userName == null | password == null){
            modelAndView.addObject("msg","注册信息不能为空");
            return modelAndView;
        }

        if(code == null){
            modelAndView.addObject("msg","请输入验证码");
            return modelAndView;
        }

        User findUn = userService.findUserName(userName);
        User findEmail = userService.findEmail(email);
        User findUnAndEmail = userService.findUserNameAndEmail(userName,email);

        if(findUnAndEmail != null) {
            if (findUn != null) {
                modelAndView.addObject("msg", "用户名已存在");
                return modelAndView;
            }

            if (findEmail != null) {
                modelAndView.addObject("msg", "邮箱已使用");
                return modelAndView;
            }

            modelAndView.addObject("msg", "邮箱和账户未绑定");
            return modelAndView;
        }

        String salt = MD5Util.addSalt();
        String pw = MD5Util.genetate(password,salt);

        if(email != null) {
            Object obj = redisTemplate.opsForValue().get("emailcode");
            if(obj == null){
                modelAndView.addObject("msg","验证码错误");
                return modelAndView;
            }
            if(obj.toString().equals(code)){
                User user = new User();
                user.setUserName(userName);
                user.setPassword(pw);
                user.setSalt(salt);
                user.setEmail(email);
                userService.register(user);

                modelAndView.addObject("msg","注册成功");
                modelAndView.setViewName("redirect:/user");
                return modelAndView;
            }


            modelAndView.addObject("msg","验证码错误");
            return modelAndView;
        }

        modelAndView.addObject("msg","注册信息不能为空");
        return modelAndView;
    }

    @RequestMapping(value = "/user/phone",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,String userName,String password,String code){
        User uuser = userService.findUserName(userName);

        if(uuser != null ) {
//            System.out.println(code);
            String salt = userService.getSalt(userName).getSalt();
            String pw = MD5Util.genetate(password, salt);
            User quser = userService.login(userName, pw);
            Object obj = redisTemplate.opsForValue().get("phonecode");
            if(obj == null){
                modelAndView.addObject("msg","验证码错误");
                return modelAndView;
            }
//            System.out.println(messageNumber);
//            System.out.println(quser);

            if (quser != null && obj.toString().equals(code)) {
                System.out.println("成功");
                String data = userName + "-" + System.currentTimeMillis();
                String token = JwtHelper.sign(data, 30L * 24L * 3600L * 1000L);
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(24 * 60 * 60);
                cookie.setPath("/u/");
                response.addCookie(cookie);
                HttpSession session = request.getSession();
                session.setAttribute("name",userName);
                session.setAttribute("token", token);
//                String sessionId = session.getId();
                modelAndView.addObject("msg", "登陆成功");
                modelAndView.setViewName("redirect:/u/students");

            } else {
                modelAndView.addObject("msg", "验证码错误");
                modelAndView.setViewName("redirect:/user");
            }

        }else {
            modelAndView.addObject("msg","手机或者账户未注册");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/user/email",method = RequestMethod.POST)
    public ModelAndView emailLogin(HttpServletRequest request, HttpServletResponse response,String userName,String password,String code){
        User uuser = userService.findUserName(userName);

        if(uuser != null ) {
//            System.out.println(code);
            String salt = userService.getSalt(userName).getSalt();
            String pw = MD5Util.genetate(password, salt);
            User quser = userService.login(userName, pw);
            Object obj = redisTemplate.opsForValue().get("emailcode");
            if(obj == null){
                modelAndView.addObject("msg","验证码错误");
                return modelAndView;
            }
//            System.out.println(messageNumber);
//            System.out.println(quser);

            if (quser != null && obj.equals(code)) {
                System.out.println("成功");
                String data = userName + "-" + System.currentTimeMillis();
                String token = JwtHelper.sign(data, 30L * 24L * 3600L * 1000L);
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(24 * 60 * 60);
                cookie.setPath("/u/");
                response.addCookie(cookie);
                HttpSession session = request.getSession();
                session.setAttribute("name",userName);
                session.setAttribute("token", token);
//                String sessionId = session.getId();
                modelAndView.addObject("msg", "登陆成功");
                modelAndView.setViewName("redirect:/u/students");

            } else {
                modelAndView.addObject("msg", "登录失败");
                modelAndView.setViewName("redirect:/user");
            }

        }else {
            modelAndView.addObject("msg","邮箱或者账户未注册");
        }

        return modelAndView;
    }
}
