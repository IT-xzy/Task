package com.task5.controller;

import com.aliyun.oss.OSSClient;
import com.task5.mapper.UserDao;
import com.task5.pojo.User;
import com.task5.service.UserService;
import com.task5.until.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    JWT jwt;
    @Autowired
    UserDao userDao;
    @Autowired
    AliyunOSSClientUntil aliyunOSSClientUntil;

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }
    @RequestMapping("/register")
    public String Register(){
        return "register";
    }
    @RequestMapping("/exit")
    public String Quit(HttpServletResponse response, HttpSession session){
        String token = jwt.generateToken(null,3600000);
        Cookie cookie = new Cookie("token",token);
        response.addCookie(cookie);
        cookie.setMaxAge(0);
        Cookie cookieSId = new Cookie("JSESSIONID",session.getId());
        response.addCookie(cookieSId);
        cookieSId.setMaxAge(0);
        session.removeAttribute("username");
        return "redirect:/home";
    }
    @RequestMapping(value = "/loginResult")
    public String Login(User user, Model model,HttpServletResponse response,HttpSession session) throws Exception {
        String message = userService.login(user);
        if (message.equals("true")) {
            String token = jwt.generateToken(user.getUserName(),3600000);
            session.setAttribute("username",user.getUserName());
            System.out.println(token);
            Cookie cookie = new Cookie("token",token);
            cookie.setMaxAge(5*60);
            response.addCookie(cookie);
            Cookie cookieSId = new Cookie("JSESSIONID",session.getId());
            cookieSId.setMaxAge(5*60);
            response.addCookie(cookieSId);
            System.out.println(cookie);
            return "redirect:/home";
        } else {
            model.addAttribute("message", message);
            return "login";
        }
    }

    @RequestMapping(value = "/registerResult", method = RequestMethod.POST)
    public String Register(User user, Model model) throws Exception {
        String message = userService.register(user);
        if (message.equals("true")) {
            model.addAttribute("message", "注册成功，请登录:");
            return "login";
        } else {
            model.addAttribute("message", message);
            return "register";
        }
    }

    @RequestMapping(value = "/checkPhone",method = RequestMethod.POST)
    @ResponseBody
    public String checkPhone(String phoneNumber){
        String result = "1";
        try {
            User user=userService.findUserByPhoneNumber(phoneNumber);
            if(user != null){
                System.out.println("手机号已存在");
                result = "0";
            }else{
                result = "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "/checkCode",method = RequestMethod.POST)
    @ResponseBody
    public String checkCode() throws Exception{
        String result = "1";
        try {
            /** 获取手动输入的手机短信验证码 */
            String SmsCheckCode = RequestContextHolderUtil.getRequest().getParameter("SmsCheckCode");
            System.out.println("前端:"+SmsCheckCode);
            /** 获取session中存放的手机短信验证码 */
//          String code = (String) RequestContextHolderUtil.getSession().getAttribute("code");
            String code = (String) MemcachedUtils.get("code");
            System.out.println("缓存:"+code);
//            if(SmsCheckCode == code){
            if(code.equals(SmsCheckCode)){
                result = "1";
            }else{
                result = "0";
            }
        } catch (Exception e) {
            throw new RuntimeException("短信验证失败", e);
        }
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "/sms",method = RequestMethod.POST)
    @ResponseBody
    public void sms(String phoneNumber,String code) throws Exception {
        SDKTestSendTemplateSMS.sendTemplateSMS(phoneNumber,code);
    }

    @RequestMapping(value = "/checkEmail",method = RequestMethod.POST)
    @ResponseBody
    public String checkEmail(String email){
        String result = "1";
        try {
            User user=userService.findUserByEmail(email);
            if(user != null){
                System.out.println("邮箱已存在");
                result = "0";
            }else{
                result = "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "/checkEmailCode",method = RequestMethod.POST)
    @ResponseBody
    public String checkEmailCode() throws Exception{
        String result = "1";
        try {
            String EmailCheckCode = RequestContextHolderUtil.getRequest().getParameter("EmailCheckCode");
            System.out.println("前端:"+EmailCheckCode);

            String emailCode = (String) MemcachedUtils.get("emailCode");
            System.out.println("缓存:"+emailCode);
            if(emailCode.equals(EmailCheckCode)){
                result = "1";
            }else{
                result = "0";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    @ResponseBody
    public void sendEmail(String email,String emailCode) throws Exception {
        SendCloud.send_common(email,emailCode);
        System.out.println(email+emailCode);
    }

   //用户信息
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(HttpSession session,Model model) throws Exception {
        String sessionName = (String) session.getAttribute("username");
        if (sessionName !=null) {
            User user = userDao.findUserByName(sessionName);
            model.addAttribute("user1",user);
        }else {
            model.addAttribute("message","用户未登录");
        }
        //返回用户信息页面
        return "user";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String findUser(@PathVariable("id")int id,Model model) throws Exception {
        User user = userDao.findUserById(id);
        System.out.println(user.getId());
        System.out.println(user);
        model.addAttribute("user",user);
        //返回修改页面
        return "update";
    }


    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public String upload(int id,@RequestParam(value = "upload")MultipartFile multipartFile,
                         HttpServletRequest request) throws Exception {
        System.out.println("id" + id);

        OSSClient ossClient = AliyunOSSClientUntil.getOSSClient();
        //图片上传到本地服务器。
        String root=aliyunOSSClientUntil.sendServer(multipartFile,request);
        //本地到第三方API
        File file=new File(root);
        //bucket名    自定义上传文件的名字，   文件在本地的具体路径，\ 用 \\代替
        if(file.getName().endsWith(".jpg")||file.getName().endsWith(".jpeg")
                || file.getName().endsWith(".bmp")|| file.getName().endsWith(".gif")
                || file.getName().endsWith(".png")){
            Map map = aliyunOSSClientUntil.uploadFile2OSS(ossClient, file);
            System.out.println("md5Key : " + map.get("md5Key"));
            String url = aliyunOSSClientUntil.getUrl(ossClient,(String) map.get("key"));

            User userTmp = userDao.findUserById(id);
            userTmp.setHeadURL(url);
            //删除服务器存放的图片
            file.delete();
            userDao.updateUser(userTmp);
        }
        return "redirect:/user";
    }
}
