package jnshu.controller;
import jnshu.pojo.Job;
import jnshu.service.CompoundService;
import jnshu.service.JobService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class PositionPageCon {

    @Autowired
    private JobService jobService;

    Logger logger = Logger.getLogger(PositionPageCon.class);

    @RequestMapping(value = "/position",method = RequestMethod.GET)
    public String position(Model model){
        System.out.println("PositionPageCon Controller Working");
        try {
            List<Job>list=jobService.listJob();
            list.forEach(x-> System.out.println(x));
            model.addAttribute("title","职业");
            model.addAttribute("lists",list);
            return "position";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }
}
