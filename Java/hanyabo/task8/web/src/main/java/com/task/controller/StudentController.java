package com.task.controller;

import com.task.entity.Student;
import com.task.service.StudentService;
import com.task.util.BeanFactoryUtil;
import com.task.util.StudentPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {

//    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    //加载service
//    @Autowired
//    StudentService studentService;


    private StudentService getStudentService(){
        return new BeanFactoryUtil().getStudentService();
    }





    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ModelAndView listStudentById(String id,String name,String number){

        //获取搜索结果 全部以list存储,初始化为null
        List<Student> students = null;

        StudentService studentService = getStudentService();


        if(!id.equals("")){
            students = studentService.findById(Integer.parseInt(id));
        }else if(!name.equals("")){
            students = studentService.findByName(name);
        }else if(!number.equals("")){
            students = studentService.findByNumber(Integer.parseInt(number));
        }

        //搜索结果加分页


        ModelAndView mav = new ModelAndView();
        mav.addObject("students",students);
        mav.setViewName("manage");

        return mav;

    }

    @RequestMapping(value = "/u/students",method = RequestMethod.GET)
    public ModelAndView listStudentByPage(StudentPage studentPage){

        StudentService studentService = getStudentService();

        int total = studentService.total();

        studentPage.caculateLast(total);

        List<Student> students = null;

        students = studentService.findByPage(studentPage);

//        logger.info("jump students");
        ModelAndView mav = new ModelAndView();
        mav.addObject("students",studentPage);
        mav.addObject("students",students);
        mav.setViewName("manage");

        return mav;
    }

}
