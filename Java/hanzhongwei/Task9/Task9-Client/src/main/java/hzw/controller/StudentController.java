package hzw.controller;

import com.aliyuncs.exceptions.ClientException;
import hzw.model.Student;
import hzw.model.User;
import hzw.service.StudentRmi;
import hzw.service.StudentService;
import hzw.util.*;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Controller
public class StudentController {
    /*@Autowired
    StudentService studentService;
    @Autowired
    StudentRmi studentRmi;*/

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    RMIServer rmiServer;

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String student(Model model) throws RemoteException, NotBoundException, MalformedURLException {
        StudentService studentService = rmiServer.getStudentService();
        logger.info("进入学员展示页");
        List<Student> list = studentService.findListStudent();
        model.addAttribute("student",list);
        return "index";
    }

    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public String addStudent(Student student) throws RemoteException, NotBoundException, MalformedURLException {
        StudentService studentService = rmiServer.getStudentService();
        logger.info("进入添加"+student);
        studentService.insertStudent(student);
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/{sId}",method = RequestMethod.DELETE)
    public String deleteStudent(Student student) throws RemoteException, NotBoundException, MalformedURLException {
        StudentService studentService = rmiServer.getStudentService();
        logger.info("删除信息"+student);
        studentService.deleteStudent(student.getsId());
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/{sId}",method = RequestMethod.POST)
    public String updateStudent(Student student) throws RemoteException, NotBoundException, MalformedURLException {
        StudentService studentService = rmiServer.getStudentService();
        logger.info("跟新信息"+student);
        studentService.updateStudent(student);
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/insert/{sId}",method = RequestMethod.GET)
    public String getIdStudent(Student student, Model model) throws RemoteException, NotBoundException, MalformedURLException {
        StudentService studentService = rmiServer.getStudentService();
        logger.info("查询信息"+student);
        student = studentService.getID(student.getsId());
        model.addAttribute("s",student);
        return "updateStudent";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user) throws RemoteException, NotBoundException, MalformedURLException {
        StudentRmi studentRmi = rmiServer.getStudentRmi();
        logger.info("进入注册页");
        logger.info("前台传进来的信息："+user.toString());
        boolean a = studentRmi.register(user);
        if (a) {
            logger.info("注册成功");
            return "login";
        }
        logger.info("注册失败");
        return "registerError";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("进入登陆页");
        StudentRmi studentRmi = rmiServer.getStudentRmi();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        logger.info("前台传进来的登录账号："+userName+",密码："+password);
        boolean a = studentRmi.nameLogin(userName,password);
        if (a) {
            logger.info("登录成功，生成cookie");
            Cookie cookie = studentRmi.getCookie(userName);
            response.addCookie(cookie);
            return "redirect:student";
        }
        logger.info("登录失败");
        return "login";

    }

    @RequestMapping(value = "/iphoneLogin",method = RequestMethod.POST)
    public String iphoneLogin(HttpServletRequest request) throws RemoteException, NotBoundException, MalformedURLException {
        logger.info("进入手机登录页");
        StudentRmi studentRmi = rmiServer.getStudentRmi();
        String userIphone = request.getParameter("userIphone");
        String Code = request.getParameter("code");
        if (studentRmi.iphoneLogin(userIphone,Code)){
            logger.info("登录成功");
            return "redirect:/student";
        }
        logger.info("登录失败");
        return "login";
    }

    @RequestMapping(value = "/SMS",method = RequestMethod.POST)
    @ResponseBody
    public Boolean SMS(String userIphone) throws ClientException, RemoteException, NotBoundException, MalformedURLException {
        StudentRmi studentRmi = rmiServer.getStudentRmi();
        logger.info("接受的号码为： "+userIphone);
        return studentRmi.iphoneVerify(userIphone);
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
    public String user(Model model,User user) throws RemoteException, NotBoundException, MalformedURLException {
        StudentService studentService = rmiServer.getStudentService();
        User user1 = studentService.findIdUser(user.getUserId());
        model.addAttribute("u",user1);
        return "user";
    }

    //邮箱点击验证部分
    @RequestMapping(value = "/sendMail",method = RequestMethod.POST)
    @ResponseBody
    public Boolean sendMail(HttpServletRequest request,User user) throws RemoteException, NotBoundException, MalformedURLException {
        StudentRmi studentRmi = rmiServer.getStudentRmi();
        String url = String.valueOf(request.getRequestURL());
        logger.info("url==="+url);
        return studentRmi.sendMail(url,user);
    }

    //邮箱验证部分
    @RequestMapping(value = "/verifyMail/{userCode}",method = RequestMethod.GET)
    @ResponseBody
    public Boolean verifyMail(@PathVariable(value = "userCode")String userCode) throws RemoteException, NotBoundException, MalformedURLException {
        StudentRmi studentRmi = rmiServer.getStudentRmi();
        logger.info("mail-code==="+userCode);
        return studentRmi.verifyMail(userCode);
    }

    //邮箱登录部分
    @RequestMapping(value = "/mailLogin",method = RequestMethod.POST)
    public String mailLogin(HttpServletRequest request) throws RemoteException, NotBoundException, MalformedURLException {
        logger.info("进入邮箱登录页");
        StudentRmi studentRmi = rmiServer.getStudentRmi();
        String userEmail = request.getParameter("userEmail");
        String password = request.getParameter("password");
        if (studentRmi.mailLogin(userEmail,password)) {
                logger.info("登录成功");
                return "redirect:student";
            }
        logger.info("登录失败");
        return "login";
    }

    @RequestMapping(value = "/main7",method = RequestMethod.GET)
    public String load(Model model) throws RemoteException, NotBoundException, MalformedURLException {
        StudentService studentService = rmiServer.getStudentService();
        long id = 4;
        User user = studentService.findIdUser(id);
        model.addAttribute("u",user);
        return "/upload";
    }

    @RequestMapping(value = "/upload/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public Boolean  uploadFile(HttpServletRequest request,MultipartFile file,Long userId) throws IOException, NotBoundException {
        logger.info("进入图片上传");
        StudentRmi studentRmi = rmiServer.getStudentRmi();
        return studentRmi.uploadPicture(file,userId);
    }
}
