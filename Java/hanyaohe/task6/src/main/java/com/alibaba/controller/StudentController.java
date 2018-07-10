package com.alibaba.controller;
import com.alibaba.dao.StudentDao;
import com.alibaba.utils.RedisUtil;
import com.alibaba.model.Student;
import com.alibaba.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
public class StudentController {
    @Resource
    private StudentDao studentDao;
    @Resource
    private StudentService studentServiceImpl;
    @Resource
    private RedisUtil redisUtil;
    private Logger logger = Logger.getLogger(StudentController.class);

    @RequestMapping(value = "/student/welcome", method = RequestMethod.GET)
    public String Login() {

        return "welcome";
    }

    @RequestMapping(value = "/student/add", method = RequestMethod.GET)
    public String add() throws Exception {
        return "add";
    }
    @RequestMapping(value = "/student/adds",method = RequestMethod.POST)
    public String adds(Student student){
        studentDao.insert(student);
        return "redirect:/student/welcome";
    }
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public String deleteS(@PathVariable("id") Long id){
        studentDao.deleteById(id);
        return "redirect:/student/welcome";
    }


@RequestMapping(value = "/student/u/{id}", method = RequestMethod.GET)
public String toUpdate(@PathVariable("id") Long id, Model model) {
    Student student = studentDao.selectById(id);
    model.addAttribute("student", student);
    return "update";
}

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable("id") Long id, String name, String qq, String type,String enrolmenttime,String graduated,String number,String daily,String ambition, Model model) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setQq(qq);
        student.setType(type);
        student.setEnrolmenttime(enrolmenttime);
        student.setGraduated(graduated);
        student.setNumber(number);
        student.setDaily(daily);
        student.setAmbition(ambition);
        studentDao.updateByIdSelective(student);
        model.addAttribute("student", student);
        return "redirect:/students";
    }



    @RequestMapping(value = "/Cache", method = RequestMethod.GET)
    public String fullsCahe() {
        //todo 重置缓存逻辑
        redisUtil.del("studentList");
        return "welcome";
    }

    @RequestMapping(value = "/studentsJson", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> reStudents() {
        List<Student> studentWhere = studentServiceImpl.studentList();
        return studentWhere;
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

//    @RequestMapping(value = "/student", method = RequestMethod.POST)
//    public ModelAndView reStudent(ModelAndView mv, @RequestParam("name") String name) {
//        //todo 查询单个用户，模拟并防止缓存穿透
//        Student student = studentServiceImpl.selectByName(name);
//        if (student != null) {
//            mv.setViewName("JsonTag");
//            mv.addObject("student", student);
//        } else {
//            mv.setViewName("as");
//        }
//        return mv;
//    }
}
