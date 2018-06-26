package controller;

import POJO.Profession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProfessionService;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author: 曹樾
 * @program: task8newclient
 * @description: second page
 * @create: 2018/6/7 下午2:50
 */
@Controller
public class ProfessionController {
    private static Logger logger = Logger.getLogger("Professioncontroller.class");
    private ProfessionService professionService;
    
    @RequestMapping("/profession")
    public String select(Model model) throws Exception {
        List<Profession> Front = professionService.findFront();
        List<Profession> After = professionService.findAfter();
        List<Profession> OP = professionService.findOP();
        List<Profession> PM = professionService.findPM();
        
        model.addAttribute("afters", After);
        model.addAttribute("fronts", Front);
        model.addAttribute("ops", OP);
        model.addAttribute("pms", PM);
        return "second";
    }
}
