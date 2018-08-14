package com.yxpStu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxpStu.dao.StudentDao;
import com.yxpStu.page.Page;
import com.yxpStu.pojo.Student;
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
    private StudentDao studentDao;

    @RequestMapping(value="/student",method=RequestMethod.GET)
    public ModelAndView selectAllStudent(Page page)
    {
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Student> student=studentDao.selectAllStudent();

        int total= (int) new PageInfo(student).getTotal();
//        计算最后last的值，即前台中末页的值
        page.finalLast(total);

        logger.info(page.getLast());
        ModelAndView mav=new ModelAndView();
        mav.addObject("student",student);
        mav.setViewName("student");
        logger.info("查询所有数据成功");
        return mav;

    }
//        删除数据
    @RequestMapping(value="/student/{studyId}",method=RequestMethod.DELETE)
    public ModelAndView deleteStudent( Student student)
    {
        studentDao.deleteStudent(student);
        logger.info("删除"+student.getStudyId()+"的数据成功");
        ModelAndView modelAndView=new ModelAndView("redirect:/student");
        return modelAndView;
    }

    //修改数据
    @RequestMapping(value="/student/{studyId}",method=RequestMethod.GET)
    public ModelAndView editStudent(Student student)
    {
        logger.info(student.getStudyId());
        Student student1=studentDao.selectStudent(student);
        logger.info("查询"+student.getStudyId()+"的数据成功");
        ModelAndView modelAndView=new ModelAndView("studentEdit");
        modelAndView.addObject("student1",student1);
        return modelAndView;
    }
    @RequestMapping(value="/student/{studyId}",method=RequestMethod.POST)
    public ModelAndView updateStudent(Student student)
    {
        studentDao.updateStudent(student);
        logger.info("更改"+student.getStudyId()+"的数据成功");
        ModelAndView modelAndView=new ModelAndView("redirect:/student");
        return modelAndView;
    }
    //  增加数据，跳转进入输入数据的页面
    @RequestMapping(value="/student/add")
    public ModelAndView insertStudent()
    {

        ModelAndView modelAndView=new ModelAndView("studentAdd");
        return modelAndView;
    }
    //  增加数据，增加完后返回首页
    @RequestMapping(value="/student/adding")
    public ModelAndView insertStudent(Student student)
    {
        studentDao.insertStudent(student);
        logger.info("增加数据成功，数据为:"+student);
        ModelAndView modelAndView=new ModelAndView("redirect:/student");
        return modelAndView;
    }
    //spring的json数据页面
    @RequestMapping(value="/student/json")
    public ModelAndView selectAllStudentJson(Page page)
    {
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Student> student1=studentDao.selectAllStudent();

        int total= (int) new PageInfo(student1).getTotal();
//        计算最后last的值，即前台中末页的值
        page.finalLast(total);
        logger.info(page.getStart());
        logger.info(page.getLast());
        ModelAndView mav=new ModelAndView();
        mav.addObject("student1",student1);
        mav.setViewName("studentJson");
        return mav;
    }

}
