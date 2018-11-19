package task6_redis.controlller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task6_redis.pojo.User;
import task6_redis.service.UserService;
import task6_redis.util.TokenUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;


/**
 * 登录注册模块控制器编写
 * 默认首页是可以访问的，t11页面是不可访问的，点击右上方登录或者注册按钮跳转到登录或者注册页面
 * 设置为登录和注册为静态页面，用form表单提交数据到控制层。然后进行业务判断
 */
@Controller
public class LoginController {
    private static Logger logger =Logger.getLogger(LoginController.class);
    @Resource(name = "userServiceImpl")
    private UserService userService;

    /**
     * 登录验证，调用userService.loginCheck的方法进行登录验证判断，暂时不处理异常，统一处理异常。
     * 然后利用des对用户名ID和时间进行加密，生成token存入cookie，用户名字也存入cookie，用于页面显示。
     * @param request 用request取出页面传来的值
     * @return 登录成功返回首页视图名
     */
    @RequestMapping(value = "/logging",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        logger.info("进入loginCheck()");
        //用request取出页面传来的参数
        String adminCode =request.getParameter("adminCode");
        String password =request.getParameter("password");
        logger.info("账号："+adminCode+","+"密码："+password);
        //调用userService.loginCheck的方法进行登录验证判断
        User user =userService.loginCheck(adminCode,password);
        logger.info(user);
        //利用des对用户名ID和时间进行加密，生成token存入cookie
        //创建一个时间戳用来表示登录的时间
        Long loginTime =System.currentTimeMillis();
        String token = TokenUtils.getToken(user.getUserID()+"|"+String.valueOf(loginTime));
        logger.info(token);
        Cookie cookie1=new Cookie("token",token);
        //把token在在存到session里面，用于在拦截器器里面做对比
        request.getSession().setAttribute("token",token);
        //把用户的姓名放到session用于页面显示
        request.getSession().setAttribute("name",user.getUserName());
        response.addCookie(cookie1);
        return "redirect:firstPage";
    }
    /**
     * 注册模块，利用框架进行参数验证，然后在调用方法对注册的信息进行保存
     */
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String register(@Validated User user, ModelMap model){
        logger.info("进入register()");
        //加入注册的时间
        user.setCreatTime(System.currentTimeMillis());
        logger.info(user);
        //调用useService.register保存注册信息
        String str =userService.register(user);
        //绑定保存是否成功的信息返回到页面
        logger.info(str);
        model.addAttribute("saveMessage",str);
        return "register_message";
    }
    //转发到登录页面
    @RequestMapping(value = "/logging",method =RequestMethod.GET)
    public String loginRelay(){
        logger.info("进入loginRelay()");
        return "login";
    }
    //转发到注册页面
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registerRelay(){
        logger.info("registerRelay()");
        return "register";
    }
}
