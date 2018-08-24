package controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.parser.Token;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.Student;
import service.StudentServiceImpl;
import sun.security.krb5.internal.crypto.dk.DkCrypto;
import util.Page;

import javax.crypto.spec.DESKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    Logger logger = Logger.getLogger("StudentController.class");
    @Autowired
    StudentServiceImpl studentService;


    @RequestMapping("/homepage")
    public ModelAndView countAll() {
        ModelAndView modelAndView = new ModelAndView("stupage1");
        long allstu=0;
        allstu = studentService.countAll();
        long jobNum=0;
        jobNum = studentService.countJob();
        modelAndView.addObject("allstu", allstu);
        modelAndView.addObject("jobNum", jobNum);
//        优秀学员展示
        List<Student> goodlist=null;
        goodlist = studentService.findGood();
//        随机展示一个优秀学员
//        int index1=(int)(Math.random()*goodlist.size());
//        Student student1 = (Student) goodlist.get(index1);
//        modelAndView.addObject("good1",student1);
//        随机展示四个优秀学员
        Random random = new Random();
        List<Integer> tempList = new ArrayList<Integer>();
        List<Student> newList = new ArrayList<Student>();
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            temp = random.nextInt(goodlist.size());
            if (!tempList.contains(temp)) {
                tempList.add(temp);
                newList.add(goodlist.get(temp));
            } else {
                i--;
            }
        }
        modelAndView.addObject("newlist", newList);
        return modelAndView;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView selectByPage(Page page) {
        PageHelper.offsetPage(page.getStart(), 10);
        ModelAndView modelAndView = new ModelAndView("list");
        List<Student> list = studentService.findAll();
        int total = (int) new PageInfo<>(list).getTotal();
        page.calculateLast(total);
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping(value = "/students/stuName", method = RequestMethod.GET)
    public ModelAndView findLikeName(@RequestParam String stuName) {
        logger.info("查询学生 姓名=" + stuName);
        List<Student> students = studentService.findLikeName(stuName);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", students);
        return modelAndView;
    }

    @RequestMapping(value = "/students/id", method = RequestMethod.GET)
    public ModelAndView findByID(@RequestParam long id) {
        List<Student> students = new ArrayList<>();
        logger.info("查询学生 id=" + id);
        students.add(studentService.findById(id));
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", students);
        return modelAndView;
    }



//    @RequestMapping(value = "/students", method = RequestMethod.POST)
//    public ModelAndView insertStudent(Student student) {
//        studentService.insertStudent(student);
//        logger.info("2新增学生 " + student);
//        ModelAndView modelAndView = new ModelAndView("redirect:/students");
//        return modelAndView;
//    }


    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public ModelAndView editStudent(@PathVariable long id) {
        Student student1 = studentService.findById(id);
        logger.info("查看学生 id=" + id);
        ModelAndView mav = new ModelAndView("update");
        mav.addObject("stu", student1);
        return mav;
    }

//    @RequestMapping(value = "/editStudent/{id}")
//    public ModelAndView edit1Student(@PathVariable long id) {
//        Student student1 = studentService.findById(id);
//        logger.info("查看学生 id=" + id);
//        ModelAndView mav = new ModelAndView("update");
//        mav.addObject("stu", student1);
//        return mav;
//    }

    @RequestMapping(value = "/students", method = RequestMethod.PUT)
    public ModelAndView updateStudent(Student student) {
        studentService.updateStudent(student);
        System.out.println(student);
        logger.info("更新学生 id" + student.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable("id") long id) {
        studentService.deleteById(id);
        logger.info("删除学生 id=" + id);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }

    @RequestMapping(value = "/students", method = RequestMethod.DELETE)
    public ModelAndView deleteAll() {
        studentService.deleteAll();
        logger.info("删除所有学生");
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }
//



}
