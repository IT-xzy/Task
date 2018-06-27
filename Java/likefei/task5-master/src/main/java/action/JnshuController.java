package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.Job;
import pojo.Student;
import service.GraduateStudentService;
import service.JobService;
import service.StudentService;
import service.UserService;
import utils.Randomlist;

import java.util.List;


@Controller
public class JnshuController {
    @Autowired
    StudentService studentService;
    @Autowired
    GraduateStudentService graduateStudentService;
    @Autowired
    UserService userService;
    @Autowired
    JobService jobService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        int total = studentService.gettotal();
        int gtotal = graduateStudentService.gettotal();
        List studentlist = studentService.list();
        System.out.println(gtotal);
        List randomlist = Randomlist.createRandomList(studentlist,4);
        model.addAttribute("gtotal", gtotal);
        model.addAttribute("total", total);
        model.addAttribute("randomlist",randomlist);
        return "home.page";
    }

    @RequestMapping(value = "/u/company", method = RequestMethod.GET)
    public String company() {
        return "company.page";
    }

    @RequestMapping(value = "/job", method = RequestMethod.GET)
    public String job(Model model) {
        List<Job> jobListtype = jobService.listtype();
        List<Job> jobListall = jobService.list();
        model.addAttribute("jobListall",jobListall);
        model.addAttribute("jobListtype",jobListtype);
        int jtotal = studentService.getjavatotal();
        model.addAttribute("jtotal", jtotal);
        return "job.page";
    }
}
