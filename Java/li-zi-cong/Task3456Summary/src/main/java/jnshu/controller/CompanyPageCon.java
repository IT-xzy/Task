package jnshu.controller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyPageCon {

    Logger logger = Logger.getLogger(CompanyPageCon.class);

    @RequestMapping("/company")
    public ModelAndView task9(){
        try {
            System.out.println("CompanyPageCon Controller Working");
            ModelAndView mav = new ModelAndView();
            String title = "合作企业";
            mav.addObject("title",title);
            return mav;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }

        return null;
    }
}
