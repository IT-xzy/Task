package com.jnshu.czm.controller;

import com.jnshu.czm.util.MD5Util;
import com.jnshu.czm.model.Users;
import com.jnshu.czm.service.StudentService;
import com.jnshu.czm.service.UserService;
import com.jnshu.czm.service.UsersService;
import com.jnshu.czm.util.TokenUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class Register {

    private static Logger logger= LoggerFactory.getLogger(Register.class);

    @Resource
    private UserService userService;

    @Resource
    private StudentService studentService;

    @Resource
    private UsersService usersService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户登录
     * @param session
     * @param username
     * @param password
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String lonIn(HttpSession session, @Param("username") String username, @Param("password") String password, HttpServletResponse response) throws Exception {

        //在session中保存用户身份信息
        session.setAttribute("username", username);
        session.setAttribute("password",password);

        Users realUser = usersService.findUserByName(username);
        String salt=realUser.getSalt();
        System.out.println("登录用户信息查看" + realUser);

        if (realUser != null &&
                realUser.getPassword().equals(MD5Util.setPasswordBySalt(password,salt))) {
            String token = TokenUtil.makeToken(realUser.getUsername());

            System.out.println("控制器的token值：" + token);

            Cookie cookie = new Cookie("token", token);

            //将cookie的有效时间设定为10天
            cookie.setMaxAge(60 * 60 * 24 * 10);

            //将cookie对象添加到response对象中，把cookie输出到客户端浏览器
            response.addCookie(cookie);

            return "redirect:/u/tll";

        } else {
            return "error";
        }
    }

    /**
     * 用户退出
     * logout
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session,HttpServletResponse response) throws Exception {
        logger.info("\n退出");
        //清除session
        session.invalidate();
        Cookie cookie = new Cookie("token", "");
        //将cookie的有效时间设定为10天
        cookie.setMaxAge(0);
        //将cookie对象添加到response对象中，把cookie输出到客户端浏览器
        response.addCookie(cookie);
        return "redirect:/u/tll";
    }

    /**
     * 跳转到注册页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/b")
    public String turn() throws Exception {
        return "register";
    }


    /**
     * 注册用户
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register( Users users, HttpServletRequest request/*,@RequestParam("photo") MultipartFile photo*/) throws Exception {

        logger.info("\nPOST /register");
        logger.info("控制器：Users users" + users);

        //获得电话验证码
        String telephone=users.getTelephone();
        String code1= (String) redisTemplate.opsForValue().get("code"+telephone);
        System.out.println("code      "+code1);
        String code2=request.getParameter("phonecode");

        //获得邮箱验证码
        String email=users.getEmail();
        String emailcode1= (String) redisTemplate.opsForValue().get("code"+email);
        String emailcode2=request.getParameter("emailcode");


        //要求用户名不能重复，密码不能为空，用户名长度不小于2
        if (usersService.findUserByName(users.getUsername()) == null
                && code1.equals(code2)
                && emailcode1.equals(emailcode2)
                && !users.getUsername().equals("")
                && !users.getPassword().equals("")
                && users.getUsername().length() >= 2) {
            String salt= UUID.randomUUID().toString().replace("-", "");
            users.setPassword(MD5Util.setPasswordBySalt(users.getPassword(),salt));
            users.setTelephone(users.getTelephone());
            users.setEmail(users.getEmail());
            users.setCreate_at(System.currentTimeMillis());
            users.setSalt(salt);
            usersService.insertUser(users);
            return "redirect:/u/tll";
        } else {
            return "error";
        }
    }


}
