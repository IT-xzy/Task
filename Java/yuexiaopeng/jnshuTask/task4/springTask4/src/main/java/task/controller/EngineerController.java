package task.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import task.pojo.Engineer;
import task.pojo.Student;
import task.service.EngineerService;
@Controller
public class EngineerController
{
    static Logger logger=Logger.getLogger(EngineerController.class);

    @Autowired
    private EngineerService engineerService;

    @RequestMapping("/job")
    public ModelAndView companyPage() {
        Engineer engineer=engineerService.selectEngineer();
        ModelAndView mav=new ModelAndView("jobPage");
        mav.addObject("eng",engineer);
        logger.info(engineer);
        return mav;
    }
}

