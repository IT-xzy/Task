package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.model.Occupation;
import spring.service.OccupationService;
import spring.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("u")
public class OccupationController {
    @Autowired
    private OccupationService occupationService;
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "occupation",method = RequestMethod.GET)
    public ModelAndView testView(){
        ModelAndView mav = new ModelAndView("meView");
        List<Occupation> list = occupationService.query();
        int a = studentService.getJava();
        int b = studentService.getWeb();
        int c = studentService.getPm();
        mav.addObject("a",a);
        mav.addObject("b",b);
        mav.addObject("c",c);
        mav.addObject("list",list);
        return mav;
    }
}
