package wyq.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wyq.webapp.pojo.OutstandingStudent;
import wyq.webapp.service.OutstandingStduentService;
import wyq.webapp.util.PageForMain;

import java.util.List;

@Controller
public class OutstandingStudentController {
    @Autowired
    OutstandingStduentService outstandingStduentService;
    ModelAndView modelAndView = new ModelAndView();

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView get(PageForMain page){
        List<OutstandingStudent> outstandingStudents = outstandingStduentService.get(page);
        int total = outstandingStduentService.total();
        page.caculateLast(total);
        modelAndView.addObject("students",outstandingStudents);
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
