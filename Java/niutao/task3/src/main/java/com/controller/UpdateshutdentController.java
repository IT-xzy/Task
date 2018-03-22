package com.controller;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.GetStudent;
import com.service.InStudent;
import com.service.UpdateStudent;
import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateshutdentController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    Student student;
    @Autowired
    UpdateStudent updateStudent;
    @Autowired
    GetStudent getStudent;

    @RequestMapping(value = "/updatestudent/{id}",method = RequestMethod.GET)
    public ModelAndView showstudent(@PathVariable int id) throws Exception {
        //ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        //StudentMapper studentMapper = (StudentMapper) context.getBean("studentMapper");
        //GetStudent getStudent = new GetStudent();
        getStudent.setStudentMapper(studentMapper);
        Student student =  getStudent.doSomeBusinessStuff(id);
        return new ModelAndView("updatestudent","student",student);

    }

    @RequestMapping(value = "/updatestudent",method = RequestMethod.POST)
    public String updatestudent(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("qq") String qq,
            @RequestParam("class_id") int class_id,
            @RequestParam("graduate_school") String graduate_school,
            @RequestParam("oline_number") String oline_number,
            @RequestParam("link") String link,
            @RequestParam("wish") String wish,
            @RequestParam("brother_id") int brother_id
    ) throws Exception {
        Logger logger = (Logger) LoggerFactory.getLogger(AddStudentController.class);
        logger.info("/updatestudent");
        //ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        //StudentMapper studentMapper = (StudentMapper) context.getBean("studentMapper");
        //Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setQq(qq);
        student.setClass_id(class_id);
        student.setGraduate_school(graduate_school);
        student.setOline_number(oline_number);
        student.setLink(link);
        student.setWish(wish);
        student.setBrother_id(brother_id);
        //UpdateStudent updateStudent = new UpdateStudent();
        updateStudent.setStudentMapper(studentMapper);
        updateStudent.doSomeBusinessStuff(student);
        return "redirect:/";
    }
}
