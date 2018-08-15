package controller;


import md5.passwordMD5;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Job;
import pojo.Student;
import pojo.User;
import service.ServiceIndex;
import service.Servicejob;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import token.TokenUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ControllerIndex {
    private static Logger logger = Logger.getLogger(ControllerIndex.class);
    @Autowired
    ServiceIndex serviceIndex;
    @Autowired
    Servicejob servicejob;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index2(Model model) {
        List<Student> studentList = serviceIndex.listStudent();
        model.addAttribute(studentList);
        return "/index";
    }

    @RequestMapping(value = "/u/index", method = RequestMethod.GET)
    public String index(Model model) {
        List<Student> studentList = serviceIndex.listStudent();
        model.addAttribute(studentList);
        return "/index";
    }

    @RequestMapping(value = "/cooperate", method = RequestMethod.GET)
    public String cooperate(Model model) {
        return "/cooperate_page";
    }

    @RequestMapping(value = "/joblist", method = RequestMethod.GET)
    public String list(Model model) {
        List<Job> jobList = servicejob.listJob();
        int count = serviceIndex.count();
        model.addAttribute("count", count);
        try{model.addAttribute(jobList);
        }catch (Exception e){
            logger.info("没数据");
        }
        return "/list_page";
    }
    @RequestMapping(value = "/loginedit",method = RequestMethod.GET)
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        logger.info("进入controller方法");
        String username = httpServletRequest.getParameter("userName");
        String password = httpServletRequest.getParameter("passWord");
        logger.info(username + password + "密码");
        String md5Password = passwordMD5.createPassword(password);
        logger.info(md5Password+"加密后密码");
        User user = userService.validateUser(username, md5Password);
        logger.info(user + "123123");
        if (user == null) {
            logger.info("登陆失败");
            httpServletRequest.getSession().setAttribute("errorInfo", "用户名错误，滚");
            return "forward:WEB-INF/tiles/login.jsp";
        } else {
            //加入登陆时间
            userService.updateTimeBtId(user.getId());
            //重新读数据
            User user1 = userService.validateUser(username,md5Password);

            logger.info(TokenUtil.genToken(user1.getId(), user1.getLogin_time()));
            String s_token = TokenUtil.genToken(user1.getId(), user1.getLogin_time());
            logger.info(s_token + "token+++++++++");
            Cookie token = new Cookie("token", s_token);
            httpServletResponse.addCookie(token);
            logger.info(token);
            return "redirect:/u/index";
        }
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        Cookie[] cookies = httpServletRequest.getCookies();
        try
        {
            for(int i=0;i<cookies.length;i++)
            {
                //System.out.println(cookies[i].getName() + ":" + cookies[i].getValue());
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setMaxAge(0);
                httpServletResponse.addCookie(cookie);
            }
        }catch(Exception ex)
        {
            logger.info("清空Cookies发生异常！");
        }
        return "redirect:loginedit";
    }

   @RequestMapping(value = "/json/joblist", method = RequestMethod.GET)
   public  @ResponseBody List<Job> sad() {
       return servicejob.listJob();
   }
}
