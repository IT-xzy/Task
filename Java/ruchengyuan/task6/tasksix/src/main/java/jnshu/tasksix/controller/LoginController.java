package jnshu.tasksix.controller;

import jnshu.tasksix.model.Student;

import jnshu.tasksix.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 处理登陆后的业务
 * @author: Administrator
 * @date: 2017-10-21
 * @Time: 上午 12:43
 * Description:
 **/

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;

    private static Logger loggerCommCon = LoggerFactory.getLogger(LoginController.class);


    //查询所有学生信息JSON格式
    @RequestMapping(value="/a/u/student/all",method = RequestMethod.GET)
    public String studentAll(HttpServletRequest request, HttpServletResponse response, Model model) {
        try{
            List<Student> students = studentService.listStudentTable();
            loggerCommCon.info("students number: "+students.size());
            model.addAttribute("students",students);
        }catch (Throwable t){
            t.printStackTrace();
            loggerCommCon.error(t.getMessage());
            return "/common/errorJson";
        }
        return "student/studyAll";
    }


    //表格界面
    @RequestMapping(value="/a/u/student/table",method = RequestMethod.GET)
    public String studentTable(HttpServletRequest request, HttpServletResponse response, Model model) {
        try{
            List<Student> studentTable = studentService.listStudentTable();
            loggerCommCon.info("studentTable : "+studentTable.size());
            model.addAttribute("studentTable",studentTable);
        }catch (Throwable t){
            t.printStackTrace();
            loggerCommCon.error(t.getMessage());
            return "/common/errorJson";
        }
        return "student/studentTable";
    }
}