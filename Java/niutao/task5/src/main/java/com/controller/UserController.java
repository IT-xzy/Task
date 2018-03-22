package com.controller;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.FromCookieGetId;
import com.service.ProduceToken;
import com.util.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    Student student;

    Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    //用户信息
    @RequestMapping(value = "/u/home",method = RequestMethod.GET)
    public String uhomeget(HttpServletRequest request, Model model
    ) { int id = FromCookieGetId.getId(request);
        Student student = studentMapper.selectByPrimaryKey(id);
        model.addAttribute("student", student);
        return "userhome";
    }

    @RequestMapping(value = "/u/home",method = RequestMethod.POST)
    public String uhomepost(HttpServletRequest request,Student student){
        int id = FromCookieGetId.getId(request);
        Date day = new Date();
        student.setUpdateTime(day);
        student.setId(id);
        int i = studentMapper.updateByPrimaryKeySelective(student);
        return "hello";
    }
//使用上面的方法代替,自动参数映射可以简化代码。
//    @RequestMapping(value = "/u/home",method = RequestMethod.POST)
//    public String uhomepost(HttpServletRequest request,
//            @RequestParam("name") String name,
//            @RequestParam("score") int score,
//            @RequestParam("status") int status,
//            @RequestParam("classId")int classId
//    ) {
//        int id = FromCookieGetId.getId(request);
//        Date day = new Date();
//        student2.setUpdateTime(day);
//        student2.setId(id);
//        student2.setName(name);
//        student2.setScore(score);
//        student2.setStatus(status);
//        student2.setClassId(classId);
//        studentMapper.updateByPrimaryKeySelective(student2);
//        return "hello";
//    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerget(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerpost(Student student) {
        student.setPassWord(MD5.getMD5(student.getPassWord()));
        Date day = new Date();
        student.setCreateTime(day);
        student.setUpdateTime(day);
        logger.info("注册用户信息"+student);
        studentMapper.insert(student);
        return "login";
    }
    //登陆
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String logget(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String logpost(
                        HttpServletResponse response,
                        @RequestParam("userName") String u,
                        @RequestParam("passWord") String pw,
                        Model model){

        student = studentMapper.selectByuserName(u);
        //使用md5加密，然后和数据库中存储的内容对比。
        String md5password = MD5.getMD5(pw);
        if(u.equals(student.getUserName()) && md5password.equals(student.getPassWord())){
            //得到系统当前时间，传给cookie
            Date day = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String logtime = sdf.format(day);
            String id = String.valueOf(student.getId());
            //使用id+logtime生成tokeng
            String token = ProduceToken.getToken(id,logtime);
            //创建cookie
            Cookie idCookie = new Cookie("id",id);
            Cookie logTimeCookie = new Cookie("logtime",logtime);
            Cookie tokenCookie = new Cookie("token",token);
            response.addCookie(idCookie);
            response.addCookie(logTimeCookie);
            response.addCookie(tokenCookie);
        }else {
            return "login";
        }
        model.addAttribute("message","已登陆");
        return "hello";
    }

    //使用title布局的页面，没有填数据。
    @RequestMapping(value = "/home10",method = RequestMethod.GET)
    public String show10() {
        return "home10";
    }
    @RequestMapping(value = "/home11",method = RequestMethod.GET)
    public String show11() {
        return "home11";
    }
}




