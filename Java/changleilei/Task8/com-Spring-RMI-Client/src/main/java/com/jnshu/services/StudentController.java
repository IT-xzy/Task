package com.jnshu.services;
import com.jnshu.model.Students;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
    private StudentsService studentsService;
    private static int i = 0;

    public static StudentsService getStudentsService() {
        StudentsService studentsService;
        ApplicationContext ctx;
        //随机取的12以获取不同的服务端
        i = (int) (Math.random() * 2 + 1);
        if (i == 1) {
            try {
                ctx = new ClassPathXmlApplicationContext("com/jnshu/services/Client.xml");
                studentsService = (StudentsService) ctx.getBean("StudentService1");
                logger.info("随机数为一，获取服务一！");
            } catch (Exception e) {
                ctx = new ClassPathXmlApplicationContext("com/jnshu/services/Client.xml");
                studentsService = (StudentsService) ctx.getBean("StudentService2");
                logger.info("随机数为一，获取服务一失败，转获取服务二");
            }
        } else {
            try {
                ctx = new ClassPathXmlApplicationContext("com/jnshu/services/Client.xml");
                studentsService = (StudentsService) ctx.getBean("StudentService2");
                logger.info("随机数为二，获取服务二！");
            } catch (Exception e) {
                ctx = new ClassPathXmlApplicationContext("com/jnshu/services/Client.xml");
                studentsService = (StudentsService) ctx.getBean("StudentService1");
                logger.info("随机数为二，获取服务二失败，转获取服务一");
            }
        }
        return studentsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Login() throws RemoteException {
        return "welcome";
    }

    //查询所有操作
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getAll(Model model) throws IOException {
        studentsService = getStudentsService();
        List<Students> student = studentsService.selectAll();
        logger.info("查看全体学员！");
        model.addAttribute("studentList", student);
        model.addAttribute("check", "当前随机值为" + i);
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
    public String toAdd(@Param("Name") String Name, @Param("Sex") String Sex, HttpServletRequest request, Model model) throws IOException {
        model.addAttribute("check", "当前随机值为" + i);
        if (Name.equals("")) {
            logger.info("注册新学员失败！");
            return "welcome";
        } else {
            model.addAttribute("check", "当前随机值为" + i);
            studentsService = getStudentsService();
            System.out.println(Name + Sex);
            Students student = new Students();
            student.setName(Name);
            student.setSex(Sex);
            studentsService.insert(student);
            request.getSession().setAttribute("student", student);
            logger.info("注册新学员成功！");
            return "redirect:/students";
        }
    }

    //删除操作
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable int id) throws IOException {
        studentsService = getStudentsService();
        studentsService.deleteById(id);
        logger.info("删除了学号为" + id + "的新学员");
        return "redirect:/students";
    }

    //查看单个学员操作
    @RequestMapping(value = "/studentId/{id}", method = RequestMethod.GET)
    public String tostudent(@PathVariable int id, Model model) throws IOException {
        if (id == 0) {
            logger.info("查看新学员失败！");
            return "welcome";
        } else {
            model.addAttribute("check", "当前随机值为" + i);
            studentsService = getStudentsService();
            Students student = studentsService.selectById(id);
            model.addAttribute("student", student);
            return "studentId";
        }
    }

    @RequestMapping(value = "/student/modify/{id}", method = RequestMethod.GET)
    public String tomodify(@PathVariable int id, Model model) throws RemoteException {
        studentsService = getStudentsService();
        Students students = studentsService.selectById(id);
        model.addAttribute("students", students);
        return "modify";
    }

    //查看单个学员操作
    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String modify(@RequestParam("id") int id, @RequestParam("Name") String name, @RequestParam("Sex") String sex, Model model) throws IOException {
        if (id == 0 || name.equals("") || sex.equals("")) {
            logger.info("新学员失败！");
            return "welcome";
        } else {
            model.addAttribute("check", "当前随机值为" + i);
            studentsService = getStudentsService();
            Students students = new Students();
            students.setId(id);
            students.setName(name);
            students.setSex(sex);
            int chjec = studentsService.updateById(students);
            logger.info("更新了学号为" + id + "的学员！");
            return "redirect:/students";
        }
    }
}