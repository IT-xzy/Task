package com.restful.controller;

import com.restful.dao.Validate2;
import com.restful.pojo.Student;
import com.restful.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @ProjectName: task2Restful
 * @Package: com.restful.controller
 * @ClassName: StudentController
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/17 14:35
 * @UpdateUser:
 * @UpdateDate: 2018/5/17 14:35
 * @UpdateRemark:
 * @Version: 1.0
 */
@Controller
@SessionAttributes("pageTimes")
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    StudentService studentService;
    List<Student> students;
    //注入pageSize.properties配置文件中studentPagesize的值
    @Value("#{configProperties['studentPageSize']}")
    private String studentPageSize;
    Logger logger = Logger.getLogger(StudentController.class);

    /**
     * @Description: Welcome to PTTeng.
     * * @param
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/19 12:38
     */
    @RequestMapping("/welcome")
    public String welcome(){

        return "welcome";
    }

    /**
     * @Description: Select all.
     * * @param model
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/17 22:03
     */
/*    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String query(Model model) {
        students = studentService.query();
        model.addAttribute("students", students);
        return "student";
    }*/

    /**
     * @param object
     * @Description: Select by int id or Long qq or String
     * * @param model
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/17 22:04
     */
    @RequestMapping(value = "/student/object", method = RequestMethod.GET)
    public String selectBy(Model model, @RequestParam String object) {

        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$"); //无符号整数
        if (pattern.matcher(object).matches()) {
            if (object.length() > 0 && object.length() < 6) {
                int id = Integer.parseInt(object);
                students = studentService.selectByNumberOrString(id);
            } else {
                Long qq = Long.parseLong(object);
                students = studentService.selectByNumberOrString(qq);
            }

        } else {
            students = studentService.selectByNumberOrString(object);
        }
        model.addAttribute("students", students);
        return "searchStudents";
    }

    /**
     * @param id
     * @Description: Select by id.
     * * @param model
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/17 22:05
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String selectById(Model model, @PathVariable Integer id) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "getById";
    }

    /**
     * @param student
     * @param bindingResult
     * @Description: Select one student using the method above, edit the properties and update.
     * * @param model
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/17 22:06
     */
    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String update(Model model, @Validated(value = Validate2.class) Student student,
                         BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                logger.info(new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"), "UTF-8"));
                model.addAttribute("errors", bindingResult.getAllErrors());
                return "error";
            }
        }
        studentService.updateStudent(student);
        return "redirect:students";
    }

    /**
     * @Description: Delete by id which is in the request.
     * * @param id
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/17 22:09
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/stu/students";
    }

    /**
     * @param student
     * @Description: Insert one student to the student table.
     * * @param model
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/17 22:10
     */
    @RequestMapping(value = "/student/student", method = RequestMethod.POST)
    public String insert(Model model, @Validated(value = Validate2.class) Student student,
                         BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                logger.info(new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"), "utf-8"));
                model.addAttribute("errors", bindingResult.getAllErrors());
                return "error";
            }
        }
        studentService.insertStudent(student);
        return "success";
//        return "redirect:/stu/students";
    }
    /**
     * @Description: Select all students limited by start-index (Integer startRow) and page size (Integer pageSize).
     * * @param page. The page in request helps calculating the start-index.
     * @param model
     * @return: org.springframework.web.servlet.ModelAndView
     * @since: 1.0.0
     * @Date: 2018/5/18 13:39
     */
    @RequestMapping("/students")
    public ModelAndView queryAll(String page, Model model){

        int pageSize = Integer.parseInt(studentPageSize);//每页显示的条数
        List<Student> students = studentService.query();
        model.addAttribute("students",students);
        //students.size()可以用SELECT COUNT (*) FROM student代替
        model.addAttribute("studentNum",students.size());//总数
        int pageTimes;//总页数
        if(students.size()%pageSize == 0){
            pageTimes = students.size()/pageSize;
        } else {
            pageTimes = students.size()/pageSize +1;
        }
        model.addAttribute("pageTimes", pageTimes);
        //如果没有数据，则page等于1
        if(null == page){
            page = "1";
        }
        int startRow = (Integer.parseInt(page)-1)*pageSize;//起始序号等于前面的页数乘以每页的条数
        students = studentService.getByLimit(startRow,pageSize);
        model.addAttribute("currentPage",Integer.parseInt(page));
        model.addAttribute("students",students);
        return new ModelAndView("student");
    }

}
