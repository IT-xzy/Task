package task05.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task05.pojo.UserLogin;
import task05.services.UserLoginServices;
import task05.util.MD5.MD5Util;
import task05.util.des.CharacterUtils;
import task05.util.des.DesUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;


@Controller
public class UserLoginController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @Autowired
    public UserLoginServices userLoginServices;
    private UserLogin userLogin;
    private static final Charset CHARSET = Charset.forName("gb2312");


    //    实现跳转至登录界
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        logger.info("------------------ 跳转至登录界面 ----------------");
        return "/login";
    }

    //实现跳转至注册界面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register1() {
        logger.info("------------------ 跳转至注册界面 ----------------");
        return "register";
    }


    @RequestMapping(value = "/toregister", method = RequestMethod.POST)
    public String register(UserLogin userLogin, Model model) {

//        生成一个空文密码，用于检测密码是否为空
//         UserLogin u = new UserLogin();
//        获取前端传回来的 name
        String name = userLogin.getName();
        logger.info("------------------ 打印从前端收集的信息----------------");
        logger.info(userLogin.toString());
        //        根据 name 来查询数据库中用户的整体信息
        UserLogin userLoginDateBase = userLoginServices.queryByName(name);
        if (null != userLoginDateBase) {
            model.addAttribute("后端通知", "用户已存在");
            return "redirect:/toregister";
        }
        if (!("".equals(userLogin.getPassword()))) {
//            创建一个随机的 salt
            String salt = CharacterUtils.getRandomString(8);
//            加密成密文保存到 password
            String password = MD5Util.MD5(userLogin.getPassword() + salt);
//            将密文保存在 前端返回的对象中 userLogin
            userLogin.setPassword(password);
//            将随机盐保存在 前端返回的对象中 userLogin
            userLogin.setSalt(salt);
            logger.info("userLogin:" + userLogin );
//            将经过修改后前端返回的对象 userLogin 写入数据库中
            userLoginServices.register(userLogin);
//            向前端返回通知
            model.addAttribute("后端通知", "注册成功，请登录");
            return "redirect:/login";
        } else {
            model.addAttribute("后端通知", "密码不能为空");
            return "redirect:/register";
        }
    }


    @RequestMapping(value = "tologin", method = RequestMethod.POST)
    public String tologinbase(Model model, UserLogin userLogin,HttpServletResponse response,
                              HttpServletRequest request) {
        logger.info("userLogin:" + userLogin.toString() );
//        获取前端返回的登录 name password
        String name = userLogin.getName();
        String password = userLogin.getPassword();
       logger.info("name:" + name + "-----password:" + password);
//        根据前端返回的 name 来获取数据库中的数据
        UserLogin userLoginDatabase = userLoginServices.queryByName(name);
        logger.info("数据库中的额数据：" + userLoginDatabase.toString());
//        生成一个 ID + time 的字符串，并把它传值至 token
        String key = CharacterUtils.getRandomString(8);
        String id = String.valueOf(userLoginDatabase.getId());
        String tokenBase = id + "," + System.currentTimeMillis();
        String token = DesUtil.encrypt(tokenBase, CHARSET, key);


//        来对前端返回的密码 结合数据库中的 salt 二次加密，在比较两次加密的密文是否相等
        if (userLoginDatabase != null) {
            if (MD5Util.MD5(password +
                    userLoginDatabase.getSalt()).equals(userLoginDatabase.getPassword())) {

//                创建 名为  tokenCookie 的cookie，然后将 token 内容写入 cookie 中
                Cookie tokenCookie = new Cookie("name", token);
                Cookie tokenCookieName = new Cookie("userName", name);

//                设定 cookie 的有效时长
                tokenCookie.setMaxAge(60 * 60 * 24);
                tokenCookieName.setMaxAge(60 * 60 * 24);
                response.addCookie(tokenCookie);
                response.addCookie(tokenCookieName);

//                生成 session
//                getSession()相当于getSession(false)，getSession(true)则不管当前是否存在Session都创建一个
                HttpSession session = request.getSession(false);
                session.setAttribute("userName",name);
                session.setAttribute("password",password);
                session.setMaxInactiveInterval(60 * 60 * 24);

//                将 token 加密用的 salt 保存至数据库中
                userLoginServices.updateDes(key, userLoginDatabase.getId());
                System.out.println("登录信息正确");

                return "redirect:/u/occupation";//一个登陆成功的页面
            } else {
                model.addAttribute("返回通知", "账户或密码不对");
                return "redirect:/login";
            }
        } else {
            model.addAttribute("返回通知", "用户不存在");
            return "redirect:/login";
        }
    }
}


