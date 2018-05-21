package cn.summerwaves.controller;

import cn.summerwaves.model.Student;
import cn.summerwaves.service.IStudentService;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by summerwaves on 2017/9/11.
 */
@Controller
public class StudentController {

    private static Logger logger = Logger.getLogger("StudentController.class");


    @Resource
    private IStudentService userService;

//    @RequestMapping(value = "/getdate", method = RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView getDate() {
//        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
//        String dateTime = tempDate.format(new java.util.Date());
//        String message = "String传递测试";
//        List<User> us = new ArrayList<User>();
//        us.add(new User("sdad","dasd","das"));
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("getuser");
//        mv.addObject("users", us);
//        mv.addObject("date", dateTime);
//        mv.addObject("message", message);
//        return mv;
//    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, headers = "Accept=application/json")
    public String jsonTest(HttpServletRequest request) throws IOException {
        List<Student> students = userService.getAllStudent();
//        modelMap.addAttribute("head",request.getHeader("Accept"));
//        modelMap.addAttribute("users",users);
        request.getHeader("Accept");
        request.getSession().setAttribute("head", request.getHeader("Accept"));
        request.getSession().setAttribute("students", students);
        logger.info("使用Json接口");
        return "json";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String toUserList(HttpServletRequest request) throws IOException {
        List<Student> students = userService.getAllStudent();
        request.getSession().setAttribute("list", students);
        logger.info("显示所有用户");
        return "studentList";
    }

    @RequestMapping(value = "/student/register", method = RequestMethod.GET)
    public String toRegister() {
        logger.info("转入添加学员页面");
        return "register";
    }

    @RequestMapping(value = "/student/modify", method = RequestMethod.GET)
    public String toModify() {
        logger.info("转入修改页面");
        return "modify";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ModelAndView register(@Param("name") String name, @Param("QQ") String QQ,
                                 @Param("type") String type, String appointment,
                                 @Param("school") String school, @Param("number") String number,
                                 @Param("link") String link, @Param("oath") String oath,
                                 @Param("supportSenior") String supportSenior, @Param("referrer") String referrer,
                                 @Param("source") String source) throws IOException {
        Student student = new Student();
        if (name != null) {
            student.setName(name);
            student.setQQ(QQ);
            student.setType(type);
            student.setAppointment(appointment);
            student.setSchool(school);
            student.setNumber(number);
            student.setLink(link);
            student.setOath(oath);
            student.setSupportSenior(supportSenior);
            student.setReferrer(referrer);
            student.setSource(source);
            userService.insertStudent(student);
            return new ModelAndView("registerSuccess", "username", student.getName());
        }
        logger.debug("用户名为空");
        return new ModelAndView("registerFailure");
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id) throws IOException {
        userService.deleteStudent(id);
        logger.info("删除用户");
        return "删除用户成功";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyPassword(@PathVariable("id") int id, @Param("name") String name, @Param("QQ") String QQ,
                                 @Param("type") String type, @Param("appointment") String appointment,
                                 @Param("school") String school, @Param("number") String number,
                                 @Param("link") String link, @Param("oath") String oath,
                                 @Param("supportSenior") String supportSenior, @Param("referrer") String referrer,
                                 @Param("source") String source, HttpServletRequest request) throws IOException {
        Student student = userService.getStudentById(id);
        request.getSession().setAttribute("student", student);
        student.setQQ(QQ);
        student.setType(type);
        student.setAppointment(appointment);
        student.setSchool(school);
        student.setNumber(number);
        student.setLink(link);
        student.setOath(oath);
        student.setSupportSenior(supportSenior);
        student.setReferrer(referrer);
        student.setSource(source);
        userService.updateStudent(student);
        logger.info("修改学员信息");
        return "修改信息成功";
    }


    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, HttpServletRequest request) throws IOException {
        Student student = userService.getStudentById(id);
        request.getSession().setAttribute("student", student);
        logger.info("查看用户详细信息");
        return "showUser";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "welcome";
    }
}