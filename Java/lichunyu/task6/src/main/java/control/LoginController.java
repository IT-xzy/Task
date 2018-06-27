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
import utils.DesUtil;
import utils.Md5Util;
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

    private static final String REG = "^[a-zA-Z][a-zA-Z0-9_]*$"; //正则表达式.英文、数字、下划线，且英文开头
    private static final String INT = "^[0-9]*$";//数字
    private Logger log = Logger.getLogger(LoginController.class);
    //注册页面
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView registerPage(@ModelAttribute("user") User user){
        return new ModelAndView("register");
    }

    //注册成功后跳转到登录页面
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(@Validated User user) throws LoginException {
        ModelAndView modelAndView = new ModelAndView();
        String username = user.getName();
        String password = user.getPassword();
        String qq = user.getQq();
        if(username.isEmpty()||password.isEmpty()||qq.isEmpty()){
            log.info("注册信息为空，重新注册");
            throw new LoginException("注册信息不能为空，请重新注册");
        }else if(!username.matches(REG)){
            throw new LoginException("注册用户名只能为英文、数字、下划线，且必须英文开头");
        }else if(username.length()>15){
            throw new LoginException("注册用户名称字符数应该小于15");
        }else if(password.length()<6||password.length()>20){
            throw new LoginException("密码应该设置为6-20位");
        }else if(!qq.matches(INT)){
            throw new LoginException("QQ号码必须是数字");
        }else if(qq.length()<8||qq.length()>13){
            throw new LoginException("QQ号码必须是8-13位数字");
        }else {
                String shaPassword = Sha256Util.createSha256(password);
                log.info("注册SHA:"+shaPassword);
                String salt = Md5Util.createSaltMd5(password); //MD5加盐加密
                User user1 = new User();
                user1.setName(username);
                user1.setPassword(shaPassword);
                user1.setQq(qq);
                user1.setSalt(salt);
            try {
                userService.addUser(user1);
            } catch (Exception e) {
                throw new LoginException("注册用户名已存在，请重新注册："+username);
            }
            modelAndView.setViewName("login");
                log.info("注册成功，跳转到登录界面:"+shaPassword);
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
            log.info("用户名或密码不正确，重新登录");
            throw new LoginException("用户名或密码不正确,请重新登录");
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
