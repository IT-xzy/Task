package com.Controller;

import com.Pojo.User;
import com.Tool.MD5Util;
import com.Tool.MemcachedUtils;
import com.service.UserService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class controller {
    private static Logger logger = Logger.getLogger(controller.class);
    @Resource
    private UserService userService;
    //登录界面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    //判断登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userId, String userPassword) throws Exception {
        long loginTime = System.currentTimeMillis();//登录时间为系统时间
        User user = userService.selectById(userId); //查看userId对应的用户的信息
        //存在这个用户时：
        if (user != null) {
            String password = MD5Util.stringToMD5(userPassword + "!!!abc");//输入的密码进行加密
            if (password.equals(user.getUserPassword())) {
                logger.info("登录成功");
                return "redirect:/form";
            } else {
                logger.info("输入密码错误");
                return "login";
            }
        }
        logger.info("输入账号错误");
        return "login";
    }
    //用户界面
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model) {
        List<User> userList = userService.selectAll();
        model.addAttribute("user", userList);
        return "form";
    }
    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String update(User user, Model model){
        user.setUpdate_at(new Date().getTime());
        userService.update(user);
        this.form(model);
        return "redirect:/form";
    }
  //信息界面
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public void message(String userTel) {
        userService.message(userTel);
    }
    //注册界面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject toRegister(@RequestParam(value = "verifyCode", required = false) String verifyCode, User user) {
        user.setCreate_at((new Date()).getTime());
        String userPassword = user.getUserPassword();
        String password = MD5Util.stringToMD5(userPassword + "!!!abc");
        user.setUserPassword(password);
        return this.userService.add(verifyCode, user);
    }
  //发送邮件
    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public String Mail() {
        return "mail";
    }
    @RequestMapping(value = "/user/userId/{userId}/profile", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("userId") String userId , Model model)
    {
        User user = userService.selectById(userId);
        model.addAttribute("update_user",user);
        return "update";
    }

    @RequestMapping(value = "/user/userId/{userId}/profileMail", method = RequestMethod.GET)
    public String toMail(@PathVariable("userId") String userId , Model model)
    {
        User user = userService.selectById(userId);
        model.addAttribute("mail",user);
        return "mail";
    }

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject toSendMail(@RequestParam String userMail, HttpServletRequest httpServletRequest,String userId) throws Exception {
        return this.userService.sendMail(userMail,httpServletRequest,userId);
    }
     //判断邮件链接
    @RequestMapping(value = "/sendMail/{userId}/{randomForMail}", method = RequestMethod.GET)
    @ResponseBody
    public boolean mail(@PathVariable(value = "randomForMail") String randomForMail ,@PathVariable(value = "userId") String userId) {
        logger.info("缓存中的数据"+MemcachedUtils.get(randomForMail));
        logger.info("用户的Id"+userId);
        User user=userService.selectById(userId);
        String mail = (String) MemcachedUtils.get(randomForMail);
        logger.info(mail);
        if (mail != null) {
            logger.info("邮箱验证通过" + mail);
            //获取对应的邮箱存入到表格中
            user.setUserMail(mail);
            this.userService.update(user);
            MemcachedUtils.delete(randomForMail);
            return true;
        }
        return false;
    }
}