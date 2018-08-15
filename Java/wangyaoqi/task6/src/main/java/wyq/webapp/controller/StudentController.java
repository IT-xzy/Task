package wyq.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wyq.webapp.pojo.Student;
import wyq.webapp.service.StudentService;
import wyq.webapp.util.Page;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/u/students",method = RequestMethod.GET)
    public ModelAndView listStudent(){
        List<Student> students= studentService.list();
//        int total = studentService.total();
//        page.caculateLast(total);
        modelAndView.addObject("students",students);
//        modelAndView.addObject("page",page);
        modelAndView.setViewName("students");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/u/student",method = RequestMethod.PUT)
    public ModelAndView addStudent(Student student){
        studentService.addStudent(student);
        modelAndView.setViewName("redirect:/u/students");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/u/student/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
        modelAndView.setViewName("redirect:/u/students");
        return modelAndView;
    }

    @RequestMapping(value = "/u/student",method = RequestMethod.POST)
    public ModelAndView outlogin(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            cookie.setValue(null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            break;
        }
        modelAndView.setViewName("user");
        return modelAndView;
    }

//    @ResponseBody
//    @RequestMapping(value = "/u/student/{id}",method = RequestMethod.POST)
//    public ModelAndView updateStudent(Student student){
//        studentService.updateStudent(student);
//        modelAndView.setViewName("redirect:/students");
//        return modelAndView;
//    }

//    @ResponseBody
//    @RequestMapping(value = "/u/student/{id}",method = RequestMethod.GET)
//    public ModelAndView showStudent(@PathVariable("id") int id){
//        Student student=studentService.getById(id);
//        modelAndView.addObject("student",student);
//        modelAndView.setViewName("editStudent");
//        return modelAndView;
//    }
}
