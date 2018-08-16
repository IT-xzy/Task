package task.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import task.util.Page;
import task.pojo.Student;
import task.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController
{
    static Logger logger=Logger.getLogger(Student.class);
    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/student",method=RequestMethod.GET)
    public ModelAndView selectAllStudent(Page page)
    {
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Student> student=studentService.selectAllStudent();
        int total= (int) new PageInfo(student).getTotal();
        // 计算最后last的值，即前台中末页的值
        page.finalLast(total);
        page.getLast();
        ModelAndView mav=new ModelAndView();
        mav.addObject("student",student);
        mav.setViewName("student");
//        logger.info("查询所有数据成功");
        return mav;
    }
//        删除数据
    @RequestMapping(value="/student/{studyId}",method=RequestMethod.DELETE)
    public ModelAndView deleteStudent( Student student)
    {
        studentService.deleteStudent(student.getStudyId());
        ModelAndView modelAndView=new ModelAndView("redirect:/student");
        return modelAndView;
    }

    //查询数据
    @RequestMapping(value="/student/{studyId}",method=RequestMethod.GET)
    public ModelAndView editStudent(Student student)
    {
        Student student1=studentService.selectStudent(student.getStudyId());
        ModelAndView modelAndView=new ModelAndView("studentEdit");
        modelAndView.addObject("student1",student1);
        return modelAndView;
    }
    //修改数据
    @RequestMapping(value="/student/{studyId}",method=RequestMethod.POST)
    public ModelAndView updateStudent(Student student)
    {
        studentService.updateStudent(student);
        ModelAndView modelAndView=new ModelAndView("redirect:/student");
        return modelAndView;
    }
    //  增加数据，跳转进入输入数据的页面，中转controller类无参数；
    @RequestMapping(value="/student/add")
    public ModelAndView insertStudent()
    {
        ModelAndView modelAndView=new ModelAndView("studentAdd");
        return modelAndView;
    }
    //  增加数据，增加完后返回首页
    @RequestMapping(value="/student/adding",method =RequestMethod.PUT)
    public ModelAndView insertStudent(Student student)
    {
        studentService.insertStudent(student);
        ModelAndView modelAndView=new ModelAndView("redirect:/student");
        return modelAndView;
    }
    //spring的json数据页面
    @RequestMapping(value="/student/json")
    public ModelAndView selectAllStudentJson(Page page)
    {
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Student> student1=studentService.selectAllStudent();
        int total= (int) new PageInfo(student1).getTotal();
//        计算最后last的值，即前台中末页的值
        page.finalLast(total);
        page.getStart();
        page.getLast();
        ModelAndView mav=new ModelAndView();
        mav.addObject("student1",student1);
        mav.setViewName("studentJson");
        return mav;
    }
}
