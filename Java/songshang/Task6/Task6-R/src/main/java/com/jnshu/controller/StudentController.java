package com.jnshu.controller;
import com.jnshu.Utils.RedisUtil;
import com.jnshu.model.Student;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class StudentController {
    @Resource
    private StudentService studentServiceImpl;
    @Resource
    private RedisUtil redisUtil;
    private Logger logger = Logger.getLogger(StudentController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Login() {
        return "welcome";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String Register(HttpServletResponse response, HttpServletRequest request) throws Exception {
        return "welcome";
    }

    @RequestMapping(value = "/Cache", method = RequestMethod.GET)
    public String fullsCahe() {
        //todo 重置缓存逻辑
        return "welcome";
    }

    @RequestMapping(value = "/studentsJson", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> reStudents() {
        List<Student> studentList = studentServiceImpl.studentList();
        return studentList;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView reStudents2(ModelAndView mv) {
        List<Student> studentList = studentServiceImpl.studentList();
        mv.setViewName("students");
        mv.addObject("studentList", studentList);
        return mv;
    }

    //JsonTag.jsp
    @RequestMapping(value = "/JsonTag", method = RequestMethod.GET)
    public ModelAndView reStudentsTag(ModelAndView mv) {
        List<Student> studentList = studentServiceImpl.studentList();
        mv.setViewName("JsonTag");
        mv.addObject("studentList", studentList);
        return mv;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ModelAndView reStudent(ModelAndView mv, @RequestParam("name") String name) {
        //todo 查询单个用户，模拟并防止缓存穿透
        Student student = studentServiceImpl.selectByName(name);
        if (student != null) {
            mv.setViewName("JsonTag");
            mv.addObject("student", student);
        } else {
            mv.setViewName("as");
        }
        return mv;
    }
}
