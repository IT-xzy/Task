package cn.wyq.controller;

import cn.wyq.pojo.OutstandingStudent;
import cn.wyq.service.OutstandingStudentService;
import cn.wyq.util.PageForMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OutstandingStudentController {
    @Autowired
    OutstandingStudentService outstandingStudentService;
    ModelAndView modelAndView = new ModelAndView();

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView get(PageForMain page){
        List<OutstandingStudent> outstandingStudents = outstandingStudentService.get(page);
        int total = outstandingStudentService.total();
        page.caculateLast(total);
        modelAndView.addObject("students",outstandingStudents);
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
