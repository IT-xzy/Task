package com.jnshu.services;

import com.jnshu.model.Students;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

@Controller
public class StudentController {
    private static Logger logger = Logger.getLogger("StudentController.class");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Login() throws RemoteException {
        return "welcome";
    }

    //查询所有操作
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getAll(Model model) throws IOException {
        StudentsServices studentsService = SelectRMI.selectRMI();
        logger.info("运行到这里了");
        List<Students> student = studentsService.selectAll();
        logger.info("查看全体学员！");
        model.addAttribute("studentList", student);
        return "students";
    }

    //跳转新增操作
    @RequestMapping(value = {"/student/register"}, method = {RequestMethod.GET})
    public String registerStudent() throws IOException {
        logger.info("开始注册新学员！");
        return "student";
    }

    //新增操作
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String toAdd(@Param("uname") String uname, @Param("usex") String usex, HttpServletRequest request) throws IOException {
        if (uname == "" || usex == "") {
            logger.info("注册新学员失败！");
            return "student";
        } else {
            StudentsServices studentsService = SelectRMI.selectRMI();
            System.out.println(uname + usex);
            Students student = new Students();
            student.setUname(uname);
            student.setUsex(usex);
            studentsService.insert(student);
            request.getSession().setAttribute("student", student);
            logger.info("注册新学员成功！");
            return "redirect:/students";
        }
    }

    //删除操作
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable Long id) throws IOException {
        StudentsServices studentsService = SelectRMI.selectRMI();
        studentsService.deleteById(id);
        logger.info("删除了学号为" + id + "的新学员");
        return "redirect:/students";
    }

    //查看单个学员操作
    @RequestMapping(value = "/studentId/{id}", method = RequestMethod.GET)
    public String tostudent(@PathVariable Long id, Model model) throws IOException {
        if (id == 0) {
            logger.info("查看新学员失败！");
            return "welcome";
        } else {
            StudentsServices studentsService = SelectRMI.selectRMI();
            Students student = studentsService.selectById(id);
            model.addAttribute("student", student);
            return "studentId";
        }
    }

    @RequestMapping(value = "/student/modify/{id}", method = RequestMethod.GET)
    public String tomodify(@PathVariable Long id, Model model) throws RemoteException {
        StudentsServices studentsService = SelectRMI.selectRMI();
        Students students = studentsService.selectById(id);
        model.addAttribute("students", students);
        return "modify";
    }

    //查看单个学员操作
    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String modify(@RequestParam("id") Long id, @RequestParam("uname") String uname, @RequestParam("usex") String usex, Model model) throws IOException {
        if (id == 0 || uname.equals("") || usex.equals("")) {
            logger.info("新学员失败！");
            return "welcome";
        } else {
            StudentsServices studentsService = SelectRMI.selectRMI();
            Students students = new Students();
            students.setId(id);
            students.setUname(uname);
            students.setUsex(usex);
            int chjec = studentsService.updateById(students);
            logger.info("更新了学号为" + id + "的学员！");
            return "redirect:/students";
        }
    }
}