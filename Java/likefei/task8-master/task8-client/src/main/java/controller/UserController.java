/*package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserRmiService;
import utils.json.JsonResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    UserRmiService userRmiService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/phonecode", method = RequestMethod.GET)
    public @ResponseBody
    JsonResult phonecode(HttpSession httpSession, User user) {
        return  userRmiService.phonecode(httpSession, user);
    }

    @RequestMapping(value = "/phoneregister",method = RequestMethod.POST)
    public @ResponseBody
    JsonResult phoneregister(HttpSession httpSession, User user, @RequestParam("phonecode") String phonecode, HttpServletRequest httpServletRequest){
        return  userRmiService.testphonecode(httpSession,phonecode,user,httpServletRequest);
    }

    @RequestMapping(value = "/emailcode",method = RequestMethod.GET)
    public @ResponseBody
    JsonResult emailcode(HttpSession httpSession, User user){
        return  userRmiService.emailcode(httpSession,user);
    }

    @RequestMapping(value = "/emailregister",method = RequestMethod.POST)
    public @ResponseBody
    JsonResult emailregister(HttpSession httpSession, User user, @RequestParam("emailcode")String emailcode, @RequestParam("signcode") String signcode){
        return  userRmiService.testemailcode(httpSession,emailcode,user);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody
    JsonResult register(HttpSession httpSession, User user, @RequestParam("signcode")String signcode){
        return  userRmiService.testcommon(user,signcode,httpSession);
    }

    @RequestMapping(value = "/phonelogin",method = RequestMethod.POST)
    public @ResponseBody
    JsonResult phonelogin(User user, @RequestParam("phonecode") String phonecode, HttpSession httpSession){
        return  userRmiService.phonelogin(user,phonecode,httpSession);
    }

    @RequestMapping(value = "/emaillogin",method = RequestMethod.POST)
    public @ResponseBody
    JsonResult emaillogin(User user, @RequestParam("emailcode") String emailcode, HttpSession httpSession, @RequestParam("signcode") String signcode){
        return  userRmiService.emaillogin(user,emailcode,httpSession,signcode);
    }

    @RequestMapping(value = "/commonlogin",method = RequestMethod.POST)
    public @ResponseBody
    JsonResult commonlogin(User user, @RequestParam("signcode") String signcode, HttpSession httpSession){
        return  userRmiService.commonlogin(user,signcode,httpSession);
    }

    @RequestMapping(value = "/u",method = RequestMethod.GET)
    public String profile(Long id,HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest) {
        userRmiService.profile(id,httpServletResponse,httpServletRequest);
        return "profile";
    }

    @RequestMapping(value = "/u/test",method = RequestMethod.GET)
    public String utest(HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest) {
        return "utest";
    }

    //就一个修改头像功能，修改密码都没有~~，更新头像之后还没删掉之前那个
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public JsonResult update(@RequestParam User user, HttpServletRequest httpServletRequest) {
       return userRmiService.upadate(user,httpServletRequest);
    }

    @RequestMapping(value = "/loginout",method = RequestMethod.GET)
    public String logout(){
        userRmiService.logout();
        return "home";
    }

    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public String admin() {return "admin";}

    @RequestMapping(value = "/signcode", method = RequestMethod.GET)
    public void service(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest)
    {
        try {
            userRmiService.service(httpServletResponse,httpServletRequest);
        } catch (ServletException | IOException e) {
            logger.info("生成验证码失败"+e.getMessage(),e);
        }
    }
}*/
