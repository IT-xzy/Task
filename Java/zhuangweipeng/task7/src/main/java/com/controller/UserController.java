package com.controller;

import com.aliyun.oss.OSSClient;
import com.entity.Excellent_Stu;
import com.entity.User;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.service.Impl.UserServiceImpl;
import com.service.UserService;
import com.utils.AliUploadFile;

import com.utils.DesUtil;
import com.utils.QiniuUp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.UUID;


@Controller
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AliUploadFile aliUploadFile;
    private User user;


    //展示主页面
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String Index(@Param("name") String name, @Param("password") String password, Model model, HttpServletRequest request, HttpServletResponse response, User user)
            throws Exception {
        String loginToken = userService.saveToken(name);
        //保存Cookie
        System.out.println(loginToken);
        Cookie tokenCookie = new Cookie("loginToken", loginToken);
        tokenCookie.setMaxAge(30 * 60);
        System.out.println(loginToken);
        response.addCookie(tokenCookie);
        //保存到session中
        HttpSession loginSession = request.getSession();
        DesUtil desUtil = new DesUtil("Hello");
        loginSession.setAttribute("loginSession", desUtil.decrypt(loginToken));
        List<Excellent_Stu> excellent_stus = userService.getAll();
        List<Excellent_Stu> limit = userService.limit();
        model.addAttribute("userService", userService);
        //从优秀学员表中取出数据展示
        Excellent_Stu u = excellent_stus.get(1);
        //User user = new User();
        logger.info("User user = new User();user:" + user);
        //查询学习人数
        model.addAttribute("studynum", u.getStudynum());
        model.addAttribute("jobnum", u.getJobnum());
        model.addAttribute("limit", limit);
        model.addAttribute("name", user.getName());
        return "home";
    }

    //登录页面
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginIndex(@Param("name") String name, @Param("password") String password, Model model,
                             HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        logger.info("------进入login控制类------");

        if (userService.findUserByName(user.getName()) == null) {
            return "redirect:loginjsp/false.jsp";
        }
        boolean isUserEistence = userService.judgeUser(name, password);
        //验证用户名和密码，匹配登录成功
        //String login = null;
        if (isUserEistence) {
            return "home";
        }
        return "redirect:loginjsp/false.jsp";
    }

    //跳转后返回展示主页面
    @RequestMapping(value = "/home1", method = RequestMethod.GET)
    public String home(Model model) {
        //查询数据库优秀学员信息展示
        List<Excellent_Stu> excellent_stus = userService.getAll();
        List<Excellent_Stu> limit = userService.limit();
        model.addAttribute("userService", userService);
        //从优秀学员表中取出数据展示
        Excellent_Stu u = excellent_stus.get(1);
        //查询学习人数
        model.addAttribute("studynum", u.getStudynum());
        model.addAttribute("jobnum", u.getJobnum());
        model.addAttribute("limit", limit);
        return "home1";
    }

    //跳转手机注册页面
    @RequestMapping(value = "/phone", method = RequestMethod.GET)
    public String toResgisterPhone(Model model) {
        logger.info("\n跳转到手机注册页面");
        return "redirect:registerjsp/registerPhone.jsp";
    }


    //手机注册
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(User user, HttpServletRequest request, @Param("psd") String psd) throws Exception {
        logger.info("\n------register方法运行------" + user.toString());
        logger.info("前段传过来再次确认密码为：" + psd);
        logger.info("获取到的phone是：" + user.getPhone());
        //获得电话验证码
        String phone = user.getPhone();
        String code1 = (String) redisTemplate.opsForValue().get("phone" + phone);
        logger.info("\nget the Rediscode is " + code1);
        String code2 = request.getParameter("phonecode");
        logger.info("缓存中验证码为：" + code1);
        logger.info("前端传过来的验证码为：" + code2);
        //判断注册码是否相等，用户名、密码是否为空
        if (userService.finUserByPhone(phone) == null) {
            if (userService.findUserByName(user.getName()) == null && code1.equals(code2) && !user.getName().equals("")
                    && !user.getPassword().equals("") && user.getPassword().equals(psd)) {
                logger.info("\n\n\n判断成功，准备插入数据：" + "\n\n\n");
                userServiceImpl.addUser(user);
                return "redirect:registerjsp/success.jsp";
            } else {
                return "redirect:registerjsp/error.jsp";
            }
        }
        logger.info("该手机号码已经被注册，请请登录！");
        return "redirect:registerjsp/error.jsp";
    }

    //跳转邮箱注册页面
    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public String toResgisterEmail(Model model) {
        logger.info("\n跳转到邮箱注册页面");
        return "redirect:registerjsp/registerEmail.jsp";
    }

    //邮箱注册
    @RequestMapping(value = "/registrationEmail", method = RequestMethod.POST)
    public String registerEmail(User user, @Param("email") String email, @Param("emailcode") String emailcode,
                                @Param("psd") String psd, @Param("password") String password) {

        logger.info("\n进入邮箱注册页面\n");

        //获得邮箱验证码
        email = user.getEmail();
        logger.info("\nuser.getEmail:\n" + email);
        String name = user.getName();
        logger.info("\nuser.getName:\n" + name);
        //String password=user.getPassword();
        String emailcode1 = (String) redisTemplate.opsForValue().get("email" + email);
        logger.info("\nemailcode1:\n" + emailcode1);
        String emailcode2 = emailcode;
        logger.info("\nemailcode2:\n" + emailcode2);
        logger.info("\n密码:\n" + password);
        logger.info("\n再次输入密码:\n" + password);

        if (userService.findUserByEmail(email) == null) {
            logger.info("\n\n该邮箱没有被注册\n" + email);
            if (userService.findUserByName(name) == null && emailcode1.equals(emailcode2) && password.equals(psd)
                    /*&&password!=""&&name!=""&&password!=null&&name!=null*/) {
                logger.info("\n\n\n邮箱校验成功，准备插入数据：" + "\n\n\n");
                userServiceImpl.addUser(user);
                return "redirect:registerjsp/success.jsp";
            } else {
                logger.info("\n\n邮箱校验不成功" + email);
                return "redirect:registerjsp/error.jsp";
            }
        }
        logger.info("该邮箱已经被注册，请登录！");
        return "login";
    }

    //    登出页面
    @RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        //清除session
        session.invalidate();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginToken")) {
                //logger.info("Cookie" + cookie.getName());
                Cookie newCookie = new Cookie("loginToken", null); //假如要删除名称为username的Cookie
                newCookie.setMaxAge(0); //立即删除型
                newCookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
                response.addCookie(newCookie);//重新写入，将覆盖之前的Cookie
            }
        }
        return "redirect:/loginjsp/reLogin.jsp";
    }

    //阿里云上传照片
    @RequestMapping(value = "/photeUpload", method = RequestMethod.POST)
    public ModelAndView upLoadPhoto(@RequestParam("name") String name, @RequestParam("photoPath") MultipartFile photoPath,
                                    HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //阿里云相关配置
        String accessKeyId = "LTAI2TGWKVTWNgdn";
        String accessKeySecret = "wrYXWEhkr8MjnNZ1E2WJHthZvXRfAY";
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        ModelAndView mav = new ModelAndView();
        String showName = name;
        mav.addObject("showName", showName);
        if (userService.judgeUserExist(name)) {
            logger.info("\n数据库存在该用户，用户名为：" + name);

            if (!photoPath.isEmpty()) {
                //获得原来文件名称
                String origionFileName = photoPath.getOriginalFilename();
                InputStream s = photoPath.getInputStream();
                System.out.println("上传之前的名称：\n\n" + origionFileName);
                //随机生成上传图片名称
                String NewFileName = String.valueOf(UUID.randomUUID()) + origionFileName.substring(origionFileName.lastIndexOf("."));
                System.out.println("上传的名称为：\n\n" + NewFileName);

                // 创建OSSClient实例。
                OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
                String showUrl = "http://aliyunuploadphoto.oss-cn-shenzhen.aliyuncs.com/" + NewFileName;
                // 上传文件流。
                logger.info("\n\n取得文件流：" + s);
                ossClient.putObject("aliyunuploadphoto", NewFileName, s);
                String msg = "Upload Success!";
                mav.addObject("msg", msg);
                //将图片注入到jsp页面
                mav.addObject("showUrl", showUrl);

                System.out.println("地址为：" + showUrl);
                //将图片信息插入数据库
                userService.updateUserByName(NewFileName, name);
                // 关闭OSSClient。
                ossClient.shutdown();
                mav.setViewName("showUpLoadPhoto");
                return mav;
            }
            RequestDispatcher rd = request.getRequestDispatcher("/photoUD/aliyunphotoupload.jsp");
            rd.forward(request, response);
            mav.setViewName("photoUPError");
        }
        logger.info("\n数据库不存在该用户，请重新输入用户名！\n");
        return mav;
    }


    //待完善逻辑
    //七牛云图片上传
    @RequestMapping(value = "/upLoadQiNiu", method = RequestMethod.POST)
    public String upLoadQiNiu(HttpSession session, @RequestParam("photoPath1") MultipartFile photoPath1,
                              HttpServletRequest request) throws IOException {
        if (!photoPath1.isEmpty()) {
            //获得原来文件名称
            String origionFileName = photoPath1.getOriginalFilename();
            InputStream s = photoPath1.getInputStream();
            System.out.println("上传之前的名称：\n\n" + origionFileName);
            String NewFileName = String.valueOf(UUID.randomUUID()) + origionFileName.substring(origionFileName.lastIndexOf("."));
            System.out.println("上传的名称为：\n\n" + NewFileName);

            //构造一个带指定Zone对象的配置类
            Configuration cfg = new Configuration(Zone.zone0());
            //...其他参数参考类注释
            UploadManager uploadManager = new UploadManager(cfg);
            //...生成上传凭证，然后准备上传
            String accessKey = "AurBmugKh-bh6pq9YoprSEHmwAOA3e0ldPaA6duj";
            String secretKey = "xLe6PDzwdmza5zYqCqXSue6xDZ26qeH47xYoXv74";
            String bucket = "zwposs";
            //如果是Windows情况下，格式是 D:\\qiniu\\test.png
            String localFilePath = "C:\\Users\\Administrator\\Desktop\\QQ图片20180910161443.png";
            //默认不指定key的情况下，以文件内容的hash值作为文件名
            String key = null;
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(localFilePath, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
            return "redirect:/photoUD/showUpLoadPhoto.jsp";
        }
        return "redirect:/photoUD/photoUPError.jsp";
    }

    //根据用户查看相对应图片
    @RequestMapping(value = "/findNameByPhoto", method = RequestMethod.POST)
    public ModelAndView findNameByPhoto(@RequestParam("name") String name) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        logger.info("\n 根据用户查看相对应图片，用户为=:" + name);
        //查询存在数据库的photo值
        String photo = userService.findPhotoByName(name);
        //阿里云Url前缀
        String aLiYunUrl = "http://aliyunuploadphoto.oss-cn-shenzhen.aliyuncs.com/";
        //七牛云Url前缀
        String qiNiuUrl = "http://pe94m5liz.bkt.clouddn.com/";
        String showName = name;
        modelAndView.addObject("showName", showName);
        if (String.valueOf(name).isEmpty()) {
            logger.info("\n controller:通过用户名查询：用户名为空");
        } else {
            List<String> list = aliUploadFile.fileList();
            logger.info("\n控制类中根据用户查看相对应图片遍历出list集合数据：" + list);

            //list.contains(o)
            //String finalUrl = null;
            //String i=  finalUrl.substring(finalUrl.lastIndexOf("/")+1);
            if (list.contains(photo)) {
                logger.info("\n进入阿里云判断是否存在对应数据");
                logger.info("\n阿里云存在相对应数据\n");
                modelAndView.addObject("showUrl", aLiYunUrl + photo);
                modelAndView.setViewName("findPhotoByName");
            } else {
                logger.info("\n进入七牛云判断是否存在对应数据");
                logger.info("\n七牛云存在相对应数据\n");
                modelAndView.addObject("showUrl", qiNiuUrl + photo);

                modelAndView.setViewName("findPhotoByName");
            }
        }
        return modelAndView;
    }


    //阿里迁移到七牛
    @RequestMapping(value = "/ALiToQiNiu", method = RequestMethod.GET)
    public String aLiToQiNiu(Model model) {
        logger.info("\n\n进入阿里云迁移到七牛云方法中");
        AliUploadFile aliUploadFile = new AliUploadFile();
        aliUploadFile.transfer();
        logger.info("\n\n阿里云迁移到七牛云迁移成功");
        return "redirect:photoUD/photoUPSuccsess.jsp";
    }

    //七牛迁移到阿里
    @RequestMapping(value = "/QiNiuToALi", method = RequestMethod.GET)
    public String qiNiuToALi(Model model) throws IOException {
        logger.info("\n\n七牛云进入迁移到阿里云方法中");
        QiniuUp qiniuUp = new QiniuUp();
        qiniuUp.transfer();
        logger.info("\n\n七牛云进入迁移到阿里云迁移成功");
        return "redirect:photoUD/photoUPSuccsess.jsp";
    }

}