package com.jns.controller;


import com.aliyuncs.exceptions.ClientException;
import com.jns.pojo.Course;
import com.jns.pojo.Student;
import com.jns.service.CourseService;
import com.jns.service.RmiService;
import com.jns.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import util.CookieUtil;
import util.JWTUtil;
import util.aliEmailUtil.AliEmailUtil;
import util.ossUtil.OssUtil;
import util.redisUtil.GetNumUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *  课程查看 个人主页
 */
@Controller
@RequestMapping("/u")
public class PersonalPageController {
 private    Logger logger=Logger.getLogger(PersonalPageController.class);

//    @Autowired
//    @Qualifier("studentRMIClientOne")
//  private StudentService studentService;
//    @Autowired
//    @Qualifier("courseRMIClientOne")
//    CourseService courseService;


    @Autowired
    OssUtil ossUtil;
    @Autowired
    GetNumUtil getNumUtil;

    @Autowired
    AliEmailUtil aliEmailUtil;

    @Autowired
    RmiService rmiService;

    @RequestMapping(value = "/course")
    public ModelAndView cp() {
        ModelAndView modelAndView = new ModelAndView("coupage1");
        Course web = rmiService.getCourseService().findCourse(1);
        Course java =rmiService.getCourseService().findCourse(2);
        modelAndView.addObject("web", web);
        modelAndView.addObject("java", java);
        int webNum = 0;
        int javaNum = 0;
        webNum = rmiService.getStudentService().countCourse("web");
        javaNum = rmiService.getStudentService().countCourse("java");
        modelAndView.addObject("webNum", webNum);
        modelAndView.addObject("javaNum", javaNum);
        return modelAndView;
    }

    /**
     * @return 将用户信息传送至个人主页
     * @Description 跳转至个人页面
     * @Param 获取cookie中的token 用以查询用户信息
     **/
    @RequestMapping("personPage")
    public ModelAndView personalPage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("personalpage");
        Cookie cookie = CookieUtil.getCookie("token", request);
        Integer tokenStuID = JWTUtil.getStuID(cookie.getValue());
        Student student =rmiService.getStudentService().selectStuID(tokenStuID);
        mv.addObject(student);
        return mv;
    }

    /**
     * @return
     * @Description 更新个人页面
     * @Param 更新邮箱地址
     **/
    @RequestMapping(value = "student", method = RequestMethod.PUT)
    public ModelAndView updateStudent( Integer stuID,String emailAddress) {
        ModelAndView mv = new ModelAndView();
        Student student =rmiService.getStudentService().selectStuID(stuID);
        //存储邮箱地址
        student.setEmailAddress(emailAddress);
        rmiService.getStudentService().updateStudent(student);
        //查看邮件修改次数
        if (getNumUtil.getRedisNum(emailAddress) > 3) {
            mv.setViewName("error");
            mv.addObject("exception", "邮箱修改次数过多，明天尝试");
            return mv;
        } else {
            //发送邮件
            try {
                aliEmailUtil.sendMail(emailAddress, "欢迎加入修真院");
            } catch (ClientException e) {
                logger.error("邮件发送异常" + emailAddress);
                e.printStackTrace();
            }
            mv.setViewName("redirect:/homepage");
            return mv;
        }
    }
    /**
     * @return
     * @Description 上传头像
     * @Param
     **/
    @RequestMapping(value = "/updateStuImage", method = RequestMethod.POST)
    public ModelAndView springUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        ModelAndView mv = new ModelAndView();
        // 文件过大 报错
        if (file.getBytes().length > 1024 * 1024 * 2) {
            mv.setViewName("error");
            mv.addObject("exception", "图片过大");
            return mv;
        } else {
            // 获取用户id
            Cookie cookie = CookieUtil.getCookie("token", request);
            Integer tokenStuID = JWTUtil.getStuID(cookie.getValue());
            Student student = rmiService.getStudentService().selectStuID(tokenStuID);
            // 获取用户姓名，以姓名为oss存储文件名
            String name = student.getStuName();
            ossUtil.upFile(name, file);
            String url = "https://hermit-liuk.oss-cn-hangzhou.aliyuncs.com/" + name;
            student.setStuImage(url);
            student.setUpdateTime(System.currentTimeMillis());
            rmiService.getStudentService().updateStudent(student);
            mv.setViewName("redirect:/homepage");
            return mv;
        }
    }
}
