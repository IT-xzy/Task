package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.User;
import service.UserService;
import utils.EncryUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/task5/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String insert(Model model, @Valid User user, BindingResult bindingResult,HttpServletRequest request) {
        //获取校验错误信息
        if(bindingResult.hasErrors()){
            //输出错误信息
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError fieldError : errors){
                request.setAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }

            return "task5/register";
        }

        if (userService.nameTest(user.getName())) {
            userService.insertUser(user);
            return "home.page";
        } else return "redirect:/register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login1() {
        return "/task5/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("User") User user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (!userService.nameTest(user.getName())) {
            if (userService.passwordTest(user)) {
                //登录成功
                Long updateTime = System.currentTimeMillis() ;
                String tk = updateTime +","+ user.getName();
                String token = EncryUtil.encrypt(tk);
                Cookie cookie = new Cookie("Token", token);
                //设置cookie的生命周期单位为秒
                cookie.setMaxAge(60 * 60 * 2);
                //将指定的cookie加入到响应中
                httpServletResponse.addCookie(cookie);
                return "redirect:/home";
            }
            //密码不正确
            else return "/task5/error";
        }
        //用户名不正确
        else return "/task5/error";
    }

    @RequestMapping (value="/loginout",method = RequestMethod.GET)
    public String loginout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        Cookie[] cookie = httpServletRequest.getCookies();
        for (Cookie ck : cookie){
            if(ck.getName().equals("Token")) {
                //删除token(token只能通过重新设置MaxAge为o
                ck.setMaxAge(0);
                //将新的Token放入Http中
                httpServletResponse.addCookie(ck);
                System.out.println("Token删除成功");

            }
        }
        return "redirect:/home";
    }
}