package controller;

import POJO.Cooperation;
import POJO.GreatStudent;
import POJO.HowToStudy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.OtherPageService;
import utils.SelectRMI;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author: 曹樾
 * @program: task8newclient
 * @description: first page
 * @create: 2018/6/7 下午2:49
 */

@Controller
public class MainController {
    private static Logger logger=Logger.getLogger("MainController.class");
//    private OtherPageService otherPageService;
    OtherPageService otherPageService= SelectRMI.selectRMI();
    @RequestMapping("/index")
    public String select(Model model) throws Exception {
        List<GreatStudent> greatStudents = otherPageService.findStudentByName();
        List<Cooperation> cooperation = otherPageService.findCooperation();
        List<HowToStudy> howToStudies = otherPageService.findStudy();
        model.addAttribute("lists", greatStudents);
        model.addAttribute("cooperation", cooperation);
        model.addAttribute("study", howToStudies);
        
        return "first";
    }

}
