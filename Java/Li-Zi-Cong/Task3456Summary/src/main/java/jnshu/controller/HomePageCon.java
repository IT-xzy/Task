package jnshu.controller;
import jnshu.pojo.Student;
import jnshu.service.CompoundService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class HomePageCon {

    @Autowired
    private CompoundService compoundService;

    Logger logger = Logger.getLogger(HomePageCon.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String homePageCon(Model model){
        System.out.println("HomePage Controller Working");
        try {
            List<Student> list = compoundService.homePage();
//            list.forEach(System.out::println);
            model.addAttribute("title", "首页");
            model.addAttribute("lists", list);
            return "home";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
            return null;
    }

//    @RequestMapping(value = "/")
//    public String testAjax(){
//        return "testAjax";
//    }

}
