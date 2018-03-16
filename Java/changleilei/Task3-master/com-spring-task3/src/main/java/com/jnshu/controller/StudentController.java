package com.jnshu.controller;
import com.jnshu.model.Student;
import com.jnshu.service.Impl.StudentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    //首先进入首页
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws IOException {
        return "welcome";
    }

    //查询所有操作
    @RequestMapping(value = "/student/List", method = RequestMethod.GET)
    public String getAll(Model model) throws IOException {
        long beginm = System.currentTimeMillis();
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("studentList", studentList);
        return "studentList";
    }

    //新增操作
    @RequestMapping(value = {"/student/register"}, method = {RequestMethod.GET})
    public String registerStudent() throws IOException {
        return "student";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String toAdd(@Param("Name") String Name, @Param("Sex") String Sex, @Param("QQ") String QQ, @Param("Graduate") String Graduate, @Param("Number") String Number, @Param("Autograph") String Autograph, HttpServletRequest request) throws IOException {
        long beginm = System.currentTimeMillis();
        if (Name == null || Objects.equals("", Name)) {
            return "welcome";
        } else {
            System.out.println(Name + Sex + QQ + Graduate + Number + Autograph);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Student student = new Student();
            student.setName(Name);
            student.setSex(Sex);
            student.setQq(QQ);
            student.setGraduate(Graduate);
            student.setNumber(Number);
            student.setAutograph(Autograph);
            student.setCreatetime(df.format(new Date()));
            long dbegin = System.currentTimeMillis();
            studentService.insertStudent(student);
            return "redirect:/student/List";
        }
    }

    //删除操作
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable int id) throws IOException {
        long beginm = System.currentTimeMillis();
        studentService.deleteStudent(id);
        return "redirect:/student/List";
    }

    //更新操作
    @RequestMapping(value = "/student/modify", method = {RequestMethod.GET})
    public String tomodify() throws IOException {
        return "modify";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String modify(@Param("Id") Integer id, @Param("Name") String Name, @Param("Sex") String Sex, @Param("QQ") String QQ, @Param("Graduate") String Graduate, @Param("Number") String Number, @Param("Autograph") String Autograph, HttpServletRequest request) throws IOException {
        //System.out.println("\t1\t" + id + "\t2\t" + Name + "\t3\t" + Sex + "\t4\t" + QQ + "\t5\t" + Graduate + "\t6\t" + Number + "\t7\t" + Autograph);
        long beginm = System.currentTimeMillis();
        int a = studentService.countStudentById(id);
        long dbendc = System.currentTimeMillis();
        if (id == null && a == 0) {
            return "modify";
        } else {
            Student student = new Student();
            student.setId(id);
            student.setName(Name);
            student.setSex(Sex);
            student.setQq(QQ);
            student.setGraduate(Graduate);
            student.setNumber(Number);
            student.setAutograph(Autograph);
            a = studentService.updateStudent(student);
            long dbendup = System.currentTimeMillis();
            if (a >= 0) {
                return "redirect:/student/List";
            } else {
                return "modify";
            }
        }
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String student(@PathVariable int id, Model model) throws Exception {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "showStudent";
    }
}