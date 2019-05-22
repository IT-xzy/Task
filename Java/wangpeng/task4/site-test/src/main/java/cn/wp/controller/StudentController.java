package cn.wp.controller;

import cn.wp.model.Student;
import cn.wp.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/19 17:10
 * @Version: 1.0
 */
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    Logger logger = Logger.getLogger(StudentController.class);

    @RequestMapping(value = "/a/u/student/list", method = RequestMethod.GET)
//    @WebLog(description = "请求主页列表")
    public String selectAll(Model model) {
        try {
            List<Student> students = studentService.selectBySalary();
            logger.info("salary排名前四的学员==================" + students);

            model.addAttribute("students", students);

            model.addAttribute("code", 1);
            return "home";
        } catch (Exception e) {
            model.addAttribute("code", -1);
            return "home";
        }
    }
}
