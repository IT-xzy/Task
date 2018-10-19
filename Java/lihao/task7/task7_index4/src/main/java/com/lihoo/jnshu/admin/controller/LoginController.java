package com.lihoo.jnshu.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lihoo.jnshu.admin.service.IStudentListService;
import com.lihoo.jnshu.admin.domain.StudentList;
import com.lihoo.jnshu.common.util.encrypt.JwtUtils2;
import com.lihoo.jnshu.common.util.encrypt.MD5Utils;
import com.lihoo.jnshu.common.util.msgUtil.Random4Code;
import com.lihoo.jnshu.common.util.msgUtil.RonglianSendMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.lihoo.jnshu.common.util.encrypt.AddSalt.getSalt;
import static com.lihoo.jnshu.common.util.encrypt.MD5Utils.getPwdHash;

/**
 * #Title: LoginController
 * #ProjectName task7_index3
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/26-11:07
 * @author lihoo
 */

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IStudentListService studentListService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     请求注册数据
     */
    @RequestMapping(value ="/join", method = RequestMethod.GET)
    public String joinForm() {
        logger.info("join GET 方法被调用……");
        return "register";
    }

    /**
     普通账号注册
     */
    @RequestMapping(value ="/join", method = RequestMethod.POST)
    public String join(@RequestParam("userName") String username,
                       @RequestParam("password") String pwd) {
        logger.info("开始...");
        logger.info("join POST 方法被调用……");
        String salt = getSalt();
        String pwdHash = getPwdHash(pwd, salt);
//       创建StudentInfo对象
        StudentList joinUser = new StudentList();
        joinUser.setUsername(username);
        joinUser.setSalt(salt);
        joinUser.setPwd(pwdHash);
        joinUser.setLogAt(System.currentTimeMillis());
        joinUser.setExpireAt(System.currentTimeMillis());
        studentListService.save(joinUser);
        logger.info("打印注册的用户信息: " + "用户名:"+username+"密码:"+pwd);
        logger.info("打印注册的用户信息: " + joinUser);
        return "redirect:/home";
    }

    /**
     请求登陆页面(输入账号密码)
     */
    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String loginForm() {
        logger.info("login GET 方法被调用……");
        return "login";
    }

    /**
     *
     *登录验证，token加密，cookie生成发送
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "userName",required = false) String username,
                        @RequestParam(value = "password",required = false) String pwd,
                        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                        Model model) throws Exception {
        //        查询用户列表
        QueryWrapper<StudentList> slqw = new QueryWrapper<>();
        slqw.gt("id", 0);
        List<StudentList> stuList = studentListService.list(slqw);
//        stuList.forEach(item -> logger.info("遍历用户列表：" + item));
        //通过用户名取出本条数据
        QueryWrapper<StudentList> slqw1 = new QueryWrapper<>();
        slqw1.eq("username", username);
        StudentList stu = studentListService.getOne(slqw1);
        Long id = stu.getId();
        //设置当前登录时间，一会儿添加到token用
        Long currentTime = System.currentTimeMillis();
        logger.info(String.valueOf(id));
        //把当前登录时间更新到数据库
        StudentList updateStu = new StudentList();
        updateStu.setId(id);
        updateStu.setLogAt(currentTime);
        Long addTime = studentListService.updateLoginTimeById(updateStu);
        logger.info(String.valueOf(addTime));
        logger.info(String.valueOf(updateStu));
        logger.info("当前登录时间是：" + currentTime);
        //**********************************************************************************************
//        定义需要加密的token( 登录时间 + 用户名 )
        String timeAndUsername = id + "," + currentTime + "," + username;
        logger.info("看一手这个（ id + 时间 + 用户名 ）的字符串：" + timeAndUsername );
//        加密，生成Token
        String jwtid = "19930909";
        String jwtToken = JwtUtils2.createJWT(jwtid,timeAndUsername,currentTime);
        System.out.println("****这就是JWT_Token：" + jwtToken);
        //        保存到Cookies
        Cookie cookie = new Cookie("token", jwtToken);
//        设置一下Cookie
//        切记cookie时间设置，当你刷新，超时cookie失效
//        cookie.setMaxAge(12*30*24*60*60);
        cookie.setMaxAge(60);
        cookie.setPath("/");
//        添加到请求中
        httpServletResponse.addCookie(cookie);
        //**********************************************************************************************
//        打印输入的用户名和密码
        logger.info("输入的账户名是：" + username );
        logger.info("输入的账户密码是：" + pwd );
//        扔到service层去看一手**账号**密码**是不是和数据库的对应
        StudentList loginUser = new StudentList();
        loginUser.setUsername(username);
        loginUser.setPwd(pwd);
//        验证用户名是否在数据库中
        Boolean isNameSame = stu.getUsername().equals(username);
        logger.info(String.valueOf(isNameSame));
//        验证密码是否在数据库中MD5加盐加密之后一致
        Boolean isPwdSame = studentListService.verifyPwd(loginUser);
        logger.info("是否一致：" + isPwdSame);
////      查找用户是否存在
        if (isNameSame && isPwdSame) {
            logger.info("登录成功");
            logger.info("打印一下cookie：" + cookie);
            logger.info("打印一下cookie的名：" + cookie.getName());
            logger.info("打印一下cookie的值：" + cookie.getValue());
            return "redirect:/home";
        }
        return "register";
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
//     用户退出时清除用户session里绑定到指定名称的对象
    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response){
        Cookie cookieKiller = new Cookie("token", null);
        cookieKiller.setMaxAge(0);
        cookieKiller.setPath("/");
        response.addCookie(cookieKiller);
        logger.info("退出登录，清除Cookie");
        return "redirect:/login";
    }









//    @RequestMapping("/toLogin")
//    public String toLogin(Model model){
//        model.addAttribute("ctx", getContextPath()+"/");
//        return "login";
//    }
//
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
//        request.setAttribute("ctx",request.getContextPath());
//        Map<String,Object> map =new HashMap<String,Object>();
//        String userName=request.getParameter("userName");
//        String password=request.getParameter("password");
//        if(!"".equals(userName) && !"".equals(password)){
//            StudentListDO user =new StudentListDO();
//            user.setUsername(userName);
//            user.setPwd(password);
//            request.getSession().setAttribute("user",user);
//            map.put("result","1");
//        }else{
//            map.put("result","0");
//        }
//        return map;
//    }



}
