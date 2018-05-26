package Task4.controller;


import Task4.pojo.User;
import Task4.service.UserService;
import Task4.unit.CookieUnit;
import Task4.unit.SHA;
import Task4.unit.TokenJWT;
import Task4.unit.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
    Logger logger = Logger.getLogger(UserController.class.getName());

    @RequestMapping("/registered")
    public String toRegistered() {
        System.out.println("aaaaa");
        return ("registered");
    }

    //注册
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ModelAndView regist(User user) {
        System.out.println("注册");
        ModelAndView mav = new ModelAndView();
        String prompt;
        String str = user.getUsername();
        String pas = user.getPassword();
        User user1 = new User();
        //正则匹配
        boolean confirmU = Verification.regexUsername(str);
        boolean confirmP = Verification.regexPassword(pas);
        if (confirmU) {
            try {
                user1 = userService.findByUsername(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (user1 == null) {
        //表示通用唯一标识符(UUID)的类。UUID表示一个128位的值
        UUID uuid = UUID.randomUUID();
        String salt = uuid.toString().substring(10);
                System.out.println("salt"+salt);
        //进行SHA加密
        pas = SHA.getResult(pas);

        user.setSalt(salt);
        //进行salt加密
        pas = SHA.getSHAwithSalt(pas,salt);
        //存入加密后的密码
        user.setPassword(pas);
                System.out.println("密码"+pas);
                userService.regist(user);
                //注册成功后跳转index.jsp页面
                prompt = "注册成功";
            } else {
                prompt = "注册失败,用户名已存在";
                logger.info("注册失败,用户名已存在");
            }
        } else {
            prompt = "注册失败,账号格式不对";
            logger.info("账号格式不对");
        }
        mav.addObject("prompt", prompt);
        mav.setViewName("prompt");
        return mav;
    }

    //登入
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signin(HttpServletResponse response,HttpServletRequest request,@RequestParam String username, @RequestParam String password) {
        User user = null;
        try {
            user = userService.login(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView mav =new ModelAndView();
        String prompt = null;
        String view;
        //获得salt值
        String salt=user.getSalt();
        String pwd = user.getPassword();
//        String sha1 = SHA.getResult(pwd);
        //获得password
        String sha = SHA.getResult(password);
        sha = SHA.getSHAwithSalt(sha,salt);
        System.out.println("sha"+sha);
        if (user != null) {
            if (pwd.equals(sha)) {
                try {
                    String token= TokenJWT.createToken(user);
                    System.out.println("token====="+token);
                    CookieUnit.addLoginCookie(response,"token",token);
                    logger.info(new Date()+"添加Cookie成功");
                } catch (Exception e) {
                    logger.info("生成token失败！");
                    e.printStackTrace();
                }
                view = "redirect:/home";
//                return ("redirect:/home");
            } else {
                logger.info("密码错误");
                prompt = "密码错误";
                view = "prompt";
            }
        } else {
            prompt ="用户名错误";
            logger.info("用户名错误");
            view ="prompt";
        }
        mav.addObject("prompt",prompt);
        mav.setViewName(view);
        return mav;

    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response, HttpServletRequest request){
        ModelAndView mav =new ModelAndView();
        Cookie cookie = CookieUnit.deleteCookieByName(request,"token");
        response.addCookie(cookie);
        System.out.println("登出cookie===="+cookie.getValue());
        mav.setViewName("redirect:/home");
        return mav;
    }

}
