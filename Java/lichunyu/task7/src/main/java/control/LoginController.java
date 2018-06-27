package control;

import exception.LoginException;
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
import utils.Md5Util;
import utils.XmemcachedManager;

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
    @Autowired
    XmemcachedManager xmemcachedManager;
    private Logger log = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "register" ,method = RequestMethod.GET)
    public ModelAndView registerPage(@ModelAttribute("user") User user){
        log.info("跳转到注册详情页");
        return new ModelAndView("register");
    }

    //注册成功后跳转到登录页面
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(@Validated User user) throws Exception {
        log.info("开始注册，并跳转");
        ModelAndView modelAndView = new ModelAndView();
        if(userService.register(user)) {
            if (null != xmemcachedManager.get("code")) {
                log.info("从缓存中获取验证码:"+xmemcachedManager.get("code"));
                if (xmemcachedManager.get("code").equals(user.getCode())) {
                    //MD5加盐加密
                    user.setPassword(Md5Util.createSaltMd5(user.getPassword()));
                    //默认头像
                    user.setCode("https://lichunyu1234.oss-cn-shanghai.aliyuncs.com/ant.png?x-oss-process=image/resize,m_lfit,h_200,w_200");
                    user.setCreatedAt(String.valueOf(System.currentTimeMillis()));
                    try {
                        userService.addUser(user);
                        log.info("添加注册用户到数据库");
                    } catch (Exception e) {
                        log.info("注册异常:" + e.getMessage());
                        User user1 = userService.getUserByName(user.getName());
                        if (user1 != null) {
                            throw new LoginException("注册用户名已存在，请重新注册：" + user.getName());
                        } else {
                            throw new LoginException("添加注册用户到数据库异常，请尝试重新注册");
                        }
                    }
                    modelAndView.setViewName("login");
                    log.info("注册成功，跳转到登录界面");
                } else {
                    throw new LoginException("验证码不正确，请重新输入");
                }
            }else {
                throw new LoginException("没有找到验证码，请重新获取");
            }
        }
        return modelAndView;
    }


    //登录页面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage(@ModelAttribute("user") User user){
        log.info("跳转到登录页面");
        return new ModelAndView("login");
    }

    //登录跳转到首页
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@Validated User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("开始登录");
        ModelAndView modelAndView = new ModelAndView();
        if(userService.login(user,response)){
            modelAndView.setViewName("redirect:/home"); //重定向到首页
            log.info("登录成功，跳转到首页");
        }else {
            log.info("密码不正确");
            throw new LoginException("密码不正确,请重新登录");
        }
        return modelAndView;
    }

    //退出登录
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        log.info("退出登录");
        ModelAndView modelAndView = new ModelAndView();
        CookieUtil.removeCookie(response,"token");
        modelAndView.setViewName("redirect:/login");
        log.info("退出到登录页面");
        return modelAndView;
    }
}
