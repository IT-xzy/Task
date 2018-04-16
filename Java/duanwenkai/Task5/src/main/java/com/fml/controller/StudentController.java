package com.fml.controller;

import com.fml.pojo.Student;
import com.fml.service.StudentService;
import com.fml.utils.CookieUtil;
import com.fml.utils.JWTUtil;
import com.fml.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@Controller
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @RequestMapping("registers")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "students",method = RequestMethod.POST)
    public String addStudent(Student student){
        final long create_at = System.currentTimeMillis();
        student.setCreate_at(create_at);
        student.setUpdate_at(System.currentTimeMillis());
        student.setStu_status(1);//学员的状态应该在后台赋予

        String password = student.getPassword();
        //表示通用唯一标识符(UUID)的类。UUID表示一个128位的值
        UUID uuid = UUID.randomUUID();
        String salt = uuid.toString().substring(10);
        //进行MD5加密
        password = MD5Util.getMd5withSalt(password,salt);
        //加密后的密码赋予给学员
        student.setPassword(password);
        student.setSalt(salt);

        LOGGER.info("盐" + student.getSalt());
        LOGGER.info("密码" + student.getPassword());

        if (studentService.add(student)){
            LOGGER.info("Successful student registration！");
            return "success";
        }else {
            LOGGER.info("Student registration failed！");
            return "error";
        }
    }

    @RequestMapping(value = "viewLogin",method = RequestMethod.GET)
    public String viewLogin(){
        return "viewLogin";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect, String email, String password){
        Student student = studentService.getStuByEmail(email);
        if (student == null){
            return "error";
        }
        String salt = student.getSalt();
        String pwd = student.getPassword();
        //判断账户密码是否匹配
        if (!MD5Util.getMd5withSalt(password,salt).equals(pwd)){
            LOGGER.info("登陆失败！");
            redirect.addFlashAttribute("message","账户或密码错误");
            return "redirect:/viewLogin";
        }

        try {
            String tokens = JWTUtil.createToken(student);
            //System.out.println(tokens);
            /*
             *  setHeader(name, value)：如果Header中没有定义则添加，如果已定义则用新的value覆盖原用value值。
             *  addHeader(name, value)：如果Header中没有定义则添加，如果已定义则保持原有value不改变。
             */

            response.addCookie(CookieUtil.getLoginCookie("tokens",tokens));
            LOGGER.info(new Date() + ": 用户登录成功！");
        } catch (Exception e) {
            LOGGER.info("生成token失败！");
            e.printStackTrace();
        }

        /*  有JWT做验证，普通cookie可以不用
        //ID和登录时间作为原密文
        String str = student.getStu_id() + ":" + System.currentTimeMillis();
        //进行DES加密
        String token = DESUtil.encrypt(str,DESUtil.getkey());
        //将密文存入cookie,回写给用户
        response.addCookie(CookieUtil.getLoginCookie("token",token));
        */
        return "redirect:home";
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = CookieUtil.deleteCookieByName(request,"token");
        response.addCookie(cookie);
        return "redirect:viewLogin";
    }
}
