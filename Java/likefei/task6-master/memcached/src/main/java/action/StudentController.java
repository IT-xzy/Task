package  action;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.Student;
import service.StudentService;
import java.util.List;


@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView  listStudent() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList=studentService.list();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("task2/listStudent");
        return modelAndView;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(@Validated Student student,BindingResult bindingResult,Model model) {
        long createtime = System.currentTimeMillis();
        long updatetime = System.currentTimeMillis();
        student.setCreatetime(createtime);
        student.setUpdatetime(updatetime);
        studentService.add(student);
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/{id}/profile", method = RequestMethod.GET)
    public String eidestudent(@PathVariable("id") Integer id,Model model) {
        Student student = (Student)studentService.get(id);
        model.addAttribute("student",student);
        return "/task2/editstudent";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
    public ModelAndView updatestudent(Student student,BindingResult bindingResult,Model model) {
        long updatetime = System.currentTimeMillis();
        student.setUpdatetime(updatetime);
        studentService.update(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        return modelAndView;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String deleteStudent( @PathVariable("id") Integer id,Model model) {
        studentService.delete(id);
        return "redirect:/student";
    }

    @RequestMapping(value = "/student/select", method = RequestMethod.POST)
    public String select(Integer id, Model model){
        Student student1 = (Student)studentService.get(id);
        model.addAttribute("student",student1);
        return "/task2/editstudent";
    }

    @RequestMapping(value = "/jsontest",method = RequestMethod.GET)
    public String jsontest(Model model){
       List<Student> list = studentService.list();
       model.addAttribute("list",list);
       return "/task2/json";
    }
}
