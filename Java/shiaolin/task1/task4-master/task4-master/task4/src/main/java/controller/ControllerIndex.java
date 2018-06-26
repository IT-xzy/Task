package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Job;
import pojo.Student;
import service.ServiceIndex;
import service.Servicejob;

import java.util.List;

@Controller
public class ControllerIndex {
    @Autowired
    ServiceIndex serviceIndex;
    @Autowired
    Servicejob servicejob;
    @RequestMapping("/")
    public String index(Model model) {
        List<Student> studentList=serviceIndex.listStudent();
        model.addAttribute(studentList);
        return "/WEB-INF/tiles/index";
    }
    @RequestMapping("/cooperate")
    public String cooperate(Model model) {
        return "WEB-INF/tiles/cooperate_page";
    }
    @RequestMapping("/joblist")
    public String list(Model model) {
        List<Job> jobList=servicejob.listJob();
        int count=serviceIndex.count();
        model.addAttribute("count",count);
        model.addAttribute(jobList);
        return "/WEB-INF/tiles/list_page";
    }
}
