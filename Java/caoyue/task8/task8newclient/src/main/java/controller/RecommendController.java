package controller;

import POJO.Company;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.OtherPageService;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author: 曹樾
 * @program: task8newclient
 * @description: third page
 * @create: 2018/6/7 下午2:51
 */
@Controller
public class RecommendController {
    private static Logger logger = Logger.getLogger("RecommendController.class");
    private OtherPageService otherPageService;
    
    @RequestMapping("/recommend")
    public String select(Model model) throws Exception {
        List<Company> companies = otherPageService.findCompany();
        model.addAttribute("Company", companies);
        return "third";
    }
}
