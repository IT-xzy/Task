package task04tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Administrator
 */

@Controller
public class SpringTilesController {

    @RequestMapping(value="/page11",method = RequestMethod.GET)
    public ModelAndView tiles10 (){
        ModelAndView mav = new ModelAndView("page01");
        return mav;
    }

    @RequestMapping(value="/page12",method = RequestMethod.GET)
    public String tiles11 (){
        ModelAndView mav = new ModelAndView("page02");
        return "page02";
    }

}
