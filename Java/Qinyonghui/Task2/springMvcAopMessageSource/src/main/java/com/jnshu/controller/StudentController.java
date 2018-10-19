package com.jnshu.controller;

import com.jnshu.entity.Student;
import com.jnshu.service.StudentService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 在类上添加@Controller注解，把Controller交由Spring管理
@Controller
//添加@RequestMapping注解，里面指定请求的url。
@RequestMapping("/students")
public class StudentController {
    Logger logger = LogManager.getLogger(StudentController.class.getName());
    @Autowired
    StudentService studentService;
    ModelAndView modelAndView = new ModelAndView();
//查找全部
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView findAllStudents() {
        logger.info("findAllStudents===========\n");
        if(studentService.findTotal()>0){
            logger.info("总记录条数： "+ studentService.findTotal());
            List<Student> studentLis = studentService.findAll();
            modelAndView.addObject("code", 0);//查找成功
          //  modelAndView.addObject("message", "findAll success");
            modelAndView.addObject("student", studentLis);
        }else{
            modelAndView.addObject("code", -1);//表为空
            //modelAndView.addObject("message", "findAll failed");
            //不存在的时候将返回给jsp页面的data值设置为空，如果不设置，会显示data中以前残留的数据
            modelAndView.addObject("student",null);
        }
        // 指定视图"/WEB-INF/jsp/items/itemsList.jsp"
        modelAndView.setViewName("showJsonFormat");
        return modelAndView;
    }

    //查找单个
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ModelAndView excuteFindOne(@PathVariable long id) {
        logger.info("excuteFindOne====="+id);

        //先对传入的ID做判断，合法了再查找，不和法直接返回错误
        if(id>0){
            Student stulist = studentService.findOneById(id);
            if(stulist!=null){
                logger.info("您所查找的学生信息为: "+ stulist.toString());
                modelAndView.addObject("code", 10);//查找单个成功
                //JSP页面接收数据的是一个array,因此需要用map对对象进行封装
                Map<String, Object> map = new HashMap<>();
                map.put("student", stulist);
                modelAndView.addObject("student",map);
            }else{
                modelAndView.addObject("code", -10);//查找的学生不存在
                modelAndView.addObject("student",null);
            }
        }else{
            modelAndView.addObject("code", -11);//输入的参数必须为正整数
            modelAndView.addObject("student",null);
        }
          modelAndView.setViewName("showJsonFormat");
          return modelAndView;
    }
    //删除
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView exquteDelete(@PathVariable long id) {
        Map map = new HashMap<>();
        logger.info("exquteDeleteId=========" + id);
        //Student oldStudent = studentMapper.findOneById(id);
        if(id>0){
            boolean flag=studentService.deleteById(id);
            if(flag==true){
                map.put("code", 20);  //删除成功
                //modelAndView.addObject("code",20);
            }else{
                map.put("code", -21);//删除失败
               //modelAndView.addObject("code",-20);
            }
        }else{
                map.put("code", -11);//输入的参数必须为正整s
                //modelAndView.addObject("code",-11);
        }
        logger.info(map.get("code"));
        modelAndView.addObject("code",map.get("code"));
        modelAndView.addObject("student",null);
        modelAndView.setViewName("showJsonFormat");
        return modelAndView;
    }

    //修改
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public ModelAndView exquteUpdate(@PathVariable long id, Student student) {
        logger.info("exquteUpdate:  " + student);
        if (id > 0 && (student.getName() != null
                || student.getNumber() != 0
                || student.getQq() != 0
                || student.getCoachName() != null
                || student.getDailyLink() != null
                || student.getGradeColleage() != null)) {
            logger.info("exquteUpdate: here=== ");
            Student oldStudent = studentService.findOneById(id);
            logger.info("oldStudent==="+oldStudent);
            if (oldStudent != null) {
                if (student.getName() != null) {
                    oldStudent.setName(student.getName());
                }
                if (student.getNumber() != 0) {
                    oldStudent.setNumber(student.getNumber());
                }
                if (student.getQq() != 0) {
                    oldStudent.setQq(student.getQq());
                }
                if (student.getCoachName() != null) {
                    oldStudent.setCoachName(student.getCoachName());
                }
                if (student.getDailyLink() != null) {
                    oldStudent.setDailyLink(student.getDailyLink());
                }
                if (student.getGradeColleage() != null) {
                    oldStudent.setGradeColleage(student.getGradeColleage());
                }
                oldStudent.setUpdate_at(System.currentTimeMillis());

                if (studentService.updateSelective(oldStudent)) {
                    modelAndView.addObject("code", 30);//更新成功
                } else {
                    modelAndView.addObject("code", -31);//更新失败
                }
            } else {
                modelAndView.addObject("code", -32);//这个id对应的记录为空
            }
        } else {
            //输入的id必须为正整数，且至少填写一个字段，不允许输入为空
            modelAndView.addObject("code", -33);
        }
        modelAndView.addObject("student",null);
        modelAndView.setViewName("showJsonFormat");
        return modelAndView;
    }

    //增加数据
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ModelAndView exquteAdd(Student student) {
        logger.info(student.toString());
        if(student.getName()!=null
                ||student.getNumber()!=0
                ||student.getQq()!=0
                ||student.getCoachName()!=null
                ||student.getDailyLink()!=null
                ||student.getGradeColleage()!=null){
            student.setCreate_at(System.currentTimeMillis());
            student.setUpdate_at(System.currentTimeMillis());
            if(studentService.insert(student)) {
                modelAndView.addObject("code", 40);//插入成功
            }else{
                modelAndView.addObject("code", -41);//插入失败
            }
        }else{
            modelAndView.addObject("code", -42);//请至少输入一个非空值
        }
        modelAndView.addObject("student",null);
        modelAndView.setViewName("showJsonFormat");
        return modelAndView;
    }
}






