package com.zyq.controller;

import com.qcloud.cos.model.COSObjectInputStream;
import com.zyq.pojo.ExcellentStudent;
import com.zyq.pojo.User;
import com.zyq.service.ExcellentStudentService;
import com.zyq.service.UserService;
import com.zyq.util.*;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    private static Logger logger = LogManager.getLogger(StudentController.class);

    @Autowired
    UserService userService;
    @Autowired
    ExcellentStudentService excellentStudentService;
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String Resister(User user, Model model){
        logger.info("这是注册用户。。。。。。。。。。。");
        logger.info("原始密码为："+user.getPassword());
        String salt = UUIDUtil.getSalt();
        logger.info("盐值为："+salt);
        user.setSalt(salt);
        String password = MD5Util.encoder(user.getPassword(),salt);
        logger.info("加盐加密后密码为："+password);
        user.setPassword(password);
        user.setHeadPhoto("/task7/user/headPhoto/default.png");
        userService.insert(user);
        model.addAttribute("item","loginBody");
        model.addAttribute("msg","注册成功，请登录");
        return "myView";
    }

    @RequestMapping(value = "/User",method = RequestMethod.POST)
    public String Login(User user, Model model, HttpSession session, HttpServletResponse response) {
        logger.info("这是用户登录。。。。。。。。。。。。。。。");
        User user1 = null;
        if (user.getUsername()!=null&&user.getUsername().length()>0){
            user1 = userService.selectByUserName(user.getUsername());
        }
        if (user.getTelephone()!=null&&user.getTelephone().length()>0){
            logger.info(user.getTelephone());
            user1 = userService.selectByTel(user.getTelephone());
        }
        logger.info(user);
        if (user.getEmail()!=null&&user.getEmail().length()>0){
            user1 = userService.selectByEmail(user.getEmail());
        }

        logger.info(user1);
        if (user1==null){
            model.addAttribute("msg", "账号、手机或者邮箱未注册");
            model.addAttribute("item", "loginBody");
            logger.info("账号、手机号或者邮箱未注册。。。。。。。。。。。。");
            return "myView";
        }else if (user1.getSalt() == null || user1.getSalt().length() <= 0){
            logger.info("这类用户注册过早，没有加密加盐，密码容易泄露。");
            if (user1.getPassword() == null || user1.getPassword().length() <= 0 || !(user1.getPassword()).equals(user.getPassword())) {
                logger.info("用户名、手机号或者邮箱与密码不匹配");
                model.addAttribute("msg", "用户名、手机号或者邮箱与密码不匹配");
                model.addAttribute("item", "loginBody");
                return "myView";
            }
        } else {
            logger.info("这类用户密码加盐加密，比较安全。");
            logger.info("原始密码为：" + user.getPassword());
            logger.info("盐值为：" + user1.getSalt());
            String password = MD5Util.encoder(user.getPassword(), user1.getSalt());
            logger.info("加密加盐后密码为：" + password);
            logger.info("数据库存储的密码为：" + user1.getPassword());
            if (user1.getPassword() == null || user.getPassword().length() <= 0 || !(user1.getPassword()).equals(password)) {
                logger.info("用户名、手机号或者邮箱与密码不匹配");
                model.addAttribute("msg", "用户名、手机号或者邮箱与密码不匹配");
                model.addAttribute("item", "loginBody");
                return "myView";
            }
        }
        logger.info(user1.getUsername()+":恭喜您登录成功。");
        List<ExcellentStudent> list = excellentStudentService.selectByOrder();
        String idPWD = DESUtil.encode(user1.getId().toString());
        String token = JwtToken.sign(idPWD, 30L * 60L * 1000L);
        Cookie cookie1 = new Cookie("token", token);
        cookie1.setHttpOnly(true);
        cookie1.setMaxAge(30*60);
        String sessionId = session.getId();
        Cookie cookie2 =new Cookie("SESSION",sessionId);
        cookie2.setHttpOnly(true);
        cookie2.setMaxAge(30*60);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        model.addAttribute("list", list);
        model.addAttribute("item", "indexBody");
        session.setAttribute("username", user1.getUsername());
        logger.info(user1);
        logger.info(user1.getHeadPhoto());
        session.setAttribute("headPhoto",user1.getHeadPhoto());
        return "myView";
    }

    @RequestMapping(value = "/exit")
    public String Exit(Model model, HttpSession session, HttpServletRequest request,HttpServletResponse response){
        model.addAttribute("item","indexBody");
        session.removeAttribute("username");
        session.removeAttribute("headPhoto");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("token")){
                cookie.setValue("");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }else if (cookie.getName().equals("SESSION")){
                cookie.setValue("");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        logger.info("退出成功。。。。。。。。。。");
        List<ExcellentStudent> list = excellentStudentService.selectByOrder();
        model.addAttribute("list", list);
        return "myView";
    }

    //通过用户名展示用户信息
    @RequestMapping(value = "/u/user/{username}",method = RequestMethod.GET)
    public String getUser(@PathVariable String username,Model model){
        logger.info("通过用户名查询用户信息了。。。。。");
        User user = userService.selectByUserName(username);
        model.addAttribute("user",user);
        model.addAttribute("item", "userViewBody");
        return "myView";
    }

    //修改用户信息
    @RequestMapping(value = "/u/user/{username}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable String username,User user,HttpSession session){
        userService.updateByUsername(username,user);
        User user1 = userService.selectByUserName(username);
        session.setAttribute("headPhoto",user1.getHeadPhoto());
        try {
            return "redirect:/u/user/"+ URLEncoder.encode(username,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.info("中文转换错误");
            return null;
        }
    }

//    @RequestMapping("/u/upload/{username}")
//    @ResponseBody
//    public Object upload(@RequestParam("multipartFile") MultipartFile multipartFile,@PathVariable String username, HttpServletRequest request)throws Exception{
//        logger.info("上传修改用户的头像信息");
//        COSClientUtil cosClientUtil = new COSClientUtil();
//        String path = request.getSession().getServletContext().getRealPath("/headPhoto/upload/");
//        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
//        String fileName = "test."+suffix;
//        File file = new File(path,fileName);
//        if(!file.exists()){
//            file.mkdirs();
//        }
//        multipartFile.transferTo(file);
//
//        Thumbnails.of(new File(path).listFiles()).
//                //scalingMode(ScalingMode.BICUBIC).
//                        scale(0.8). // 图片缩放80%, 不能和size()一起使用
//                toFiles(new File(path), Rename.SUFFIX_HYPHEN_THUMBNAIL);
//
//        File localFile = new File(path+"test-thumbnail."+suffix);
//        String etag=null;
//        try {
//            etag = cosClientUtil.uploadFile("/task7/user/headPhoto/"+username+".jpg",localFile);
//        }catch (Exception e){
//            logger.info("上传头像至腾讯cos发生异常，失败");
//            e.printStackTrace();
//        }
//        file.delete();
//        localFile.delete();
//        cosClientUtil.destory();
//        if (etag!=null&&etag.length()>0){
//            return "0";
//        }
//        return 1;
//    }

    @RequestMapping("/u/upload/{username}")
    @ResponseBody
    public Object upload(@RequestParam("multipartFile") MultipartFile multipartFile,@PathVariable String username, HttpServletRequest request)throws Exception{
        logger.info("上传修改用户的头像信息");
        OSSClientUtil ossClientUtil = new OSSClientUtil();
        String path = request.getSession().getServletContext().getRealPath("/headPhoto/upload/");
        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
        String fileName = "test."+suffix;
        File file = new File(path,fileName);
        if(!file.exists()){
            file.mkdirs();
        }
        multipartFile.transferTo(file);

        Thumbnails.of(new File(path).listFiles()).
                //scalingMode(ScalingMode.BICUBIC).
                        scale(0.8). // 图片缩放80%, 不能和size()一起使用
                toFiles(new File(path), Rename.SUFFIX_HYPHEN_THUMBNAIL);

        File localFile = new File(path+"test-thumbnail."+suffix);
        String etag=null;
        try {
            etag = ossClientUtil.uploadFile("task7/user/headPhoto/"+username+".jpg",localFile);
        }catch (Exception e){
            logger.info("上传头像至腾讯cos发生异常，失败");
            e.printStackTrace();
        }
        file.delete();
        localFile.delete();
        ossClientUtil.destory();
        if (etag!=null&&etag.length()>0){
            return "0";
        }
        return 1;
    }

    //从腾讯对象存储cos获取头像
//    @RequestMapping("/u/headPhoto")
//    public void getHeadPhoto(String key, HttpServletResponse response) throws IOException {
//        logger.info("获取用户的头像信息");
//        COSClientUtil cosClientUtil = new COSClientUtil();
//        //重置response
//        response.reset();
//        //设置contenttype
//        response.setContentType("image/jpeg");
//        COSObjectInputStream cosObjectInputStream = null;
//        try {
//            cosObjectInputStream = cosClientUtil.getFile(key);
//        }catch (Exception e){
//            logger.info("从腾讯cos获取头像输出流发生异常，失败");
//            e.printStackTrace();
//        }
//
//        //输入缓冲流
//        BufferedInputStream bis = new BufferedInputStream(cosObjectInputStream);
//        //得到输出流
//        OutputStream outputStream = response.getOutputStream();
//        //输出缓冲流
//        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
//        // 缓冲字节数
//        byte data[] = new byte[4096];
//        int size = bis.read(data);
//        while (size != -1) {
//            bos.write(data, 0, size);
//            size = bis.read(data);
//        }
//        cosObjectInputStream.close();
//        bis.close();
//        bos.flush();
//        bos.close();
//        outputStream.close();
//        cosClientUtil.destory();
//    }

//    从阿里对象存储oss获取头像
    @RequestMapping("/u/headPhoto")
    public void getHeadPhoto(String key, HttpServletResponse response) throws IOException {
        logger.info("获取用户的头像信息");
        OSSClientUtil ossClientUtil = new OSSClientUtil();
        //重置response
        response.reset();
        //设置contenttype
        response.setContentType("image/jpeg");
        InputStream inputStream = null;
        try {
            inputStream = ossClientUtil.getFile(key);
        }catch (Exception e){
            logger.info("从腾讯cos获取头像输出流发生异常，失败");
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
        ossClientUtil.destory();
    }

    //验证账号是否已注册（存在）
    @ResponseBody
    @RequestMapping(value = "/user/{username}",method = RequestMethod.GET)
    public String getByUserName(@PathVariable String username){
        String password = userService.selectPwdByUserName(username);
        if(password!=null&&password.length()>0){
            logger.info("该账号已存在。。。。。。。。。。。。");
            return "0";
        }else {
            logger.info("该账号可用，请输入密码");
            return "1";
        }
    }

//    验证手机号是否已注册
    @ResponseBody
    @RequestMapping(value = "/user/telUnique/{telephone}",method = RequestMethod.GET)
    public String getByTelephone(@PathVariable String telephone){
        String password = userService.selectPwdByTelephone(telephone);
        if(password!=null&&password.length()>0){
            logger.info("该手机号已存在。。。。。。。。。。。。");
            return "0";
        }else {
            logger.info("该手机号可用，可以注册");
            return "1";
        }
    }

    //    验证邮箱是否已注册
    @ResponseBody
    @RequestMapping(value = "/user/{email}/emailUnique",method = RequestMethod.GET)
    public String getByEmail(@PathVariable String email){
        String password = userService.selectPwdByEmail(email);
        if(password!=null&&password.length()>0){
            logger.info("该邮箱已存在。。。。。。。。。。。。");
            return "0";
        }else {
            logger.info("该邮箱可用，可以注册");
            return "1";
        }
    }


//    发送手机验证码
    @ResponseBody
    @RequestMapping(value = "/user/tel/{telephone}",method = RequestMethod.GET)
    public String SendTelMsg(@PathVariable String telephone){
        logger.info(telephone);
        return userService.SendTelMsg(telephone);
    }

//    发送邮箱验证码
    @ResponseBody
    @RequestMapping(value = "/user/{email}/email",method = RequestMethod.GET)
    public String SendEmailMsg(@PathVariable String email){
        logger.info(email);
        return userService.SendEmailMsg(email);
    }

//    验证手机验证码是否正确
    @ResponseBody
    @RequestMapping(value = "/user/verifyMsg/tel/{telephone}/{message}",method = RequestMethod.GET)
    public String verifyTelMsg(@PathVariable String telephone,@PathVariable String message){
        logger.info(telephone+message);
        return userService.verifyTelMsg(telephone,message);
    }

//    验证邮箱验证码是否正确
    @ResponseBody
    @RequestMapping(value = "/user/verifyMsg/email/{email}/{message}",method = RequestMethod.GET)
    public String verifyEmailMsg(@PathVariable String email,@PathVariable String message){
        logger.info(email+message);
        return userService.verifyEmailMsg(email,message);
    }


}
