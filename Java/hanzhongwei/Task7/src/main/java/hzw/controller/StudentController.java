package hzw.controller;

import com.aliyuncs.exceptions.ClientException;
import hzw.model.Student;
import hzw.model.User;
import hzw.service.StudentService;
import hzw.util.*;
import org.apache.commons.codec.binary.Base64;
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
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    SMSUtil smsUtil;
    @Autowired
    SendMailSDK sendMailSDK;
    @Autowired
    AliyunOSSAPI aliyunOSSAPI;

    private static final String skey = "zhongwei";
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String student(Model model){
        logger.info("进入学员展示页");
        List<Student> list = studentService.findListStudent();
        model.addAttribute("student",list);
        return "index";
    }

    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public String addStudent(Student student){
        logger.info("进入添加"+student);
        studentService.insertStudent(student);
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/{sId}",method = RequestMethod.DELETE)
    public String deleteStudent(Student student){
        logger.info("删除信息"+student);
        studentService.deleteStudent(student.getsId());
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/{sId}",method = RequestMethod.POST)
    public String updateStudent(Student student, Model model){
        logger.info("跟新信息"+student);
        studentService.updateStudent(student);
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/insert/{sId}",method = RequestMethod.GET)
    public String getIdStudent(Student student, Model model){
        logger.info("查询信息"+student);
        student = studentService.getID(student.getsId());
        model.addAttribute("s",student);
        return "updateStudent";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user){
        logger.info("进入注册页");
        logger.info("前台传进来的信息："+user.toString());
        User u =  studentService.findNameUser(user.getUserName());
        if (u != null){
            logger.info("已经存在用户");
            return "registerError";
        }else {
            logger.info("开始注册");
            //以用户名为盐
            String salt = user.getUserName();
            //对密码加盐和md5加密
            String passwordMD5 = MD5Util.stringToMD5(user.getPassword()+salt);
            logger.info("加盐加密后的密码："+passwordMD5);
            user.setPassword(passwordMD5);
            studentService.insertUser(user);
            logger.info("注册的信息是："+user);
            return "login";
        }

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("进入登陆页");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        logger.info("前台传进来的登录账号："+userName+",密码："+password);
        //对密码加盐加密，然后和数据库里的比较
        String passwordMD5 = MD5Util.stringToMD5(password+userName);
        logger.info("加盐加密后的密码："+passwordMD5);
        User user = studentService.findNameUser(userName);
        logger.info("根据用户名查询数据库"+user);
        if (user != null && (user.getUserName()).equals(userName) && (user.getPassword()).equals(passwordMD5)) {
            logger.info("登录成功");
            Long id = user.getUserId();
            // 使用用户ID+系统当前时间生成唯一token, 格式为键值对
            String token = id + "|" + id + "|" + System.currentTimeMillis();
            logger.info("生成的token是:"+token);
            // 用DES加密key 必须8位
            byte[] bytes = DESUtil.encrypt(token,skey);
            logger.info("加密后的token: " + DESUtil.toHexString(bytes).toUpperCase());
            logger.info("加密后的Base64 token: " + Base64.encodeBase64String(bytes));
            //org.apache.commons.codec.binary.Base64;依赖包
            Cookie cookie = new Cookie("token",Base64.encodeBase64String(bytes));
            // 设置 Cookie 过期时间 单位为秒
            cookie.setMaxAge(7000);
            // 设置 Cookie 有效路径
            cookie.setPath("/");
            logger.info("新生成的Cookie-效时间-值: " + cookie.getName() + "-->" + cookie.getMaxAge() + "-->" + cookie.getValue() + cookie.getPath());
            response.addCookie(cookie);
            return "redirect:student";
        }else {
            logger.info("登录失败");
            return "login";
        }
    }

    @RequestMapping(value = "/iphoneLogin",method = RequestMethod.POST)
    public String iphoneLogin(HttpServletRequest request, HttpServletResponse response){
        logger.info("进入手机登录页");
        String userIphone = request.getParameter("userIphone");
        String Code = request.getParameter("code");
        User user = studentService.findIphone(userIphone);
        if (user != null && Code.equals(user.getUserCode())){
                return "redirect:/student";
        }
        return "login";
    }

    @RequestMapping(value = "/SMS",method = RequestMethod.POST)
    @ResponseBody
    public Boolean SMS(String userIphone,HttpServletRequest request) throws ClientException {
        logger.info("接受的号码为： "+userIphone);
        User user = studentService.findIphone(userIphone);
        if (user != null) {
            String userCode = RandNum.getRandLength(6);
            logger.info("userCode======="+userCode);
            user.setUserCode(userCode);
            studentService.updateUser(user);
            boolean flag = smsUtil.SMSclient(userIphone, userCode);
            logger.info("返回值"+flag);
            return flag;
        }else {
            return false;
        }
    }

    //登录
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String main(){
        return "login";
    }

    //注册
    @RequestMapping(value = "/main2",method = RequestMethod.GET)
    public String main2(){
        return "register";
    }

    //手机登陆
    @RequestMapping(value = "/main1",method = RequestMethod.GET)
    public String main1() {
        return "iphoneLogin";
    }

    //用户展示页
    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public String user(Model model,User user){
        User user1 = studentService.findIdUser(user.getUserId());
        model.addAttribute("u",user1);
        return "user";
    }

    //邮箱点击验证部分
    @RequestMapping(value = "/sendMail",method = RequestMethod.POST)
    @ResponseBody
    public Boolean sendMail(HttpServletRequest request,User user){
        String url = String.valueOf(request.getRequestURL());
        logger.info(url);
        String httpUrl = url.split("/sendMail")[0] + "/verifyMail";
        logger.info("访问项目网址为: " + httpUrl);
//        String httpUrl = request.getRequestURI().toString().split("/sendMail")[0] + "/verifyMail";
//        logger.info("访问项目网址为: " + httpUrl);
        String randInt = RandNum.getRandLength(6);
        logger.info("生成的验证码是"+randInt);
        user.setEmailState(0);
        user.setUserCode(randInt);
        studentService.updateUser(user);
        return sendMailSDK.sendMail(httpUrl,user,randInt);
    }

    //邮箱验证部分
    @RequestMapping(value = "/verifyMail/{userCode}",method = RequestMethod.GET)
    @ResponseBody
    public Boolean verifyMail(@PathVariable(value = "userCode")String userCode){
        User user = studentService.findCodeUser(userCode);
        if (studentService.findCodeUser(userCode) != null && (user.getUserCode()).equals(userCode)){
            user.setEmailState(1);
            studentService.updateUser(user);
            return true;
        }
        return false;
    }

    //邮箱登录部分
    @RequestMapping(value = "/mailLogin",method = RequestMethod.POST)
    public String mailLogin(HttpServletRequest request){
        logger.info("进入邮箱登录页");
        String userEmail = request.getParameter("userEmail");
        String password = request.getParameter("password");
        User user = studentService.findMailUser(userEmail);
        if (user != null && user.getEmailState() == 1){
            //对密码加盐加密，然后和数据库里的比较
            String passwordMD5 = MD5Util.stringToMD5(password+user.getUserName());
            logger.info("加盐加密后的密码："+passwordMD5);
            if ((user.getPassword()).equals(passwordMD5)){
                logger.info("登录成功");
                return "redirect:student";
            }
        }
        logger.info("登录失败");
        return "login";
    }

    @RequestMapping(value = "/main7",method = RequestMethod.GET)
    public String load(Model model){
        long id = 4;
        User user = studentService.findIdUser(id);
        model.addAttribute("u",user);
        return "/upload";
    }

    @RequestMapping(value = "/upload/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public Boolean  uploadFile(HttpServletRequest request,MultipartFile file,Long userId) throws IOException {
        logger.info(file.toString());
//        Integer id = 10;
        System.out.println("fileName===" + file.getOriginalFilename());
        System.out.println("fileSize===" + file.getSize());
        System.out.println("fileContentType===" + file.getContentType());
        System.out.println("fileString===" + file.toString());
        System.out.println("name===" + file.getName());
        System.out.println("fileInputStream===" + file.getInputStream());
        System.out.println("fileBytes===" + Arrays.toString(file.getBytes()));

        String fileName = MD5Util.getMultipartFileMd5(file);

        Boolean a = aliyunOSSAPI.updateFile(userId,file,fileName);
        if (a){
            logger.info("成功上传阿里云");
            String url = aliyunOSSAPI.geturl1(fileName);
            logger.info("返回的阿里云url为  "+url);
            User user = new User(userId,url);
            studentService.updateUser1(user);
            return true;
        }
        return false;
    }


}
