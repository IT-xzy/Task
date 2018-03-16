package com.jnshu.controller;

import com.jnshu.model.Student;
import com.jnshu.service.Impl.StudentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    private static Logger logger=Logger.getLogger("StudentController.class");

    //首先进入首页
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index() {
        logger.info("访问首页中！");
        return "welcome";
    }

    //查询所有操作
    @RequestMapping(value="/students", method=RequestMethod.GET)
    public String getAll(Model model,HttpServletResponse response) throws IOException {
        String josn=null;
        if (studentService.countAll()==0) {
            logger.info("没有学员可以查找！");
            josn="<script language=\"javascript\"> alert(\"111王！\")\n"+"</script>";
            try {
                response.getWriter().print(josn);
                response.getWriter().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "jsona";
        } else {
            josn="{success:false,msg:修改失败！“}";
        }
        List<Student> student=studentService.getAllStudent();
        logger.info("查看全体学员！");
        model.addAttribute("studentList",student);
        return "students";
    }

    //新增操作
    @RequestMapping(value={"/student/register"}, method={RequestMethod.GET})
    public String registerStudent() throws IOException {
        logger.info("开始注册新学员！");
        return "student";
    }

    @RequestMapping(value="/student", method=RequestMethod.POST)
    public String toAdd(@Param("Name") String Name,@Param("Sex") String Sex,@Param("QQ") String QQ,@Param("Graduate") String Graduate,@Param("Number") String Number,@Param("Autograph") String Autograph,HttpServletRequest request) throws IOException {
        if (Name==null||Objects.equals("",Name)) {
            logger.info("注册新学员失败！");
            return "welcome";
        } else {
            System.out.println(Name+Sex+QQ+Graduate+Number+Autograph);
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Student student=new Student();
            student.setName(Name);
            student.setSex(Sex);
            student.setQq(QQ);
            student.setGraduate(Graduate);
            student.setNumber(Number);
            student.setAutograph(Autograph);
            student.setCreatetime(df.format(new Date()));
            studentService.insertStudent(student);
            request.getSession().setAttribute("student",student);
            logger.info("注册新学员成功！");
            return "redirect:/students";
        }
    }

    //删除操作
    @RequestMapping(value="/student/{id}", method=RequestMethod.DELETE)
    public String del(@PathVariable int id) throws IOException {
        studentService.deleteStudent(id);
        logger.info("删除了学号为"+id+"的新学员");
        return "redirect:/students";
    }

    //更新操作
    @RequestMapping(value="/student/modify", method={RequestMethod.GET})
    public String tomodify() throws IOException {
        logger.info("开始更新学员信息！");
        return "modify";
    }

    @RequestMapping(value="/student/{id}", method=RequestMethod.PUT)
    public String modify(@Param("Id") Integer id,@Param("Name") String Name,@Param("Sex") String Sex,@Param("QQ") String QQ,@Param("Graduate") String Graduate,@Param("Number") String Number,@Param("Autograph") String Autograph,HttpServletRequest request) throws IOException {
        System.out.println("\t1\t"+id+"\t2\t"+Name+"\t3\t"+Sex+"\t4\t"+QQ+"\t5\t"+Graduate+"\t6\t"+Number+"\t7\t"+Autograph);
        int a=studentService.countStudentById(id);
        if (id==null&&a==0) {
            logger.info("不存在该ID记录或者传输的ID为空！");
            return "modify";
        } else {
            Student student=new Student();
            student.setId(id);
            student.setName(Name);
            student.setSex(Sex);
            student.setQq(QQ);
            student.setGraduate(Graduate);
            student.setNumber(Number);
            student.setAutograph(Autograph);
            a=studentService.updateStudent(student);
            if (a>=0) {
                logger.info("更新学员员"+student+"成功");
                return "redirect:/students.do";
            } else {
                logger.info("更新学员员"+student+"失败");
                return "modify";
            }
        }
    }

    @RequestMapping(value="/json", method=RequestMethod.GET, headers="Accept=application/json")
    public String jsonTest(HttpServletRequest request) throws IOException {
        request.getHeader("Accept");
        request.getSession().setAttribute("head",request.getHeader("Accept"));
        logger.info("使用Json接口");
        return "jsona";
    }


    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String student(@PathVariable int id,Model model) throws Exception {
        Student student =  studentService.getStudentById(id);
        logger.info("进入大撒旦");
        model.addAttribute("student",student);
        return "showstudent";
    }
}