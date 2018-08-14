package com.jnshu.czm.controller;


import com.jnshu.czm.encryp.MD5Util;
import com.jnshu.czm.model.Student;
import com.jnshu.czm.model.User;
import com.jnshu.czm.model.Users;
import com.jnshu.czm.service.StudentService;
import com.jnshu.czm.service.UserService;
import com.jnshu.czm.service.UsersService;
import com.jnshu.czm.tool.TokenUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private StudentService studentService;

    @Resource
    private UsersService usersService;

    /**
     * 用户登录
     * logIn
     *
     * @return
     * @throws Exception
     */

    @RequestMapping("/login")
    public String lonIn(HttpSession session, @Param("username") String username, @Param("password") String password, HttpServletResponse response) throws Exception {

        //在session中保存用户身份信息
        session.setAttribute("username", username);
        Users realUser = usersService.findUserByName(username);
        System.out.println("登录用户信息查看" + realUser);

        if (realUser != null &&
                realUser.getPassword().equals(MD5Util.setPasswordBySalt(username, password))) {
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
    public String logout(HttpSession session) throws Exception {

        //清除session
        session.invalidate();
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
    public String register(Model model, Users users) throws Exception {

        logger.info("控制器：Users users" + users);

        //要求用户名不能重复，密码不能为空，用户名长度不小于2
        if (usersService.findUserByName(users.getUsername()) == null
                && !users.getUsername().equals("")
                && !users.getPassword().equals("")
                && users.getUsername().length() >= 2) {
            users.setPassword(MD5Util.setPasswordBySalt(users.getUsername(), users.getPassword()));
            users.setCreate_at(System.currentTimeMillis());
            usersService.insertUser(users);
            return "redirect:/u/tll";
        } else {
            return "error";
        }
    }


    /**
     * 修真主页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/a")
    public String index(Model model) {

        long time = System.currentTimeMillis();
        model.addAttribute("time", time);

        //测试
        // System.out.println(studentService.findById(1));
        //通过遍历存储结业人员的数据（已经排好序）


        List<Student> studentList = studentService.findAll();
        //将数据传进表格
        model.addAttribute("studentList", studentList);

        //在学人员
        int atnum = studentService.selectAt();
        model.addAttribute("atnum", atnum);

        //结业人员
        int upnum = studentService.selectCount();
        model.addAttribute("upnum", upnum);

        return "first";
        //这里的first为layout.xml中配置的视图名称，根据返回值，去匹配对应的jsp页面

    }


    /**
     * 职业介绍页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/u/tll")
    public String tll(Model model) {

        long time = System.currentTimeMillis();
        model.addAttribute("time", time);
        //测试
        //System.out.println(userService.findUserById(1));
        //通过遍历存储所有的数据
        List<User> userList = userService.findAll();
        //将数据传进表格
        model.addAttribute("userList", userList);
        return "last";
    }


}
