package spring.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import spring.exception.LoginException;
import spring.model.Student;
import spring.service.IstudentService;
import spring.service.RmiService;
import utils.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {

//    @Qualifier("studentServiceOne")
//    @Autowired
//    private IstudentService studentService;

    @Autowired
    RmiService rmiService;

    @Autowired
    private MessageUtil messageUtil;
    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private Redis redis;

    private Logger logger = Logger.getLogger(StudentController.class);


    @RequestMapping(value = "home",method = RequestMethod.GET)
    public ModelAndView testView(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("home");
        IstudentService studentService = rmiService.getStudentService();
        int a = studentService.getAll();
        int b = studentService.getOffer();
        List<Student> list = studentService.getGood();
        mav.addObject("all",a);
        mav.addObject("offer",b);
        mav.addObject("list",list);
        logger.error("访问主页");
        return mav;
    }
    //添加学生
    @RequestMapping(value = "student",method = RequestMethod.POST)
    public String addStudent(String name,String occupation,String telephone,String username,String email,String code ) throws Exception {
        IstudentService studentService = rmiService.getStudentService();
        String inputEmail = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
        logger.error("申请加入内门");
        System.out.println(messageUtil.getA());
        System.out.println(code);
        if(!studentService.selectByName(username)){
            if(email.matches(inputEmail)&&messageUtil.getA().equals(code)){
                Student student = new Student();
                student.setName(name);
                student.setOccupation(occupation);
                student.setTelephone(telephone);
                student.setCreatdate(System.currentTimeMillis());
                student.setState("在学");
                student.setUsername(username);
                student.setEmail(email);
                studentService.addStudent(student);
                emailUtil.sample(email);
                redis.delete("studentNumber");
                redis.delete("offerStudent");
                redis.delete("javaNumber");
                redis.delete("webNumber");
                redis.delete("pmNumber");
                logger.error("添加学生");
                return "redirect:/u/student";
            }else{
                logger.error("信息输入错误");
                throw new LoginException("请输入正确的信息！");
            }
        }else {
            logger.error("已经是内门");
            throw new LoginException("您已经是内门弟子了，赶快去学习吧！");
        }
    }

    //获得验证码
    @RequestMapping(value = "telephone",method = RequestMethod.GET)
    public ModelAndView getTelePhone(String telephone) throws Exception {
        IstudentService studentService = rmiService.getStudentService();
        String inputTelephone = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        GetNumber getNumber = new GetNumber();
        if(getNumber.number(telephone)>5){
            logger.error("条数超过");
            throw new LoginException("每小时只能发5个");
        }else {
            if(telephone.matches(inputTelephone)){
                messageUtil.SmsMessage(telephone);
                ModelAndView mav = new ModelAndView("welcome");
                mav.addObject("telephone",telephone);
                logger.error("获得验证码");
                return mav;
            }else {
                logger.error("手机输入有误");
                throw  new LoginException("输入手机号有误!");
            }
        }
    }
     //获得个人主页信息
    @RequestMapping(value = "/u/student",method = RequestMethod.GET)
    public ModelAndView student(HttpServletRequest request) throws Exception {
        IstudentService studentService = rmiService.getStudentService();
        Cookie cookie = CookieUtil.getCookie("login",request);
        ModelAndView mav = new ModelAndView("student");
        String value = cookie.getValue();
        String userId = Token.parseJWT(value).getId();
        Student student = studentService.getStudentByName(userId);
        mav.addObject(student);
        logger.error("访问个人主页");
        return mav;
    }
    //上传图片
    @RequestMapping(value = "image",method = RequestMethod.POST)
    public String input(MultipartFile file,HttpServletRequest request) throws Exception {
        IstudentService studentService = rmiService.getStudentService();
        if(file.getBytes().length>1024*1024*2){
            throw new LoginException("请上传2M以内的图片");
        }else {
            Cookie cookie = CookieUtil.getCookie("login",request);
            String objectName = Token.parseJWT(cookie.getValue()).getId();
            String fileUrl = "https://imageku.oss-cn-beijing.aliyuncs.com/"+objectName;   //得到路径
            System.out.println(fileUrl);
            String[] fileName = file.getOriginalFilename().split("\\.");
            String filenameExtension = fileName[fileName.length - 1];    //得到扩展名
            String regex ="(jpg|png|img)$";
            System.out.println(filenameExtension);
            if (filenameExtension.matches(regex)) {
                OssUtil ossUtil = new OssUtil();
                ossUtil.upImage(file,objectName);
                Student student = new Student();
                student.setUsername(objectName);
                System.out.println(objectName);
                student.setImage(fileUrl);
                System.out.println(fileUrl);
                studentService.updateByName(student);
                redis.delete("getStudent"+objectName);
            }else {
                throw new LoginException("上传文件格式有问题！");
            }
        }
        return "redirect:/u/student";
    }
}
