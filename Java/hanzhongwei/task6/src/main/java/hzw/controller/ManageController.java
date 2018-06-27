package hzw.controller;

import hzw.model.Profession;
import hzw.model.Students;
import hzw.model.User;
import hzw.service.ServiceManage;
import hzw.util.DESUtil;
import hzw.util.MD5Util;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ManageController {
    private static final String skey = "zhongwei";
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ManageController.class);
    @Autowired
    ServiceManage serviceManage;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String index(Model model){
        logger.info("进入首页");
        List<Students> students = serviceManage.findListStudents();
        int a = serviceManage.countStudent();
        int b = serviceManage.countWork();
        model.addAttribute("students",students);
        model.addAttribute("a",a);
        model.addAttribute("b",b);
        return "home";
    }

    @RequestMapping(value = "/company",method = RequestMethod.GET)
    public String company(){
        logger.info("进入推荐企业页");
        return "company";
    }

    @RequestMapping(value = "/u/pro",method = RequestMethod.GET)
    public String profession(Model model){
        logger.info("进入职业推荐页");
        List<Profession> profession = serviceManage.findListProfession();
        model.addAttribute("profession",profession);
        return "profession";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Model model,User user){
        logger.info("进入注册页");
        logger.info("前台传进来的信息："+user.toString());
        User u =  serviceManage.findNameUser(user.getUserName());
        if (u != null){
            logger.info("已经存在用户");
            return "registerError";
        }else {
            logger.info("开始注册");
            //以用户名为盐
            String salt = user.getUserName();
            //对密码加盐和md5加密
            String passwordMD5 = MD5Util.stringToMD5(user.getPassword()+salt);
            logger.info("加盐加密后的密码："+passwordMD5);
            user.setPassword(passwordMD5);
            serviceManage.insertUser(user);
            logger.info("注册的信息是："+user);
            return "login";
        }

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("进入登陆页");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        logger.info("前台传进来的登录账号："+userName+",密码："+password);
        //对密码加盐加密，然后和数据库里的比较
        String passwordMD5 = MD5Util.stringToMD5(password+userName);
        logger.info("加盐加密后的密码："+passwordMD5);
        User user = serviceManage.findNameUser(userName);
        logger.info("根据用户名查询数据库"+user);
        if (user != null && (user.getUserName()).equals(userName) && (user.getPassword()).equals(passwordMD5)) {
            logger.info("登录成功");
            Long id = user.getUserId();
            // 使用用户ID+系统当前时间生成唯一token, 格式为键值对
            String token = id + "|" + id + "|" + System.currentTimeMillis();
            logger.info("生成的token是:"+token);
            // 用DES加密key 必须8位
            byte[] bytes = DESUtil.encrypt(token,skey);
            logger.info("加密后的token: " + DESUtil.toHexString(bytes).toUpperCase());
            logger.info("加密后的Base64 token: " + Base64.encodeBase64String(bytes));
            //org.apache.commons.codec.binary.Base64;依赖包
            Cookie cookie = new Cookie("token",Base64.encodeBase64String(bytes));
            // 设置 Cookie 过期时间 单位为秒
            cookie.setMaxAge(7000);
            // 设置 Cookie 有效路径
            cookie.setPath("/");
            logger.info("新生成的Cookie-效时间-值: " + cookie.getName() + "-->" + cookie.getMaxAge() + "-->" + cookie.getValue() + cookie.getPath());
            response.addCookie(cookie);
            return "redirect:/u/pro";
        }else {
            logger.info("登录失败");
            return "login";
        }
    }

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String main(){
        return "login";
    }

    @RequestMapping(value = "/main2",method = RequestMethod.GET)
    public String main1(){
        return "register";
    }
}
