package Task4.controller;

import Task4.rmi.RandomService;
import Task4.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/u")
public class PositionController {

    @Autowired
    private RandomService randomService;
//    @Qualifier("rmiPositionA")
//    PositionService positionService;

    @RequestMapping(value = "/position",method = RequestMethod.GET)
    public ModelAndView position(){
        PositionService positionService=randomService.getPositionService();
        ModelAndView mav =new ModelAndView();
        String title = "职业";
        ArrayList list =new ArrayList<>(10);
        for (int i = 1;i <= positionService.findAll();i++){
            list.add(positionService.findById(i));
        }
        //0=HTML 1=JAVA 2=Python 3=CSS 4=JS 5=Android 6=IOS 7=OP 8=PM 9=UI
        mav.addObject("title",title);
        mav.addObject("list",list);
        mav.setViewName("position");
        return mav;
    }
}
