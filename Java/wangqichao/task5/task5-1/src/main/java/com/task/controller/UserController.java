package com.task.controller;

import com.task.models.User;
import com.task.models.UserToken;
import com.task.service.UserService;
import com.task.utils.*;
import javafx.scene.transform.ShearBuilder;
import org.apache.commons.lang.UnhandledException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * 关于用户的功能在此controller中
 * 注册，登陆，修改密码
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = Logger.getLogger(UserController.class);

    /**
     *登陆
     * @param username 用户输入的用户名
     * @param password 用户输入的密码
     * @return 返回对应的页面
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam String username, String password, HttpServletResponse response, HttpSession session) throws Exception {
        DESUtil desUtil=new DESUtil();
        try {
            //按照username将数据库中对应的数据取出来
            User user = userService.listByName(username);
            //hashKey1为存在数据库中的hashKey
            String hashKey1=user.getHashKey();
           // logger.info(hashKey1);
            String salt=user.getSalt();
            String str=password+salt;
            //hashKey2为输入密码结合数据库中盐重新加密得到的hashKey
            String hashKey2= EncryptionUtil.getSHA256Str(str);
            //logger.info(hashKey2);
            //将输入的密码得到的hashKey与之前存储的hashKey比对，正确就跳转到主页
            if (hashKey1.equals(hashKey2)) {
               //session.setAttribute("username",username);
                long currentTime=System.currentTimeMillis();
                user.setLoginTime(currentTime);
                userService.updateLoginTime(user);//这时候其实只有username和loginTime起作用
                UserToken userToken=new UserToken(username,currentTime);
                String token= JWTHelper.sign(userToken,5L*24L*3600L*1000L);//将userToken对象和允许期限生成token
                CookieUtil.addCookie(response,"token",token);//将token放进cookie中
               CookieUtil.addCookie(response,"username",username);
                return "redirect:/homepage";
            } else
                //错误就跳转到错误页面
                logger.error("输入密码不正确");
            return "errorLogin";
        }catch (Exception e){
            logger.error("用户不存在");
            logger.error(e.getMessage());
            return "errorLogin";
        }
    }

    //帮助login 页面跳转到注册页面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String goRegister() throws Exception {
        return "page05";
    }

    /**
     *注册信息，在此页面将成功的账户信息存入数据库并直接跳转至主页
     * @param username 用户注册的用户名
     * @param password 用户注册的密码
     * @param repassword 用户重复输入的密码
     * @return 按照输入的用户名和密码确定注册是否成功返回到
     * @throws Exception
     */
    @RequestMapping(value = "/doregister", method = RequestMethod.POST)
    public String doregister(@RequestParam String username, String password, String repassword,HttpServletResponse response) throws Exception {
        DESUtil desUtil=new DESUtil();
        User user;
        try {
            if ((!password.equals(repassword)) || !RegexUtil.usernameRegex(username)||!RegexUtil.passwordRegex(password)) {
                //如果两次密码输入不一致，或者输入密码为空则跳转到errorRigister页面
                logger.error("用户名，密码有误");
                return "errorRegister";
            } else {
                //因为设置了loginTime默认值是0，所以这里不需要带上loginTime
                user = new User(System.currentTimeMillis(), username, password);
                userService.justAdd(user);
            }
        } catch (Exception e) {
            logger.error("注册信息重复");
            //用户名重复则跳转到errorName页面
            return "errorName";
        }
        //没有报错就直接登陆首页
        long currentTime=System.currentTimeMillis();
        user.setLoginTime(currentTime);
        userService.updateLoginTime(user);//这时候其实只有username和loginTime起作用
        UserToken userToken=new UserToken(username,currentTime);
        String token= JWTHelper.sign(userToken,5L*24L*3600L*1000L);//将userToken对象和允许期限生成token
        CookieUtil.addCookie(response,"token",token);//将token放进cookie中
        CookieUtil.addCookie(response,"username",username);
        return "redirect:/homepage";
    }
    //帮助主页跳转到修改密码页面
    @RequestMapping(value = "/goPassword", method = RequestMethod.GET)
    public String goPassword() throws Exception {
        return "page04";
    }

    //修改密码,综合了登陆，注册和调用cookie的知识点
    @RequestMapping(value = "changePassword",method = RequestMethod.POST)
    public ModelAndView goPassword(@RequestParam String oldpassword, String password, String repassword, HttpServletResponse response, HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        try{
            //将cookie中的用户id取出来当作username
            String username=CookieUtil.getCookieValue(request,"username");
            //使用此用户名查找原密码
            User user=userService.listByName(username);
            String salt1=user.getSalt();
            String hashKey1=user.getHashKey();
            String str1=oldpassword+salt1;
            String hashKey2=EncryptionUtil.getSHA256Str(str1);
            //确定旧密码是否正确
            if (hashKey1.equals(hashKey2)){
                //原密码正确，判断两个新密码是否相等,且密码是否符合规范
                if(password.equals(repassword)&&RegexUtil.passwordRegex(password)){
                    //两个新密码相等，并且符合规范，将其储存并修改
                    user.setPassword(password);
                    user.setUpdatedAt(System.currentTimeMillis());
                    userService.justUpdate(user);
                    logger.info(username+"修改密码为"+password);
                    //因为cookie中只储存了未转化的username，所以此时不需要再对cookie进行操作
                    mav.setViewName("redirect:homepage");
                    return mav;
                }
               else {
                    //两次新密码不相等
                    mav.setViewName("errorChangePwd");
                    mav.addObject("errorMessage","请确认两次新密码必须相等且符合规范");
                    return mav;
                }
            }else {
                //原密码不正确
                mav.setViewName("errorChangePwd");
                mav.addObject("errorMessage","原密码错误，请确认后重新输入");
                return mav;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            mav.setViewName("errorChangePwd");
            mav.addObject("errorMessage","不知道为啥反正就是错了");
            return mav;
        }
    }

    //登出功能
    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    public String signOut(HttpServletResponse response,HttpServletRequest request) throws Exception {
        CookieUtil.delCookie(response,request,"username");
        CookieUtil.delCookie(response,request,"token");
        return "redirect:homepage";
    }
}
