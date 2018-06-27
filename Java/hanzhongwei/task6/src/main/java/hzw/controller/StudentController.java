package hzw.controller;

import hzw.model.Student;
import hzw.service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String student(Model model){
        logger.info("进入学员展示页");
        List<Student> list = studentService.findListStudent();
        model.addAttribute("student",list);
        return "index";
    }

    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public String addStudent(Student student){
        logger.info("进入添加"+student);
        studentService.insertStudent(student);
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/{sId}",method = RequestMethod.DELETE)
    public String deleteStudent(Student student){
        logger.info("删除信息"+student);
        studentService.deleteStudent(Math.toIntExact(student.getsId()));
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/{sId}",method = RequestMethod.POST)
    public String updateStudent(Student student,Model model){
        logger.info("跟新信息"+student);
        studentService.updateStudent(student);
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/insert/{sId}",method = RequestMethod.GET)
    public String getIdStudent(Student student, Model model){
        logger.info("查询信息"+student);
        student = studentService.getID(student.getsId());
        model.addAttribute("s",student);
        return "updateStudent";
    }
}
