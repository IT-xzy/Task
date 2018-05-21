package controller;

import ServiceImpl.Online_studentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Student;
import pojo.job;
import service.JobService;
import service.Online_studentService;
import service.StudentService;
import sun.print.SunPrinterJobService;

import java.util.List;

@Controller
public class StudentController {
@Autowired
StudentService studentService;

@Autowired
Online_studentService online_studentService;

@Autowired
    JobService jobService;


@RequestMapping(value = "/home",method= RequestMethod.GET)
    public String home(Model model){
    int total = studentService.count();
    int gtotal = online_studentService.gtotal();
    model.addAttribute("total",total);
    model.addAttribute("gtotal",gtotal);
    return "home.page";
}

@RequestMapping(value = "/u/student/profile/{id}", method = RequestMethod.GET)
    public ModelAndView select(@PathVariable("id") int id){
     Student student=studentService.select(id);
     ModelAndView  mav = new ModelAndView("task4/student");
     mav.addObject("student",student);
     return mav;

    }
   @RequestMapping(value = "/job",method = RequestMethod.GET)
    public String job(Model model){
    List<job> jobType = jobService.jobType();
    List<job>  jobList = jobService.jobList();
    model.addAttribute("jobType",jobType);
    model.addAttribute("jobList",jobList);
    return "job.page";
    }

}
