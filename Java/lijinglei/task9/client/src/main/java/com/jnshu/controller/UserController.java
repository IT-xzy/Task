package com.jnshu.controller;

import com.jnshu.RMIClient;
import com.jnshu.model.ExcellentStudent;
import com.jnshu.model.JobInfo;
import com.jnshu.model.StudentNum;
import com.jnshu.model.User;
import com.jnshu.service.ESService;
import com.jnshu.service.JIService;
import com.jnshu.service.SNService;
import com.jnshu.service.UserService;
import com.jnshu.tools.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {


//
//    ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
//    UserController userController = (UserController)context.getBean("userController");

//    public UserController() {
//    }
//
//    public void setJiService(JIService jiService) {
//        UserController.jiService = jiService;
//    }
//
//    public void setSnService(SNService snService) {
//        UserController.snService = snService;
//    }
//
//    public void setUserService(UserService userService) {
//        UserController.userService = userService;
//    }
//
//    public void setEsService(ESService eSService) {
//        UserController.eSService = eSService;
//    }
//
//    static ESService eSService;
//    static JIService jiService;
//
//    static SNService snService;
//
//    static UserService userService;




   static RMIClient rmiClient =RMIClient.server();


    ESService eSService = rmiClient.geteSService();
    JIService jiService = rmiClient.getJiService();
    SNService snService = rmiClient.getSnService();
    UserService userService = rmiClient.getUserService();

    private Logger logger = Logger.getLogger(UserController.class);

    public String isNull(HttpServletRequest request){
        if (rmiClient == null){
            request.setAttribute("InfoMessage", "服务器都坏了");
            return "result";
        }
        return null;
    }

    public static void LongTime(HttpServletRequest request) {
        long timeStamp = System.currentTimeMillis();
        System.out.println(timeStamp);
        request.setAttribute("time", timeStamp);
    }



    /**
     * 登录跳转
     *
     * @return
     */

    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request) {
        LongTime(request);
        return "login";
    }

    /**
     * 登录跳转
     *
     * @return
     */

    @RequestMapping(value = "/toResult", method = RequestMethod.GET)
    public String toResult() {
        return "result";
    }

    /**
     * 根据id查找
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        try {
            isNull(request);
            LongTime(request);
            System.out.println("首页");
            List<ExcellentStudent> student = eSService.listAll();
            StudentNum num = snService.findById(1);
            System.out.println(num.getCumulativeNum());
            request.setAttribute("student", student);
            request.setAttribute("num", num);
            logger.info("获取数值成功");
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("信息载入失败！具体异常信息：" + e.getMessage());
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }


    /**
     * 根据id查找
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/u/vocation", method = RequestMethod.GET)
    public String vocation(HttpServletRequest request) {
        try {
            isNull(request);
            LongTime(request);
            System.out.println("职业");
            List<JobInfo> info = jiService.listAll();
            request.setAttribute("info", info);
            logger.info("获取数值成功");
            return "vocation";
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            logger.error("信息载入失败！具体异常信息：" + e.getMessage());
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }


    /**
     * 登录
     *
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request, HttpServletResponse response) {
        try {
            String timeStamp = String.valueOf(System.currentTimeMillis());
            LongTime(request);
            System.out.println("------login--qian----" + user.getUserName() + "," + user.getPassword() + ".");
            String password = user.getPassword();
            String salt = userService.selectByName(user.getUserName()).getSalt();
            String psSalt = MD5Util.generate(password, salt);
            boolean loginUser = psSalt.equals(userService.selectByName(user.getUserName()).getPassword());
            if (loginUser = true) {
                String data = user.getUserName() + "," + psSalt + "," + timeStamp;
                HttpSession session = request.getSession();
                session.setAttribute("session", data);//插入session
                request.setAttribute("loginUser", user.getUserName());
                return "index";
            } else {
                request.setAttribute("loginUser", "登录失败");
                return "result";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "登录失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }


    @RequestMapping("/page/login")
    public String showLogin(String redirectURL, Model model) {
        //上一个页面的url传递给登录页面，当登录页面成功登录后，由登录页面跳转到redirectURL指向的页面（js完成）
        model.addAttribute("redirect", redirectURL);
        return "login";
    }

    /**
     * 删除cookie
     *
     * @param request
     * @param response
     */
    @RequestMapping("/delCookie")
    public String delCookie(HttpServletRequest request, HttpServletResponse response) {
        LongTime(request);
        HttpSession session = request.getSession();
        String se = (String) session.getAttribute("session");
        if (null == se) {
            System.out.println("没有session==============");
        } else {
            session.setAttribute("session", null);
            System.out.println("清除session");
        }
        return "index";
    }
}
