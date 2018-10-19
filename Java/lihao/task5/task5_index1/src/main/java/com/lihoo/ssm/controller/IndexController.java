package com.lihoo.ssm.controller;

import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentHome;
import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.model.StudentProfession;
import com.lihoo.ssm.service.StudentHomeService;
import com.lihoo.ssm.service.StudentInfoService;
import com.lihoo.ssm.service.StudentProfessionService;
import com.lihoo.ssm.util.*;
import io.jsonwebtoken.Claims;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static com.lihoo.ssm.util.AddSalt.getSalt;
import static com.lihoo.ssm.util.MD5Encryption.*;
import static com.lihoo.ssm.util.MD5Utils.getPwdHash;

/**
 * #Title: IndexController
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/28-15:18
 * @author lihoo
 */

@SuppressWarnings("unused")
@Controller
public class IndexController {
//    打印日志
    private static Logger logger = LogManager.getLogger(IndexController.class);

    @Autowired
    StudentInfoService studentInfoService;

    /**
     请求注册数据
     */
    @RequestMapping(value ="/join", method = RequestMethod.GET)
    public String joinForm() {
        logger.info("join GET 方法被调用……");
        return "join.page";
    }

    /**
     注册
     */
    @RequestMapping(value ="/join", method = RequestMethod.POST)
    public String join(@RequestParam("username") String username,
                       @RequestParam("pwd") String pwd) {
        logger.info("开始...");
        logger.info("join POST 方法被调用……");
        String salt = getSalt();
        String pwdHash = getPwdHash(pwd, salt);
////        创建StudentInfo对象
        StudentInfo joinUser = new StudentInfo();
        joinUser.setUsername(username);
        joinUser.setSalt(salt);
        joinUser.setPwd(pwdHash);
        joinUser.setLogAt(System.currentTimeMillis());
        joinUser.setExpireAt(System.currentTimeMillis());
        studentInfoService.insert(joinUser);
        logger.info("打印添加的用户信息: " + "用户名:"+username+"密码:"+pwd);
        logger.info("打印添加的用户信息: " + joinUser);
        return "main.home";
    }

    /**
     请求直接登陆页面
     */
    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String loginForm() {
        logger.info("login GET 方法被调用……");
        return "login.page";
    }

