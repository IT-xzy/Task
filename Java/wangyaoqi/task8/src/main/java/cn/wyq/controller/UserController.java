package cn.wyq.controller;

import cn.wyq.pojo.User;
import cn.wyq.service.UserService;
import cn.wyq.util.JwtHelper;
import cn.wyq.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String user(){
        return "user";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView getRegister(){
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView registerPhone(HttpServletRequest request, HttpServletResponse response, String userName,
                                      String password) {

        if(userName == null | password == null){
            modelAndView.addObject("msg","注册信息不能为空");
            return modelAndView;
        }

        User findUn = userService.findUserName(userName);
        if (findUn != null) {
            modelAndView.addObject("msg", "用户名已存在");
            return modelAndView;
        }

        String salt = MD5Util.addSalt();
        String pw = MD5Util.genetate(password,salt);

        User user = new User();
        user.setUserName(userName);
        user.setPassword(pw);
        user.setSalt(salt);
        userService.register(user);

        modelAndView.addObject("msg","注册成功");
        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,String userName,String password){
        User uuser = userService.findUserName(userName);

        if(uuser != null ) {
            String salt = userService.getSalt(userName).getSalt();
            String pw = MD5Util.genetate(password, salt);
            User quser = userService.login(userName, pw);

            if (quser != null) {
                String data = userName + "-" + System.currentTimeMillis();
                String token = JwtHelper.sign(data, 30L * 24L * 3600L * 1000L);
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(24 * 60 * 60);
                cookie.setPath("/u/");
                response.addCookie(cookie);
                HttpSession session = request.getSession();
                session.setAttribute("name", userName);
                session.setAttribute("token", token);
//                String sessionId = session.getId();
                modelAndView.setViewName("redirect:/u/students");
            } else {
                modelAndView.addObject("msg", "密码错误");
                modelAndView.setViewName("redirect:/user");
            }
        }
        else {
            modelAndView.addObject("msg","用户名不存在");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/session",method = RequestMethod.DELETE)
    public ModelAndView outlogin(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            cookie.setValue(null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            break;
        }
        modelAndView.setViewName("redirect:user");
        return modelAndView;
    }

}
