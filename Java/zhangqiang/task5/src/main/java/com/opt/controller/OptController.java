package com.opt.controller;


import com.opt.model.Page;
import com.opt.model.Profession;
import com.opt.model.Student;
import com.opt.model.User;
import com.opt.service.impl.ProfessionServiceImpl;
import com.opt.service.impl.StudentServiceImpl;
import com.opt.service.impl.UserServiceImpl;
import com.opt.util.JWTUtil;
import com.opt.util.RandomStudent;
import com.opt.util.Sha256Util;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Controller 核心控制器 页面跳转
 *
 * @Title: 控制器
 * @Description: 接收url 调用service操作数据库 返回数据 渲染视图
 * @author By.ZhangQiang(张强)
 * @date 2018-5-26
 */
@Controller
public class OptController {

    private static Logger logger = Logger.getLogger(OptController.class);
    private RandomStudent randomStudent = new RandomStudent();
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
    StudentServiceImpl studentService = (StudentServiceImpl) applicationContext.getBean("studentService");
    ProfessionServiceImpl professionService = (ProfessionServiceImpl) applicationContext.getBean("professionService");
    UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");

    private final String TOKENKEY = "zhangqiang";
    private String message = "似乎遇到点问题...";

    @Test
    public void test(){

        logger.info(userService.findById(2));

    }


    /*
    * */
    @RequestMapping("/home")
    public String tiles(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        Page<Student> pages = studentService.findByPage(2,4);

        String name = (String) session.getAttribute("username");

        if(name!=null){
            model.addAttribute("sessionname",name);
        }

        model.addAttribute("onlineTotal",session.getAttribute("onlineT"));
        model.addAttribute("students",pages.getPages());

        return "home";
    }

    @RequestMapping("/u/profession")
    public String profession(Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<Profession> pros = professionService.findAll();
        model.addAttribute("onlineT",session.getAttribute("onlineT"));
        model.addAttribute("pros",pros);
        return "profession";
    }

    @RequestMapping("/u/login")
    public String tologin(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        return "login";
    }
    @RequestMapping(value = "/u/e")
    public String exlogin(Model model, User user, HttpServletRequest request, HttpServletResponse response){
        logger.info("\nDLETE");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        JWTUtil jwtUtil = new JWTUtil(TOKENKEY);
        try {
            String newToken = jwtUtil.createToken("exit",30);
            Cookie cookie = new Cookie("token",newToken);
//            Cookie cookie = new Cookie("token",null);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.invalidate();

        Page<Student> pages = studentService.findByPage(2,4);
        model.addAttribute("students",pages.getPages());
        return "home";
    }
    @RequestMapping(value = "/u/login",method = POST)
    public String login(Model model,User user,HttpServletRequest request, HttpServletResponse response,HttpSession session){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        logger.info("\n登录信息："+user.toString());

        JWTUtil jwtUtil = new JWTUtil(TOKENKEY);
        Sha256Util shaUtil = new Sha256Util();

        if (user!=null){

            User userInfo = userService.findByName(user.getName());

            if (userInfo!=null){
                String shapwd = user.getPwd();
                String salt = userInfo.getSalt();

                if (shaUtil.getSha256(shapwd+salt).equals(userInfo.getPwd())){

                    try {

                        String token = jwtUtil.createToken(user.getName(),7*24*60);//一周
                        Cookie cookie = new Cookie("token",token);
                        cookie.setMaxAge(7*24*60*60);
                        response.addCookie(cookie);

                        String name = user.getName();
                        session.setAttribute("username",name);
                        session.setMaxInactiveInterval(30 * 60);//30分钟

                        message = "登录成功";

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return "home";
                }else {
                    message = "密码错误或用户名无效！请重新输入！";
                }
            }else {
                message = "用户名错误，找不到此用户！";
            }
        }else {
            message = "无此用户，请重新输入";
        }

        model.addAttribute("message",message);
        return "login";
    }

    @RequestMapping("/u/reg")
    public String goReg(){
        return "reg";
    }

    @RequestMapping(value = "/u/reg",method = POST)
    public String reg(User user,Model model){

        logger.info("\nuser："+user.toString());
        Sha256Util sha256Util = new Sha256Util();

        String name = user.getName();
        String pwd = user.getPwd();

           User user1 = userService.findByName(name);

           logger.info("\n注册 查询到表内信息："+user1);

            if(user1!=null){

                message = "已有用户！请重输！";

            }else {

                logger.info("\n未查詢到信息，開始注冊");
                String salt = sha256Util.getSalt();
                user.setSalt(salt);
                String pwda = sha256Util.getSha256(pwd+salt);
                user.setPwd(pwda);
                userService.insertOne(user);
                message = "注册成功，请登录";
                model.addAttribute("message",message);
                return "login";
            }

        model.addAttribute("message",message);
        return "reg";
    }


    @RequestMapping(value = "/stringfilter")
    public String tofilter(){
        return "stringfilter";
    }

    @RequestMapping(value = "/a/stringfilter",method = POST)
    public String filter(@RequestParam("note") String str, Model model, HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String att = (String) request.getAttribute("note");
        model.addAttribute("fst",att);

        return "stringfilter";
    }

    @RequestMapping("/u/commend")
    public String tocommend(){
        logger.info("\ncommend");return "commend";
    }


    @RequestMapping(value = "/u/list")
    public String studentList(@RequestParam(value = "nowPage",defaultValue = "1")Integer nowpage,
                              @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize,Model model){
        logger.info("\nnowpage="+ nowpage + "pagesize=" + pagesize);
        Page<Student> page = studentService.findByPage(nowpage,pagesize);
//        List<Student> students = page.getPages();
        model.addAttribute("nowPages",page);
        logger.info(page.getPages().toString());
        return "list";
    }

    @RequestMapping(value = "/u/student/{id}")
    public String toUpdStudent(@PathVariable("id")Integer id,Model model){
        Student student = studentService.findByID(id);
        if (student!=null){

            model.addAttribute("studentInfo",student);
        }
        return "updStudent";
    }
    @RequestMapping(value = "/u/student",method = PUT)
    public String updStudent(Student student,Model model){
        logger.info("\n信息："+student);
        int flag = studentService.updateOne(student);
        if (flag!=0){
            message = "修改成功";
        }else {
            message = "修改失败";
            model.addAttribute("message",message);
            return "redirect:updStudent";
        }
        model.addAttribute("message",message);
        return "redirect:list";
    }

}
