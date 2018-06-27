package hzw.controller;

import hzw.model.Profession;
import hzw.model.Student;
import hzw.model.User;
import hzw.service.ServiceManage;
import hzw.service.StudentService;
import hzw.util.DESUtil;
import hzw.util.MD5Util;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class JsonController {
    private static final String skey = "zhongwei";
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(JsonController.class);

    @Autowired
    StudentService studentService;
    @Autowired
    ServiceManage serviceManage;

    @RequestMapping(value = "/json",method = RequestMethod.GET)
    public ModelAndView jsonList(){
        List<Student> students = studentService.findListStudent();
        ModelAndView mav = new ModelAndView();
        mav.addObject("stu",students);
        logger.info("json: "+mav.getModel());
        mav.setViewName("jsonList");
        return mav;
    }

    @RequestMapping(value = "/json1",method = RequestMethod.GET)
    public ModelAndView jsonList1(){
        List<Student> students = studentService.findListStudent1();
        ModelAndView mav = new ModelAndView();
        mav.addObject("stu",students);
        logger.info("json: "+mav.getModel());
        mav.setViewName("jsonList");
        return mav;
    }

    @RequestMapping(value = "/json/{sId}",method = RequestMethod.GET)
    public String jsonID(@PathVariable("sId")Long sId, Model model){
        Student student = studentService.getID(sId);
        model.addAttribute("s",student);
        logger.info("json-getid-model"+model);
        return "jsonID";
    }

    @RequestMapping(value = "/json/s/{sId}",method = RequestMethod.GET)
    public String jsonID1(@PathVariable("sId")Long sId, Model model){
        Student student = studentService.getID1(sId);
        model.addAttribute("s",student);
        logger.info("json-getid-model"+model);
        return "jsonID";
    }

    //Json-taglib主页登录
    @RequestMapping(value = "/u/json",method = RequestMethod.GET)
    public ModelAndView jsonLogin(){
        logger.info("进入json登陆");
        ModelAndView mav = new ModelAndView();
        List<Profession> profession =  serviceManage.findListProfession();
        mav.addObject("profession",profession);
        mav.setViewName("professionJson");
        return mav;
    }

    @RequestMapping(value = "/json/login",method = RequestMethod.GET)
    public String jsonLogin1(Model model){
        logger.info("进入json登陆==================");
        List<Profession> profession =  serviceManage.findListProfession();
        model.addAttribute("profession",profession);
        return "professionJson";
    }

    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    public String login1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("进入登陆页");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        logger.info("前台传进来的登录账号："+userName+",密码："+password);
        //对密码加盐加密，然后和数据库里的比较
        String passwordMD5 = MD5Util.stringToMD5(password+userName);
        logger.info("加盐加密后的密码："+passwordMD5);
        User user = serviceManage.findNameUser(userName);
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
            return "redirect:/u/json";
        }else {
            logger.info("登录失败");
            return "login";
        }
    }
}
