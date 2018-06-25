package control;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.UserService;
import utils.CookieUtil;
import utils.DesUtil;
import utils.Sha256Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注册登录登出
 */
@Controller
@RequestMapping
public class LoginController {
    @Autowired
    UserService userService;

    private Logger log = Logger.getLogger(LoginController.class);
    //注册页面
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView registerPage(@ModelAttribute("user") User user){
        return new ModelAndView("register");
    }

    //注册成功后跳转到登录页面
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(@Validated User user){
        ModelAndView modelAndView = new ModelAndView();
        String username = user.getName();
        String password = user.getPassword();
        if (!username.isEmpty()&& !password.isEmpty()) {
            String shaPassword = Sha256Util.createSha256(password);
            User user1 = new User();
            user1.setName(username);
            user1.setPassword(shaPassword);
            try {
                userService.addUser(user1);
            } catch (Exception e) {
                log.info("该数据已经注册过："+username);
            }
            modelAndView.setViewName("login");
            log.info("注册成功，跳转到登录界面");
        }else {
            modelAndView.setViewName("register");
            log.info("注册信息为空，重新注册");
        }
        return modelAndView;
    }

    //登录页面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage(@ModelAttribute("user") User user){
        return new ModelAndView("login");
    }

    //登录跳转到首页
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@Validated User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("开始登录加密操作");
        ModelAndView modelAndView = new ModelAndView();
        String username = user.getName();
        String password = user.getPassword();
        String shaPassword = Sha256Util.createSha256(password); //密码通过SHA256进行加密存储
        log.info("把密码生成为SHA加密："+shaPassword);
        user.setName(username);
        user.setPassword(shaPassword);
        User user1 = userService.getUser(user);
        log.info("获取数据库中用户信息："+user1);
        if(user1 != null){
            modelAndView.addObject("user",user1);
            String str = user1.getId()+":"+System.currentTimeMillis();
            String token = DesUtil.encrypt(str); //DES加密方式把用户Id和登录时间生成token
            log.info("DES加密方式生成token："+token);
            CookieUtil.addCookie(response,"token",token);
            modelAndView.setViewName("redirect:/home");//重定向到首页
            log.info("登录成功，跳转到首页");
        }else {
            modelAndView.setViewName("login"); //返回登录界面
            log.info("用户名或密码不正确，重新登录");
        }
        return modelAndView;
    }

    //退出登录
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        CookieUtil.removeCookie(response,"token");
        modelAndView.setViewName("redirect:login");
        log.info("登出到登录页面");
        return modelAndView;
    }
}
