package  action;

import com.github.pagehelper.PageHelper;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.Student;
import service.StudentService;
import utils.Page;
import com.github.pagehelper.PageInfo;
import validator.ValidatorGroup1;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView listStudent(Page page) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.offsetPage(page.getStart(), 10);
        List<Student> studentList = studentService.list();
        int total = (int) new PageInfo<>(studentList).getTotal();
        page.caculateLast(total);
//        // 放入转发参数
        modelAndView.addObject("studentList", studentList);
//        // 放入jsp路径
        modelAndView.setViewName("task2/listStudent");
        return modelAndView;
    }
//    @RequestMapping(value = "/student",method = RequestMethod.GET)
//    public String liststudent(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,Model model)
//    {
//        PageInfo pageInfo = studentService.page(pn);
//
//        model.addAttribute("pageInfo",pageInfo);
//        return "task2/listStudent";
////        PageHelper.startPage(pn,10);
////        List<Student> studentList = studentService.list();
////        PageInfo pageInfo = new PageInfo<>(studentList,10);
////        map.put("pageInfo",pageInfo);
////        return "test";
//    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(@Valid Student student,BindingResult bindingResult,Model model) {
        long createtime = System.currentTimeMillis();
        long updatetime = System.currentTimeMillis();
        student.setCreatetime(createtime);
        student.setUpdatetime(updatetime);
        studentService.add(student);
        return "redirect:/student";
    }


    //这里model有bug 没法参数检验
    @RequestMapping(value = "/student/{id}/profile", method = RequestMethod.GET)
    public String eidestudent(@PathVariable("id") Integer id,Model model) {
        Student student = studentService.get(id);
        model.addAttribute("student",student);
//        ModelAndView modelAndView = new ModelAndView("task2/editstudent");
//        modelAndView.addObject("student", student);
//        return modelAndView;
        return "/task2/editstudent";
    }


    @RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
    public ModelAndView updatestudent(@Valid Student student,BindingResult bindingResult,Model model) {
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
//    public String select(@Validated(value = {ValidatorGroup1.class}) Student student, BindingResult bindingResult, Model model)
    public String select(Integer id, Model model){
        Student student1 = studentService.get(id);
        model.addAttribute("student",student1);
        return "/task2/editstudent";
    }


    @RequestMapping(value = "/jsontest", method = RequestMethod.GET)
    public String json(ModelMap modelMap) {
        List<String> list = new ArrayList<>();
        list.add("袁磊");
        list.add("郭超");
        list.add("吴艺强");
        modelMap.addAttribute("list", list);
        return "task2/jsontest";
    }
}
