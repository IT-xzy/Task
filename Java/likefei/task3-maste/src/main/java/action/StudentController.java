package  action;

import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;
import pojo.Student;
import service.StudentService;
import page.Page;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value="/student",method=RequestMethod.GET)
    public  ModelAndView listStudent(Page page){
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.offsetPage(page.getStart(),10);
        List<Student> studentList= studentService.list();
        int total=(int) new PageInfo<>(studentList).getTotal();
        page.caculateLast(total);
        // 放入转发参数
        modelAndView.addObject("studentList", studentList);
        // 放入jsp路径
        modelAndView.setViewName("listStudent");
        return modelAndView;
    }
    @RequestMapping(value="/student",method= RequestMethod.POST)
    public ModelAndView addStudent(Student student){
        studentService.add(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        return modelAndView;
    }
    @RequestMapping(value="/student/{id}/profile",method=RequestMethod.GET)
    public ModelAndView eidestudent(@PathVariable("id") int id){
        Student student = studentService.get(id);
        ModelAndView modelAndView =new ModelAndView("editstudent");
        modelAndView.addObject("student",student);
        return  modelAndView;
    }
    @RequestMapping(value = "/student/{id}",method=RequestMethod.POST)
    public ModelAndView updatestudent(Student student){
        studentService.update(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        return  modelAndView;
    }
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
       public ModelAndView deleteStudent( @PathVariable("id") int id){
        studentService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request){
        String username=request.getParameter("userid");
        String userpass=request.getParameter("userpass");
        if(username.equals("lkf1995")&&userpass.equals("userpass"))
        {
            ModelAndView modelAndView = new ModelAndView("redirect:/student");
            return  modelAndView;
        }
     else {
            ModelAndView modelAndView = new ModelAndView("redirect:/main");
            return  modelAndView;
        }
    }
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        return  modelAndView;
}
    @RequestMapping(value = "/student/select",method = RequestMethod.POST)
    public ModelAndView select(HttpServletRequest request){
     int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.get(id);
        ModelAndView modelAndView =new ModelAndView("editstudent");
        modelAndView.addObject("student",student);
        return  modelAndView;
    }
    @RequestMapping(value = "/jsontest", method = RequestMethod.GET)
    public String json(ModelMap modelMap) {
        List<String> list = new ArrayList<>();
        list.add("袁磊");
        list.add("郭超");
        list.add("吴艺强");
        modelMap.addAttribute("list", list);
        return "jsontest";
    }
}
