package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import pojo.PageBean;
import pojo.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.sound.midi.Soundbank;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
//@RequestMapping("/student")
public class StudentController {
    Logger logger = Logger.getLogger("StudentController.class");
    @Autowired
    StudentServiceImpl studentService;

    //
//@RequestMapping(value = "/find",method = RequestMethod.GET)
//    public ModelAndView findById(@RequestParam("id") long id) {
//    Student student=studentService.findById(id);
//    ModelAndView modelAndView=new ModelAndView("student");
//    modelAndView.addObject("student",student);
//    return  modelAndView;
//}
//@RequestMapping("/student")
//public ModelAndView findAll(){
//    ModelAndView modelAndView = new ModelAndView("student");
//    List<Student> list = studentService.findAll();
//    modelAndView.addObject("list",list);
//    return modelAndView;
//}
//
//    @RequestMapping("/queryUser")
//    public ModelAndView queryItems() throws Exception
//    {
//        List<Student> users=studentService.findAll();
//        System.out.println("users:"+users);
//        ModelAndView modelAndView=new ModelAndView("index");
//        modelAndView.addObject("UserList", users);
//        return modelAndView;
//
//    }
//
//    @RequestMapping("/list")
//    public ModelAndView selectbypage(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model)
//    {
//        ModelAndView modelAndView = new ModelAndView("list");
//        List<Student> l = studentService.findByPage(currentPage);
//        modelAndView.addObject("list",l);
//        return modelAndView;
//
//    }
//public String selectbypage(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model)
//    {
//   model.addAttribute("pagemsg",studentService.findByPage(currentPage));
//        return "list";
//    }
//

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public ModelAndView selectAll() {
//        List<Student> students = studentService.findAll();
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("list", students);
////        modelAndView.setView(new MappingJackson2JsonView());
//        return modelAndView;
//    }
    @RequestMapping(value = "students", method = RequestMethod.GET)
    public ModelAndView selectAll() {
        List<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", students);
//        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }



//    @RequestMapping("/findLikeName")
//    public ModelAndView findLikeName(@RequestParam String stuName) {
//        List<Student> students = studentService.findLikeName(stuName);
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("list", students);
//        return modelAndView;
//    }


    @RequestMapping(value = "students/stuName",method = RequestMethod.GET)
    public ModelAndView findLikeName(@RequestParam String stuName) {
        logger.info("查询学生姓名"+stuName);
        List<Student> students = studentService.findLikeName(stuName);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", students);
        return modelAndView;
    }

//
    @RequestMapping(value = "/students/id",method = RequestMethod.GET)
    public ModelAndView findByID(@RequestParam long id) {
        List<Student> students =new ArrayList<>();
        students.add(studentService.findById(id));
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", students);
        return modelAndView;
    }


    //添加用户
//    @RequestMapping("insertStudent")
//    public ModelAndView insertStudent(Student student) {
//        studentService.insertStudent(student);
//        ModelAndView modelAndView = new ModelAndView("redirect:/list");
//        return modelAndView;
//    }

//    @RequestMapping(value = "/student" ,method = RequestMethod.POST)
//    public ModelAndView insertStudent(Student student) {
//        studentService.insertStudent(student);
//        ModelAndView modelAndView = new ModelAndView("redirect:/list");
//
//        return modelAndView;
//    }

    @RequestMapping( value = "students",method = RequestMethod.POST)
    public ModelAndView insertStudent(Student student) {
        studentService.insertStudent(student);
        System.out.println(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }

    @RequestMapping(value = "students/{id}",method = RequestMethod.GET)
    public ModelAndView editStudent(@PathVariable long id) {
        Student student1 = studentService.findById(id);
        ModelAndView mav = new ModelAndView("update");
        mav.addObject("stu", student1);
        return mav;
    }

//    @RequestMapping(value = "/list/{id}",method = RequestMethod.PUT)
//    public ModelAndView editStudent(@PathVariable long id, Student student) {
//        Student student1 = studentService.findById(student.getId());
//        ModelAndView mav = new ModelAndView("update");
//        mav.addObject("stu", student1);
//        return mav;
//    }



//    @RequestMapping("updateStudent")
//    public ModelAndView updateStudent(Student student) {
//        studentService.updateStudent(student);
//        System.out.println(student);
//        ModelAndView modelAndView = new ModelAndView("redirect:/list");
//        return modelAndView;
//    }

    @RequestMapping(value = "students",method = RequestMethod.PUT)
    public ModelAndView updateStudent(Student student) {
        studentService.updateStudent(student);
        System.out.println(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }



//    @RequestMapping(value = "/list" , method = RequestMethod.GET)
//    public String toList(){
//        return  "list";
//

@RequestMapping(value="students/{id}", method = RequestMethod.DELETE)
public ModelAndView deleteStudent(@PathVariable("id") long id) {
//        Student student=studentService.findById(id);
//    System.out.println(id);
        studentService.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }


//
//    @RequestMapping("deleteStudent")
//    public ModelAndView deleteStudent(Student student) {
//        studentService.deleteById(student.getId());
//        ModelAndView modelAndView = new ModelAndView("redirect:/list");
//        return modelAndView;
//    }
    @RequestMapping(value = "students",method = RequestMethod.DELETE)
    public  ModelAndView deleteAll(){
        studentService.deleteAll();
        ModelAndView modelAndView =new ModelAndView("redirect:/students");
        return modelAndView;
    }
}
