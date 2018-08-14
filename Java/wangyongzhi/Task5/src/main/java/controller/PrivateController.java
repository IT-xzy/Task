package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ProfService;

@Controller
@RequestMapping(value = "/u")//此controller都带前缀/u，进入之前会被拦截器拦截
public class PrivateController {

    @Autowired
    ProfService profService;

    @RequestMapping(value = "/profession", method = RequestMethod.GET)
    public ModelAndView listProf() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("prof", profService.getByProf("java后端工程师"));
        mav.setViewName("profession");
        return mav;
    }
}