    /**
     登录验证，token加密，cookie生成发送
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username",required = false) String username,
                        @RequestParam(value = "pwd",required = false) String pwd,
                        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                        Model model) throws Exception {

        //        查询用户列表
        List<StudentInfo> stuList = studentInfoService.selectAll();
        for (StudentInfo list : stuList) {
            list.getId();
//            logger.debug("用户名：" + list.getUsername() + "密码：" + list.getPwd() + "盐：" + list.getSalt());
        }
        //通过用户名取出本条数据
        StudentInfo stu = studentInfoService.selectByUsername(username);
        //设置当前登录时间，一会儿添加到token用
        Long id = stu.getId();
        Long currentTime = System.currentTimeMillis();
        logger.info(id);
        //把当前登录时间更新到数据库
        StudentInfo updateStu = new StudentInfo();
        updateStu.setId(id);
        updateStu.setLogAt(currentTime);
        int addTime = studentInfoService.updateLoginTimeById(updateStu);
        logger.info(addTime);
        logger.info(updateStu);
        logger.info("当前登录时间是：" + currentTime);

//        定义需要加密的token( id + 登录时间 + 用户名 )
        String idAndTimeAndUsername = id + "," + currentTime + "," + username;
        logger.info("看一手这个（ id + 时间 + 用户名 ）的字符串：" + idAndTimeAndUsername );

//        加密，生成Token
        String jwtid = "123456";
        String jwtToken = JwtUtils2.createJWT(jwtid,idAndTimeAndUsername,currentTime);
        System.out.println("****JWT生成牛皮Token：" + jwtToken);

//        String token = DesUtil.encrypt(idAndTimeAndUsername);
//        logger.info("****这就是Token：" + token);
//        保存到Cookies
        Cookie cookie = new Cookie("token", jwtToken);
//        Cookie cookie = new Cookie("token", token);
//        设置一下Cookie
//        切记cookie时间设置，当你刷新，超时cookie失效
        cookie.setMaxAge(10);
        cookie.setPath("/");
//        添加到请求中
        httpServletResponse.addCookie(cookie);
//        打印输入的用户名和密码
        logger.info("输入的账户名是：" + username );
        logger.info("输入的账户密码是：" + pwd );
//        扔到service层去看一手**账号**密码**是不是和数据库的对应
        StudentInfo loginUser = new StudentInfo();
        loginUser.setUsername(username);
        loginUser.setPwd(pwd);
//        验证用户名是否在数据库中
        Boolean isNameSame = stu.getUsername().equals(username);
        logger.info(isNameSame);
//        验证密码是否在数据库中MD5加盐加密之后一致
        Boolean isPwdSame = studentInfoService.verifyPwd(loginUser);
        logger.info("是否一致：" + isPwdSame);
////      查找用户是否存在
        if (isNameSame && isPwdSame) {
            logger.info("登录成功");
            logger.info("打印一下cookie：" + cookie);
            logger.info("打印一下cookie的名：" + cookie.getName());
            logger.info("打印一下cookie的值：" + cookie.getValue());
            return "redirect:/index";
        }
        return "error.page";
    }

//    因为状态栏每个页面都有，所以每个路径下都要写一个下面的login状态Util
//    @RequestMapping("")
//    public String header(HttpServletRequest request, Model model) {
//        String[] status = LoginStatus.status(request);
//        model.addAttribute("status", status);
//        return "index.page";
//    }


//     用户退出时清除用户session里绑定到指定名称的对象
    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response){
        Cookie cookieKiller = new Cookie("token", null);
        cookieKiller.setMaxAge(0);
        cookieKiller.setPath("/");
        response.addCookie(cookieKiller);
        logger.info("退出登录，清除Cookie");
        return "redirect:/index";
    }

    @Autowired
    StudentHomeService studentHomeService;
//  主页
    @RequestMapping("/index")
    public String home(Model model, HttpServletRequest request) throws Exception {
        List<StudentHome> selectGreatStudent = studentHomeService.selectGreatStudent();
        int countAll = studentHomeService.countAll();
        int workingCount = studentHomeService.workingCount();

        String[] status = LoginStatus.status(request);
        logger.info("我王境泽就是饿死：" + status);
        model.addAttribute("status", status);

        model.addAttribute("selectGreatStudent", selectGreatStudent);
        model.addAttribute("countAll", countAll);
        model.addAttribute("workingCount", workingCount);
        return "main.home";
    }

    @Autowired
    StudentProfessionService studentProfessionService;

//  职业
    @RequestMapping(value = "/u/profession")
    public String profession(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("token".equals(cookies[i].getName())) {
                    try {
                        String tokenValue = cookies[i].getValue();
                        logger.info("这个cookie中，名为token的值为：" + tokenValue);

//                        解密token
                        Claims claims = JwtUtils2.parseJWT(tokenValue);
                        System.out.println(claims);
                        String tokenValueDecrypt =  claims.getSubject();
                        System.out.println(tokenValueDecrypt);

//                        String tokenValueDecrypt = DesUtil.decrypt(tokenValue);

                        logger.info("解码token得到用户id和登录时间拼接的字符串为：" + tokenValueDecrypt);
                        String[] arrToken = tokenValueDecrypt.split(",");
                        logger.info("得到一个数组：" + arrToken);
                        String uid = arrToken[0];
                        logger.info("数组索引为“0”的部分是用户id:" + uid);
                        String loginTime = arrToken[1];
                        logger.info("数组索引为“1”的部分是登录时间:" + loginTime);
                        String uname = arrToken[2];
                        logger.info("数组索引为“2”的部分是用户名:" + uname);
                        StudentInfo stuFindByName = studentInfoService.selectByUsername(uname);
                        logger.info("用户信息：" + stuFindByName);
                        Long dblLogtime = stuFindByName.getLogAt();
//                        因为uid是一个String，需要转换为Long类型
//                        Long dbUid = Long.parseLong(uid);
//                        StudentInfo stu = studentInfoService.selectByPrimaryKey(dbUid);
//                        logger.info("用户信息：" + stu);
//                        Long dblLogtime = stu.getLogAt();
                        logger.info("数据库存储的登录时间：" + dblLogtime);
                        Long loginTimeLong = Long.parseLong(loginTime);
                        if (loginTimeLong.equals(dblLogtime)) {
                            List<StudentProfession> selectAll = studentProfessionService.selectAll();
                            model.addAttribute("selectAll", selectAll);
                            int countAll = studentProfessionService.countAll();
                            model.addAttribute("countAll", countAll);

                            String[] status = LoginStatus.status(request);
                            logger.info("也不带吃你们一口东西：" + status);
                            model.addAttribute("status", status);

                            return "profession.home";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "redirect:/login";
    }

//  推荐


    @RequestMapping(value = "/u/recommend")
    public String recommend(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("token".equals(cookies[i].getName())) {
                    try {
                        String tokenValue = cookies[i].getValue();
                        logger.info("这个cookie中，名为token的值为：" + tokenValue);
//                        解密token
                        Claims claims = JwtUtils2.parseJWT(tokenValue);
                        System.out.println(claims);
                        String tokenValueDecrypt =  claims.getSubject();
                        System.out.println(tokenValueDecrypt);
//                        String tokenValueDecrypt = DesUtil.decrypt(tokenValue);

                        logger.info("解码token得到用户id和登录时间拼接的字符串为：" + tokenValueDecrypt);
                        String[] arrToken = tokenValueDecrypt.split(",");
                        logger.info("得到一个数组：" + arrToken);
                        String uid = arrToken[0];
                        logger.info("数组索引为“0”的部分是用户id:" + uid);
                        String loginTime = arrToken[1];
                        logger.info("数组索引为“1”的部分是登录时间:" + loginTime);
                        String uname = arrToken[2];
                        logger.info("数组索引为“2”的部分是用户名:" + uname);
                        StudentInfo stuFindByName = studentInfoService.selectByUsername(uname);
                        logger.info("用户信息：" + stuFindByName);
                        Long dblLogtime = stuFindByName.getLogAt();
//                        因为uid是一个String，需要转换为Long类型
//                        Long dbUid = Long.parseLong(uid);
//                        StudentInfo stu = studentInfoService.selectByPrimaryKey(dbUid);
//                        logger.info("用户信息：" + stu);
//                        Long dblLogtime = stu.getLogAt();
                        logger.info("数据库存储的登录时间：" + dblLogtime);
                        Long loginTimeLong = Long.parseLong(loginTime);
                        if (loginTimeLong.equals(dblLogtime)) {
                            List<StudentProfession> selectAll = studentProfessionService.selectAll();
                            model.addAttribute("selectAll", selectAll);
                            int countAll = studentProfessionService.countAll();
                            model.addAttribute("countAll", countAll);

                            String[] status = LoginStatus.status(request);
                            logger.info("哎呀，真香：" + status);
                            model.addAttribute("status", status);

                            return "recommend.home";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "redirect:/login";
    }

    /**
     请求失败
     */
    @RequestMapping("/error")
    public String error() {
        return "error.page";
    }

    /**
     * 用户列表
     */
    @RequestMapping("/u/userList")
    public String userList(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return "userList.home";
        }
        String[] status = LoginStatus.status(request);
        logger.info("哎呀，真香：" + status);
        model.addAttribute("status", status);

        return "redirect:/login";
    }

}
