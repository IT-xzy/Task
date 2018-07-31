package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.PageBean;
import pojo.Student;
import service.StudentServiceImpl;

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
//    @RequestMapping(value = "students", method = RequestMethod.GET)
//    public ModelAndView queryItems() throws Exception
//    {
//        List<Student> students=studentService.findAll();
//        ModelAndView modelAndView=new ModelAndView("index");
//        modelAndView.addObject("list", students);
//        return modelAndView;
//
//    }
//
    @RequestMapping(value = "/students", method = RequestMethod.GET)
//    public ModelAndView selectByPage(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model)
//    {
//        ModelAndView modelAndView = new ModelAndView("list");
//        PageBean<Student> l = studentService.findByPage(currentPage);
//        modelAndView.addObject("list",l);
//        return modelAndView;
//
//    }
public String selectByPage(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model)
    {
        model.addAttribute("pagemsg",studentService.findByPage(currentPage));
        return "list";
    }


//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public ModelAndView selectAll() {
//        List<Student> students = studentService.findAll();
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("list", students);
////        modelAndView.setView(new MappingJackson2JsonView());
//        return modelAndView;
//    }
//    @RequestMapping(value = "students", method = RequestMethod.GET)
//    public ModelAndView selectAll() {
//        List<Student> students = studentService.findAll();
//        logger.info("查询所有学员");
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("list", students);
////        modelAndView.setView(new MappingJackson2JsonView());
//        return modelAndView;
//    }



//    @RequestMapping("/findLikeName")
//    public ModelAndView findLikeName(@RequestParam String stuName) {
//        List<Student> students = studentService.findLikeName(stuName);
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("list", students);
//        return modelAndView;
//    }


    @RequestMapping(value = "/students/stuName",method = RequestMethod.GET)
    public ModelAndView findLikeName(@RequestParam String stuName) {
        logger.info("查询学生 姓名="+stuName);
        List<Student> students = studentService.findLikeName(stuName);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", students);
        return modelAndView;
    }

//
    @RequestMapping(value = "/students/id",method = RequestMethod.GET)
    public ModelAndView findByID(@RequestParam long id) {
        List<Student> students =new ArrayList<>();
        logger.info("查询学生 id="+id);
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

    @RequestMapping( value = "/students",method = RequestMethod.POST)
    public ModelAndView insertStudent(Student student) {
        studentService.insertStudent(student);
        logger.info("2新增学生 "+student);
//        System.out.println(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }

    @RequestMapping(value = "/students/{id}",method = RequestMethod.PUT)
    public ModelAndView editStudent(@PathVariable long id) {
        Student student1 = studentService.findById(id);
        logger.info("查看学生 id="+id);
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

    @RequestMapping(value = "/students",method = RequestMethod.PUT)
    public ModelAndView updateStudent(Student student) {
        studentService.updateStudent(student);
        System.out.println(student);
        logger.info("更新学生 id"+student.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }



//    @RequestMapping(value = "/list" , method = RequestMethod.GET)
//    public String toList(){
//        return  "list";
//

@RequestMapping(value="/students/{id}", method = RequestMethod.DELETE)
public ModelAndView deleteStudent(@PathVariable("id") long id) {
//        Student student=studentService.findById(id);
//    System.out.println(id);
        studentService.deleteById(id);
        logger.info("删除学生 id="+id);
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
    @RequestMapping(value = "/students",method = RequestMethod.DELETE)
    public  ModelAndView deleteAll(){
        studentService.deleteAll();
        logger.info("删除所有学生");
        ModelAndView modelAndView =new ModelAndView("redirect:/students");
        return modelAndView;
    }
}
