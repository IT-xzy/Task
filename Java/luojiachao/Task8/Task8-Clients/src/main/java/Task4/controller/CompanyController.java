package Task4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping
public class CompanyController {

    @RequestMapping("/company")
    public ModelAndView task9(){
        ModelAndView mav = new ModelAndView();
        String title = "合作企业";
        mav.addObject("title",title);
        return mav;
    }
}
