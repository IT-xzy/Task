package com.suger.controller;

import com.suger.pojo.User;
import com.suger.service.UploadService;
import com.suger.service.UserService;
import com.suger.service.impl.UserServiceImpl;
import com.suger.util.*;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author suger
 * @date 2018/11/20 14:53
 *
 * 用户的注册，登录与注销，验证
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UploadService uploadService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    SMS sms;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    /**
     * 跳转个人主页
     * @param user 获取用户信息
     * @param request
     * @return  在个人主页展示
     */
    @RequestMapping(value = "/u/user/{name}")
    public ModelAndView userPage(@PathVariable(value = "name") String name,HttpServletRequest request){
        ModelAndView mav = new ModelAndView("userPage");
        User userInfo = userService.getUserByName(name);
        mav.addObject("user",userInfo);
        mav.addObject("img",userInfo.getImg());
        return mav;
    }

    /**
     *  获取数据库中的头像
     * @param name
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/u/user/img/")
    public String userImg(String name, HttpServletRequest request,Model model){
        // 由于视图解析器需要处理，目前直接返回json
        User userInfo = userService.getUserByName(name);
        String imgURL = userInfo.getImg();
        model.addAttribute("userImg",imgURL);
        //return  "/loayout/header";
        return imgURL;
    }



    // 跳转登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }

    // 准备登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String name, String pwd,Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session){

        logger.info("登录信息,name:{},pwd:{}",name,pwd);

        User userInfo = null;

        // 输入的是邮箱
        if(name.contains("@")){
            logger.info("邮箱登录：{}",name);
            userInfo = userService.getUserByEmail(name);
            logger.info("-------1------------userInfo：" + userInfo);
        }else
        // 输入的是11位手机号
        if(name.length()==11&&StringUtils.isNumeric(name)){
            logger.info("手机号登录：{}",name);
            userInfo = userService.getUserByphone(name);
            logger.info("--------2---------------------userInfo：" + userInfo);

        }else if(!name.isEmpty()){
            logger.info("用户名登录：{}",name);
            userInfo = userService.getUserByName(name);
            logger.info("---------3---------------------userInfo：" + userInfo);
        }


        logger.info("userInfo：" + userInfo);

        if(userInfo == null){
            model.addAttribute("message","用户不存在");
            logger.info("账号不存在");
            return "login";
        }
        // 参数检验通过,开始登陆
        // 采用 UUID 为盐值
        String salt = userInfo.getSalt();
        logger.info("盐值："+salt);
        // md5 加密
        String password = MD5Utils.md5(pwd+salt);
        logger.info("加盐后的密码："+password);
        logger.info("数据库的密码："+userInfo.getPwd());



        // 判空以及验证密码
        if(userInfo.getPwd() == null || userInfo.getPwd().isEmpty() || !userInfo.getPwd().equals(password)) {
            model.addAttribute("message","密码输入有误，请重新输入");
            logger.info("密码输入有误，请重新输入");
            return "login";
        }else{
            logger.info(name+":登录成功");
            // 实例化 jwt ,可以设置自己的加密密码---字符串形式
            JwtUtils jwtUtils = new JwtUtils();

            // 用户名加密后 和时间戳一起写入token
            String username = DesUtils.encode(userInfo.getName());
            // 1小时后token过期
            long maxAge = 60L * 60L * 1000L;
            String token = jwtUtils.getToken(username, maxAge);

            Cookie cookie = new Cookie("token", token);
            logger.info("token = " + token);

            // 1天过期
            cookie.setMaxAge(24*60*60);
            cookie.setPath("/");
            response.addCookie(cookie);

            session.setAttribute("name",userInfo.getName());
            session.setAttribute("img",userInfo.getImg());
            // 60分钟
            session.setMaxInactiveInterval(60*60);

            return "redirect:/home";

        }

    }

   /* @RequestMapping(value="/validateCode")
    public String validateCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        ValidateCode vCode = new ValidateCode(120,40,5,100);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        return null;
    }*/

    /**
     * 发送邮箱验证码
     * @param email
     * @return  发送成功（状态为0），发送失败(状态为1），默认发送失败
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/user/email",method = RequestMethod.POST,produces = "text/xml;charset=UTF-8")
    public String emailCode(String email) throws IOException {
        logger.info("使用邮箱{}注册：",email);
        //生成随机验证码
        //String msgCode = DataUtils.getNumber(6);
        // 为测试方便 验证码固定为111111
        String msgCode = "111111";
        logger.info("验证码："+msgCode);
        int status = userService.sendEmai(email,msgCode);
        logger.info("email-status:{}",status);
        String message = "请稍后再试";
        if(status == 0){
            message = "验证码发送成功";
        }
        return message;
    }

    /**
     * 发送手机验证码
     * @param phone
     * @return  0：发送成功 2:发送过于频繁 3：超过每天最大次数 1：其他
     */
    @ResponseBody
    @RequestMapping(value = "/user/phone",method = RequestMethod.POST,produces = "text/xml;charset=UTF-8")
    public String phoneCode(String phone) {
        logger.info("使用手机号:{}注册",phone);
        // String msgCode = DataUtils.getNumber(6);
        // 为测试方便 验证码固定为111111
        String msgCode = "111111";
        logger.info("验证码："+msgCode);
        int status = userService.sendPhone(phone,msgCode);
        logger.info("phone-status:{}",status);
        String message = null;
        if(status == 0){
            message = "验证码发送成功";
        }
        if(status == 1){
            message = "请稍后再试";
        }
        if(status == 2){
            message = "发送过于频繁";
        }
        if(status == 3){
            message = "超过每天最大次数";
        }
        logger.info("手机验证码的信息:{}",message);
        return message;
    }



    // 跳转注册页面
    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public String goReg(){
        return "/reg";
    }

    // 进入注册页面
    @RequestMapping(value = "/reg/phone",method = RequestMethod.POST)
    public ModelAndView regPhone(User user,String msgCode, ModelAndView mav,HttpServletRequest request, HttpServletResponse response){
        String name = user.getName();
        String password = user.getPwd();
        String phone = user.getPhone();
        logger.info("name:{},phone:{},msgCode(验证码）:{}",name,phone,msgCode);

        // 此处写参数检验
        mav.setViewName("/reg");
        if(StringUtils.isBlank(name)|| StringUtils.isBlank(password)|| StringUtils.isBlank(phone)){
            mav.addObject("message","注册信息不能为空");
            mav.addObject("code",1);
            return mav;
        }

        if(userService.getUserByName(name)!=null){
            mav.addObject("message","用户名已经存在");
            mav.addObject("code",2);
            return mav;
        }
        if(userService.getUserByphone(phone)!=null){
            mav.addObject("message","手机号已经被注册");
            mav.addObject("code",2);
            return mav;
        }
        logger.info("注册信息检查："+mav.getModel());


        // 用户信息检查完毕，可以注册
        if(msgCode==null){
            mav.addObject("message","请输入验证码");
            return mav;
        }
        // 检验手机号的验证码，msgcode 是用户输入的验证码
        if(userService.checkPhoneCode(phone,msgCode)==0){
            // 手机号的验证码 检验成功，进行注册
            // 密码加密
            String salt = UUIDUtils.getUUID();
            logger.info("盐值："+salt);
            user.setSalt(salt);
            password = MD5Utils.md5(user.getPwd()+salt);
            user.setPwd(password);

            userService.insertUser(user);
            mav.setViewName("redirect:/login");
            return mav;
        }else{
            mav.addObject("message","验证码错误");
            return mav;
        }
    }

    @RequestMapping(value = "/reg/email",method = RequestMethod.POST)
    public ModelAndView regEmail(User user, ModelAndView mav,String msgCode,HttpServletRequest request, HttpServletResponse response){


        String name = user.getName();
        String password = user.getPwd();
        String email =user.getEmail();

        logger.info("name:{},email:{},msgCode(验证码）:{}",name,email,msgCode);
        // 判定输入用户名，密码，邮箱，是否为空，若其中一项为空，则返回注册页面
        // 此处写参数检验
        if(StringUtils.isBlank(name)|| StringUtils.isBlank(password)|| StringUtils.isBlank(email)){
            mav.addObject("message","注册信息不能为空");
            mav.addObject("code",1);
            mav.setViewName("/reg");
            return mav;
        }
        // 检验用户名以及邮箱的唯一性，若不唯一,说明已经注册过，则跳转登录页面
        if(userService.getUserByName(name)!=null || userService.getUserByEmail(email) != null){
            logger.info("用户已经存在！");
            mav.addObject("message","用户名已存在,");
            mav.addObject("code",2);
            mav.setViewName("redirect:/login");
            return mav;
        }

        // 注意默认 0 是正确的，这个之前写反了，
        if(userService.checkEmailCode(email,msgCode)==1){
            mav.addObject("message","验证码错误");
            mav.addObject("code",3);
            mav.setViewName("/reg");
            return mav;
        }

        // 检验通过，开始注册
        String salt = UUIDUtils.getUUID();
        logger.info("盐值："+salt);
        user.setSalt(salt);
        password = MD5Utils.md5(user.getPwd()+salt);
        user.setPwd(password);
        logger.info(user.toString());


        userService.insertUser(user);
        mav.addObject("message","注册成功");
        mav.setViewName("redirect:/login");
        return mav;
    }


    @RequestMapping("/u/upload/{name}")
    @ResponseBody
    public String upload(MultipartFile multipartFile, @PathVariable String name, HttpServletRequest request,HttpSession session)throws Exception {
        logger.info("上传修改用户的头像信息");
        // COSUtils cosUtils = new COSUtils();
        String imgURL = uploadService.aliyunUploadFile(multipartFile);
        logger.info("图片的对象存储链接地址：{}", imgURL);
        User user = userService.getUserByName(name);
        user.setImg(imgURL);
        logger.info("user:{}", user.toString());
        if (imgURL != null && imgURL.length() > 0) {
            userService.updateUser(user);
            // 更新session值
            session.setAttribute("img",user.getImg());
        }
        return imgURL;
    }

    /**
     * 从阿里对象存储oss获取头像
     */
    /*@RequestMapping("/u/img")
    public void getHeadImg(String key, HttpServletResponse response) throws IOException {
        logger.info("获取用户的头像信息");*/
       /* COSUtils cosUtils = new COSUtils();

        AliyunOSSClientUtil ossClientUtil1 = new AliyunOSSClientUtil();
        //重置response
        response.reset();
        //设置contenttype
        response.setContentType("image/jpeg");
        InputStream inputStream = null;
        try {
            inputStream = ossClientUtil1.getFile(key);
            //inputStream = cosUtils.getFile(key);
        }catch (Exception e){
            logger.warn("从阿里云获取头像输出流发生异常，失败");
            e.printStackTrace();
        }

        //输入缓冲流
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        //得到输出流
        OutputStream outputStream = response.getOutputStream();
        //输出缓冲流
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        // 缓冲字节数
        byte data[] = new byte[4096];
        int size = bis.read(data);
        while (size != -1) {
            bos.write(data, 0, size);
            size = bis.read(data);
        }
        inputStream.close();
        bis.close();
        bos.flush();
        bos.close();
        outputStream.close();
        ossClientUtil1.destory();*/

    //-----------------注销---------------------------
    @RequestMapping(value = "/u/logout",method = RequestMethod.GET)
    public String logout(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        // 删除session
        session.invalidate();
        logger.info("注销------");

        Cookie[] cookies = request.getCookies();
        // setMaxAge(0)------删除Cookie失效----------默认 setMaxAge(-1) ,关闭浏览器删除Cookie
        if(cookies==null){
            return  "redirect:/home";
        }

        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName()) || "JSESSIONID".equals(cookie.getName())) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                logger.info("清除token和session");
            }
        }
        logger.info("退出登录");
        return  "redirect:/home";
    }

}
